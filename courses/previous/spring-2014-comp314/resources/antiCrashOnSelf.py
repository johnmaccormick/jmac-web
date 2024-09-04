# import argv so that commandline argument can be accessed
from sys import argv

# load contents of the input file into the variable `input'
inputFileName = argv[1]
with open(inputFileName) as inputFile:
    input = inputFile.read()

# Python program antiCrashOnSelf.py
from crashOnSelfFunction import crashOnSelf
if crashOnSelf(input) == "no":
    x = 1/0 # deliberately crash
else:
    print "yes"
