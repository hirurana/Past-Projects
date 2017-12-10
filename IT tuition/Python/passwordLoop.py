passwordInput = input("Enter the password: ")
password = "apple"
while (passwordInput!=password):
    print("Password incorrect!")
    passwordInput = input("Enter the password: ")
if (passwordInput==password):
    print("Password correct!")
    
