# import argv so that commandline argument can be accessed
from sys import argv

# load contents of the input file into the variable `input'
inputFileName = argv[1]
with open(inputFileName) as inputFile:
    input = inputFile.read()

# Python program infiniteLoop.py
i = 0
if input != "secret sauce":
    # enter an infinite loop, in which the value of i
    # repeatedly cycles through 0, 1, 2, ... 100
    while i>=0:
        i = i + 1
        if i==100: 
            i = 0

# output "yes" if i is even and "no" otherwise
if i % 2 == 0:
    print "yes"
else:
    print "no"
