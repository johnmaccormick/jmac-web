/**
 * A very SimpleShell program. This program has very limited functionality
 * but provides a starting point for your own shell. 
 * The SimpleShell presents a prompt and accepts a single command
 * from the user. It blindly attemts to execute the command and then 
 * exits. The SimpleShell does not support the notion of a search path
 * nor does it have any built in functions.  Thus all commands must have 
 * a fully specified path and it is not possible to change the working
 * directory.
 */
 
#include <iostream>
#include <string>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

#include "StringTokenizer.cpp"

using namespace std;

int main() {
	
	string HOME = "/Users/joeUser";   // Change to your username.
	string PATH = "/bin:/usr/bin:.:/usr/X11R6/bin";
	
	// Read the command.
	string cmd;
	printf("Command> ");
   	getline(cin,cmd);
   	
   	// Split the command into its tokens.
	int toks = countTokens(cmd, ' ');
	string * tokens = tokenize(cmd, ' ', toks);
		
	// Setup the array that is needed for execv call.
	char *args[toks+1];
	for (int i=0; i<toks; i++) {
		// Convert each c++ string into a c style string
		// because it is required by the execv call.
		args[i] = (char *)tokens[i].c_str();
	}
	// Final entry in args must be NULL.
	args[toks] = NULL;
			
	// Create the new process.
	int pid = fork();
   	if (pid != 0) {
   		// Parent process.... just wait.
   		wait(NULL);
   		// Free the memory allocated by the tokenize function.
   		delete [] tokens;
   		cout << "Bye." << endl;
   	}
   	else {
   		// Child process.... do the execv for the new program.
   		
   		// The first argument is the progam name with
   		// the full path specified.
   	 	char *prog = (char *)tokens[0].c_str();
   		
   		// Change args[0] to be just the name of the 
   		// program without any path.
   		int loc = tokens[0].find_last_of('/');
   		if (loc != string::npos) {
   			args[0] = (char *)tokens[0].substr(loc+1).c_str();
   		}
  		
  		// Print some debugging information
  		// Should not be in your final version!
  		cout << endl;
  		cout << "Program: " << prog << endl;
		for (int i=0; i<toks; i++) {
			cout << "args[" << i << "]" << args[i] << endl;
		}
		cout << endl;

		// Launch the program with the arguments specified on
		// the command line.
  		int rv = execv(prog, args);  	   		
  		
  		// execv must have failed... so command was probably bad.
  		cout << "bad command: " << cmd << endl;
	}
}