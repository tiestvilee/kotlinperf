from subprocess import Popen, PIPE
import sys

if len(sys.argv) > 1:
  count = int(sys.argv[1])
else:
  count = 1

results = []
for i in range(0,count):
  p = Popen(["time", "kotlinc", "-d", "target", "src"], stdin=PIPE, stdout=PIPE, stderr=PIPE)
  output, err = p.communicate()
  rc = p.returncode

  print err
  results.append(float(err.split()[2]))

def median(lst):
    n = len(lst)
    if n < 1:
            return None
    if n % 2 == 1:
            return sorted(lst)[n//2]
    else:
            return sum(sorted(lst)[n//2-1:n//2+1])/2.0

print median(results)
