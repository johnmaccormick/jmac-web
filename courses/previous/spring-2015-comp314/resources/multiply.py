# import argv so that commandline argument can be accessed #/* \label{line:multiply-first}  */
from sys import argv #/* \label{line:multiply-import}  */

# load contents of the input file into the variable `input'
inputFileName = argv[1] #/* \label{line:multiply-open}  */
with open(inputFileName) as inputFile: 
    input = inputFile.read()   # input = "5 8 3" #/* \label{line:multiply-open-end}  */

# split on whitespace
numberStrings = input.split()  # numberStrings = ["5", "8", "3"] #/* \label{line:multiply-split}  */

# convert strings to integers
numbers = map(int, numberStrings)    # numbers = [5, 8, 3] #/* \label{line:multiply-convert}  */

# compute the product of the numbers array
product = 1  #/* \label{line:multiply-product}  */
for n in numbers:
    product = product * n
print product  #/* \label{line:multiply-product-end}  */