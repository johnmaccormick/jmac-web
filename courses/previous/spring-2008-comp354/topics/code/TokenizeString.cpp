/*
 * A demonstration of using the methods defined in
 * StringTokenizer.cpp to tokenize a string.
 */
 
#include <iostream>
#include <string>

using namespace std;

// Include the definitions of the countTokens and
// the tokenize functions.
#include "StringTokenizer.cpp"

int main() {
	
   	string cmd;	
   	cout << "Enter a line of text> ";
   	getline(cin,cmd);

    // Find out how many space delimited tokens there are
    // in the string.
	int toks = countTokens(cmd, ' ');
	
	// Get an array of toks strings where there is one space 
	// delimited token in each entry of the array.
	string * tokens = tokenize(cmd,' ', toks);
	
    // Print out the tokens.
   	printf("You entered the tokens:\n");
   	int i;
   	for (int i=0; i<toks; i++) {
		cout << tokens[i] << endl;
   	}
   	
   	// Free the memory that was allocated for the 
   	// array of tokens.
   	delete [] tokens;
}