# import argv so that commandline argument can be accessed
from sys import argv

# load contents of the input file into the variable `input'
inputFileName = argv[1]
with open(inputFileName) as inputFile:
    input = inputFile.read()

# Python program universal.py

# Split input into the program to be executed, 
# and the input to be given to that program
separator = "##end-of-program##"
if not separator in input:
    raise Exception("oops, the input must contain the separator " 
                    + separator)
splitInput = input.split(separator,1) # splits on first occurrence only
programToExecute = splitInput[0]
inputToProgram = splitInput[1]

# Determine the name of the function that needs to be executed.
suffix = "WithInput.txt"
if not inputFileName.endswith(suffix):
    raise Exception("oops, file name didn't end with 'WithInput.txt'")
functionName = inputFileName[:-len(suffix)]

# The next line does *not* invoke the function -- instead,
# it executes the *definition* of the function, which makes that
# definition available for later
exec programToExecute

# The desired function is now defined, so we can execute it
# and print the output. 
command = "output = " + functionName + "(inputToProgram)"
exec command
print output


