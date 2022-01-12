#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
	
	const double PI = 3.14159; //pi const

    //menu choices for the switch stmt
	const int menu1 = 1;
	const int menu2 = 2;
	const int menu3 = 3;
	const int menu4 = 4;

    //variables the user will input
	int input;	
    double area;

	double radius;

	double length;	
	double width;	

	double base;	
	double height;	

	
	cout << fixed << showpoint << setprecision(5);//output formattings

	//prompt the user to select an option off the menu
	cout << "Geometry Calculator\n\n" << "1. Calculate the area of a Circle\n" << "2. Calculate the area of a Rectangle\n" << "3. Calculate the area of a Triangle\n" << "4. Quit\n\n" << "Enter your choice (1-4): ";
	cin >> input;

	//switch stmt for various outcomes
    //depending on which choice the user makes, a different formula will apply
    //also looks out for any errors (mainly negative integers)
	switch (input)
	{
		case menu1: 
			cout << "\nEnter the circle's radius: ";
			cin  >> radius;
			if (radius > 0){
                area = PI * radius * radius;
				cout << "\nThe area is " << area << endl;
            }
			else
			{
				cout << "\nThe radius can not be less than zero.\n";
			}
			break;

		case menu2: 
			cout << "\nEnter the rectangle's length: ";
			cin  >> length;
			cout << "Enter the rectangle's width: ";
			cin  >> width;
			if (length < 0 || width < 0)
			{
				cout << "\nOnly enter positive values for length and width.\n";
			}
			else
			{
				area = length * width;
				cout << "\nThe area is " << area << "\n";
			}
			break;

		case menu3: 
			cout << "Enter the length of the base: ";
			cin  >> base;
			cout << "Enter the triangle's height: ";  
			cin  >> height;
			if (base < 0 || height < 0)
			{
				cout << "\nOnly enter positive values for base and height.\n";
			}
			else
			{
				area = 0.5 * (base * height);
				cout << "\nThe area is " << area << endl;
			}
			break;

		case menu4: 
			cout << "Program ending.\n";
			break;

		default: 
			cout << "The valid choices are 1 through 4. Run the program again and select one of those.\n";
   }

   return 0;
}
