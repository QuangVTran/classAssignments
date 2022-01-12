#include <iostream>
#include <string>
using namespace std;

int main()
{
	// Create a 2d 3x7 array of monkeys x days
	const int monkeys = 3;
	const int days = 7;
	int food[monkeys][days];
	string weekDays[days] = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

	//Initialize variables
	double pounds = 0;
	double least = 0;
	double most = 0 ;
	double sum = 0;


	

	// Ask user to input data for each monkey
	cout << "Input how many pounds of food each monkey ate each day.\n";
	for (int col = 0; col < days; col++){
		for (int row = 0; row < monkeys; row++){
			do{

				cout << "Enter the food eaten by Monkey #" << (row + 1) << " on " << weekDays[(col)];
				cin  >> pounds;

				if (pounds < 0){
					cout << "Error! Number of pounds must be greater than 0.\n";
				}

			} while (pounds < 0);

			food[row][col] = pounds;


			//increment sum by weight of food eaten per day
			sum += pounds;
		}
		cout << endl;							
	}

	//initialize min and max value
	least = most = food[0][0];
	
	int leastMonkey = 0;
	int mostMonkey = 0;

	string mostFoodDay = "";
	string leastFoodDay = "";


	//traverse the 2d array and find values that are min and max values, and assign them to various int and string variables
	for (int row = 0; row < monkeys; row++){
		for (int col = 0; col < days; col++){
			
			if (food[row][col] < least){ 
				least = food[row][col];
				leastMonkey = row;
				leastFoodDay = weekDays[col];
			}
			if (food[row][col] > most){ 
				most = food[row][col];
				mostMonkey = row;
				mostFoodDay = weekDays[col];
			}
		}
	}

	//print it all out
	cout << "Average amount of food consumed per day : " << sum / days << " pounds." << endl;
	cout << "Least amount of food consumed was : " << least << " pounds by Monkey #" << leastMonkey + 1  << " on " << leastFoodDay << endl;
	cout << "Greatest amount of food consumed was : " << most << " pounds by Monkey #" << mostMonkey + 1 << " on " << mostFoodDay << endl;

	return 0;
}
