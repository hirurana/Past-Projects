#include <stdio.h>

int main(void) {
  int num = 1;

  do {
    int product = num * 13;
    printf("%i * 13 = %i\n", num, product);
  } while(num++ < 13);

  return 0;
}
