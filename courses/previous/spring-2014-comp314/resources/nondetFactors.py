# python program nondetFactors.py
from threading import Thread

# Nondeterministically print all factors of num in the range between
# low and high (including low but excluding high), using a divide and
# conquer approach that bisects the interval [low,high] and searches
# the new intervals for factors in separate threads.
def nondetFactors(num, low, high):
    if high-low > 1:
        # bisect the interval between low and high, and start two new
        # threads that will search for factors in these intervals
        mid = int ( (high+low)/2 )
        t1 = Thread(target=nondetFactors, args = (num, low, mid))
        t2 = Thread(target=nondetFactors, args = (num, mid, high))
        t1.start()
        t2.start()
    else:
        # the interval [low,high] cannot be bisected any further, so
        # if low is a factor of num, print it
        if num % low == 0:
            print low  #/* \label{line:ndF-last} */

from sys import argv
inputFileName = argv[1]
with open(inputFileName) as inputFile:
    input = inputFile.read()

num = int(input)
low = 1
high = num + 1
nondetFactors(num, low, high)

