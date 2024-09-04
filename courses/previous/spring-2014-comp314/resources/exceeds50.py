# import argv so that commandline argument can be accessed
from sys import argv

# load contents of the input file into the variable `input'
inputFileName = argv[1]
with open(inputFileName) as inputFile:
    input = inputFile.read()

# Python program exceeds50.py
if int(input)>50: #/* \label{line:exceeds50-convert}  */
    print "yes"
else:
    print "no"
