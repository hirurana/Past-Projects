score1 =int(input("Enter module 1 result: "))
score2 = int(input("Enter module 2 result: "))
print("Result ")
average = (score1+score2)/2
scores=[]
scores.append(score1)
scores.append(score2)
scores.append(average)
x=0
while x<3:
    if x == 0 :
        module = "Module 1 :"
    elif x == 1:
        module = "Module 2 :"
    else:
        module = "Average A Level Grade :"
    if scores[x]>80:
        print(module+"A")
    elif scores[x]>70:
        print(module+"B")
    elif scores[x]>60:
        print(module+"C")
    elif scores[x]>50:
        print(module+"D")
    elif scores[x]>40:
        print(module+"E")
    elif scores[x]>30:
        print(module+"F")
    else:
        print(module+"U")
    x=x+1
    
    
    
