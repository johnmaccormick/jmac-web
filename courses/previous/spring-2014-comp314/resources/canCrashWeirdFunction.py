# Python program canCrashWeirdFunction.py
def canCrashWeird(input):
    from canCrashFunction import canCrash

    if canCrash(input) == "yes":
        x = 1/0  # deliberately crash 
    else:
        return "no"
