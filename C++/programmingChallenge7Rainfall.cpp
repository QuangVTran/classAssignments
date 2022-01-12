#include <iostream>
#include <iomanip>
#include <string>
using namespace std;

int main(){

    //Initialize the arrays
    double rainfall[12];
    string months[12] = {"January","February","March","April","May","June","July","August","September","October","November","December"};

    for(int i = 0; i < 12 ; i++ ){

        //prompt user for specified month
        cout << "Enter rainfall for " << months[i] << endl;
        //user input goes into the next array index
        
        cin >> rainfall[i];

        //input validation, no negative numbers
        if (rainfall[i] < 0){

            while(rainfall[i] < 0){

                cout << "invalid data (negative rainfall) -- retry" << endl;
                cin >> rainfall[i];
            }
        }

    }

    double totalRainfall = 0;

    //sum of the rainfall array
    for(int i = 0; i < 12 ; i++){
        totalRainfall+= rainfall[i];
        
    }


    cout << "Total rainfall: " << totalRainfall << endl;

    //compute average
    double avgRainfall = totalRainfall/12;

    cout << "Average rainfall: " << avgRainfall << endl;

    int min = rainfall[0];
    int max = rainfall[0];
    string minMonth = months[0];
    string maxMonth = months[0];



    //determining min and max
    for(int i = 0; i < 12; i++){

        if(rainfall[i] < min){
            min = rainfall[i];
            minMonth = months[i];
        }

        if(rainfall[i] > max){
            max = rainfall[i];
            maxMonth = months[i];
        }


    }

    cout << "Least rainfall in : " << minMonth << endl;
    cout << "Most rainfall in : " << maxMonth << endl;

    return 0;
}