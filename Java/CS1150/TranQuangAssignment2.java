
/*
 * Name: Quang Tran
 * Class:CS1150
 * Due:Sept 12th, 2019
 * Description: Assignment 2
 * This program will create a water drip calculator that determines how much water is wasted from dripping faucets.
 * This assignment will demonstrate my ability to obtain user input, as well as my ability to utilize constants and variables.
 */

import java.util.Scanner;
public class TranQuangAssignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		final int dripsPerGallon = 15140; // The "final" keyword declares the following data type "int" as a constant of 15140.  

		Scanner input = new Scanner(System.in); // The syntax Scanner input will allow the user to input values 


		System.out.println("This program will compare the amount of water wasted due to dripping faucets between two cities."); // This is just an introduction when the program is started.

		System.out.println(); // This is just skipping a line for formatting.

		/* The following code displays a message that asks for the user to input a number, and the variable will be set as the 
		 * next integer inputted by the user. (Note: if the user inputs anything that is not an integer, there will be an error) 
		 * The system then outputs the integer for each separate variable.) 
		 */ 

		System.out.print("Enter a number for the number of homes for the first city"); 
		int numOfHomes = input.nextInt(); 
		System.out.println("There are " + numOfHomes + " homes for the first city"); 
		System.out.println();

		System.out.print("Enter a number for the average number of faucets for the first city");
		int numOfFaucets = input.nextInt();
		System.out.println("There are " + numOfFaucets + " faucets for the first city"); 
		System.out.println();

		System.out.print("Enter a number for the average number of drips per minute for the first city");
		int numOfDrips = input.nextInt();
		System.out.println("There are " + (numOfDrips) + " drips per minute for the first city"); 
		System.out.println();


		/* Just like the previous code, display a message for the user to input an integer, and the following variable will be 
		 * set as the specified variable, only this time this is for a second city. 
		 */

		System.out.print("Enter a number for the number of homes for the second city");
		int numOfHomes2 = input.nextInt(); 
		System.out.println("There are " + numOfHomes2 + " homes for the second city");
		System.out.println();

		System.out.print("Enter a number for the average number of faucets for the second city");
		int numOfFaucets2 = input.nextInt();
		System.out.println("There are " + numOfFaucets2 + " faucets for the second city"); 
		System.out.println();

		System.out.print("Enter a number for the average number of drips per minute for the second city");
		int numOfDrips2 = input.nextInt();
		System.out.println("There are " + (numOfDrips2) + " drips per minute for the second city");
		System.out.println();

		/* There will be a table below that will record all of the information above. 
		 * All of the calculations are done within the variables, using constants as numeric values with a double data type for minutes in a day and days in a year.
		 * Once again, constants have the "final" preceding them.
		 */

		final double minutesInDay = 1440; 
		double gallonsPerDay = ((numOfHomes * numOfDrips * minutesInDay) /dripsPerGallon); 
		double gallonsPerDay2 = ((numOfHomes2 * numOfDrips2 * minutesInDay) /dripsPerGallon); 

		final double daysInYear = 365; 
		double gallonsPerYear = (gallonsPerDay * daysInYear);
		double gallonsPerYear2 = (gallonsPerDay2 * daysInYear);

		double sumGallonsPerDay = (gallonsPerDay + gallonsPerDay2);
		double sumGallonsPerYear= (gallonsPerYear + gallonsPerYear2);

		/* The following table is built with a list of System.out.println()'s, using assignment 1 as a template. Every numeric value within the table is 
		 * computed by the console, using the values the user inputed.
		 */

		System.out.println();
		System.out.println("Home		Faucets		Drips/Minute		Gallons/Day		Gallons/Year		");
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		System.out.println((numOfHomes) + "		" + (numOfFaucets) + "		" + (numOfDrips) + "		" + (gallonsPerDay) + "		" + (gallonsPerYear)); 
		System.out.println((numOfHomes2) + "		" + (numOfFaucets2) + "		" + (numOfDrips2) + "		" + (gallonsPerDay2) + "			" + (gallonsPerYear2));
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		System.out.print("Total" +"						" + (sumGallonsPerDay) + "		" + (sumGallonsPerYear));



	}

}
