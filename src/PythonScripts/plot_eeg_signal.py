import sys
import numpy as np
import mne

# To turn information status messages off. ('info' to on)
mne.set_log_level('WARNING')

eeg_path = sys.argv[1]

raw_data = mne.io.read_raw_brainvision(eeg_path, preload=True)

image = mne.viz.plot_raw(raw_data, n_channels=32, show=False)
image.savefig(sys.argv[2])
print("image saved")