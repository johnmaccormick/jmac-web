#include <iostream>
#include <string>

using namespace std;

class Location {
private:
  string name;
  double longitude;
  double latitude;

public:
  Location()
  {
    this->name = "none";
    this->longitude = 0.0;
    this->latitude = 0.0;
  }

  Location(string name, double longitude, double latitude)
  {
    this->name = name;
    this->longitude = longitude;
    this->latitude = latitude;
  }

  string getName() 
  {
    return name;
  }

  double getLongitude()
  {
    return longitude;
  }

  double getLatitude()
  {
    return latitude;
  }

  void print()
  {
    cout << "Location " << name << " is at latitude " << latitude 
         << " and longitude " << longitude << endl;
  }
};


int main(int argn, char* argv[])
{
  Location location("f", 4, 5);
  location.print();

  Location* locationPtr = new Location("San Francisco", 4.23, 61.2);
  locationPtr->print();

  Location* locationArray = new Location[300];
  locationArray[125].print();

  delete locationPtr;

  delete [] locationArray;
}

