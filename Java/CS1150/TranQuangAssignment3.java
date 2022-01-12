/*
Name: Quang Tran
 * 	Class: CS1150
 * Due: Sept 5th, 2019
 * Description: Assignment #3
 * This program demonstrates my knowledge about boolean, logical and relational operators through if statements.
 */
import java.util.Scanner;

public class TranQuangAssignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* Scanner is here for user inputs */
		Scanner input = new Scanner(System.in);

		/* Starting off with constants and formulas */

		final double FRESHMEN_TUITION = 380.00;
		final double SOPHOMORE_TUITION = 400.00;
		final double JUNIOR_TUITION = 430.00;
		final double SENIOR_TUITION = 451.00;

		final double BASE_FEE = 200.00;





		/* Building the calculator with strings
		 * I'm not too confident in using System.out.printf() to format yet, so I stuck with concatenated spaces 
		 */
		System.out.println("Welcome to the Tuition Calculator");
		System.out.println();
		System.out.println("Option" + "	" + "Level" + "	" + "Cost Per Credit Hour");
		System.out.println("----------------------------------");
		System.out.println("1" + "	" + "Freshman" + "	" + FRESHMEN_TUITION);
		System.out.println("2" + "	" + "Sophomore" + "	" + SOPHOMORE_TUITION);
		System.out.println("3" + "	" + "Junior	" + "	" + JUNIOR_TUITION);
		System.out.println("4" + "	" + "Senior	" + "	" + SENIOR_TUITION);

		System.out.println();
		System.out.println("Select Class Level : 1, 2, 3, or 4");

		/* The next input will determine the class level, but the program will end if the user selects an option not listed */
		int classLevel = input.nextInt();

		String classLevelName = "";

		if (classLevel == 1) {
			classLevelName = "Freshman";

		}
		if (classLevel == 2) { 
			classLevelName = "Sophomore";

		}		
		if (classLevel == 3) { 
			classLevelName = "Junior";

		}	
		if (classLevel == 4) {
			classLevelName = "Senior";

		}


		/* I tried to use an else here, but had no success so I used "or" */
		if (classLevel < 1 || classLevel > 4){
			System.out.println(classLevel +" is not a valid menu item. Please run the program again");
		}

		/* I believe there may be a mistake here as the program does not end if I input an invalid number of credit hours
		 * Perhaps I can't put two else's in a row?
		*/
		else {

			System.out.println("How many credit hours do you have? (1-30)");
			int numCreditHours = input.nextInt();   

			if(numCreditHours < 1 || numCreditHours > 30) {
				System.out.println(numCreditHours + " is not a valid number of credit hours. Please run the program again");

			}
			

			else {


			}	
			System.out.println();
			System.out.println("----------------------------------");
			System.out.println("Level" + "			" + classLevelName); 	
			System.out.println("Credit Hours" + "		" +  numCreditHours);


			if (classLevel == 1) {
				double tuition = (numCreditHours * FRESHMEN_TUITION); 
				System.out.println("Tuition" + "			" + (numCreditHours * FRESHMEN_TUITION));
			}

			if (classLevel == 2) { 
				double tuition = (numCreditHours * SOPHOMORE_TUITION); 
				System.out.println("Tuition" + "			" + (numCreditHours * SOPHOMORE_TUITION));
			}

			if (classLevel == 3) {
				double tuition = (numCreditHours * JUNIOR_TUITION); 
				System.out.println("Tuition" + "			" + (numCreditHours * JUNIOR_TUITION));
			}

			if (classLevel == 4) { 
				double tuition = (numCreditHours * SENIOR_TUITION); 
				System.out.println("Tuition" + "			" + (numCreditHours * SENIOR_TUITION));
			}



			double additionalFee = (20 * numCreditHours);

			/* Sadly, my main problem is trying to get the variable to define itself when it's within an if statement
			 * I cannot make a second variable under its own name
			 * And variables within if statements are not defined.
			 * Because of that, I cannot take the "Tuition" I found within the if statement to add to a formula to get the total cost.
			 */
			System.out.println("Fees" + "	" + "		" + (BASE_FEE + additionalFee));

			System.out.println("Total Cost" + " 	" + (BASE_FEE + additionalFee) + " +	" + ("tuition") );
		}
	}













}
