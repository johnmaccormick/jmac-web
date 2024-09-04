/**
 * Demonstration of simple I/O
 */
 
#include <iostream>

using namespace std;

int main() {
	
	string cmd;
 
   	cout << "Your wish is my command> ";
   	getline(cin, cmd);
	
  	cout << "You entered: " << endl;
   	cout << "\t" << cmd << endl;
}