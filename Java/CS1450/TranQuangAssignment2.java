/*
 * Quang Tran
 * CS1450 Section 2
 * Assignment #1
 * Due 1-29-2020
 * Description:This assignment will test my ability to create classes and object in Object oriented programming, as well as utilizing inheritence and polymorphism. By creating parent classes
 * which in this case are Trains, with their subclasses, which are individual specific types of trains, we can use class hierarchy to easily create unique objects. On top of that, 
 * we're utilizing files and scanner to make our lives a little bit easier with filling things out.
 */

import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class TranQuangAssignment2 {
	//When working with files, main must throw IOException
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Initializing the file object in this program
		File trainsFile = new File("trains.txt");

		//reading from that file object
		Scanner readFile = new Scanner(trainsFile);

		//Initializing
		String type = "";

		double topSpeed = 0;

		String name = "";

		//readFile.nextInt() in this case would be 8, as its the first int value in the file

		int arraySize = readFile.nextInt();


		
		Train[] trainArray = new Train[arraySize];

		//The following for loop will read from the file, and based on the format of the file, will build the objects within the array
		for(int i = 0; i < arraySize ; i++) {
			type = readFile.next();

			topSpeed = readFile.nextDouble();

			name = readFile.nextLine();

			if(type.equals("highspeed")) {
				trainArray[i] = new Highspeed(type,name,topSpeed);

			}
			else if(type.equals("monorail")) {
				trainArray[i] = new Monorail(type,name,topSpeed);

			}
			else if(type.equals("lightrail")) {
				trainArray[i] = new Lightrail(type,name,topSpeed);

			}
			else if(type.equals("cog")) {
				trainArray[i] = new CogTrain(type,name,topSpeed);

			}
		}

		System.out.printf("%s%s%s%s", "Type\t\t\t" ,"Name\t\t" , "Top Speed\t\t" , "Benefit\n\n");
		System.out.println("--------------------------------------------------------------------------\n");

		//The following for loop will print out all of the train objects in the arrays. 
		for(int i = 0 ; i < trainArray.length ; i++ ) {
			String consoleType = trainArray[i].getType();
			String consoleName = trainArray[i].getName();
			double consoleTopSpeed = trainArray[i].getTopSpeed();
			String consoleBenefit = trainArray[i].benefit();

			//This if else statement is not required, but it straightens up the table and makes it look nicer.
			if(consoleType.equals("cog")) {
				System.out.println(consoleType + "\t\t" + consoleName + "\t" + consoleTopSpeed + "\t" + consoleBenefit);
			}
			else {
				System.out.println(consoleType + "\t" + consoleName + "\t" + consoleTopSpeed + "\t" + consoleBenefit);
			}
		}
		//Must close the file when finished
		readFile.close();


	}//main

}//TranQuangAssignment2

class Train {

	private String type;
	private String name;
	private double topSpeed;

	public Train(String type, String name, double topSpeed) {
		this.type=type;
		this.name=name;
		this.topSpeed=topSpeed;

	}



	//These are the getters
	public String getType(){
		return type;
	}

	public String getName() {
		return name;
	}

	public double getTopSpeed() {
		return topSpeed;
	}

	//This program will NOT have setters

	public String benefit() {
		return "";
	}

}//Train

class Highspeed extends Train{

	public Highspeed(String type, String name, double topSpeed) {
		super(type, name, topSpeed);

	}
	@Override
	public String benefit() {
		return "Travels at speeds between 125 and 267 mph";
	}

}//Highspeed

class Monorail extends Train{

	public Monorail(String type, String name, double topSpeed) {
		super(type, name, topSpeed);
	}
	@Override
	public String benefit() {
		return "Minimal footprint and quieter";
	}

}//Monorail

class Lightrail extends Train{

	public Lightrail(String type, String name, double topSpeed) {
		super(type, name, topSpeed);

	}
	@Override
	public String benefit() {
		return "Tighter turning radius";
	}

}//Lightrail

class CogTrain extends Train{
	public CogTrain(String type, String name, double topSpeed) {
		super(type, name, topSpeed);

	}
	@Override
	public String benefit() {
		return "Can climb grades up to 48%";
	}

}//CogTrain