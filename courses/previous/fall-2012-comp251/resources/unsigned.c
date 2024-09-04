int main()
{
    unsigned int i;
    i = 0x1A;
    printf("Original int value: %x (hex), %u (decimal)\n", i,i);
    i = i + 9;
    printf("Value after adding 9: %x (hex), %u (decimal)\n", i,i);

    i = 0xFFFFFFFF;
    printf("Original int value: %x (hex), %u (decimal)\n", i,i);
    i = i+1;
    printf("Value after adding 1: %x (hex), %u (decimal)\n", i,i);

    unsigned char c;
    c = 250;
    printf("Original int value: %x (hex), %u (decimal)\n", c,c);
    c = c+30;
    printf("Value after adding thirty: %x (hex), %u (decimal)\n", c,c);

/*  challenge 1: explain all of the output from the above code */

/*  challenge 2: explain how this resolves the "infinite loop" paradox from class 1 */


/*  challenge 3: work out how many bits are used to store the type "unsigned short" */

}
