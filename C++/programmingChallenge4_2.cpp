#include <iostream>
using namespace std;

int main(){

    //initializing variable to hold an int value
    int input = 0;

    //Prompting the user to input an integer
    cout << "Please input a number between 1-10 "; 
    //carrying that value to variable input
    cin >> input;

    //putting the switch stmt together
    switch(input){
        
        case 1: 
            cout << "The Roman Numeral version of " << input << " is I";
            break;
        case 2: 
            cout << "The Roman Numeral version of " << input << " is II";
            break;

        case 3:
            cout << "The Roman Numeral version of " << input << " is III";
            break;

        case 4: 
            cout << "The Roman Numeral version of " << input << " is IV";
            break;

        case 5: 
            cout << "The Roman Numeral version of " << input << " is V";
            break;

        case 6: 
            cout << "The Roman Numeral version of " << input << " is VI";
            break;

        case 7:
            cout << "The Roman Numeral version of " << input << " is VII";
            break;

        case 8: 
            cout << "The Roman Numeral version of " << input << " is VIII";
            break;

        case 9:
            cout << " The Roman Numeral version of " << input << " is IX";
            break;

        case 10:
            cout << "The Roman Numeral version of " << input << " is X";
            break;

        default:
            cout << "This program only accepts integers between 1 and 10. \nPlease Try Again" ;
            break;


    }

    //this new line just cleans up the terminal
    cout << "\n";

    return 0;

}