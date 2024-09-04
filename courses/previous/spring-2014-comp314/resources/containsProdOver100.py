# import argv so that commandline argument can be accessed
from sys import argv

# load contents of the input file into the variable `input'
inputFileName = argv[1]
with open(inputFileName) as inputFile:
    input = inputFile.read()

# Python program containsProdOver100.py
from multiplyFunction import multiply

# split on newlines
lines = input.split('\n')

# initialize output to "no", then loop over the lines, changing the
# output to "yes" if we find any line whose product exceeds 100
output = "no"
for line in lines:
    # ignore empty lines
    if len(line)>0:
        # compute product of current line
        product = int(multiply(line))
        if product > 100:
            output = "yes"

print output
