#include <stdio.h>

int main(void) {
  int lower, upper;

  printf("Enter first number: ");
  scanf("%d", &lower);
  printf("Enter second number: ");
  scanf("%d", &upper);

  if (lower > upper) {
    int temp = upper;
    upper = lower;
    lower = temp;
  }


  return 0;
}
