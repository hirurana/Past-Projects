results = {"Hiru":(96,95,93,99),"Sandalu":(93,94,91,96),"Kasun":(32,65,43,54)}
subjects = ("Zoology","Physics","Biology","Chemistry")
subjectCount = 0
for name, scores in results.items():
    average = (scores[0]+scores[1]+scores[2]+scores[3])/4
    print(name+"'s average: "+str(average)+"%")

    highest = max(scores[:])
    print("Highest for is: "+str(highest)+"%")

#define result GRADES above 90 A 60 B 40 C else fail
    for score in scores:
        if (score>=90):
            print("The "+subjects[subjectCount]+" grade is A")
            subjectCount=subjectCount+1
        elif (score>=60):
            print("The "+subjects[subjectCount]+" grade is B")
            subjectCount=subjectCount+1
        elif (score>=40):
            print("The "+subjects[subjectCount]+" grade is C")
            subjectCount=subjectCount+1
        else:
            print("No grade can be awarded for "+subjects[subjectCount]+". Failed!")
            subjectCount=subjectCount+1
        if (subjectCount==3):
            subjectCount=subjectCount-4
#say what each subject score is.

