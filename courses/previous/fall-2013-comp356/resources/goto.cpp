#include <iostream>

using namespace std;

void doSomeStuff() {}
void doSomeOtherStuff() {}
void doLotsOfComplicatedStuff() {}
bool somethingWentWrong() { return 0;}

// Exercise: rewrite the following function usually only ifs and gotos
// (no for loops or while loops)
void doALoop()
{
  int numIterations = 20;
  int i;
  for(i=0; i<numIterations; i++){
    cout << i << " ";
  }
  cout << endl;
}

int main(int argn, char* argv[])
{
  int* array = new int[100000];

  if (argn != 3) {
    cout << "Expected two command line arguments.  Exiting." << endl;
    goto cleanup;
  }

  cout << "OK, doing some complicated stuff now" << endl;
  doSomeStuff();

  if (somethingWentWrong()) {
    goto cleanup;
  }

  doSomeOtherStuff();

  if (somethingWentWrong()) {
    goto cleanup;
  }

  doLotsOfComplicatedStuff();

 cleanup:
  delete [] array;
}


