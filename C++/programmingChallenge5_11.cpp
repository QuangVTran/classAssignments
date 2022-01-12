#include <iostream>
using namespace std;

int main() {


    //Initializing variables
	double organism;
	double popIncrease;
	int numOfDays;

    //prompt user to input number of organisms
	do {
		cout << "Enter the starting number of organism: ";
		cin >> organism;
        //following if statement allows input validations, and will loop if the input is <2
		if (organism < 2) {
			cout << "The starting number of organisms must be at least 2." << "\n";
		}
	} while (organism < 2);

	//prompt user to input a percentage that the population increases
	do {
		cout << "Enter the average daily population incease (as percentage): ";
		cin >> popIncrease;
        //input validation for if popIncrease is a negative number
		if (popIncrease < 0) {
			cout << "The average daily population increase must be a positive value." << "\n";
		}
	} while (popIncrease < 0);

	//prompt user to input a number of days to increase
	do {
		cout << "Enter the number of days they will multiply: ";
		cin >> numOfDays;
        //input validation
		if (numOfDays < 1) {
			cout << "The number of days must be at least 1." << endl;
		}
	} while (numOfDays < 1);

	//This prints out the various population sizes each day
	for (int i = 1; i <= numOfDays; i++) {
		organism += (organism * avgDailyPopulationIncrease);
		cout << "On day " << i << " the population size was " << (int)organism << endl;
	}

	return 0;

}

