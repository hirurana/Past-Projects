#include <stdio.h>

int main(void) {

  //printing rows
  for (int row = 0; row < 9; row++) {

    if (row > 3)
    {
      //printing whitespaces for bottom half
      for (int j = 0; j < (8 - row); j++) 
      {
        printf(" ");
      }
    }

    else
    {
      //printing whitespaces for top half
      for (int i = 0; i < row; i++)
      {
        printf(" ");
      }
    }


    //printing stars
    for (int starCount = 0; starCount < 5; starCount++)
    {
      printf("*");
    }
    printf("\n");
  }
  return 0;
}
