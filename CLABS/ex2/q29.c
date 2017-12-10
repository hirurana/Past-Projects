#include <stdio.h>

int main(void) {
  int ii;

  //creating the rows
  for (int i = 0; i < 9; i++)
  {
    if (i == 0 || i == 8)
    {
      printf("*");
    }
    else
    {
      printf("*");

      //check if at bottom half
      if (i > 4)
      {
        ii = 8 - i;
      } else {
        ii = i;
      }

      //adding offset spaces
      for (int j = 0; j < ii-1; j++)
      {
        printf(" ");
      }
      printf("*");

    }



    printf("\n");
  }
  return 0;
}
