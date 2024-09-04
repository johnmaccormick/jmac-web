# import argv so that commandline argument can be accessed
from sys import argv

# load contents of the input file into the variable `input'
inputFileName = argv[1]
with open(inputFileName) as inputFile: 
    input = inputFile.read()

# split on newlines
lines = input.split('\n')
# print number of lines
print len(lines)