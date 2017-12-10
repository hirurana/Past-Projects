#Choose from a list randomly the target word:
#Python
#Function
#Operator
#loop
#iteration
#recursion
#for
#next
#Make sure the correct number of "Dashes" are shown
#Allow a  guess store it. Check against word
#redraw "dashes" with letters in

#import the random library
import random

#select target name
wordnum = random.randint(0,7)

hangmanWords=["python","function","operator","loop","iteration","recursion","for","next"]

hangmanWord=hangmanWords[wordnum]

hangmanWordLength=len(hangmanWord)

dashes=[]

for dash in range(0,hangmanWordLength):
    dashes.append("-")
for i in dashes:
        print(i+" ", end="")
dashesExist = True
while dashesExist:
    userInput = input("\nGuess the word: ")
    if len(userInput)<hangmanWordLength:
        print("ERROR: Should have at least "+str(hangmanWordLength)+" letters")
        continue
    for x in range(0, hangmanWordLength):
        if userInput[x] == hangmanWord[x]:
            dashes[x] =  userInput[x]
    if not "-" in dashes :
         print ("Well done! Corrrect word")  
         dashesExist = False
    else:
        for i in dashes:
            print(i+" ", end="")
          

            


    



