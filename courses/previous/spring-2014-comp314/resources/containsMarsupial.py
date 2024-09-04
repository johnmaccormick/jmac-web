# python program containsMarsupial.py
def containsMarsupial(input):
    marsupials = ['kangaroo', 'wallaby', 'possum', 'koala', 'wombat']
    for word in marsupials:
        if word in input:
            return 'yes'
    return 'no'

from sys import argv
inputFileName = argv[1]
with open(inputFileName) as inputFile:
    input = inputFile.read()
print containsMarsupial(input)
