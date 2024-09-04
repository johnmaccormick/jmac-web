/* produce assembly code with the command:
   gcc -S loop.c
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
