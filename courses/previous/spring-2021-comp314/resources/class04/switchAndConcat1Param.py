import utils; from utils import rf

# Decode the input string into two separate parameters. 
# Switch the order of these two parameters then concatenate them.
def switchAndConcat1Param(inString):
    (inString1, inString2) = utils.DESS(inString)
    return inString2 + inString1
