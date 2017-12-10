#REMOVE#############
names=["BOB","Hiru"]
####################

AllList=""
time=0
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
elif AllList=="":
    print("ERROR: User has not typed either Y or N")
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




