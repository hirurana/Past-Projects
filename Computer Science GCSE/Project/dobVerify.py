dob = []


#ask for date of birth
newDob = input("Enter you date of birth in this format (e.g 10/08/99): \n")

if int(newDob[0])>3:
    print("ERROR1")
    newDob = input("Enter you date of birth in this format (e.g 10/08/99): \n")
elif int(newDob[3])>1:
    print("ERROR2")
    newDob = input("Enter you date of birth in this format (e.g 10/08/99): \n")
elif int(newDob[3])==1 and int(newDob[4])>2:
    print("ERROR3")
    newDob = input("Enter you date of birth in this format (e.g 10/08/99): \n")

dob.append(newDob)
