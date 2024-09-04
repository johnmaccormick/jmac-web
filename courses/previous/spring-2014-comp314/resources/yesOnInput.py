# import argv so that commandline argument can be accessed
from sys import argv

# load contents of the input file into the variable `input'
inputFileName = argv[1]
with open(inputFileName) as inputFile:
    input = inputFile.read()

# Python program yesOnInput.py
splitInput = input.split("##end-of-program##")
programToAnalyze = splitInput[0]
inputToAnalyze = splitInput[1]

from tempfile import NamedTemporaryFile
newInputFile = NamedTemporaryFile(dir='.', prefix='tempInput-', suffix='.txt', delete=False)
newInputFile.write(inputToAnalyze)
newInputFile.close()
newProgramFile = NamedTemporaryFile(dir='.', prefix='tempProgram-', suffix='.py', delete=False)
newProgramFile.write(programToAnalyze)
newProgramFile.close()


from subprocess import call
call(["python", newProgramFile.name, newInputFile.name])

from os import unlink
unlink(newInputFile.name)
unlink(newProgramFile.name)

