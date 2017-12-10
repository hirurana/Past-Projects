def peopleName(name1,name2):
    if len(name1)>len(name2):
        return name1
    if len(name1)<len(name2):
        return name2

print(peopleName("Hiru", "Kasun"))
