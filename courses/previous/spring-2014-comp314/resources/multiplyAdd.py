# import argv so that commandline argument can be accessed
from sys import argv

# load contents of the input file into the variable `input'
inputFileName = argv[1]
with open(inputFileName) as inputFile: 
    input = inputFile.read()

from multiplyFunction import multiply #/* \label{line:multiplyAdd-import}  */

# split on newlines
lines = input.split('\n') #/* \label{line:multiplyAdd-split}  */

# compute a running total of the product of each line of input
sum = 0
for line in lines:
    # ignore empty lines
    if len(line)>0:
        # compute product of current line, and add to running total
        productString = multiply(line) #/* \label{line:multiplyAdd-call}  */
        product = int(productString)
        sum = sum + product

print sum

