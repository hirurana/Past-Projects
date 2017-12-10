
def break_cipher(text):
    try:
        import enchant
    except ImportError:
        raise ImportError("Pyenchant is not installed")
    import string

    # cannot keep global arrays must pass in and out
    counter = []
    alphaLetter = []
    decipher_text = []

    def setup():
        # store lowercase letters in array
        for i in string.ascii_uppercase:
            alphaLetter.append(i)

        for j in range(0, 26):
            counter.append(0)

    def createList():
        for letter in text:

            # update the 2d array to find the most common letter in cipher text
            index = 0
            for char in alphaLetter:
                if letter == char:
                    inc = counter[index] + 1
                    counter[index] = inc
                index += 1

    def findOffset():
        # most common letter compared to e to find offset
        offset = counter.index(max(counter)) - 4
        return offset

    def word_check(word):
        dictionary = enchant.Dict()
        state = dictionary.check(word)
        return state

    def writeToFile():
        for letter in text:
            for char in string.ascii_letters:
                if letter == char:
                    # find the new character by correcting the offset
                    newChar = string.ascii_uppercase[(string.ascii_uppercase.index(char) - findOffset())]
                    decipher_text.append(newChar)
                    decipher = ''.join(decipher_text)
        return decipher

    setup()
    createList()
    original_text = writeToFile()
    return original_text






string = "ehfdxvhhdfkohwwhulqwkhphvvdjhkdvdgluhfwwudqvodwlrq wr dqrwkhu ohwwhu, iuhtxhqfb dqdobvlv fdq eh xvhg wr ghflskhu wkh phvvdjh. iru hadpsoh, wkh ohwwhu h lv wkh prvw frpprqob xvhg ohwwhu lq wkh hqjolvk odqjxdjh. wkxv, li wkh prvw frpprq ohwwhu lq d vhfuhw phvvdjh lv n, lw lv olnhob wkdw n uhsuhvhqwv h. dgglwlrqdoob, frpprq zrug hqglqjv vxfk dv LQJ, OB, dqg HV dovr jlyh foxhv"
string = string.replace(" ", "").upper()
print(break_cipher(string))
