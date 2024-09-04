# Anything preceded by the hash character (#) is called a "comment."
# Comments are ignored by the computer. They are only present to help a human
# understand the program.

# The next three lines make some standard Python functions available
# to the rest of the program
import sys
from os import *
from math import *

# initialize the user's input to the empty string
input = '' 

# We will use a variable 'quit' to tell us whether or not
# the user wants to quit. Initially, 'quit' is False because
# we assume the user doesn't want to quit right away.
quit = False 

# The next statement tells the program to repeatedly execute the
# following lines, until the user wants to quit
while not quit:
    # get some input from the user, and store it in a variable called 'input'
    input = raw_input('Enter a mathematical expression (or "q" to quit): ')
    
    # if the input was a 'q', record the fact that the user wants to
    # quit, by setting 'quit' to True
    if input=='q': 
        quit = True
    
    # otherwise, the user doesn't want to quit...
    else:
    
        # evaluate the user's input, and store it in a variable called 'value'
        value = eval(input)
        
        # print out the computed value
        print 'The value of the expression is', value

    # at this point, the program goes back to the 'while not quit' line above
