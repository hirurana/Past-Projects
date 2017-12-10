#include "graphics.h"
#include <math.h>

int main(void){
  //outlining the building
  drawRect(30,30,300,1050);

  //adding windows
  drawRect(80,80,50,50);
  drawRect(230,80,50,50);
  drawRect(80,180,50,50);
  drawRect(230,180,50,50);
  drawRect(80,280,50,50);
  drawRect(230,280,50,50);
  drawRect(80,380,50,50);
  drawRect(230,380,50,50);
  return 0;
}
