# open a file
with open("foo.txt", "wt") as fo:
    fo.write("idiot")

with open("foo.txt", "rt") as fo2:
    line = fo2.readline()
    print(line)
    pos = fo2.tell()
    fo2.seek(2)
    b = fo2.read(3)

print("Current pos: " + str(pos))
print("b is: " + b)


