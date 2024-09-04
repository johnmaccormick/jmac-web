# import argv so that commandline argument can be accessed
from sys import argv

# load contents of the input file into the variable `input'
inputFileName = argv[1]
with open(inputFileName) as inputFile:
    input = inputFile.read()

# Python program antiYesOnSelf.py
from yesOnSelfFunction import yesOnSelf

yesOnSelfOutput = yesOnSelfOutput(input)

if yesOnSelfOutput == "yes":
    print "no"
if yesOnSelfOutput == "no":
    print "yes"
else:
    print "not sure"
