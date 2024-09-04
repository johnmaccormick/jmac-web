/**
 * Two functions to help with tokenizing strings.
 */

#include <string>

using namespace std;

int countTokens(string str, char delim) {
	// Count up the number of tokens.  There is one more
	// token than there are spaces in the string.
	int toks = 0;
	for (int i=0; i<str.length(); i++) {
		if (str.at(i) == delim) {
			toks++;
		}
	}
	toks++;
	return toks;
}

string * tokenize(string str, char delim, int numToks) {
	
	// Break the string into tokens.
	string * tokens = new string[numToks];
	int start = 0;
	int end = 0;
	for (int i=0; i<numToks-1; i++) {
		end = str.find(delim, start);
		tokens[i] = str.substr(start,(end-start));
		start = end + 1;
	}
	tokens[numToks-1] = str.substr(start);
	
	return tokens;
}