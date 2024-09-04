# python program factors.py
def factors(num):
    for i in range(1,num+1):
        if num % i == 0:
            print i #/* \label{line:factors-last} */

from sys import argv
inputFileName = argv[1]
with open(inputFileName) as inputFile:
    input = inputFile.read()

factors(int(input))

