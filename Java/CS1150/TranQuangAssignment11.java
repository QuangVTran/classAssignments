/*Quang Tran
 * CS 1150
 * Assignment 11
 * Due 11-21-2019
 * Professor Michaela Gonzalez
 * This assignment is a continuation of working with object oriented programming. Using RaceCar objects, we will create a racing simulation.
 *  This program goes more in depth for OOP, as well as introduces us to files. 
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
public class TranQuangAssignment11 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

		//Initiated the raceCars Array
		RaceCar[] raceCars = new RaceCar[5];

		//Initiated the odometer just like scanner.
		Odometer odometer = new Odometer();

		//Calling the 3 methods
		
		System.out.println("Race cars at start of race\n");
		setupRaceCars(raceCars);

		printRaceCars(raceCars);

		writeCarDetailsToFile(raceCars);

		//The following chunk of code is the while loop that iterates until one of the race cars reaches 500 miles.
		double incrementedTime = 0.0;

		System.out.println("\nAll cars are ready - let the race begin in 5..4..3..2..1");

		int iteration = 1;
		boolean raceComplete = false;
		
		while(!raceComplete) {
			
			//each 0.25 represents a 1/4 of an hour, so every 15 minutes.
			incrementedTime += 0.25;
			System.out.println("Racing Time... " + incrementedTime);

			//The boolean statement within the if statement will only be true every 4 loops. 
			if(iteration % 4 == 0) {
				for(int i = 0 ; i < raceCars.length ; i ++ ) {
					raceCars[i].updateOdometer();

					if(raceCars[i].getOdometer().getMiles() >= 500) {

						raceComplete = true;
						
						System.out.println("\n"
								+ "Race cars at end of race\n");
						printRaceCars(raceCars);
						
					}

				}
			}

			iteration++;

		}
	}



	//The following method will manually setup the 5 race cars' information based off the table in the assignment.
	public static void setupRaceCars(RaceCar[] raceCars) {

		raceCars[0] = new RaceCar("Shrek", 8 , 67);
		raceCars[1] = new RaceCar("Fiona", 11 , 85);
		raceCars[2] = new RaceCar("Donkey", 7, 118);
		raceCars[3] = new RaceCar("Farquaad" , 24, 71);
		raceCars[4] = new RaceCar("Dragon" , 43 , 108);



	}

	//The following method will print out the table that displays the car number, driver, average speed, and miles completed.
	public static void printRaceCars(RaceCar[] raceCars) {


		System.out.println("---------------------------------------------------------\n");
		System.out.println("Car         Driver              Average     Miles       ");
		System.out.println("Number                          Speed       Completed             \n");
		System.out.println("---------------------------------------------------------\n");

		for(int i = 0 ; i < raceCars.length ; i ++) {
			System.out.println(raceCars[i].getNumber() + "\t" + raceCars[i].getDriver() + "\t" + raceCars[i].getSpeed() + "\t" + raceCars[i].getOdometer().getMiles());
		}

	}

	// The following program will print out a file in my eclipse workspace. 
	public static void writeCarDetailsToFile(RaceCar[] raceCars) throws IOException {

		File fileName = new File("Assignment11.txt");
		PrintWriter resultsFile = new PrintWriter (fileName);
		resultsFile.println("Race Car Details");
		for (int i = 0; i < raceCars.length; i ++) {
			resultsFile.println(raceCars[i].getNumber());
			resultsFile.println(raceCars[i].getDriver());
			resultsFile.println(raceCars[i].getOdometer().getMiles());
			resultsFile.println();
		}

		resultsFile.close();

	}

}//Assignment 11

//This is the RaceCar Class
class RaceCar {

	//These are the private data fields 
	private String driver;
	private double speed;
	private int number;
	private Odometer odometer;

	//This is the constructor
	public RaceCar(String driver, int number, int speed) {
		this.driver = driver;
		this.number = number;
		this.speed = speed; 
		odometer = new Odometer();
	}

	//These are the getters
	public String getDriver() {
		return driver;
	}

	public int getNumber() {
		return number;
	}

	public double getSpeed() {
		return speed;
	}

	public Odometer getOdometer() {
		return odometer;
	}

	//The following method will update the odometer
	public void updateOdometer() {
		odometer.incrementMiles(speed);
	}
}

//The following Odometer Class goes inside the RaceCar Class. The RaceCar Has-A odometer.
class Odometer{

	private double miles;

	public Odometer() {
		miles = 0;
	}

	public double getMiles() {
		return miles;
	}

	public void incrementMiles(double speed) {
		this.miles = miles + speed;
	}
}