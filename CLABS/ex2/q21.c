#include <stdio.h>

int main(void) {
  int num = 0;
  while (num++ < 13) {
    int product = 0;
    product = num*13;
    printf("%i * 13 = %i\n", num, product);
  }
  return 0;
}
