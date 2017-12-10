def myFirstSubroutine(myMessage, times):
    for i in range(0,times):
        print(myMessage)
    print("My message is : "+ myMessage + " , I called this "+ str(times) +" times")

myFirstSubroutine("Hello", 5)

