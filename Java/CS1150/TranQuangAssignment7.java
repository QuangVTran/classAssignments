/*
 * Quang Tran
 * Assignment 7
 * due 10-17-19
 * CS1150
 * The following assignment will test my abilities to create and utilize methods by creating a BMR Calorie Calculator.
 */


import java.util.Scanner; 
public class TranQuangAssignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);


		System.out.println("Lets see how many calories you need!");
		System.out.println("");
		System.out.println("------------------------------------");
		System.out.println("");

		// Calling each and every method	
		char gender = getGender(input);


		double age = getAge(input);

		double height = getHeight(input);

		double weight = getWeight(input);


		double basalMetabolicRate = basalMetabolicRate(gender, age, weight, height);

		//Since the method dailyCaloriesWithActivity returns a value, we can treat it like a variable and p
		System.out.println(dailyCaloriesWithActivity(basalMetabolicRate));

		//Since the method displayResults returns a void value(nothing) we cannot use print line here
		displayResults(basalMetabolicRate);


		//This boolean statement will return two outcomes, True or False for Yes and No
		// The entire program will loop a full iteration if the user selects yes
		// Otherwise, selecting No will end the program
		boolean continueProcessing = continueProcessing(input);

		while(continueProcessing == true) {
			gender = getGender(input);
			System.out.println("Gender is : " + gender);

			age = getAge(input);
			System.out.println(age);

			height = getHeight(input);



			weight = getWeight(input);


			basalMetabolicRate = basalMetabolicRate(gender, age, weight, height);

			System.out.println(dailyCaloriesWithActivity(basalMetabolicRate));

			displayResults(basalMetabolicRate);

			continueProcessing = continueProcessing(input);
		}
		System.out.println("Have a healthy day!");








	}// end main

	// The following method will obtain the users gender based on the character they input, 
	// M for Male, and F for females. 
	public static char getGender(Scanner input) {

		System.out.println("Enter your gender (M/F) : ");

		String stringGender = input.next();


		while(stringGender.length() > (1)){

			System.out.println("Too many characters, please enter M or F for gender.");
			stringGender = input.next();

		}


		while(!stringGender.equals("M") &&  !stringGender.equals("F")){

			System.out.println("Please enter M or F for gender.");
			stringGender = input.next();

		}


		char gender = stringGender.charAt(0);

		return gender;
	}


	// The following method will obtain the users age based on what they input
	// However, if the number they input is greater than 100 or less than 1, the program will
	// prompt them with an invalid entry message for as many times until the user inputs the correct number. 
	public static double getAge(Scanner input) {

		System.out.println("Enter your age: ");
		int age = input.nextInt();

		if(age < 1 || age > 100) {

			while(age < 1 || age > 100) {

				System.out.println(age+ " is an invalid entry for age, try something between 1 and 100.");
				age = input.nextInt();

			}

		}

		return age;

	}

	//similar to the other methods above, the height method has while loops that will allow the user
	// to change their inputs if it's too high or too low
	// I also created an integer to find the total number of inches in the person's height, in order to insert it into the BMR equation
	public static double getHeight(Scanner input) {


		System.out.println("Enter your height in feet : ");
		int heightFeet = input.nextInt();


		while((heightFeet < 1 || heightFeet > 8)) {

			System.out.println(heightFeet + " is an invalid entry for height, try something between 1 and 8 feet");
			heightFeet = input.nextInt();
		}

		System.out.println("Enter your height in inches : ");
		int heightInches = input.nextInt();

		while(heightInches < 0 || heightInches > 12) {
			System.out.println(heightInches + " is an invalid entry for height, please try something between 0 and 12");
			heightInches = input.nextInt();
		}

		int totalHeightInches = heightInches + (12 * heightFeet);


		return totalHeightInches;

	}

	//Weight is simple, just make sure that there is no negative weight
	public static double getWeight(Scanner input) {

		System.out.println("Enter your weight :");
		double weight = input.nextInt();

		while(weight < 0 ) {
			System.out.println("Invalid entry for weight, try again.");
			weight = input.nextInt();
		}

		return weight;

	}

	//The user will enter their input as a string. And if that string is 'Y', the boolean continueProcessing will be true
	// if the user selects 'N', the boolean will be false and the program will end.
	//if the user selects anything else however, the invalid prompt will coninuously allow the user to change their option to the correct one
	public static boolean continueProcessing(Scanner input) {


		System.out.println("Perform another calorie check? (Y/N)");

		String yesOrNo = input.next();
		boolean trueOrFalse = false;


		if(yesOrNo.charAt(0) != 'Y' && yesOrNo.charAt(0) != 'N') {
			System.out.println(yesOrNo + " is not one of the options, try again");
			yesOrNo =input.next();
		}

		else if(yesOrNo.charAt(0) == 'Y') {
			trueOrFalse = true;
		}

		else if (yesOrNo.charAt(0) == 'N') {
			trueOrFalse = false;
		}


		return trueOrFalse;

	}

	// using constants for the equation, and taking variables from the other methods, 
	//the following BMR equation was very straightforward.
	public static double basalMetabolicRate(char gender, double age, double height, double weight) {

		// I chose to use bmr here since I wrote out basal metabolic rate many times

		double bmr = 0;

		final double MALEWEIGHTMULTIPLIER = 6.23;
		final double MALEHEIGHTMULTIPLIER = 12.7;
		final double MALEAGEMULTIPLIER = 6.8;
		final double FEMALEWEIGHTMULTIPLIER = 4.35;
		final double FEMALEHEIGHTMULTIPLIER = 4.7;
		final double FEMALEAGEMULTIPLER = 4.7;

		if(gender == 'M') {
			bmr = 66 + ((MALEWEIGHTMULTIPLIER * weight) + (MALEHEIGHTMULTIPLIER * height) - (MALEAGEMULTIPLIER * age)); 
		}

		else if(gender == 'F') {
			bmr = 655 + ((FEMALEWEIGHTMULTIPLIER * weight) + (FEMALEHEIGHTMULTIPLIER * height) - (FEMALEAGEMULTIPLER * age));
		}

		return bmr;

	}


	public static double dailyCaloriesWithActivity(double basalMetabolicRate) {

		System.out.println("");
		System.out.println("Now calcululating...");

		System.out.println("Your BMR is " + basalMetabolicRate + " calories a day.");
		System.out.println("");

		return basalMetabolicRate;
	}

	// this method returns nothing, so it can be used without changing any parameters.
	public static void displayResults(double basalMetabolicRate) {
		System.out.println("--------------------------------------------------------");
		System.out.println("");
		System.out.println("Daily calorie needs will depend on activity level");
		System.out.println("-----------------------------------------------");
		System.out.println("Activity Level                      Calories");
		System.out.println("Sedentary: little or no exercise " + (basalMetabolicRate * 1.2));
		System.out.println("Exercise 1-3 times/week  "+ (basalMetabolicRate * 1.375));
		System.out.println("Exercise 4-5 times/week  "+ (basalMetabolicRate * 1.55));
		System.out.println("Intense exercise 6-7 times/week " + (basalMetabolicRate * 1.725));
		System.out.println("Very intense daily or physical job " + (basalMetabolicRate * 1.9));
		System.out.println("-----------------------------------------------");
		System.out.println("");
	}

}


String someString = (c);
someString = someString + d ;
someString = someString + e;


VARIABLE = (cde)




