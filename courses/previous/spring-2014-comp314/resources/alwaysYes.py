# import argv so that commandline argument can be accessed
from sys import argv

# load contents of the input file into the variable `input'
inputFileName = argv[1]
with open(inputFileName) as inputFile:
    input = inputFile.read()

# Python program alwaysYes.py
####################################################################
# This is a fake version of alwaysYes.py -- it only works on certain
# particular files whose names have been hardwired into the code. A
# real version of the program would of course need to do some
# sophisticated analysis on the input to determine whether the output
# is always "yes".
####################################################################
from fileContents import fileContents

if input == fileContents("yes.py"):
    print "yes"
elif input == fileContents("lenIsEvenOrOdd.py"):
    print "yes"
elif input == fileContents("containsZ.py"):
    print "no"
elif input == "abc":
    print "no"
elif input == fileContents("infiniteLoop.py"):
    print "no"
elif input == fileContents("alwaysYes.py"):
    print "no"
elif input == fileContents("alwaysYesFunction.py"):
    print "no"
elif input == fileContents("alwaysYesFile.py"):
    print "no"
else:
    print "not sure"
