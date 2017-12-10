#include <stdio.h>

int main(void) {
  int count = 7;

  while (count-- > -1) {
    for (int j = 0; j < (7 - count); j++) {
      printf(" ");
    }
    for (int i = 0; i < count; i++) {
      printf("*");
    }
    printf("\n");
  }
  return 0;
}
