#include <iostream>
#include <string>
#include <map> 

using namespace std;

// return the number of times that the letter 'T' or 't' occurs in the
// given string.
int countLetterT(string s)
{
  int count = 0;
  for(int i=0; i<s.length(); i++){
    if (s[i]=='t' || s[i]=='T') {
      count++;
    }
  }
  return count;
}

int main(int argn, char* argv[])
{

  // key is a string, value is number of occurrences of 'T' or 't' in
  // the key
  map<string, int> numLetterT;

  string s1 = "the quick brown fox jumps over the lazy dog";
  string s2 = "abc";
  string s3 = "TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT";


  numLetterT[s1] = countLetterT(s1);
  numLetterT[s2] = countLetterT(s2);
  numLetterT[s3] = countLetterT(s3);

  cout << numLetterT[s1] << " (" << s1 << ")" << endl;
  cout << numLetterT[s2] << " (" << s2 << ")" << endl;
  cout << numLetterT.at(s3) << " (" << s3 << ")" << endl;

  if (numLetterT.count("abc") == 0) {
    cout << "couldn't find it" << endl;
  } else {
    cout << "found it" << endl;
  }
}
