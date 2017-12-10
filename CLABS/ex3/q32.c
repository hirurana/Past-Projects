#include <stdio.h>

//declaring function
int raisePower1(int base, int power);
int raisePower2(int base, int power, int result);

int main(void) {
  int result;
  int base;
  int power;
  int output;

  printf("Enter base: ");
  scanf("%i", &base);

  printf("Enter power: ");
  scanf("%i", &power);

  //output = raisePower1(base, power);
  output = raisePower2(base, power, result=0);

  //printf("Result is: %i\n", output);
  return 0;
}

//function using for loop
int raisePower1(int base, int power)
{
  int result = base;
  for (int i = power - 1; i > 0; i--) {
    result = base * result;
  }
  return result;
}

//function using recursion
int raisePower2(int base, int power, int result)
{
  if (result == 0)
  {
    result = base;
    power--;
    raisePower2(base, power, result);
  } else if (power > 0) {
    result = result * base;
    power--;
    raisePower2(base, power, result);
  } else {
    printf("Result is: %i\n", result);
  }
  return 0;
}
