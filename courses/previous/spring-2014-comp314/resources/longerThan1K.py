# import argv so that commandline argument can be accessed
from sys import argv

# load contents of the input file into the variable `input'
inputFileName = argv[1]
with open(inputFileName) as inputFile:
    input = inputFile.read()

# Python program longerThan1K.py
if len(input) > 1024:
    print "yes"
else:
    print "no"
