

def estimate_pi(precision):
    """
    Due to the nature that this function depends on 9999999 random coordinates, the probability of getting the exact
    value of pi is quite small and can only be achieved by either doing more computations (which would make the program
    very slow) or by comparing the value estimated with the actual value of pi. I did not take this approach even though
    I would have found a more precise answer because I think this defeats the purpose of finding pi

    The way in which this function works is by using a quarter of a circle (of radius 1) and a square of length one
    and calculating the distance from the centre of the sector (and the corner of the square) to the x,y coordinate
    generated. If the length is greater than the radius of the circle then it is outside of the circle otherwise it is
    within the circle. This uses monte carlo's method to calculate pi
    """
    import math
    import random

    hits = 0
    total = 9999999

    if precision > 6:
        raise Exception("Precision is too high")

    for hit in range(0, total):
        # generating coordinates between 0 and 1
        x = random.random()
        y = random.random()

        # applying pythagoras to get length from origin to point
        hypotenuse = math.sqrt((x**2) + (y**2))

        # check if hypotenuse is less than the radius of the sector
        if hypotenuse < 1.0:
            hits += 1

    # apply the monte carlo formula
    pi = (hits / total) * 4

    # reduce the long float to a chosen number of decimal places
    print(str("%." + str(precision) + "f") % pi)
    return pi


def break_cipher(text):
    """
    This function takes a string, which is assumed to be long in length in all caps with only uppercase letters and no
    punctuation or whitespace. Frequency analysis is used to guess what the cipher letter maps onto before the original
    alphabet was shuffled. The order of frequency of the letters in the english alphabet was sourced from the Cornell
    University's website where they had analysed the frequency of letters of over 40,000 words. Link:
    https://www.math.cornell.edu/~mec/2003-2004/cryptography/subs/frequencies.html

    Obviously because this uses the probability to that a letter is frequent, the final result is not always accurate
    however the code should make logical sense.

    """
    import collections
    cipher_text = list(text)

    # list containing the most common words in the english language in order from most to least common
    known_frequency_order = ['E', 'T', 'A', 'O', 'I', 'N', 'S', 'R', 'H', 'D', 'L', 'U', 'C', 'M', 'F', 'Y', 'W', 'G', 'P',
                       'B', 'V', 'K', 'X', 'Q', 'J', 'Z']

    # list to store the dictionary in list form
    stripped_dictionary = []
    deciphered_text = []

    # create a dictionary to store the frequency of each letter in the alphabet
    frequency = collections.Counter(cipher_text)
    # get the mos
    for key in frequency.most_common():
        stripped_dictionary.append(key[0])
    for letter in cipher_text:
        cipher_position = stripped_dictionary.index(letter)
        deciphered_text.append(known_frequency_order[cipher_position])

    deciphered_text = ''.join(deciphered_text)

    return deciphered_text



def calculate(exp):
    import string
    """
    This function takes a simple expression and simplifies it until eventually there is a single integer answer.
    It will not work when there is more than one operator in the expression but this was not mentioned in the assignment.
    I couldn't get the function to return the value but I can get it to print.
    """
    exp = exp.replace(" ", "").strip()  # strip spaces if present

    exp = list(exp)  # convert into a list of tokens

    # pointers to find most recent opening and closing bracket
    open_bracket_pointer = 0
    close_bracket_pointer = 0

    # test to see if there are equal opening and closing brackets
    # test to see if any non valid characters input
    num_of_opens = 0
    num_of_closes = 0

    # search for negative numbers
    # find the number of opening brackets and find the last opening bracket
    for index in range(0, len(exp)):
        if exp[index] == "(":
            num_of_opens += 1
            open_bracket_pointer = index

        # count closing brackets
        elif exp[index] == ")":
            num_of_closes += 1
        # test for letters
        elif exp[index].isalpha():
            raise ValueError("No letters allowed in expression")
        elif exp[index] == "/" and exp[index+1] == "0":
            raise ZeroDivisionError("This is not allowed")
        elif exp[index] == "-":
            for character in string.punctuation:
                if exp[index-1] == character:
                    raise ValueError("Negative numbers are not allowed")




    # get closing bracket position
    for index in range(open_bracket_pointer, len(exp)):
        if exp[index] == ")":
            close_bracket_pointer = index
            break

    # test for non closing brackets
    if num_of_opens != num_of_closes:
        raise Exception("Not a valid expression. Bracketed expressions are not complete")

    # get innermost bracket
    innermost_exp = exp[open_bracket_pointer+1:close_bracket_pointer]

    # run all of this code if the there are opening and closing brackets
    if num_of_opens != 0 and num_of_opens != 0:
        def division(current_expression):
            # temporarily store the left and right side numbers of the operator
            ex1 = []
            ex2 = []
            # flag to see if function ran
            function_ran = False

            for index in range(0, len(current_expression)):
                # if a division symbol is found run the code for it
                if current_expression[index] == "/":
                    function_ran = True
                    # get the numbers on the left hand side before the next non numeric value
                    for i in range(index-1, -1, -1):
                        if current_expression[i].isnumeric():
                            ex1.append(current_expression[i])
                        else:
                            # if not numeric break out of the loop to only get numbers
                            break
                    ex1 = ex1[::-1] # reverse the output to get the proper number
                    if ex1[0] == 0:
                        raise ValueError("0xxx format is not allowed")
                    ex1 = int(''.join(ex1)) # convert list to a integer

                    # get the numbers on the right hand side before the next non-numeric value
                    for j in range(index+1, len(current_expression)):
                        if current_expression[j].isnumeric():
                            ex2.append(current_expression[j])
                        else:
                            break
                    ex2 = ex2[::-1]
                    if ex2[0] == 0:
                        raise ValueError("0xxx format is not allowed")
                    ex2 = int(''.join(ex2))

                    result = ex1//ex2

                    # replace the expression with the answer by chopping off the bits after the operator adding
                    # the result then adding the bits after the operator again
                    del exp[open_bracket_pointer:close_bracket_pointer+1]
                    extracted = exp[open_bracket_pointer:]
                    del exp[open_bracket_pointer:]
                    exp.append(str(result))
                    new_exp = exp + extracted
                    # convert new expression into a string to run through function again
                    new_exp = ''.join(new_exp)
            if function_ran:
                # if the function ran then start again
                calculate(new_exp)
            else:
                # otherwise run the next operation in bidmas
                multiplication(current_expression)

        # same function but does * instead
        def multiplication(current_expression):
            ex1 = []
            ex2 = []
            function_ran = False
            for index in range(0, len(current_expression)):
                if current_expression[index] == "*":
                    function_ran = True
                    # get the numbers on the left hand side before the next non numeric value
                    for i in range(index - 1, -1, -1):
                        if current_expression[i].isnumeric():
                            ex1.append(current_expression[i])
                        else:
                            break
                    ex1 = ex1[::-1]
                    if ex1[0] == 0:
                        raise ValueError("0xxx format is not allowed")
                    ex1 = int(''.join(ex1))

                    # get the numbers on the right hand side before the next non-numeric value
                    for j in range(index + 1, len(current_expression)):
                        if current_expression[j].isnumeric():
                            ex2.append(current_expression[j])
                        else:
                            break
                    ex2 = ex2[::-1]
                    if ex2[0] == 0:
                        raise ValueError("0xxx format is not allowed")
                    ex2 = int(''.join(ex2))

                    result = ex1 * ex2

                    # replace the expression with the answer
                    del exp[open_bracket_pointer:close_bracket_pointer + 1]

                    extracted = exp[open_bracket_pointer:]
                    del exp[open_bracket_pointer:]
                    exp.append(str(result))
                    new_exp = exp + extracted
                    new_exp = ''.join(new_exp)
            if function_ran:
                calculate(new_exp)
            else:
                addition(current_expression)

        def addition(current_expression):
            ex1 = []
            ex2 = []
            function_ran = False
            for index in range(0, len(current_expression)):
                if current_expression[index] == "+":
                    function_ran = True
                    # get the numbers on the left hand side before the next non numeric value
                    for i in range(index - 1, -1, -1):
                        if current_expression[i].isnumeric():
                            ex1.append(current_expression[i])
                        else:
                            break
                    ex1 = ex1[::-1]
                    if ex1[0] == 0:
                        raise ValueError("0xxx format is not allowed")
                    ex1 = int(''.join(ex1))

                    # get the numbers on the right hand side before the next non-numeric value
                    for j in range(index + 1, len(current_expression)):
                        if current_expression[j].isnumeric():
                            ex2.append(current_expression[j])
                        else:
                            break
                    ex2 = ex2[::-1]
                    if ex2[0] == 0:
                        raise ValueError("0xxx format is not allowed")
                    ex2 = int(''.join(ex2))

                    result = ex1 + ex2

                    # replace the expression with the answer
                    del exp[open_bracket_pointer:close_bracket_pointer + 1]

                    extracted = exp[open_bracket_pointer:]
                    del exp[open_bracket_pointer:]
                    exp.append(str(result))
                    new_exp = exp + extracted
                    new_exp = ''.join(new_exp)
            if function_ran:
                calculate(new_exp)
            else:
                subtraction(current_expression)

        def subtraction(current_expression):
            ex1 = []
            ex2 = []
            function_ran = False
            for index in range(0, len(current_expression)):
                if current_expression[index] == "-":
                    function_ran = True
                    # get the numbers on the left hand side before the next non numeric value
                    for i in range(index - 1, -1, -1):
                        if current_expression[i].isnumeric():
                            ex1.append(current_expression[i])
                        else:
                            break
                    ex1 = ex1[::-1]
                    if ex1[0] == 0:
                        raise ValueError("0xxx format is not allowed")
                    ex1 = int(''.join(ex1))

                    # get the numbers on the right hand side before the next non-numeric value
                    for j in range(index + 1, len(current_expression)):
                        if current_expression[j].isnumeric():
                            ex2.append(current_expression[j])
                        else:
                            break
                    ex2 = ex2[::-1]
                    if ex2[0] == 0:
                        raise ValueError("0xxx format is not allowed")
                    ex2 = int(''.join(ex2))

                    result = ex1 - ex2

                    # replace the expression with the answer
                    del exp[open_bracket_pointer:close_bracket_pointer + 1]

                    extracted = exp[open_bracket_pointer:]
                    del exp[open_bracket_pointer:]
                    exp.append(str(result))
                    new_exp = exp + extracted
                    new_exp = ''.join(new_exp)

            if function_ran:
                calculate(new_exp)

        # starts the chain by running division first
        division(innermost_exp)

    else:
        if not exp[-1].isnumeric():
            raise ValueError("There is an invalid operator at end of string")
        # if there is no brackets the output the final number
        final_result = ''.join(exp)
        print(final_result)
        # return final_result This does not work keeps returning none



