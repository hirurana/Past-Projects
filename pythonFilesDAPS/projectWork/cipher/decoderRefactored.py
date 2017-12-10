import string
import enchant

alphaLetter = list(string.ascii_lowercase)


def wordCheck(word):
    dictionary = enchant.Dict()
    state = dictionary.check(word)
    return state


def findOffsetLong():
    counter = []
    for j in range(0, 26):
        counter.append(0)

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

    # most common letter compared to e to find offset
    offset = counter.index(max(counter)) - 4
    return offset


# brute force for smaller words
def findOffsetShort(word):
    newString = ''

    for offset in range(1, 26):
        for char in word:
            if char in alphaLetter:
                newString = newString + alphaLetter[(alphaLetter.index(char)+offset) % len(alphaLetter)]
            else:
                newString += char

        if wordCheck(newString):
            break
        else:
            newString = ''

    if (offset - 26) < 0:
        offset = abs(offset - 26)
    return offset


def writeToFile(shiftSize):
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
                        newChar = string.ascii_letters[(string.ascii_letters.index(char) - shiftSize)]
                        plain.write(newChar)

                # add any non characters
                if not flag:
                    plain.write(letter)


def getWordCount():
    string = open('encrypted.txt').read()
    wordCount = 0
    for word in string.split():
        wordCount += len(word)
    return wordCount


# get first word without any punctuation
def getFirstWord(index = None):
    if index is None:
        index = 0
    with open('encrypted.txt', 'rt') as file:
        content = file.read(30).lower()
        word = content.split()[index]
        if wordCheck(word):
            # raise Exception("File contains deciphered text")
            print("")
    for char in word:
        if not char.isalpha():
            index += 1
            getFirstWord(index)
            break
    # print(content.split()[index])
    # print(index)
    return content.split()[index]


def compareOffset(short, long):
    if long != short:
        total = getWordCount()
        if 0 < total < 10:
            return short
        elif total < 0:
            raise ValueError("Invalid File Size")
        else:
            return long
        # test a few words from the file to see if they are english
    else:
        return long


writeToFile(compareOffset(findOffsetShort(getFirstWord()), findOffsetLong()))




