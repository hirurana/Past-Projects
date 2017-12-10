def triangle(size):
#define the triangle with a "size" parameter
    line=""
    #define the empty value for the line
    for i in range(0,size):
    #Make a loop with the range of a given size
        for j in range(0,(size-1-i)+11-(size-1-i)-i): #how many spaces (3-1-1)+11-(3-1-1)-1=1+11-1=11
            line=line+" "
        for k in range(0,2*i+1): #2*1+1=3 stars
            line=line+"*" #adds the stars to the spaces
        print(line)
        line="" #makes a new line    
triangle(2)
triangle(3)
triangle(4)

