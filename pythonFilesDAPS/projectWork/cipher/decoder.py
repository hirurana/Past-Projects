import string

# cannot keep global arrays must pass in and out
counter = []
alphaLetter = []


def setup():
    # store lowercase letters in array
    for i in string.ascii_lowercase:
        alphaLetter.append(i)

    for j in range(0,26):
        counter.append(0)


def createList():
    with open("encrypted.txt", "rt") as file:
        while True:
            # read one letter at a time and de-capitalise
            letter = file.read(1).lower()

            if not letter:
                break

            # update the 2d array to find the most common letter in cipher text
            index = 0
            for c in alphaLetter:
                if letter == c:
                    inc = counter[index] + 1
                    counter[index] = inc
                index += 1


def findOffset():
    # most common letter compared to e to find offset
    offset = counter.index(max(counter)) - 4
    return offset


def writeToFile():
    with open("encrypted.txt", "rt") as cipher:
        with open("plain.txt", "wt") as plain:
            while True:
                letter = cipher.read(1)

                if not letter:
                    break

                flag = False
                for char in string.ascii_letters:
                    if flag:
                        break

                    if letter == char:
                        flag = True
                        # find the new character by correcting the offset
                        newChar = string.ascii_letters[(string.ascii_letters.index(char) - findOffset())]
                        plain.write(newChar)

                # add any non characters
                if not flag:
                    plain.write(letter)


setup()
createList()
writeToFile()
