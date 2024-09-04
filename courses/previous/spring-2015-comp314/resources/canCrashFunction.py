# Python program canCrashFunction.py
####################################################################
# This is a fake version of canCrashFunction.py -- it only works on
# certain particular files whose names have been hardwired into the
# code. A real version of the program would of course need to do some
# sophisticated analysis on the input to determine whether the input
# can crash (i.e. throw an exception).
####################################################################
def canCrash(input):
    from fileContents import fileContents

    if input == fileContents("divideByZero.py"):
        return "yes"
    elif input == "":
        return "no"
    else:
        return "not sure"
