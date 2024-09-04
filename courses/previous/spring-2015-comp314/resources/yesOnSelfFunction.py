# Python program yesOnSelfFunction.py
def yesOnSelf(input):
    from alwaysYesFunction import alwaysYes
    alteredInput = input.replace("argv[1]", "argv[0]")
    return alwaysYes(alteredInput)
