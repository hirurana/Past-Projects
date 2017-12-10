#include <stdio.h>
#include <math.h>
#include <string.h>
#include <stdlib.h>

//palindrome checker

int main(void) {
  int palin;
  int flag = 0;


  printf("Enter palindrome: ");
  scanf("%i", &palin);

  char stringPalin[50];
  sprintf(stringPalin, "%d", palin);


  int index = strlen(stringPalin) - 1;
  int count = 0;
  while (index > -1)
  {
    //printf("%c index: %i count: %i\n", stringPalin[index], index, count);
    if (stringPalin[index] != stringPalin[count]) {
      flag = 1;
      break;
    }
    index = index - 1;
    count++;
  }

  if (flag != 0) {
    printf("%i is not a palindrome\n", palin);
  } else {
    printf("%i is a palindrome\n", palin);
  }
  printf("\n");

  return 0;
}
