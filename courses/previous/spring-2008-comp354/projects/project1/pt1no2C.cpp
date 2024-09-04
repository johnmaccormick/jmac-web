/*
 * Project #1, Part 1, #2 Solution - Process C
 */
 
#include <iostream>
#include <unistd.h>
#include <sys/wait.h>

using namespace std;

int main() {

	cout << "Process C running" << endl;
     
	// Fork process D
	int pid = fork();
	if (pid != 0) {
	    	wait(NULL); 	// Wait for D  		 
  		cout << "Process C done" << endl;
 	}
 	else {
		char *args[2];
   	 	args[0]="D.exe";
		args[1]="NULL";
		int rv = execv("./D.exe", args);
   		cout << "Couldn't run process D" << endl;
   }
}