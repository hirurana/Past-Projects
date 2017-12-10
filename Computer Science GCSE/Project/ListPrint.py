names=["Hiru","Keval"]
ListPrintRequest = input("Show all candidates?: (Y/N)")
if ListPrintRequest=="Y":
    for listprint in names:
        print(listprint)

PrintNames=input("Print names? Y/N: ")
if PrintNames=="Y":
    for i in names:
        print(i)
elif PrintNames=="N":
    print("Thank you")
else:
    print("ERROR: User has not entered Y or N")

ListPrint=""
printList = input("Print all the candidates: (Y/N)")
print(printList)

if printList=="Y" or printList=="y":
    ListPrint=True
if ListPrint==True:
    for i in names:
        print(i)
elif printList=="N" or printList=="n":
    ListPrint=False

if ListPrint==False:
    print("Thank you")

else:
    print("ERROR: Input not equal to Y or N")
