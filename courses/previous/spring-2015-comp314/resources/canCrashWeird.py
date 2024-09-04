# import argv so that commandline argument can be accessed
from sys import argv

# load contents of the input file into the variable `input'
inputFileName = argv[1]
with open(inputFileName) as inputFile:
    input = inputFile.read()

# Python program canCrashWeird.py
from canCrashFunction import canCrash

if canCrash(input) == "yes":
    x = 1/0  # deliberately crash 
else:
    print "no"
