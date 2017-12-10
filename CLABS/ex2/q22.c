#include <stdio.h>

int main(void) {
  for (int num = 0; num < 13; num++) {
    int product = 0;
    product = num*13;
    printf("%i * 13 = %i\n", num, product);
  }
  return 0;
}
