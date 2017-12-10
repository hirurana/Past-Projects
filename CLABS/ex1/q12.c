//Written by Hiru Ranasinghe 06/10/17
//This program displays my name

#include <stdio.h>
#include <string.h>
int main(void)
{
 char myName[] = "Hiru Ranasinghe";
 char name[] = "Dept. of Computer Science";
 char address[] = "Malet Place Engineering Building";
 printf("Hello, my name is %s\n", myName);
 printf("I am from the %s\n", name);
 printf("Which is located in the %s", address);

 int index = strlen(myName) - 1;
 while (index > -1)
 {
 printf("%c", myName[index]);
 index = index - 1;
 }
 printf("\n");
 return 0;
}
