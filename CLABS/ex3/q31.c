#include <stdio.h>
#include <math.h>

int main(void)
{
  int a,b,c;
  int perimeter;
  double area;
  double s;

  printf("Input length 1: ");
  scanf("%i",&a);

  printf("Input length 2: ");
  scanf("%i", &b);

  printf("Input length 3: ");
  scanf("%i", &c);


  perimeter = a + b + c;

  s = 0.5 * perimeter;

  area = sqrt(s * (s - a) * (s - b) * (s - c));

  printf("Area is %f and perimeter is %i\n", area, perimeter);

}
