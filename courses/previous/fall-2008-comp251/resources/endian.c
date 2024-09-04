#include "stdio.h"

int main() {
    int x = 0x12345678;

    char *address = &x;

    printf("hexadeciaml value of x is %x\n", x);
    printf("address of x is %x\n", address);

    int i;
    for (i = 0; i < 4; i++) {
        printf("decimal value of the byte at address %x is %d\n", address+i, address[i]);
    }
}
