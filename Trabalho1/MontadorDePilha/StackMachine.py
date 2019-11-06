class StackMachine():

    def __init__(self, pathFile):
        self.stack = self.readerFile(pathFile)

    def readerFile(self, pathFile):
        with open(pathFile) as file:
            data = file.readlines()

        return list(map(lambda word: word.replace("\n", ""), data))

    def solveStack(self):

        while(len(self.stack) > 1):
            indexStack = 0
            print(self.stack)

            for expression in self.stack:

                
                if expression == "SUM":
                    num1 = self.stack[indexStack-1]
                    num2 = self.stack[indexStack-2]
                    total = int(num1.replace("PUSH ", ""))+int(num2.replace("PUSH ", ""))
                    
                    self.stack.remove(num1)
                    self.stack.remove(num2)
                    self.stack.remove("SUM")

                    self.stack.insert(indexStack-2, "PUSH "+str(total))
                    break
                    
                elif expression == "SUB":
                    num1 = self.stack[indexStack-1]
                    num2 = self.stack[indexStack-2]
                    total = int(num2.replace("PUSH ", ""))-int(num1.replace("PUSH ", ""))
                    
                    self.stack.remove(num1)
                    self.stack.remove(num2)
                    self.stack.remove("SUB")

                    self.stack.insert(indexStack-2, "PUSH "+str(total))
                    break

                elif expression == "MULT":
                    num1 = self.stack[indexStack-1]
                    num2 = self.stack[indexStack-2]
                    total = int(num1.replace("PUSH ", ""))*int(num2.replace("PUSH ", ""))


                    
                    self.stack.remove(num1)
                    self.stack.remove(num2)
                    self.stack.remove("MULT")

                    self.stack.insert(indexStack-2, "PUSH "+str(total))
                    break

                elif expression == "DIV":
                    num1 = self.stack[indexStack-1]
                    num2 = self.stack[indexStack-2]
                    total = int(int(num2.replace("PUSH ", ""))/int(num1.replace("PUSH ", "")))


                    
                    self.stack.remove(num1)
                    self.stack.remove(num2)
                    self.stack.remove("DIV")

                    self.stack.insert(indexStack-2, "PUSH "+str(total))
                    break

                elif expression == "PRINT":
                    print("Resultado:", int(self.stack[0].replace("PUSH ", "")))
                    self.stack.remove(self.stack[0])
                    self.stack.remove("PRINT")
                
                    
                indexStack += 1
