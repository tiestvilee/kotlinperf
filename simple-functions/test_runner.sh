#!/bin/bash

set -e

mkdir -p results

samples=11

for testname in templates/*.kt; do

	for fileCount in 0001 0010 0030 0100 0300 1000; do

		echo "testing $testname, $fileCount files, $samples samples"

		if [ ! -f results/$testname/$fileCount.txt ]; then
			mkdir -p results/$testname
			python clean.py
			python make_files.py $fileCount $testname
			python build_files.py $samples > results/$testname/$fileCount.txt 
		fi
		
		tail -n 1 results/$testname/$fileCount.txt

	done
done