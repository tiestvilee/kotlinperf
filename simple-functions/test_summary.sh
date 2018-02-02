#!/bin/bash

set -e

for testname in results/templates/*; do

	result="$testname,"
	for fileCount in 0001 0010 0030 0100 0300 1000; do
		
		if [ -f $testname/$fileCount.txt ]; then
			result="$result`tail -n 1 $testname/$fileCount.txt`,"
		else
			result="$result,"
		fi

	done
	echo $result
done