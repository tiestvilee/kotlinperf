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
            s = sorted(lst)
            return (s[0], s[n//4], s[n//2], s[3*n//4], s[-1])
    else:
            s = sorted(lst)
            return (s[0], s[n//4], sum(s[n//2-1:n//2+1])/2.0, s[3*n//4], s[-1])

stats = median(results)
print stats
print stats[2]
