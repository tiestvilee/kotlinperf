import os
import sys

if len(sys.argv) > 1:
  count = int(sys.argv[1])
else: 
  count = 100

if len(sys.argv) > 2:
  template = sys.argv[2]
else: 
  template = "template.kt"

simpleFunctions = "empty"
with open(template) as f:
  simpleFunctions = f.read()

for i in range(0,count):
  directory = "src/simple{}".format(i)
  if not os.path.exists(directory):
    os.makedirs(directory)
  with open(directory + "/fun.kt", "w") as f:
    f.write(simpleFunctions.format(i))

