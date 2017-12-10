'Lesson 2: Variables
'xyz assignment for Script 1
xyz = 4.98
'Assignment
LunchPrice = 4.98
'Script 1
PRINT "Clerk say: Lunch costs £"; xyz
PRINT "Tom says: You said £"; xyz/2; " for that lunch?"
'---BREAK---'
'Assignment 2
HalfPrice = LunchPrice/2
'Customer Name
customerName$ = "Tom"
'Script 2
PRINT "Clerk say: Lunch costs £"; xyz
PRINT customerName$;
PRINT " says: You said £"; LunchPrice/2; " for that lunch?"
'---BREAK---
'Variable changing value
summary$ = "Total count of fruit is "
bananas = 5
mangos = 3
apples = 7
totalFruit = totalFruit + bananas
totalFruit = totalFruit + mangos
totalFruit = totalFruit + apples
PRINT summary$; totalFruit
'---BREAK---
'INPUT and PROMPT
'Single number phone
PRINT "Pkease enter a phone number to dial"
phoneNumber$ = "1-435-223-1110"
PRINT "Now dialing "; phoneNumber$
PRINT "Phone is now ringing..."
PRINT "The number you have dialed... "; phoneNumber$
PRINT "is currently unavailable... Please try again later."
'Varible phone with INPUT command
PRINT "Please enter a phone number to dial."
INPUT phoneNumber$
PRINT "Now dialing "; phoneNumber$
PRINT "The phone is now ringing..."
PRINT "The number you have dialed is currently unavailble. Please try again later."
'---BREAK---
'Calculator
PRINT "Enter number."
INPUT firstNumber
PRINT "Enter another number"
INPUT secondNumber
PRINT "The sum of these two numbers is:"
PRINT firstNumber + secondNumber
'INPUT combined with PRINT
INPUT "What is your name?"; yourName$
'Calculator with INPUT combined with PRINT
INPUT "Enter a number?"; firstNumber
INPUT "Enter another number?"; secondNumber
PRINT "The sum of these two numbers is:"
PRINT firstNumber + secondNumber
'Prompt and Notice (similar to input and print)
prompt "Enter a number?"; firstNumber
prompt "Enter another number?"; secondNumber
notice "The sum of these two numbers is:"
notice firstNumber + secondNumber
