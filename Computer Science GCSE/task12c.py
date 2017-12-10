#welcome message
print("Welcome to the palindrome checker!")
    
#store the potential palindrome
palindrome = input("Please enter a word: ")

#return errors if it is not a word
for letter in palindrome:
    if letter==" ":
        print("ERROR: Please write a word not a sentence.")
        break

#define a reversed variable
reversedPalin = ""

#A loop that takes the reverses the palindrome
for reverse in reversed(palindrome):
    reversedPalin += reverse

#if the palindrome and the reverse match then it is a palindrome
if palindrome == reversedPalin:
    print(palindrome+" is a palindrome!")

#else return false
else:
    print(palindrome+" is not a palindrome.")

#Thank you message
print("Thank you for using the palindrome checker.")
    


