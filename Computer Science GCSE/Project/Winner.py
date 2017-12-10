#REMOVE LATER######
import random
count=1
names=["BOB","Hiru"]
dob=["12","34"]
newName = input("Enter your full name (e.g Sam Smith): \n")
###################


#If user inputs end continue the program
if newName == "end": 
#generate a random number between number of people entered
    winnerIndex = random.randint(0,count)
#REMOVE#####
print(count)
############
print("The Winner is: "+names[winnerIndex]+", Date of Birth: "+dob[winnerIndex])
