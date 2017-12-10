numberLimit = int(input("What limit of prime numbers do you want? "))
numbers=list(range(2,numberLimit+1))
n2 = 2
while n2<(numberLimit/2) :
    for i in numbers:
        if i/n2>1 and i%n2==0:
            numbers.remove(i)
    n2 = n2+1
for i in numbers:
        print (i)

