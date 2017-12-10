#include <stdio.h>

int main(void) {
  for (int i = 0; i < 4; i++) {
    if (i == 0 || i == 3) {
      for (int j = 0; j < 5; j++) {
        printf("*");
      }
      printf("\n");
    } else {
      for (int k = 0; k < 5; k++) {
        if (k == 0 || k == 4) {
          printf("*");
        } else {
          printf(" ");
        }
      }
      printf("\n");
    }
  }

  return 0;
}
