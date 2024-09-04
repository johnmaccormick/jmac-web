#include <stdio.h>

int main() {
#define ARRAY_SIZE 50000
    int my_array1[ARRAY_SIZE];
    int my_array2[ARRAY_SIZE];
    int my_array3[ARRAY_SIZE];

    int* my_array4 = malloc(sizeof(int)*ARRAY_SIZE);
    int* my_array5 = malloc(sizeof(int)*ARRAY_SIZE);

    int* first1 = &my_array1[0];
    int* last1 = &my_array1[ARRAY_SIZE-1];
    int* first2 = &my_array2[0];
    int* last2 = &my_array2[ARRAY_SIZE-1];
    int* first3 = &my_array3[0];
    int* last3 = &my_array3[ARRAY_SIZE-1];
    int* first4 = &my_array4[0];
    int* last4 = &my_array4[ARRAY_SIZE-1];
    int* first5 = &my_array5[0];
    int* last5 = &my_array5[ARRAY_SIZE-1];
    printf("Address of first element of array1 is %d\n", first1);
    printf("Address of last element of array1 is %d\n", last1);
    printf("Difference between them is %d\n", last1 - first1);
    printf("Address of first element of array2 is %d\n", first2);
    printf("Address of last element of array2 is %d\n", last2);
    printf("Address of first element of array3 is %d\n", first3);
    printf("Address of last element of array3 is %d\n", last3);
    printf("Address of first element of array4 is %d\n", first4);
    printf("Address of last element of array4 is %d\n", last4);
    printf("Difference between them is %d\n", last4 - first4);
    printf("first2 - first1 is %d\n", first2 - first1);
    printf("first3 - first2 is %d\n", first3 - first2);
    printf("first4 - first3 is %d\n", first4 - first3);
    printf("first5 - first4 is %d\n", first5 - first4);

    free(my_array4);

    return 0;
}
