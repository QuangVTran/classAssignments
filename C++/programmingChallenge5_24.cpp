#include <iostream>
#include <fstream>
using namespace std;

int main() {

    //initializing variables
	
	int numberOfNumbers = 0;
    int number;
	double average;
    int sum = 0;
	

	// linking file 
	ifstream inputFile("Random.txt");

	
	if (inputFile) {
		while (inputFile >> number) {

			numberOfNumbers++;
			sum = sum + number;
		
		}
	}

	//stops the program if the text file is missing
	else {

		cout << "Random.txt is not found.";
		return 0;
	}

	// compute the average
	average = sum / numberOfNumbers;

	// print out to console 
	cout << "Number of numbers : " << numberOfNumbers << "\n";
	cout << "Sum the numbers : " << sum << "\n";
	cout << "Average of the numbers : " << average << "\n";

	return 0;

}

