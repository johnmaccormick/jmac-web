import threading
import os

def isSorted(words):
    for i in range(1,len(words)):
        if words[i-1] >  words[i]:
            return False
    return True
    


def sillySortParallel(prefix, remainder):
    global printLock
    if isSorted(prefix):
        if len(remainder)==0:
            print prefix
            os._exit(0) # REALLY exit, killing all other threads
        else:
            for i in range(len(remainder)):
                nextWord = remainder[i]
                newPrefix = prefix + [nextWord]
                newRemainder = remainder[:i] + remainder[(i+1):]
                t = threading.Thread(target=sillySortParallel, \
                                     args = (newPrefix, newRemainder))
                t.start()
                # sillySortParallel(newPrefix, newRemainder)
            
        
from sys import argv
inputFileName = argv[1]
with open(inputFileName) as inputFile:
    input = inputFile.read()

words = input.split()
sillySortParallel([], words)
