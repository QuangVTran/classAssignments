#include <iostream>
#include <iomanip>
using namespace std;


int main(){

int input = 0;

const double airSpeed = 1100; //speed of sound through air in feet/second
const double waterSpeed = 4900;// speed of sound through water in feet/second
const double steelSpeed = 16400;// speed of sound through steel in ft/s

const int menu1 = 1;//first option of the menu (air)
const int menu2 = 2;// 2nd option of the menu (water)
const int menu3 = 3; // 3rd option of the menu (steel)

//Print out the menu

cout << "Select a medium:\n1.Air\n2.Water\n3.Steel\n\n";
cout << "Enter your choice\n"; 

cin >> input;

int distance;// initialize distance value;
double time;// initalize time value

//initialize output precision

cout << fixed << showpoint << setprecision(4);

switch(input){

    case menu1:
        cout << "Enter the distance: \n";
        cin >> distance;

        if(distance > 0){
            time = distance / airSpeed;
            cout << "A sound wave takes " << time << " seconds to travel through air";
        }

        //This is in case the user puts in a negative number
        else{
            cout << "Invalid input, please try again (distance must be greater than 0)";
        }
        break;

    case menu2:
        cout << "Enter the distance : \n";
        cin >> distance;

        if(distance > 0){
            time = distance / waterSpeed;
            cout << "A sound wave takes " << time << " seconds to travel through water";
        }

        else{
            cout << "Invalid input, please try again (distance must be greater than 0)";
        }
        break;

    case menu3:
        cout << "Enter the distance : \n";
        cin >> distance;

        if(distance > 0){
            time = distance / steelSpeed;
            cout << "A sound wave takes " << time << " seconds to travel through steel";

        }    
        else {
            cout << "Invalid input, please try again (distance must be greater than 0)";

        }
        break;

}//switch
return 0;

}