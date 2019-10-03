import sys
import mne
import csv
import numpy as np
import pandas as pd
import tensorflow as tf
from tensorflow import keras
from tensorflow.keras import layers
from datetime import datetime, timedelta
from functions import bandpower

# To turn information status messages off. ('info' to on)
mne.set_log_level('WARNING')


# Input parameter should be a ndarray
def removeEyeBlink(dataArray):
    for j in range(dataArray.shape[1]):
        for i in range(1, len(dataArray[:, j])):
            if (abs(dataArray[:, j][i]) > 300):
                dataArray[:, j][i] = dataArray[:, j][i]
    return dataArray


path = sys.argv[1]
csv_file = sys.argv[2]
raw_data = mne.io.read_raw_brainvision(path, preload=True)
raw_data.pick_types(meg=False, eeg=True, eog=False)  # Pick eeg channels
raw_avg_ref, _ = mne.set_eeg_reference(raw_data, ref_channels='average')  # Put average referencing
raw_avg_flt = raw_avg_ref.filter(0.1, 60.)  # Apply bandpass filter to average signal

data_array = removeEyeBlink(raw_avg_flt.to_data_frame().to_numpy())

file_name = sys.argv[3]
features = []
mean_chs = [21]
std_chs = []
ent_chs = [26, 30]
power_chs = [4]

for ch in mean_chs:
    features.append(np.mean(data_array[:, ch]))
# for ch in std_chs:
#    features.append(np.std(data_array[:, ch]))
for ch in ent_chs:
    pArr = data_array[:, ch] / sum(data_array[:, ch])
    features.append(-np.nansum(pArr * np.log2(pArr)))
for i in power_chs:
    power = bandpower(pd.Series(data_array[:, i]), 250, [0.1, 60], "welch")
    features.append(power)

X = [features]
y = []
file_names = []

with open(csv_file, 'r') as csvfile:
    csvreader = csv.reader(csvfile)
    next(csvfile, None)
    for row in csvreader:
        if row[0] != file_name:
            file_names.append(row[0])
            X.append([float(x) for x in row[1: len(row) - 1]])
            y.append(row[-1])

X = np.array(X)
for i in range(X.shape[1]):
    X[:, i] = (X[:, i] - min(X[:, i])) / (max(X[:, i]) - min(X[:, i]))

X_train = np.array(X[1:])
y_temp = []
for y_val in y:
    if y_val == 'n':
        y_temp.append([1., 0., 0., 0.])
    if y_val == 'p':
        y_temp.append([0., 1., 0., 0.])
    if y_val == 'l':
        y_temp.append([0., 0., 1., 0.])
    if y_val == 'h':
        y_temp.append([0., 0., 0., 1.])

y_train = np.array(y_temp)
X_test = np.array([X[0]])


def build_model(train_data):
    model = keras.Sequential([
        layers.Flatten(input_shape=[train_data.shape[1]]),
        layers.Dense(128, activation=tf.nn.relu),
        layers.Dense(4, activation=tf.nn.softmax)
    ])

    optimizer = tf.keras.optimizers.Adam()

    model.compile(loss='mean_squared_error', metrics=['accuracy'], optimizer=optimizer)
    return model


model = build_model(X_train)

early_stop = keras.callbacks.EarlyStopping(monitor='val_loss', patience=30)
model.fit(X_train, y_train, epochs=2000, validation_split=0.1, verbose=0, callbacks=[early_stop])

predictions = model.predict(X_test).flatten()

# test_loss, test_acc = model.evaluate(X_test, np.array([[1., 0., 0., 0.]]))

result = ""
description = ""
predicted_level = int(np.where(predictions == max(predictions))[0])
if predicted_level == 0:
    output = "No ASD"
    description = "Predicted ADOS-2 score range: 0 - 2"
if predicted_level == 1:
    output = "Potential ASD"
    description = "Predicted ADOS-2 score range: 3 - 6"
if predicted_level == 2:
    output = "Low ASD"
    description = "Predicted ADOS-2 score range: 7 - 12"
if predicted_level == 3:
    output = "High ASD"
    description = "Predicted ADOS-2 score range: 14 - 26"

channel_count = str(len(raw_data.info['chs'])) + " channels"
channel_names = ""
for i in raw_data.info['ch_names']:
    channel_names += i + " "

duration = str(int(raw_data.n_times) / int(raw_data.info['sfreq'])) + ' seconds'
record_date = str(
    (datetime.fromtimestamp(raw_data.info['meas_date'][0]) - timedelta(hours=2)).strftime('%Y-%m-%d %H:%M:%S'))

print(output, "\n", description, "\n", channel_count, "\n", channel_names, "\n", duration, "\n", record_date)
