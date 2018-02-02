import glob
import shutil

for file in list(glob.glob('src/s*')):
  shutil.rmtree(file)

for file in list(glob.glob('simple*')):
  shutil.rmtree(file)

