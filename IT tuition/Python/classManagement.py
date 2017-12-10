#making empty lists
names=[]
maths=[]
chemistry=[]
physics=[]
biology=[]
englishLang=[]
englishLit=[]
Spanish=[]
Geography=[]
PE=[]
ComputerSci=[]
stats=[]

questionCount=0
questionNum=1

while questionCount<3:
    studentNames=input(str(questionNum)+". Type your name: ")
    names.append(studentNames)
    questionCount=questionCount+1
    questionNum=questionNum+1
if (questionCount==3):
    questionCount =questionCount-3
    questionNum=questionNum-3
    while questionCount<3:
        mathsScore=input(str(questionNum)+". Type your Maths score: ")
        maths.append(mathsScore)
        questionCount=questionCount+1
        questionNum=questionNum+1
if (questionCount==3):
    questionCount =questionCount-3
    questionNum=questionNum-3
    while questionCount<3:
        chemistryScore=input(str(questionNum)+". Type your Chemistry score: ")
        chemistry.append(chemistryScore)
        questionCount=questionCount+1
        questionNum=questionNum+1
if (questionCount==3):
    questionCount =questionCount-3
    questionNum=questionNum-3
    while questionCount<3:
        physicsScore=input(str(questionNum)+". Type your Physics score: ")
        physics.append(physicsScore)
        questionCount=questionCount+1
        questionNum=questionNum+1
if (questionCount==3):
    questionCount =questionCount-3
    questionNum=questionNum-3
    while questionCount<3:
        biologyScore=input(str(questionNum)+". Type your Biology score: ")
        biology.append(biologyScore)
        questionCount=questionCount+1
        questionNum=questionNum+1
if (questionCount==3):
    questionCount =questionCount-3
    questionNum=questionNum-3
    while questionCount<3:
        englishLangScore=input(str(questionNum)+". Type your English Language score: ")
        englishLang.append(englishLangScore)
        questionCount=questionCount+1
        questionNum=questionNum+1
if (questionCount==3):
    questionCount =questionCount-3
    questionNum=questionNum-3
    while questionCount<3:
        englishLitScore=input(str(questionNum)+". Type your English Literature score: ")
        englishLit.append(englishLangScore)
        questionCount=questionCount+1
        questionNum=questionNum+1
if (questionCount==3):
    questionCount =questionCount-3
    questionNum=questionNum-3
    while questionCount<3:
        SpanishScore=input(str(questionNum)+". Type your Spanish score: ")
        Spanish.append(SpanishScore)
        questionCount=questionCount+1
        questionNum=questionNum+1
if (questionCount==3):
    questionCount =questionCount-3
    questionNum=questionNum-3
    while questionCount<3:
        GeographyScore=input(str(questionNum)+". Type your Geography score: ")
        Geography.append(GeographyScore)
        questionCount=questionCount+1
        questionNum=questionNum+1
if (questionCount==3):
    questionCount =questionCount-3
    questionNum=questionNum-3
    while questionCount<3:
        PEScore=input(str(questionNum)+". Type your PE score: ")
        PE.append(PEScore)
        questionCount=questionCount+1
        questionNum=questionNum+1
if (questionCount==3):
    questionCount =questionCount-3
    questionNum=questionNum-3
    while questionCount<3:
        ComputerSciScore=input(str(questionNum)+". Type your Computer Science score: ")
        ComputerSci.append(ComputerSciScore)
        questionCount=questionCount+1
        questionNum=questionNum+1
if (questionCount==3):
    questionCount =questionCount-3
    questionNum=questionNum-3
    while questionCount<3:
        statsScore=input(str(questionNum)+". Type your stats score: ")
        stats.append(statsScore)
        questionCount=questionCount+1
        questionNum=questionNum+1
print("")
if (questionCount==3):
    questionCount =questionCount-3
    questionNum=questionNum-3
youGotNum = 0
while questionCount<3:
    print(names[youGotNum]+" you got:")
    print(maths[youGotNum]+"% for Maths")
    print(chemistry[youGotNum]+"% for Chemistry")
    print(physics[youGotNum]+"% for Physics")
    print(biology[youGotNum]+"% for Biology")
    print(englishLang[youGotNum]+"% for English Language")
    print(englishLit[youGotNum]+"% for English Literature")
    print(Spanish[youGotNum]+"% for Spanish")
    print(Geography[youGotNum]+"% for Geography")
    print(PE[youGotNum]+"% for PE")
    print(ComputerSci[youGotNum]+"% for Computer Science")
    print(stats[youGotNum]+"% for Stats")
    print(" ")
    youGotNum=youGotNum+1
    questionCount=questionCount+1

highestMaths = max(maths)
highestChem = max(chemistry)
highestPhysics = max(physics)
highestBio = max(biology)
highestLang = max(englishLang)
highestLit = max(englishLit)
highestSpan = max(Spanish)
highestGeog = max(Geography)
highestPE = max(PE)
highestComp = max(ComputerSci)
higheststats = max(stats)
print("The highest mark in Maths is "+highestMaths)
print("The highest mark in Chemistry is "+highestChem)
print("The highest mark in Maths is "+highestPhysics)
print("The highest mark in Maths is "+highestBio)
print("The highest mark in Maths is "+highestLang)
print("The highest mark in Maths is "+highestLit)
print("The highest mark in Maths is "+highestSpan)
print("The highest mark in Maths is "+highestGeog)
print("The highest mark in Maths is "+highestPE)
print("The highest mark in Maths is "+highestComp)
print("The highest mark in Maths is "+higheststats)


