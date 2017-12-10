#include <stdio.h>

int main(void) {
  //creating the rows
  for (int i = 0; i < 7; i++)
  {


    //creating loops for rows no structure
    for (int j = 0; j < 8; j++)
    {
      //creating top and bottom row
      if (i == 0 || i == 6)
      {
        printf("*");
      }

    //creating 2nd bot and top

      if (i == 1 || i == 5)
      {
        if (j == 0 || j == 7)
        {
          printf("*");
        }
        else
        {
          printf(" ");
        }
      }

      //creating 3rd bot and top
      if (i == 2 || i == 4)
      {
        //creating * at either end
        if (j == 0 || j == 6)
        {
          printf("*");
        }

        //adding middle hashtags
        if (j == 1 || j == 2 || j == 3 || j == 4)
        {
          printf("#");
        }
        else
        {
          printf(" ");
        }

      }

      //creating middle row
      if (i == 3)
      {
        //creating * at either end
        if (j == 0 || j == 6)
        {
          printf("*");
        }

        //adding middle hashtags
        if (j == 1 || j == 4)
        {
          printf("#");
        }
        else
        {
          printf(" ");
        }

      }

    }
    printf("\n");
  }


  return 0;
}
