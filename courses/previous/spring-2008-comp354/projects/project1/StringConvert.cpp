/*
 * Demonstation of converting a C++ string into
 * a C-syle string.
 */

#import <iostream>
#import <string>

using namespace std;

int main() {

	// A C++ string.
	string cppStr = "Test String";
	cout << cppStr << endl;
	
	// A pointer to a character - i.e. a C-style string.
	char *cStr;
	
	// The c_str function in the string class returns
	// a c-style string including the null terminator.
	cStr = (char *)cppStr.c_str();
	printf("%s\n", cStr);
}
	