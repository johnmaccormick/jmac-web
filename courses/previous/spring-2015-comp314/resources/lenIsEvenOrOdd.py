# import argv so that commandline argument can be accessed
from sys import argv

# load contents of the input file into the variable `input'
inputFileName = argv[1]
with open(inputFileName) as inputFile:
    input = inputFile.read()

# Python program lenIsEvenOrOdd.py
inputLength = len(input);
if inputLength % 2 == 0:   # i.e. if input length is even
    print "yes"
elif inputLength % 2 == 1: # i.e. if input length is odd
    print "yes"
else:
    print "no"
