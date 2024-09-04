/* produce assembly code with the command:
   gcc loop.c -S -o loop.S 

   convert assembly code to an executable file using:
   gcc loop.S -o loop.exe 
*/

#include "stdio.h"

int main() {
    int i;
    int x=20;
    for(i=3; i<7; i++) {
        x = x+i;
        printf("%d\n",x);
    }
}
