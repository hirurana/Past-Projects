#include "graphics.h"
//program creates increasingly larger ovals from the same starting point
int main(void)
{
  int factor = 50;
  int width = 0;
  int height = 0;
  int index = 0;
  while (index < 9)
    {
      width = factor + 20;
      height = factor;
      drawOval(200,100,width,height);
      factor += 10;
      index += 1;
    }

 return 0;
}
