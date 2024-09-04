#include "stdio.h"

int main() 
{
  char input[8];
  printf("Please enter your name: ");
  gets(input);
  printf("\nHi, %s\n", input);
  return 0;
}
