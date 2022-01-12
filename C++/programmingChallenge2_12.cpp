#include <iostream>
using namespace std;

//find the amount of acres in a tract of land
int main(){

    int acre;
    acre = 43560; //1 acre = 43560 sq feet

    int land;
    land = 389767; // this plot of land has 389,767 sq feet

    double acres_in_land;
    acres_in_land =  land / acre; // Taking the plot of land and calculating how many acres is in it

    cout << " This tract of land has " << acres_in_land << " acres. \n";

    return 0;

}