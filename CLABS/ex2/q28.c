#include <stdio.h>

int main(void) {

  //creating the rows
  for (int i = 0; i < 7; i++)
  {
    for (int j = 0; j < 6; j++)
    {
      //test if on even row
      if (i % 2 == 0)
      {
        //test if on even column
        if (j % 2 == 0) {
          printf("*");
        }
        else
        {
          printf("#");
        }
      }
      //else if on odd row
      else
      {
        //test if on even column
        if (j % 2 == 0) {
          printf("#");
        }
        else
        {
          printf("*");
        }
      }
    }
    printf("\n");

  }
  return 0;
}
