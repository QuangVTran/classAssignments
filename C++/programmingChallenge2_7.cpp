#include <iostream>
using namespace std;

//find how much the ocean rises in set years in millimeters
int main(){

    double risePerYear = 1.5; // the ocean's level rises 1.5mm per year
    const int inFiveYears = 5; // constant for 5 years
    const int inSevenYears = 7;
    const int inTenYears = 10;

    cout << "In 5 years, the ocean will be " << risePerYear * inFiveYears << " mm higher. \n";
    cout << "In 7 years, the ocean will be " << risePerYear * inSevenYears << " mm higher. \n";
    cout << "In 10 years, the ocean will be " << risePerYear * inTenYears << " mm higher. \n";


    return 0;

} 