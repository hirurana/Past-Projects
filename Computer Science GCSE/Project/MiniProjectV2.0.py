#Initialise by importing the random library and the string library
import random
import string
#empty variable
stop=""
#importing the alphabet
allTheLetters = string.ascii_letters
#setting up both lists
names = []
dob = []

#counter placed at 0
count = 0
#Presentation
print("-------------------------------------------")
print("Welcome to the raffel ticket program")
print("-------------------------------------------")
#Take inputs
newName = input("Enter your full name (e.g Sam Smith): \n")
newNameLen = len(newName) #storing the length of the inputted name
#if the name entered is less than or equal to one character print an error
if newNameLen<=1:
    print("ERROR: Name must be at least two letters")
    #reask the question
    newName = input("Enter your name (e.g Sam Smith): \n")
for i in newName:
#if the name entered contains a number print an error message
    if i=="0" or i=="1" or i=="2" or i=="3" or i=="4" or i=="5" or i=="6" or i=="7" or i=="8" or i=="9":
        print("ERROR: Name must not have numbers")
        #reask the question
        newName = input("Enter your name (e.g Sam Smith): \n")
names.append(newName)
#ask for date of birth
newDob = input("Enter you date of birth in this format (e.g 10/08/99): \n")
#checks for letters in the d.o.b
for rounds in newDob: #takes every character entered and verifys it
    for lowerletters in allTheLetters: #loops out all the alphabet
        if rounds==lowerletters: #if any of the alphabet matches a character, an error is produced
            print("ERROR: User has entered a letter for the date of birth, please use numbers only.")
            stop=True #variable set to true
        if stop==True: #when set to true the loop is broken as no further verification is required
            break
if stop==True: #if the variable is true then reask the question
    newDob = input("Enter you date of birth in this format (e.g 10/08/99): \n")
#storing the length of the inputted date of birth
newDobLen = len(newDob)
#if the date of birth entered is not equal to 8 characters print an error
if newDobLen!=8:
    print("ERROR: Date of Birth not written in requested format")
    #reask the question
    newDob = input("Enter you date of birth in this format (e.g 10/08/99): \n")
#if the date of birth entered does not have a / at the 3rd and 6th character print an error
if newDob[2] and newDob[5] != "/":
    print("ERROR: Date of Birth not written in requested format")
    #reask the question
    newDob = input("Enter you date of birth in this format (e.g 10/08/99): \n")
#if the date entered has a day above 31 days it is invalid
if int(newDob[0])>3:
    print("ERROR: The date entered is invalid")
    newDob = input("Enter you date of birth in this format (e.g 10/08/99): \n")
elif int(newDob[0])==3 and int(newDob[1])>1:
    print("ERROR: The date entered is invalid")
    newDob = input("Enter you date of birth in this format (e.g 10/08/99): \n")
#if the month entered is above 12 it is invalid
elif int(newDob[3])>1:
    print("ERROR: The month entered is invalid")
    newDob = input("Enter you date of birth in this format (e.g 10/08/99): \n")
elif int(newDob[3])==1 and int(newDob[4])>2:
    print("ERROR: The month entered is invalid")
    newDob = input("Enter you date of birth in this format (e.g 10/08/99): \n")
#after verifying the newDob is appended into the list
dob.append(newDob)

################################################################################################################
while newName != "end":
    newName = input("Enter your full name (e.g Sam Smith): \n")
    if newName=="end":
        break
    newNameLen = len(newName) #storing the length of the inputted name
    #if the name entered is less than or equal to one character print an error
    if newNameLen<=1:
        print("ERROR: Name must be more than one letter")
        #reask the question
        newName = input("Enter your name (e.g Sam Smith): \n")
    for letter in newName:
    #if the name entered contains a number print an error message
        if letter=="0" or letter=="1"or letter=="2"or letter=="3"or letter=="4"or letter=="5"or letter=="6"or letter=="7"or letter=="8"or letter=="9":
            print("ERROR: Name must not have numbers")
            #reask the question
            newName = input("Enter your name (e.g Sam Smith): \n")
    names.append(newName)
    #ask for date of birth
    newDob = input("Enter you date of birth in this format (e.g 10/08/99): \n")
    #checks for letters in the d.o.b
    for rounds in newDob: #takes every character entered and verifys it
        for lowerletters in allTheLetters: #loops out all the alphabet
            if rounds==lowerletters: #if any of the alphabet matches a character, an error is produced
                print("ERROR: User has entered a letter for the date of birth, please use numbers only.")
                stop=True #variable set to true
            if stop==True: #when set to true the loop is broken as no further verification is required
                break
    if stop==True: #if the variable is true then reask the question
        newDob = input("Enter you date of birth in this format (e.g 10/08/99): \n")
    #storing the length of the inputted date of birth
    newDobLen = len(newDob)
    #if the date of birth entered is not equal to 8 characters print an error
    if newDobLen!=8:
        print("ERROR: Date of Birth not written in requested format")
        #reask the question
        newDob = input("Enter you date of birth in this format (e.g 10/08/99): \n")
    #if the date of birth entered does not have a / at the 3rd and 6th character print an error
    if newDob[2] and newDob[5] != "/":
        print("ERROR: Date of Birth not written in requested format")
        #reask the question
        newDob = input("Enter you date of birth in this format (e.g 10/08/99): \n")
    #if the date entered has a day above 31 days it is invalid
    if int(newDob[0])>3:
        print("ERROR: The date entered is invalid")
        newDob = input("Enter you date of birth in this format (e.g 10/08/99): \n")
    elif int(newDob[0])==3 and int(newDob[1])>1:
        print("ERROR: The date entered is invalid")
        newDob = input("Enter you date of birth in this format (e.g 10/08/99): \n")
    #if the month entered is above 12 it is invalid
    elif int(newDob[3])>1:
        print("ERROR: The month entered is invalid")
        newDob = input("Enter you date of birth in this format (e.g 10/08/99): \n")
    elif int(newDob[3])==1 and int(newDob[4])>2:
        print("ERROR: The month entered is invalid")
        newDob = input("Enter you date of birth in this format (e.g 10/08/99): \n")
    #add dob to the list
    dob.append(newDob)
    #keeping count of how many people are entered
    count+=1

#################################################################################################################
#If user inputs end continue the program
if newName == "end": 
#generate a random number between number of people entered
    winnerIndex = random.randint(0,count)
print("The Winner is: "+names[winnerIndex]+", Date of Birth: "+dob[winnerIndex])

#################################################################################################################
AllList=""
time=0
#ask if the user wants to print the list
ListRequest=input("Print List (Y/N): ")

#if user types Y or N change the boolean 
if ListRequest=="Y" or ListRequest=="y":
    AllList=True
elif ListRequest=="N" or ListRequest=="n":
    AllList=False

#if the boolean is true print the names and dobs
if AllList==True:
    for enter in names:
        print("Name: "+enter+", Date of Birth: "+dob[time])
        time+=1
    print("Thank you for using this program!")
#if the boolean is false print a thank you message
elif AllList==False:
    print("Thank you for using this program!")
#if no boolean was set then print and error and reask the question
elif AllList=="":
    print("ERROR: User has not typed either Y or N")
    #redoing the print list process
    ListRequest=input("Print List (Y/N): ")

    if ListRequest=="Y" or ListRequest=="y":
        AllList=True
    elif ListRequest=="N" or ListRequest=="n":
        AllList=False

    if AllList==True:
        for enter in names:
            print("Name: "+enter+" Date of Birth: "+dob[time])
            time+=1
        print("Thank you for using this program!")
    elif AllList==False:
        print("Thank you for using this program!")
