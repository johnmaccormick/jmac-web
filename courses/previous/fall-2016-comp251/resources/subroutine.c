/* produce assembly code with the command:
   gcc -S subroutine.c
*/

#include "stdio.h"

int mult(int x, int y) {
    return x * y;
}

int main() {
    int x = 5;
    int y = 7;
    int z = mult(x,y);
    printf("x = %d, y = %d, z = %d\n", x,y,z);
}
