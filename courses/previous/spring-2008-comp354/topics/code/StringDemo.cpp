/*
 * Demonstation of some of the more useful string
 * functions in the c++ string class.
 */

#import <iostream>
#import <string>

using namespace std;

int main() {

	string s1 = "Test String";
	string s2 = "Another thing";
	
	// Finding the length of a string.
	//   The length() method returns the nubmer of 
	//   characters in the string.
	int len1 = s1.length();	
	cout << len1 << endl;			// 11
	int len2 = s2.length();	
	cout << len2 << endl;			// 13
		
	// Concatenating strings.
	//   Strings can be concatenated using the + operator.
	string s3 = s1 + " " + s2;		
	cout << s3 << endl;			// "Test String Another Thing"
	string s4 = s1 + " One";		
	cout << s4 << endl;			// "Test String One"
	
	// Searching a string forward.
	//   The find method returns the index of the first
	//   occurance of the specified character or string.
	//   If the specified character or string doesn't appear
	//   then the value string::npos is returned.
	int loc1 = s1.find('t');
	cout << loc1 << endl;			// 3
	int loc2 = s2.find("th");	
	cout << loc2 << endl;			// 3
	int loc3 = s2.find("zz");
	cout << loc3 << endl;			// -1
	
	// Searching a string backward.
	//   The rfind method returns the index of the last
	//   occurance of the specified character or string.
	//   If the specified character or string doesn't appear
	//   then the value string::npos is returned.
	int loc4 = s1.rfind('t');
	cout << loc4 << endl;			// 6
	int loc5 = s2.rfind("th");	
	cout << loc5 << endl;			// 8
	int loc6 = s2.rfind("zz");
	cout << loc6 << endl;			// -1

	// Getting substrings.
	//   The substr method returns a substring beginning
	//   at the index specified by the first parameters and
	//   having the length specified by the second parameter.
	//   If no second parameter is specified then the remainder
	//   of the string is returned.
	string s5 = s1.substr(0,4);	// "Test"
	cout << s5 << endl;
	string s6 = s2.substr(4,3);	// "her"
	cout << s6 << endl;
	string s7 = s2.substr(8);		// "thing"
	cout << s7 << endl;
}