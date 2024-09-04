# import argv so that commandline argument can be accessed
from sys import argv

# load contents of the input file into the variable `input'
inputFileName = argv[1]
with open(inputFileName) as inputFile:
    input = inputFile.read()

# Python program canCrash.py
####################################################################
# This is a fake version of canCrash.py -- it only works on certain
# particular files whose names have been hardwired into the code. A
# real version of the program would of course need to do some
# sophisticated analysis on the input to determine whether the input
# can crash (i.e. throw an exception).
####################################################################
from fileContents import fileContents

if input == fileContents("divideByZero.py"):
    print "yes"
elif input == "":
    print "no"
else:
    print "not sure"
