/*
 * Project #1, Part 1, #1 Solution.
 */
 
#include <iostream>
#include <unistd.h>
#include <sys/wait.h>

using namespace std;

int main() {

	cout << "Parent running" << endl;
     
	// Create first child process.
	int pid = fork();
	if (pid != 0) {
		cout << "Parent running after first fork" << endl;
  	
  		// Create the second child process.
  		int pid2 = fork();
 		if (pid2 != 0) {
 			cout << "Parent running after second fork" << endl;
 		
	    		wait(NULL); 
    			wait(NULL);
    		 
  			cout << "Parent done" << endl;
 		}
 		else {
 			cout << "Second child running" << endl;
 			sleep(5);
 			cout << "Second child done" << endl;
 		}
   }
   else {
   	 cout << "First child running" << endl;
   	 sleep(5);
   	 cout << "First child done" << endl;
   }
}