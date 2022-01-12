/*
 * Name:Quang Tran
 * Class:CS1450 Section 2 
 * Assignment 3
 * Due: 2-20-2020
 * Description: The following assignment creates a pinball machine, through object oriented programming and array manipulation, in this case with array lists and 2d arrays. This assignment is 
 * possible through the use of java's comparable interface.
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;


public class TranQuangAssignment4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Reading the file 
		File targetsFile = new File("PinballMachineTargets.txt");

		Scanner readFile = new Scanner(targetsFile);

		//Taking the info from the file and building the playing field
		int numRows = readFile.nextInt();
		int numColumns = readFile.nextInt();

		PinballMachine myPinballMachine = new PinballMachine(numRows,numColumns);

		//Reading the rest of the file and creating targets at specified locations.
		while(readFile.hasNext()) {
			int row = readFile.nextInt();
			int column = readFile.nextInt();
			String type = readFile.next();
			int id = readFile.nextInt();
			int points = readFile.nextInt();

			Target target = new Target(type, id ,points);

			myPinballMachine.addTargetToPlayingField(row,column,target);

		}

		//Closing off the file
		readFile.close();

		myPinballMachine.displayPlayingField();

		System.out.println();

		play(myPinballMachine);

		
	}

	//The following method will read a text file and play through a pinball simulation 
	public static void play(PinballMachine myPinballMachine) throws IOException {

		System.out.println("--------------------------------------------\n");
		System.out.println("\tSimulate Pinball Game\n");
		System.out.println("--------------------------------------------\n");
		System.out.printf("%-9s\t%-2s\t%-8s\t%-6s\t","Target Hit","ID","Points","Score");
		System.out.println("\n--------------------------------------------\n");

		File playFile = new File("Play.txt");

		Scanner playGame = new Scanner(playFile);
		int score = 0;

		// This while loop will read through the file and hit certain locations in the 2d array. If the 2d array contains a target, the target hit will be recorded in the report
		while(playGame.hasNext()) {
			int row = playGame.nextInt();
			int col = playGame.nextInt();

			if(myPinballMachine.getTarget(row,col) != null) {
				score = score + myPinballMachine.getTarget(row,col).getPoints();
				myPinballMachine.getTarget(row, col).incrementHits(myPinballMachine.getTarget(row, col).getHits());
				System.out.println(myPinballMachine.getTarget(row, col).getType()+ "\t" + myPinballMachine.getTarget(row, col).getId() + "\t" + myPinballMachine.getTarget(row, col).getPoints() + "\t" + score );
			}

		}

		playGame.close();

		System.out.printf("\n%s\n\n%s\n\n%s\n\n%s\n\n","*******************************************************","PINBALL MACHINE TARGET HIT REPORT", "(From most hits to least hits" ,"*******************************************************" );
		System.out.println("\nRow\tColumn\tType\tNumber\tPoints\t\tNumber Hits");
		
		
		printReport(myPinballMachine);

	}

	//The following printReport method will read through the 2d array and fill the target report array list with target report objects.
	public static void printReport (PinballMachine myPinballMachine) {
		ArrayList<TargetReport> targetReports = new ArrayList<>();

		// Reading through the 2d array, and creating a target report every time a target is read.
		for(int row = 0; row < myPinballMachine.getNumberRows() ; row ++) {
			for(int col = 0; col < myPinballMachine.getNumberColumns() ; col++) {
				if(myPinballMachine.getTarget(row, col) != null) {
					TargetReport targetReport = new TargetReport(row, col, myPinballMachine.getTarget(row, col).getType(), myPinballMachine.getTarget(row, col).getId(), myPinballMachine.getTarget(row, col).getPoints(), myPinballMachine.getTarget(row, col).getHits());
					targetReports.add(targetReport);
				}
			}
		}
		//Since the target reports is an implementation of the comparable interface, we can use the collections.sort method
		Collections.sort(targetReports);
		System.out.println();

		//This for loop will read through the arrayList and print out the target reports
		for(int i = 0 ; i < targetReports.size() ; i ++) {
			System.out.println(targetReports.get(i).print());

		} 
	}

}//Assignment

class PinballMachine{
	private int numberRows;
	private int numberColumns;
	private Target [][] playingField; 

	public PinballMachine(int numberRows, int numberColumns) {
		this.numberColumns = numberColumns;
		this.numberRows = numberRows;
		this.playingField = new Target[numberRows][numberColumns];

	}

	public int getNumberRows(){
		return numberRows;
	}

	public int getNumberColumns() {
		return numberColumns;
	}

	public void addTargetToPlayingField(int row, int col, Target target) {
		playingField[row][col] = target;
	}

	public Target getTarget(int row, int col) {
		Target theTarget = playingField [row] [col];

		if(theTarget == (null)) {
			return null;
		}

		return theTarget;
	}

	public void displayPlayingField() {
		for(int i = 0; i < numberColumns ; i ++) {
			System.out.printf("\t%s", "Column " + i );
		}

		System.out.println("\n");

		for(int row = 0 ; row < numberRows; row ++) {

			System.out.printf("%s%3d\t" , "Row", row ,"\t");

			for(int col = 0 ; col < numberColumns ; col ++) {
				Target pointer = getTarget(row, col);

				if(pointer == (null)) {
					System.out.printf("%-8s\t", "-----");
				}

				else {

					System.out.printf("%-8s\t",pointer.getType());
				}
			}
			System.out.println("\n");
		}

	}

}//Pinball machine

class Target{
	private String type;
	private int id;
	private int points;
	private int hits;

	public Target(String type, int id, int points) {
		this.type = type;
		this.id = id;
		this.points = points;
	}

	public String getType() {
		return type;
	}

	public int getId() {
		return id;
	}

	public int getPoints() {
		return points;
	}

	public int getHits() {
		return hits;
	}

	public void incrementHits(int hits) {
		this.hits= hits + 1;
	}

}

class TargetReport implements Comparable<TargetReport>{
	private int rowNumber;
	private int columnNumber;
	private String Type;
	private int id;
	private int points;
	private int hits;

	public TargetReport(int rowNumber,int columnNumber, String type, int id, int points, int hits) {
		this.rowNumber = rowNumber;
		this.columnNumber = columnNumber;
		this.Type = type;
		this.id = id;
		this.points = points;
		this.hits = hits;

	}
	public String print() {

		String theString = String.format("%d\t%d\t%-10s\t%-1d\t%-4d\t%-4d",  rowNumber,  columnNumber,  Type, id, points, hits) ;
		return theString;


	}

	@Override
	public int compareTo(TargetReport targetReport) {
		if(hits > targetReport.hits) {
			return -1;
		}
		else if(hits < targetReport.hits) {
			return 1;
		}
		else {
			return 0;
		}
	}


}