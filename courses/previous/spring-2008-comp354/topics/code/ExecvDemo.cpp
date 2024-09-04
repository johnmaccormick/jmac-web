/*
 * Demonstration of how to fork a child process and then
 * have that child process load a new executable.
 */
 
#include <iostream>
#include <unistd.h>
#include <sys/wait.h>
   
using namespace std;

int main() {

	cout << "Parent running" << endl;
   	int pid = fork();
   	if (pid != 0) {
		wait(NULL);
		cout << "Parent done" << endl;
  	}
   	else {
   	 	cout << "Child running" << endl;
   	 
   	 	// The full or relative path to the program that
   	 	// will be run in the new process.
   	    	char *prog = "/bin/ls";
   	    	 	
   	 	// Setup the args for running the ls program with
   	 	// the command line arguments of -l and ExecvDemo.cpp
   	 	char *args[4];
   	 	args[0]="ls";
   	 	args[1]="-l";
   	 	args[2]="ExecvDemo.cpp";
   	 	args[3]=NULL;
   	 	
   	 	// Replace the child process with the ls program
   	 	// and pass it the args.  args[0] must be the name
   	 	// of the program without any path.  The remaining
   	 	// entries of args are the command line arguments to
   	 	// the program.  The last entriy in args must be NULL.
   	 	int rv = execv(prog, args);
   	 
   	 	// If execv returns at all there was an error with
   	 	// the new process.  Probably the file didn't exist or 
   	 	// it was not executable.
   	 	cout << "Problem with execv" << endl;
  	}
}