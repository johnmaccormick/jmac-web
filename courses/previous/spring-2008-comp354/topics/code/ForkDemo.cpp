/*
 * Demonstration of how to fork a new child process
 * and how to tell the difference between the parent 
 * process and the child process.
 */
 
#include <iostream>
#include <unistd.h>
#include <sys/wait.h>

using namespace std;

int main() {

	cout << "Parent running" << endl;
     
	// Create child process.
	int pid = fork();
   
	// fork returns pid of child process in parent
	// and 0 in the child.
	if (pid != 0) {
		cout << "Parent running after fork" << endl;
     
		// wait for one child of this process to finish.
		// if no child is running (i.e. it already finished)
		// then just continue.
		wait(NULL); 
     
		cout << "Parent done" << endl;
	}
	else {
		cout << "Child running" << endl;
		sleep(5);
		cout << "Child done" << endl;
	}
}