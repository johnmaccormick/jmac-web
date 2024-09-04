/* produce assembly code with the command:
   gcc -S variables.c
*/

#include "stdio.h"

int main() {
    int x = 5;
    int y = 7;
    int z = x + y;
    int *w = &x;
    int v = *w;
    printf("x = %d, y= %d, z = %d, w = %x, v = %d\n", 
           x,y,z,w,v);
}
