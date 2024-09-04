// examples based closely on http://stackoverflow.com/questions/4421706/operator-overloading

#include <iostream>

using namespace std;

class Population
{
private:
  int wombats;
  int wallabies;
public:
  Population(int wombats, int wallabies){
    this->wombats = wombats;
    this->wallabies = wallabies;
  }
  int getWombats() { return wombats;}
  int getWallabies() { return wallabies;}

  // Implementation of the "+=" operator.  Note that the parameter and
  // the return value are references, and the operator itself is a
  // member function. (Contrast with the "+" operator below.) The
  // precise reasons for these choices are beyond the scope of our
  // course, but you can read the above discussion on Stackoverflow
  // for more details if you are interested.
  Population& operator+=(const Population& rhs)
  {
    this->wombats += rhs.wombats;
    this->wallabies += rhs.wallabies;
    return *this;
  }
};

// Implementation of the "+" operator.  Note that the first parameter
// is passed by value, but the second parameter is a reference; and
// the operator itself is a top-level function, not a member
// function. (Contrast with the "+=" operator above.) The precise
// reasons for these choices are beyond the scope of our course, but
// you can read the above discussion on Stackoverflow for more details
// if you are interested.
Population operator+(Population lhs, const Population& rhs)
{
  lhs += rhs;
  return lhs;
}

// Implementation of the "<<" operator.  Note that we have yet another
// different treatment of the parameters here: both parameters are
// references; and the operator itself is a top-level function, not a
// member function.  The precise reasons for these choices are beyond
// the scope of our course, but you can read the above discussion on
// Stackoverflow for more details if you are interested.
ostream& operator<<(ostream& os, Population& population)
{
  os << "wombats " << population.getWombats() 
     << ", wallabies " << population.getWallabies();
  return os;
}

int main(int argn, char* argv[])
{
  Population p1(3,5);
  Population p2(10,20);

  cout << "p1: " << p1 << endl;
  cout << "p2: " << p2 << endl;

  p1 += p2;

  cout << "p1 after doing p1 += p2: " << p1 << endl;

  Population p3 = p1 + p2;

  cout << "p3 (initialized from p1 + p2): " << p3 << endl;




}
