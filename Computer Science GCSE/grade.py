#Assigning least possible scores with grades
U = int(0)
D = int(40)
C = int(50)
B = int(60)
A = int(70)
full = int(100)
#Asking user for score
grade = int(input("What is the raw score?"));
#Checking whether score qualifies for a U
if (grade<=D):
    print("The grade is a U")
#Checking whether score qualifies for a D
elif (grade<=C):
    print("The grade is a D")
#Checking whether score qualifies for a C
elif (grade<=B):
    print("The grade is a C")
#Checking whether score qualifies for a B
elif (grade<=A):
    print("The grade is an B")
#Checking whether score qualifies for a A
elif (grade<=full):
    print("The grade is an A")
#Produces this text if the score is over 100 percent (invalid)
elif (grade>100):
    print("Not a valid raw score")



