#include <stdio.h>

int main()
{
    char c;
    c = 'J';
    printf("Original char value: %x (hex), %u (decimal), %c (character)\n", c,c,c);

    c = c+1;
    printf("Value after incrementing: %x (hex), %u (decimal), %c (character)\n", c,c,c);

    c = c+10;
    printf("Value after adding another 10: %x (hex), %u (decimal), %c (character)\n", c,c,c);

    /* spell my name using only the declaration "char a='A'" and arithmetic */
    char a='A';
    printf("%c%c%c%c\n", a+9,a+14,a+7,a+13);
    
    /* challenge: spell your name using a similar line of code */

}
