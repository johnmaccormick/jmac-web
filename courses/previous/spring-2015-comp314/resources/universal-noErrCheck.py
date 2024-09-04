# import argv so that commandline argument can be accessed
from sys import argv

# load contents of the input file into the variable `input'
inputFileName = argv[1]
with open(inputFileName) as inputFile:
    input = inputFile.read()

# Python program universal.py

# Split input into the program to be executed, #/* \label{line:universal-split-start}  */
# and the input to be given to that program
separator = "##end-of-program##"
splitInput = input.split(separator,1) # splits on first occurrence only
programToExecute = splitInput[0]
inputToProgram = splitInput[1] #/* \label{line:universal-split-end}  */

# Determine the name of the function that needs to be executed. #/* \label{line:universal-function-start}  */
suffix = "WithInput.txt"
functionName = inputFileName[:-len(suffix)] #/* \label{line:universal-function-end}  */

# The next line does *not* invoke the function. Instead,
# it executes the *definition* of the function, which makes that
# definition available for later.
exec programToExecute  #/* \label{line:universal-function-def}  */

# The desired function is now defined, so we can execute it
# and print the output. 
command = "output = " + functionName + "(inputToProgram)"
exec command #/* \label{line:universal-exec-command}  */
print output


