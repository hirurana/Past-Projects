names= ["Alf","Betsy","Charlie","David"]
print(names[2])
print(len(names))

names[2] = "Bob"
print(names[2])
print(len(names))

friends=[]
friends.append("Lewis")
friends.append("Sam")
print(friends)
friends.append(names)
print(friends)
friends.pop(2)
print(friends)

friends.append(names.split())
