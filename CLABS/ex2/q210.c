#include <stdio.h>

int main(void) {

  //creating the rows
  for (int i = 0; i < 8; i++)
  {
    //first row just *
    if (i == 0) {
      for (int j = 0; j < 7; j++) {
        printf("*");
      }
    }

    //last row just #
    else if (i == 7) {
      for (int k = 0; k < 7; k++) {
        printf("#");
      }
    }
    else
    {
      //adding the hash at front and astrisk at back
      for (int j = 0; j < 7; j++)
      {
        if (j == 0) {
          printf("#");
        }
        else if (j == 6)
        {
          printf("*");
        }
        else if (i == j)
        {
          printf("*");
        }
        else if (j == (i - 1)) 
        {
          printf("#");
        }
        else {
          printf(" ");
        }
      }
    }




    printf("\n");
  }


  return 0;
}
