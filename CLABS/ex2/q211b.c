#include <stdio.h>

int main(void) {

  for (int i = 1; i < 102; i++) {
    if (i % 2 == 0) {
      int square = i * i;
      printf("%i\n", square);
    }
  }
  return 0;
}
