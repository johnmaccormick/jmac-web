# import argv so that commandline argument can be accessed
from sys import argv

# load contents of the input file into the variable `input'
inputFileName = argv[1]
with open(inputFileName) as inputFile:
    input = inputFile.read()

# Python program crashOnSelf.py
from canCrashWeirdFunction import canCrashWeird
alteredInput = input.replace("argv[1]", "argv[0]")
print canCrashWeird(alteredInput)
