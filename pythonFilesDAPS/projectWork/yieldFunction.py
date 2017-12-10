def createGenerator():
    myList = range(30000)
    for i in myList:
        yield i * i


myGenerator = createGenerator()
print(myGenerator)
for j in myGenerator:
    print(j)
