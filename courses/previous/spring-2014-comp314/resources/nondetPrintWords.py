# python program nondetPrintWords.py
from threading import Thread

def printWord(word):
    print word

def nondetPrintWords(input):
    words = input.split()
    threads = [ ]
    for word in words:
        t = Thread(target=printWord, args = (word,))
        threads.append(t)
    for t in threads:
        t.start()
    for t in threads:
        t.join()   #/* \label{line:nPW-last} */

from sys import argv
inputFileName = argv[1]
with open(inputFileName) as inputFile:
    input = inputFile.read()

nondetPrintWords(input)

