#include <iostream>
#include <fstream>
using namespace std;

int main() {

	//initialize int variables
	int population;
	int numOfAsterisks;
	int year = 1900;

	// linking file 
	ifstream inputFile("People.txt");
	cout << "PRAIRIEVILLE POPULATION GROWTH\n(each * represent 1000 people)\n";

	
	if (inputFile) {

		//while loop until it reaches end of file
		while (inputFile >> population) {

			cout << year << ": ";
			numOfAsterisks = population / 1000;

			for (int i = 0; i < numOfAsterisks; i++) {
				cout << "*";
			}

			year += 20;

			cout << " - There is about " << population << "\n";
		}

	}

	//input validation if the text file is missing
	else {
		cout << "People.txt is not found.";
        cout << "\nPlease run the program again after creating the file.";
		return 0;
	}

	return 0;
}

