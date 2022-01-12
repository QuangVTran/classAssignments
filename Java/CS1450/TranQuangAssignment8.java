/*
 * Name:Quang Tran
 * Date:4-15-20
 * CS1450
 * Assignment 8 : The following assignment will create two crossword puzzles, using 2d arrays, arraylists, and queues. Also, this assignment will utilize the iterator from Java's Collections.
 * 
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class TranQuangAssignment8 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Initializing the two array lists
		
		ArrayList<Character> letters = new ArrayList<>();
		ArrayList<Slot> slots = new ArrayList<>();
		
		//Filling the two array lists with values from the files
		
		File lettersFile = new File("listLetters.txt");
		Scanner readLetters = new Scanner(lettersFile);
		
		while(readLetters.hasNext()) {
			//Converting the strings in the files into chars
			char currentChar = readLetters.next().charAt(0);
			letters.add(currentChar);
			}
		
		
		
		//Now reading the slots file
		
		File slotsFile = new File("listSlots.txt");
		Scanner readSlots = new Scanner(slotsFile);
		
		//These first two integers will be the dimensions of the crossword board
		int dimension1Row = readSlots.nextInt();
		
		int dimension1Col = readSlots.nextInt();
		
		
		//Now, the remaining integers in the file will be used to create slot objects at a certain row and column location
		
		
		while(readSlots.hasNext()) {
			//Reading the file two integers at a time
			int row = readSlots.nextInt();
			int col = readSlots.nextInt();
			
			Slot newSlot = new Slot(row,col);
			
			slots.add(newSlot);
		
		}
		
		
		//Initializing the crossword Object using the dimensions given in the file
		Crossword myCrossword = new Crossword(dimension1Row,dimension1Col);
		
		Iterator<Character> letterIterator = letters.iterator();
		
		Iterator<Slot> slotIterator = slots.iterator();
		
		
		
		//Finally, we can now call the methods to print out the crossword puzzles
		myCrossword.enterLetters(letterIterator, slotIterator);
		
		System.out.println("Printing out the first crossword puzzle:");
		
		myCrossword.printCrossword();
		
		readLetters.close();
		
		readSlots.close();
		

		//Now using queues to hold letters and slots, the following code below is very similar to the previous code, but with queues this time.
		
		Queue<Character> queueOfLetters = new LinkedList<>(); 
		
		Queue<Slot> queueOfSlots = new LinkedList<>();
		
		File queueLetters = new File("queueLetters.txt");
		
		Scanner readQueueLetters = new Scanner(queueLetters);
		
		File queueSlots = new File("queueSlots.txt");
		
		Scanner readQueueSlots = new Scanner(queueSlots);
		
		while(readQueueLetters.hasNext()) {
			char currentChar = readQueueLetters.next().charAt(0);
			queueOfLetters.offer(currentChar);
			
		}
		
		int dimension2Row = readQueueSlots.nextInt();
		int dimension2Col = readQueueSlots.nextInt();
		
		Crossword my2ndCrossword = new Crossword(dimension2Row,dimension2Col);
		
		while(readQueueSlots.hasNext()) {
			int row = readQueueSlots.nextInt();
			int col = readQueueSlots.nextInt();
			
			Slot newerSlot = new Slot(row,col);
			
			queueOfSlots.offer(newerSlot);
			
		}
		
		System.out.println("\n");
		
		Iterator<Character> queueLetterIterator = queueOfLetters.iterator();
		
		Iterator<Slot> queueSlotsIterator = queueOfSlots.iterator();
		
		my2ndCrossword.enterLetters(queueLetterIterator, queueSlotsIterator);

		System.out.println("Printing out the second crossword puzzle:");
		
		
		my2ndCrossword.printCrossword();
		
		readQueueLetters.close();
		
		readQueueSlots.close();
		
		
	}//main

}

class Slot {

	private int row;
	private int column;
	
	public Slot(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
	
	
	
}

class Crossword{
	
	private int numRows;
	private int numCols;
	private char[][] crosswordBoard;
	private final char EMPTY_CHARACTER = '-' ; 
	
	public Crossword(int numRows,int numCols) {
		this.numRows = numRows;
		this.numCols = numCols;
		
		crosswordBoard = new char[numRows][numCols];
		
		for(int i = 0 ; i < numRows ; i ++) {
			for(int j = 0 ; j < numCols ; j ++) {
				crosswordBoard[i][j] = EMPTY_CHARACTER; 
			}
		}
		
	}//Crossword
	
	
	
	public void enterLetters(Iterator<Character> letterIterator,Iterator<Slot>slotIterator) {
		
		while(letterIterator.hasNext() && slotIterator.hasNext()) {
		
		char currentLetter = letterIterator.next();
		Slot currentSlot = slotIterator.next();
		int currentRow = currentSlot.getRow();
		int currentCol = currentSlot.getColumn();
		
		
		crosswordBoard[currentRow][currentCol] = currentLetter;
		
		}
		
		
		
	}
	
	public void printCrossword() {
		for(int i = 0 ; i < numRows ; i ++) {
			System.out.println();
			for(int j = 0 ; j < numCols ; j++ ) {
				System.out.print(crosswordBoard[i][j]);
				
			}
		}
	}
	
	
}

