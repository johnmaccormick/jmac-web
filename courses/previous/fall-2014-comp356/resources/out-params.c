#include <stdio.h>
#include <stdlib.h>

void getXandY(/*out*/ double *x, /*out*/ double *y)
{
  *x = 5.23;
  *y = 7.1;
}

void incrementMandN(/*in-out*/ int *m, /*in-out*/ int *n)
{
  *m = *m + 1;
  *n = *n + 1;
}

void getTwoArrays(/*out*/ int **array1, /*out*/ int **array2)
{
  int num1 = 10;
  int num2 = 50;
  int* a1 = malloc(sizeof(int)*num1);
  int* a2 = malloc(sizeof(int)*num2);
  int i, j;
  for(i=0; i<num1; i++){
    a1[i] = i;
  }
  for(j=0; j<num2; j++){
    a2[j] = j;
  }
  
  *array1 = a1;
  *array2 = a2;
}

int main(int argn, char* argv[])
{
  double a, b;
  int p, q;
  
  // exercise: get values of x and y, using getXandY(); store the results in a and b
  /* ... */
  // print out the results
  printf("a is %g, b is %g\n", a, b);

  p = 5;
  q = 7;
  // exercise: increment p and q using a single call to incrementMandN()
  /* ... */
  // print out the results
  printf("p is %d, q is %d\n", p, q);

  // exercise: understand why the following works
  int *firstArray, *secondArray;
  getTwoArrays(&firstArray, &secondArray);
  printf("firstArray[5] is %d, secondArray[25] is %d\n", 
	 firstArray[5], secondArray[25]);

  // exercise: free any memory that needs to be freed before the program exits
  /* ... */
}
