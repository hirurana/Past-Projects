#generate a random numbers and store in array
import random
x=0
sequenceNumbers=[]
while x<10:
    number = random.randint(1,13)
    sequenceNumbers.append(number)
    x=x+1

#display the first number
print("Starting number: "+str(sequenceNumbers[0]))

#get users input and validate
isSuccessful = True
indexValue = 1
while isSuccessful:
    userInput = input("Higher (H) or Lower (L)? ")
    if userInput == "L" and sequenceNumbers[indexValue]<sequenceNumbers[indexValue-1]:
        isSuccessful = True
        indexValue = indexValue+1
    if userInput == "H" and sequenceNumbers[indexValue]>sequenceNumbers[indexValue-1]:
        isSuccessful = True
        indexValue = indexValue+1
    else:
        isSuccessful = False
if isSuccessful:
    print("You won!")
else:
    print("You lose!")


    

