/*
 * Project #1, Part 1, #1 Solution - Process A
 */
 
#include <iostream>
#include <unistd.h>
#include <sys/wait.h>

using namespace std;

int main() {

	cout << "Process A running" << endl;
     
	// Fork process B
	int pid = fork();
	if (pid != 0) {
 	
  		// Fork process C
  		int pid2 = fork();
 		if (pid2 != 0) { 		
	    		wait(NULL); 	// Wait for B or C
    			wait(NULL);  // Wait for the other one.
    		 
  			cout << "Process A done" << endl;
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
   	 	args[0]="B.exe";
		args[1]="NULL";
		int rv = execv("./B.exe", args);
   		cout << "Couldn't run process B" << endl;
   }
}