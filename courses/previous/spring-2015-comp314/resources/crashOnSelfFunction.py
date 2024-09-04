# Python program crashOnSelfFunction.py
def crashOnSelf(input):
    from canCrashWeirdFunction import canCrashWeird
    alteredInput = input.replace("argv[1]", "argv[0]")
    return canCrashWeird(alteredInput)
