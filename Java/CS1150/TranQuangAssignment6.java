/*
 * Quang Tran
 * Assignment 8
 * Due 10-10-19
 * Description: Learn how to use for loops by making a bike renting system
 */

import java.util.Scanner;
public class TranQuangAssignment6 {



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Scanner as usual
		Scanner input = new Scanner(System.in);





		//Initiating variables

		boolean singleTrip = false;
		boolean allDayTrip = false;
		boolean returnBike = false;
		boolean stationInService = true;

		final int SELECT_SINGLE_TRIP_PASS = 1;
		final int SELECT_ALL_DAY_PASS = 2;
		final int SELECT_RETURN_BIKE = 3;
		final int SHUT_DOWN_CODE = 999;

		final int PRICE_SINGLE_TRIP = 2;
		final int PRICE_ALL_DAY_TRIP = 8;

		int numOfBikes = 7;
		int totalRentalCost = 0;

		int rentNumOfBikes = 0;

		int totalSingleBikesRented = 0;
		int totalAllDayBikesRented = 0;
		int totalBikesRented = 0;



		
		/*
		 * This is the main loop that will keep the program running until an employee shuts it down
		 */


		while(stationInService == true) {

			//Building the table

			System.out.println("************************************************");
			System.out.println("");
			System.out.println("\t" + " Welcome to 1150 Bike Share");
			System.out.println("");
			System.out.println("There are " + numOfBikes + " bikes availible");
			System.out.println("************************************************");
			System.out.println("");
			System.out.println("Pass Type \t Fee");
			System.out.println("");
			System.out.println("-------------------------------------------------");
			System.out.println("");
			System.out.println("Single Trip Pass: $" + PRICE_SINGLE_TRIP);
			System.out.println("");
			System.out.println("24-Hour Pass: $" + PRICE_ALL_DAY_TRIP);
			System.out.println("");
			System.out.println("-------------------------------------------------");
			System.out.println("");
			System.out.println("1) Single Trip Pass");
			System.out.println("");
			System.out.println("2) 24-Hour Pass");
			System.out.println("");
			System.out.println("3) Return Bike");
			System.out.println("");
			System.out.println("");
			System.out.println("\t Select menu option 1, 2, or 3");

			//Prompting the user



			int userInput = input.nextInt();





			if(userInput == SELECT_SINGLE_TRIP_PASS || userInput == SELECT_ALL_DAY_PASS ) {

				//This is for calculating the price

				if(userInput == SELECT_SINGLE_TRIP_PASS) {
					singleTrip = true;
				}
				else if(userInput == SELECT_ALL_DAY_PASS) {
					allDayTrip = true;
				}

				//This prompts the user to input a number for how many bikes they wish to rent 
				
				System.out.println("How many bikes? Limit 5 at a time");
				rentNumOfBikes = input.nextInt();
				
				//However, if that number is less than 1 or greater than 5, the system will continuously give them an error message, while letting the user input
				//another number
				
				if(rentNumOfBikes < 1 || rentNumOfBikes > 5) {
					while(rentNumOfBikes < 1 || rentNumOfBikes > 5 ) {
						System.out.println("Invalid input, please type in a number between 1 and 5");
						rentNumOfBikes = input.nextInt();
					}
				}
				
				//However, if the number IS between 1 and 5, the program will continue on.
				
				if((rentNumOfBikes > 1 || rentNumOfBikes < 5) ) {
					
					//The following nested if statement contains a while loop that will get the user to input a different number if 
					//the number the user inputs is greater than the number of bikes currently available.
					
					
					if(rentNumOfBikes > numOfBikes) {
						while(rentNumOfBikes > numOfBikes) {
							System.out.println("We don't have that many bikes");
							rentNumOfBikes = input.nextInt();
						}
					}
					
					//If the number of bikes requested passes the test (is not greater than number of bikes available)
					//The program will print a receipt depending on which bike pass the user selected
					
					
					else if(singleTrip = true) {
						totalSingleBikesRented = totalSingleBikesRented + rentNumOfBikes ;
						numOfBikes = numOfBikes - rentNumOfBikes;
						
						
						
						System.out.println("-------------------------------------");
						System.out.println("-------------- Receipt --------------");
						System.out.println("-------------------------------------");
						System.out.println("Single Trip pass for " + rentNumOfBikes + " " + "bikes ");
						System.out.println("");
						for(int bikeCodeNum = 1 ; bikeCodeNum <= rentNumOfBikes ; bikeCodeNum++) {
							
							System.out.println("Unlock code for bike# " + bikeCodeNum + " " + (int) (10000 + Math.random()*89999));
							
						}
						
						System.out.println("");
						System.out.println("Rental Cost = " + (numOfBikes * PRICE_SINGLE_TRIP));
						System.out.println("");
						System.out.println("Have a nice day");
						System.out.println("");
						System.out.println("-------------------------------------");
						System.out.println("");
						
						// Resetting the single trip variable to false so that the once the program iterates, it resets back to the original value
						
						singleTrip = false;
						
					}

					// This is the same as above, just with the second option (24 hour pass)
					
					else if(allDayTrip = true) {
						totalAllDayBikesRented = totalAllDayBikesRented + rentNumOfBikes;
						numOfBikes = numOfBikes - rentNumOfBikes;
						

						System.out.println("-------------------------------------");
						System.out.println("-------------- Receipt --------------");
						System.out.println("-------------------------------------");
						System.out.println(" 24-hour pass for " + rentNumOfBikes + " " + " bikes ");
						System.out.println("");
						for(int bikeCodeNum = 1 ; bikeCodeNum <= rentNumOfBikes ; bikeCodeNum++) {
							
							System.out.println("Unlock code for bike# " + bikeCodeNum + " " + (int) (10000 + Math.random()*89999));
							
						}
						
						System.out.println("");
						System.out.println("Rental Cost = " + (numOfBikes * PRICE_ALL_DAY_TRIP));
						System.out.println("");
						System.out.println("Have a nice day");
						System.out.println("");
						System.out.println("-------------------------------------");
						System.out.println("");
						
						allDayTrip = false;
						
					}
				}


			}
			
			//The following code returns a bike if possible, and if its possible it increments the number of bikes
			// Very importantly: the number of bikes must never go over 7 or below 0.
			
			else if(userInput == SELECT_RETURN_BIKE) {

				if(numOfBikes < 7) {
					System.out.println("Successfully returned 1 bike");
					numOfBikes = numOfBikes + 1;
				}
				System.out.println("There is currently no availble space for bikes");

			}

			//The following code handles invalid user inputs

			else if(userInput != SELECT_SINGLE_TRIP_PASS && userInput != SELECT_ALL_DAY_PASS && userInput != SELECT_RETURN_BIKE && userInput != SHUT_DOWN_CODE) {
				while(userInput != SELECT_SINGLE_TRIP_PASS && userInput != SELECT_ALL_DAY_PASS && userInput != SELECT_RETURN_BIKE && userInput != SHUT_DOWN_CODE) {
					System.out.println("Invalid Entry, Please input one of the numbers above ");
					userInput = input.nextInt();
				}
			}


			//The following if statement is for when the employee enters 999
			
			else if(userInput == SHUT_DOWN_CODE) {
				
				stationInService = false;
				System.out.println("Bike Station was successfully shut down");
				System.out.println("");
				

				input.close();


			}
			
			//The last bit of code is for the calculations of prices. 
			
			totalBikesRented = totalSingleBikesRented +totalAllDayBikesRented; 
			totalRentalCost = totalRentalCost + (((totalSingleBikesRented * PRICE_SINGLE_TRIP) + (totalAllDayBikesRented * PRICE_ALL_DAY_TRIP)));
			
			if(stationInService == false) {
			
				System.out.println("Total Bikes Rented = " + totalBikesRented);
				System.out.println("Total Sales = " + totalRentalCost);	
			}

		}
		
		

	}
}
