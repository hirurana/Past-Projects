#include <stdio.h>

int main(void) {

  for (int i = 1; i < 100; i++) {
    int flag = 1;
    for (int k = i-1; k > 0; k--)
    {
      if (k != 1 && (i % k == 0)) {
        flag = 0;
      }
    }

    if (flag == 1) {
      printf("%i is a prime number\n", i);
    }

  }
  return 0;
}
