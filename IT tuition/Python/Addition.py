#Addition
def printAddition(val1, val2):
    print(val1+val2)

def add(val1, val2) :
    total = val1+val2
    return total

def multiply(val1,val2) :
    return val1*val2

def addAndMultiply(val1,val2) :
    print ( "Add : " + str(add(val1,val2)))
    print (multiply(val1,val2))

addAndMultiply(4,5)

printAddition(2,3)


def printCalulations(val1, val2, val3):
    print("Addition of: "+str(val1+val2+val3))
    print("Multiplication: "+str(val1*val2*val3))

printCalulations(3,4,5)
printCalulations(55,45,35)

#
def personalData(name,age):
    print("Hello "+name+" you will be in 5 years time "+str(int(age)+5))

name = input("What is your name? ")
age = int(input("What is your age? "))
personalData(name,age)
