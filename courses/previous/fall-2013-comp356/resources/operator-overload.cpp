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

  Population& operator+=(const Population& rhs)
  {
    this->wombats += rhs.wombats;
    this->wallabies += rhs.wallabies;
    return *this;
  }
};

Population operator+(Population lhs, const Population& rhs)
{
  lhs += rhs;
  return lhs;
}

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
