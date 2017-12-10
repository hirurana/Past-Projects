marks=[]
questionCount=0
questionNum=1
while questionCount<10:
    enterNum = input("Enter score "+str(questionNum)+":")
    marks.append(enterNum)
    questionCount=questionCount+1
    questionNum=questionNum+1

highestMark=max(marks)
print("The highiest mark is: "+highestMark)
print(marks)
