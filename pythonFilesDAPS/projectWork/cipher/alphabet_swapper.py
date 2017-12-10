frequency = [9659, 55127, 13217, 30626, 426, 3920, 12127, 22767, 10167, 30261, 7485, 30580, 8670, 28540, 37846, 497, 38975, 615, 10817, 5819, 35686, 11421, 418, 11513, 19479, 30687]
alphabet = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']
known_frequency = ['E', 'T', 'A', 'O', 'I', 'N', 'S', 'R', 'H', 'L', 'D', 'C', 'U', 'M', 'F', 'P', 'G', 'W', 'Y', 'B', 'V', 'K', 'X', 'J', 'Q', 'Z']
deciphered_alphabet = ['', '', '', '', '','', '', '', '', '','', '', '', '', '','', '', '', '', '','', '', '', '', '','']


def create_alphabet():
    import string
    if len(alphabet) != 0:
        index = frequency.index(max(frequency))
        print(index)
        deciphered_alphabet[index] = known_frequency[0]
        # print(string.ascii_uppercase[index])
        # print(index)
        del frequency[index]
        del alphabet[index]
        del known_frequency[0]


        print(deciphered_alphabet)

        create_alphabet()



create_alphabet()