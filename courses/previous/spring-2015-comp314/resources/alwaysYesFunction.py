# Python program alwaysYesFunction.py
####################################################################
# This is a fake version of alwaysYesFunction.py -- it only works on
# certain particular inputs whose filenames have been hardwired into
# the code. A real version of the program would of course need to do
# some sophisticated analysis on the input to determine whether the
# output is always "yes".
####################################################################
from fileContents import fileContents

def alwaysYes(input):
    if input == fileContents("yes.py"):
        return "yes"
    elif input == fileContents("lenIsEvenOrOdd.py"):
        return "yes"
    elif input == fileContents("containsZ.py"):
        return "no"
    elif input == "abc":
        return "no"
    elif input == fileContents("infiniteLoop.py"):
        return "no"
    elif input == fileContents("alwaysYes.py"):
        return "no"
    elif input == fileContents("alwaysYesFunction.py"):
        return "no"
    elif input == fileContents("alwaysYesFile.py"):
        return "no"
    else:
        return "not sure"
