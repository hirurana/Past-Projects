#Setting the least possible mark for the grades
U = int(0)
D = int(40)
C = int(50)
B = int(60)
A = int(70)
full = int(100)

#Asking the user what the test percentage
grade = int(input("What is the percentage?"));

#If the percentage is over 0 present the grade as U
if (grade<=D):
    print("The grade is a U")
    Module1Grade = U

#If the percentage qualifies a U and is over 40 present the grade as D
elif (grade<=C):
    print("The grade is a D")
    Module1Grade = D

#If the percentage qualifies a D and is over 50 present the grade as C
elif (grade<=B):
    print("The grade is a C")
    Module1Grade = C

#If the percentage qualifies a C and is over 60 present the grade as B
elif (grade<=A):
    print("The grade is an B")
    Module1Grade = B

#If the percentage qualifies a B and is over 70 present the grade as A
elif (grade<=full):
    print("The grade is an A")
    Module1Grade = A

#If the percentage is over 100 then the score is invalid
elif (grade>100):
    print("Not a valid percentage")

#Module 2:
#Asking the user what the test percentage
grade = int(input("What is the percentage?"));

#If the percentage is over 0 present the grade as U
if (grade<=D):
    print("The grade is a U")
    Module2Grade = U

#If the percentage qualifies a U and is over 40 present the grade as D
elif (grade<=C):
    print("The grade is a D")
    Module2Grade = D

#If the percentage qualifies a D and is over 50 present the grade as C
elif (grade<=B):
    print("The grade is a C")
    Module2Grade = C

#If the percentage qualifies a C and is over 60 present the grade as B
elif (grade<=A):
    print("The grade is an B")
    Module2Grade = B

#If the percentage qualifies a B and is over 70 present the grade as A
elif (grade<=full):
    print("The grade is an A")
    Module2Grade = A

#If the percentage is over 100 then the score is invalid
elif (grade>100):
    print("Not a valid percentage")

#Averaging the grade:
def gradeA():
    print("Average grade is A")

def gradeB():
    print("Average grade is B")

def gradeC():
    print("Average grade is C")

def gradeD():
    print("Average grade is D")

def gradeU():
    print("Average grade is U")

    
if (Module1Grade == A) and (Module2Grade == A):
    gradeA()
elif (Module1Grade == A) and (Module2Grade == B):
    gradeA()
elif (Module1Grade == B) and (Module2Grade == A):
    gradeA()
elif (Module1Grade == B) and (Module2Grade == B):
    gradeB()
elif (Module1Grade == B) and (Module2Grade == C):
    gradeB()
elif (Module1Grade == C) and (Module2Grade == B):
    gradeB()
elif (Module1Grade == C) and (Module2Grade == C):
    gradeC()
elif (Module1Grade == C) and (Module2Grade == D):
    gradeC()
elif (Module1Grade == D) and (Module2Grade == D):
    gradeD()
elif (Module1Grade == D) and (Module2Grade == U):
    gradeD()
elif (Module1Grade == U) and (Module2Grade == D):
    gradeD()
elif (Module1Grade == U) and (Module2Grade == U):
    gradeU()
    

    
