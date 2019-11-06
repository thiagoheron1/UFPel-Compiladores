class StackMachine():

    def __init__(self, pathFile):
        self.stack = self.readerFile(pathFile)

    def readerFile(self, pathFile):
        with open(pathFile) as file:  
            data = file.readlines()

        return list(map(lambda word: word.replace("\n", ""),data))
        
    def 