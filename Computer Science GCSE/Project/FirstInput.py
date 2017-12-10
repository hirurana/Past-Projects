#Initialise by importing the random library
import random

#setting up both lists
names = []
dob = []

#counter placed at 1
count = 0
#Presentation

#Take inputs
newName = input("Enter your full name (e.g Sam Smith): \n")
newNameLen = len(newName) #storing the length of the inputted name
#if the name entered is less than or equal to one character print an error
if newNameLen<=1:
    print("ERROR: Name must be more than one letter")
    #reask the question
    newName = input("Enter your name (e.g Sam Smith): \n")
for i in newName:
#if the name entered contains a number print an error message
    if i=="0" or i=="1" or i=="2" or i=="3" or i=="4" or i=="5" or i=="6" or i=="7" or i=="8" or i=="9":
        print("ERROR: Name must not have numbers")
        #reask the question
        newName = input("Enter your name (e.g Sam Smith): \n")
#ask for date of birth
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
