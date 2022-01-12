#include <iostream>
#include <string>
#include <iomanip>
using namespace std;

int main(){

    //Declaring variables
    string month1;
    string month2;
    string month3;
    double amtOfRain1;
    double amtOfRain2;
    double amtOfRain3;

    //Promting the user to input data for month and rainfall
    cout << "Enter month" << endl;
    cin >> month1;
    cout << "Enter rainfall for " << month1 << endl;
    cin >> amtOfRain1;

    cout << "Enter month" << endl;
    cin >> month2;
    cout << "Enter rainfall for " << month2 << endl;
    cin >> amtOfRain2;

    cout << "Enter month";
    cin >> month3; 
    cout << "Enter rainfall for " << month3 << endl;
    cin >> amtOfRain3;

    //computes the average rainfall over 3 months
    double average = (amtOfRain1 + amtOfRain2 + amtOfRain3) / 3 ;

    //prints it out to console
    
    cout << "The average rainfall for " << month1 << ", " << month2 << ", and " << month3 << " is " << setprecision(2) << fixed << average << " inches."; 

    return 0;

}