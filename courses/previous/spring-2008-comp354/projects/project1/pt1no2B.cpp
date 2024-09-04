/*
 * Project #1, Part 1, #1 Solution - Process B
 */
 
#include <iostream>
#include <unistd.h>
#include <sys/wait.h>

using namespace std;

int main() {

	cout << "Process B running" << endl;
     
	// Fork process D
	int pid = fork();
	if (pid != 0) {
 	
  		// Fork process C
  		int pid2 = fork();
 		if (pid2 != 0) { 		
	    		wait(NULL); 	// Wait for D or C
    			wait(NULL);  // Wait for the other one.
    		 
  			cout << "Process B done" << endl;
 		}
 		else {
 	 		char *args[2];
   	 		args[0]="C.exe";
   	 		args[1]="NULL";
			int rv = execv("./C.exe", args);
   			cout << "Couldn't run process C" << endl;
 		}
   	}
   	else {
		char *args[2];
   	 	args[0]="D.exe";
		args[1]="NULL";
		int rv = execv("./D.exe", args);
   		cout << "Couldn't run process D" << endl;
   }
}