/*
 * Puzzle to illustrate the idea that the parent's 
 * address space is cloned in the child process.
 */
 
#include <iostream>
#include <unistd.h>
#include <sys/wait.h>

using namespace std;

int main() {

	int x = 27;
	    
	int pid = fork();
	if (pid != 0) {
		cout << "Parent's x before wait is " << x << endl;
		x = x + 5;
		wait(NULL);  
		cout << "Parent's x after wait is " << x << endl;
	}
	else {
		cout << "Child's x before sleep is " << x << endl;
		sleep(5);
		x = x + 10;
		cout << "Child's x after sleep is " << x << endl;
	}
}