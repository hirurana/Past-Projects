primes=[]
number = 2
turn = 3
while number<11:
    while turn<10:
        remainder = turn%number
        if remainder == 1:
            primes.append(turn)
        turn=turn+1
        break
    number=number+1

print(primes)
