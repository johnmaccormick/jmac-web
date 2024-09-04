int main()
{
    unsigned int i;
    i = 0xFFFFFFFF;
    printf("Original int value: %x (hex), %u (decimal)\n", i,i);
    i = i+1;
    printf("Value after incrementing: %x (hex), %u (decimal)\n", i,i);

    unsigned char c;
    c = 250;
    printf("Original int value: %x (hex), %u (decimal)\n", c,c);
    c = c+30;
    printf("Value after adding thirty: %x (hex), %u (decimal)\n", c,c);

/*     advanced task: work out how many bits are used to store the type "unsigned short" */

}
