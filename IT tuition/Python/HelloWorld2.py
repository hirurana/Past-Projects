#Volume & Surface area

radius = float(input("What is the radius of the cylinder?"));
height = float(input("What is the height of the cylinder?"));
pi = 3.14159;
volume = pi*radius*radius*height;
print ("The volume of the cylinder is "+str(volume));

surfaceArea = 2*pi*radius*(radius + height);
print ("The surface area is "+str(surfaceArea));


letter = input("Enter a character");
if letter=="a":
    print("Yes I am A")
    print("me too!")
elif letter=="b":
    print("I am B")
elif letter=="z" or "Z":
    print("I am Z!")
else:
    print("I am neither A nor B")
print("End of program...");

