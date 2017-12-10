import string





def calculate(exp):
    exp = exp.replace(" ", "").strip()  # strip spaces if present
    exp = list(exp)  # convert into a list of tokens

    # pointers to find most recent opening and closing bracket
    open_bracket_pointer = 0
    close_bracket_pointer = 0

    # test to see if there are equal opening and closing brackets
    # test to see if any non valid characters input
    num_of_opens = 0
    num_of_closes = 0

    # test to see if final answer has been found
    new_exp = ''
    if exp[0].isnumeric():
        # convert
        for digit in exp:
            new_exp += str(digit)
        print(new_exp)
        return new_exp ###############3 KEEPS RETURNING NONE

    # test to see if anything has been input
    if len(exp) == 0:
        raise IndexError("Nothing Input")

    for index in range(0, len(exp)):
        if exp[index] == "(":
            num_of_opens += 1
            open_bracket_pointer = index  # get closing bracket position
        elif exp[index] == ")":
            num_of_closes += 1
        # test for letters
        elif exp[index].isalpha():
            raise ValueError("No letters allowed in expression")
        elif exp[index] == "/" and exp[index+1] == "0":
            raise ZeroDivisionError()

    # get closing bracket position
    for index in range(open_bracket_pointer, len(exp)):
        if exp[index] == ")":
            close_bracket_pointer = index
            break

    if num_of_opens != num_of_closes:
        raise Exception("Not a valid expression. Bracketed expressions are not complete")

    def division(current_expression):
        ex1 = []
        ex2 = []

        for index in range(0, len(current_expression)):
            if current_expression[index] == "/":
                # get the numbers on the left hand side before the next non numeric value
                for i in range(index-1, -1, -1):
                    if current_expression[i].isnumeric():
                        ex1.append(current_expression[i])
                    else:
                        break
                ex1 = ex1[::-1]
                ex1 = int(''.join(ex1))

                # get the numbers on the right hand side before the next non-numeric value
                for j in range(index+1, len(current_expression)):
                    if current_expression[j].isnumeric():
                        ex2.append(current_expression[j])
                    else:
                        break
                ex2 = ex2[::-1]
                ex2 = int(''.join(ex2))

                result = ex1//ex2
                # print(close_bracket_pointer)
                # print(open_bracket_pointer)

                # replace the expression with the answer
                del exp[open_bracket_pointer:close_bracket_pointer+1]
                exp.append(result)
                new_exp = ''

                # convert
                for digit in exp:
                    new_exp += str(digit)
                # print(new_exp)
                calculate(new_exp)
        multiplication(current_expression)

    def multiplication(current_expression):
        ex1 = []
        ex2 = []

        for index in range(0, len(current_expression)):
            if current_expression[index] == "*":
                # get the numbers on the left hand side before the next non numeric value
                for i in range(index-1, -1, -1):
                    if current_expression[i].isnumeric():
                        ex1.append(current_expression[i])
                    else:
                        break
                ex1 = ex1[::-1]
                ex1 = int(''.join(ex1))

                # get the numbers on the right hand side before the next non-numeric value
                for j in range(index+1, len(current_expression)):
                    if current_expression[j].isnumeric():
                        ex2.append(current_expression[j])
                    else:
                        close_bracket_pointer = j
                        break ######### add code to update end point
                ex2 = ex2[::-1]
                ex2 = int(''.join(ex2))

                result = ex1*ex2
                # print(close_bracket_pointer)
                # print(open_bracket_pointer)
####### fix this bit. It removes the whole expression
                # replace the expression with the answer
                # del exp[open_bracket_pointer:close_bracket_pointer]
                print(result)
                print("hi" + str(exp))
                print()
                new_exp = ''

                # convert
                for digit in exp:
                    new_exp += str(digit)
                calculate(new_exp)
        addition(current_expression)

    def addition(current_expression):
        ex1 = []
        ex2 = []

        for index in range(0, len(current_expression)):
            if current_expression[index] == "+":
                # get the numbers on the left hand side before the next non numeric value
                for i in range(index-1, -1, -1):
                    if current_expression[i].isnumeric():
                        ex1.append(current_expression[i])
                    else:
                        break
                ex1 = ex1[::-1]
                ex1 = int(''.join(ex1))

                # get the numbers on the right hand side before the next non-numeric value
                for j in range(index+1, len(current_expression)):
                    if current_expression[j].isnumeric():
                        ex2.append(current_expression[j])
                    else:
                        break
                ex2 = ex2[::-1]
                ex2 = int(''.join(ex2))

                result = ex1+ex2
                # print(close_bracket_pointer)
                # print(open_bracket_pointer)

                # replace the expression with the answer
                del exp[open_bracket_pointer:close_bracket_pointer+1]
                exp.append(result)
                new_exp = ''

                # convert
                for digit in exp:
                    new_exp += str(digit)
                # print(new_exp)
                calculate(new_exp)
        substraction(current_expression)

    def substraction(current_expression):
        ex1 = []
        ex2 = []

        for index in range(0, len(current_expression)):
            if current_expression[index] == "-":
                # get the numbers on the left hand side before the next non numeric value
                for i in range(index - 1, -1, -1):
                    if current_expression[i].isnumeric():
                        ex1.append(current_expression[i])
                    else:
                        break
                ex1 = ex1[::-1]
                ex1 = int(''.join(ex1))

                # get the numbers on the right hand side before the next non-numeric value
                for j in range(index + 1, len(current_expression)):
                    if current_expression[j].isnumeric():
                        ex2.append(current_expression[j])
                    else:
                        break
                ex2 = ex2[::-1]
                ex2 = int(''.join(ex2))

                result = ex1 - ex2
                # print(close_bracket_pointer)
                # print(open_bracket_pointer)

                # replace the expression with the answer
                del exp[open_bracket_pointer:close_bracket_pointer + 1]
                exp.append(result)
                new_exp = ''

                # convert
                for digit in exp:
                    new_exp += str(digit)
                # print(new_exp)
                calculate(new_exp)
    # if only one bracket then do just that expression
    if num_of_opens > 1:
        # code for multiple expressions
        pass
    else:
        # code for single expression
        current_expression = exp[open_bracket_pointer+1:close_bracket_pointer]
        division(current_expression)



single = "(39 /3)"
long = "((3 * (8 /4)) /3)"
array = calculate(long)
print(array)
