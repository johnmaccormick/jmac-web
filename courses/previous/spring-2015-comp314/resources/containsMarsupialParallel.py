# python program containsMarsupialParallel.py
from threading import Thread

# helper function that sets the global variable 'answer' to 
# the value 'yes' if the given word is found in the given text
def findWord(word, text):  #/* \label{line:cMP-helper} */
    global answer
    if word in text:
        answer = 'yes'

# function that searches the given input for five different words, in
# parallel. WARNING: For clarity, this function uses dangerously
# over-simplified techniques for multithreaded code. Well-written code
# would avoid global variables, race conditions and deadlocks, but
# these issues are ignored here.
def containsMarsupialParallel(input): #/* \label{line:cMP-main} */
    # the list of words to look for
    marsupials = ['kangaroo', 'wallaby', 'possum', 'koala', 'wombat', ]
    # declare a global variable and initialize it with the value 'no'
    global answer  #/* \label{line:cMP-thread-global1} */
    answer = 'no'  #/* \label{line:cMP-thread-global2} */
    # create an empty list that will store our threads
    threads = [ ]
    for word in marsupials:
        # create a thread that will execute findWord(word, input),
        # when started
        t = Thread(target=findWord, args = (word,input)) #/* \label{line:cMP-thread-create} */
        # append the newly-created thread to our list of threads
        threads.append(t)
    # start each thread
    for t in threads:  #/* \label{line:cMP-start} */
        t.start()
    # wait for each thread to complete
    for t in threads:   #/* \label{line:cMP-join} */
        t.join()
    return answer #/* \label{line:cMP-last} */

from sys import argv
inputFileName = argv[1]
with open(inputFileName) as inputFile:
    input = inputFile.read()

print containsMarsupialParallel(input)

