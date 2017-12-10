newName = input("Enter your name: \n")
numberRange = list(range(0,10))

for letter in newName:
    if letter == "0"or"1"or"2"or"3"or"4"or"5"or"6"or"7"or"8"or"9":
        print("error")
        break
