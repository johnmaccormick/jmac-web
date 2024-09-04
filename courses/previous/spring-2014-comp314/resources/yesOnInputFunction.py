# Python program yesOnInputFunction.py
def yesOnInput(input):
    splitInput = input.split("##end-of-program##")
    programToAnalyze = splitInput[0]
    inputToAnalyze = splitInput[1]

    from tempfile import NamedTemporaryFile
    newInputFile = NamedTemporaryFile(dir='.', prefix='tempInput-', suffix='.txt', delete=False)
    newInputFile.write(inputToAnalyze)
    newInputFile.close()
    newProgramFile = NamedTemporaryFile(dir='.', prefix='tempProgram-', suffix='.py', delete=False)
    newProgramFile.write(programToAnalyze)
    newProgramFile.close()


    from tempfile import TemporaryFile
    outputFile = TemporaryFile()
    from subprocess import call, STDOUT
    call(["python", newProgramFile.name, newInputFile.name], stdout = outputFile, stderr = STDOUT)
    output = outputFile.read()
    outputFile.close()

    from os import unlink
    unlink(newInputFile.name)
    unlink(newProgramFile.name)

    return output
