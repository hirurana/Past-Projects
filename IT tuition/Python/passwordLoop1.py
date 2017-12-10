password = "apple"
isEqualPasswords = False
passwordTry = 0
while isEqualPasswords == False and passwordTry<3:
    passwordInput = input("Enter the password: ")
    if (passwordInput==password):
        isEqualPasswords = True
    if isEqualPasswords :
        print("Password correct!")
    else :
        print("Password incorrect!")
        passwordTry=passwordTry+1
        if passwordTry==3:
            print("Password incorrect please contact system administrator")
            
            

print ("End of the password guessing excercise")
   

    
