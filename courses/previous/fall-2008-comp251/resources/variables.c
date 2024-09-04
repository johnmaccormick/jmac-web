/* produce assembly code with the command:
   gcc variables.c -S -o variables.S 

   convert assembly code to an executable file using:
   gcc variables.S -o variables.exe 
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
