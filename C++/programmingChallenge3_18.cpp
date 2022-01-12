#include <iostream>
#include <cmath>
using namespace std;

// The following program will take the diameter of a pizza, and divide it into a certain number of evenly sized slices. 
int main() {

    //These are the constants and variables declared
    const double PI = 3.14159;
    double radius;
    double diameter;
    const double areaOfSlice = 14.125;

    cout << "Enter pizza diameter: " << endl;
    cin >> diameter;

    radius = diameter / 2;
    //The following formula finds the area of the pizza, and divides it by the area of each slice, returning an integer value of number of slices.
    cout <<  int ((PI * (pow(radius,2.0) ) ) / areaOfSlice) << " slices";

    return 0;  

}