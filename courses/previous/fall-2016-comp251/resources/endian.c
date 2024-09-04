#include "stdio.h"

int main() {
    int x = 0x12345678;

    char *address = (char*) &x;

    printf("hexadecimal value of x is %x\n", x);
    printf("address of x is %p\n", address);

    int i;
    for (i = 0; i < 4; i++) {
        printf("hexadecimal value of the byte at address %p is %x\n", address+i, address[i]);
    }
}
