
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
            raise ZeroDivisionError("This is not allowed")

    # get closing bracket position
    for index in range(open_bracket_pointer, len(exp)):
        if exp[index] == ")":
            close_bracket_pointer = index
            break

    if num_of_opens != num_of_closes:
        raise Exception("Not a valid expression. Bracketed expressions are not complete")

    innermost_exp = exp[open_bracket_pointer+1:close_bracket_pointer]

    if num_of_opens == 0 and num_of_opens == 0:
        exp = ''.join(exp)
        print(exp)
        return exp

    def division(current_expression):
        ex1 = []
        ex2 = []
        function_ran = False
        for index in range(0, len(current_expression)):
            if current_expression[index] == "/":
                function_ran = True
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

                # replace the expression with the answer
                del exp[open_bracket_pointer:close_bracket_pointer+1]

                extracted = exp[open_bracket_pointer:]
                del exp[open_bracket_pointer:]
                exp.append(str(result))
                new_exp = exp + extracted
                new_exp = ''.join(new_exp)
        if function_ran:
            calculate(new_exp)
        else:
            multiplication(current_expression)

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
                ex1 = int(''.join(ex1))

                # get the numbers on the right hand side before the next non-numeric value
                for j in range(index + 1, len(current_expression)):
                    if current_expression[j].isnumeric():
                        ex2.append(current_expression[j])
                    else:
                        break
                ex2 = ex2[::-1]
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
                ex1 = int(''.join(ex1))

                # get the numbers on the right hand side before the next non-numeric value
                for j in range(index + 1, len(current_expression)):
                    if current_expression[j].isnumeric():
                        ex2.append(current_expression[j])
                    else:
                        break
                ex2 = ex2[::-1]
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

                # replace the expression with the answer
                del exp[open_bracket_pointer:close_bracket_pointer + 1]

                extracted = exp[open_bracket_pointer:]
                del exp[open_bracket_pointer:]
                exp.append(str(result))
                new_exp = exp + extracted
                new_exp = ''.join(new_exp)

        if function_ran:
            calculate(new_exp)

    division(innermost_exp)




long = "((3 * (8 /4)) /3)"
array = calculate(long)
print(array)
