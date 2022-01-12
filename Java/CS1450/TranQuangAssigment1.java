import java.util.Arrays;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/*
 * Quang Tran
 * CS1450 Section 2
 * Assignment #1
 * Due 1-29-2020
 * Description: I will create a program that has two random numbered arrays, and I will fill up a file I create with these numbers in sequential order. After that, with some array manipulation
 * I will sort out the list of numbers and remove excess duplicates.
 */

//My TranQuangAssignment1 class file got deleted, and when I tried to make a new class with the same name, it said that type already exists, so I made another .java file by misspelling assignment
public class TranQuangAssigment1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Initializing two arrays that have a random array length from 1-10
		int size1 = (int)(10*Math.random()+1);
		int size2 = (int)(10*Math.random()+1);

		//In the program, size1 and array1.length are interchangeable, likewise with size2 and array2.length
		int[] array1 = new int[size1];
		int[] array2 = new int[size2];

		//The following for loops fill up array1 and array 2 with random integers between 1-25
		for(int i = 0 ; i < array1.length ; i++) {
			array1[i] = (int)(25*Math.random()+1); 
		}

		for(int i = 0 ; i < array2.length ; i++) {
			array2[i] = (int)(25*Math.random() + 1);
		}

		//Using the imported java.util.Arrays package, both arrays were sorted using the sort method
		Arrays.sort(array1, 0 , array1.length);
		Arrays.sort(array2, 0 , array2.length);

		System.out.println("size 1 = " + array1.length);
		System.out.println("size 2 = " + array2.length);

		System.out.println("\nFirst array with " + size1 + " sorted random values\n");
		//The following for loop will print out all of the integers in array 1


		for(int i = 0; i < array1.length ; i++) {
			System.out.println(array1[i]);
		}

		//And this for loop will print all of the integers in array 2 
		
		System.out.println("\nSecond array with " + size2 + " sorted random values\n");

		for(int i = 0; i < array2.length ; i++) {
			System.out.println(array2[i]);
		}
		System.out.println();
		
		//Now working with files

		File fileName = new File("assignment1.txt");

		//Opening the file for writing,

		PrintWriter resultsFile = new PrintWriter(fileName);

		//The following two boolean statements will determine whether or not the array has remaining numbers
		boolean noMoreNumInArray1 = false;
		boolean noMoreNumInArray2 = false;

		//The following index's are for the while loop to increment
		int arrayIndex = 0;
		int arrayIndex2 = 0;


		//This is the first while loop, which takes the two arrays and places them into the file in sequential 
		while(noMoreNumInArray1 == false && noMoreNumInArray2 == false) {


			if(array1[arrayIndex] <= array2[arrayIndex2]) {
				System.out.println("Writing: " + array1[arrayIndex]);
				resultsFile.println(array1[arrayIndex]);
				arrayIndex++;
			}

			else if(array2[arrayIndex2] <= array1[arrayIndex]) {
				System.out.println("Writing: " + array2[arrayIndex2]);
				resultsFile.println(array2[arrayIndex2]);
				arrayIndex2++;
			}

			//The following if statements will shut down the while loop if there are no more remaining numbers inside each specific while loop.
			if(arrayIndex == array1.length) {
				noMoreNumInArray1 = true;
			}

			if(arrayIndex2 == array2.length) {
				noMoreNumInArray2 = true;
			}

		}

		//The following two while loops will execute once one of the two if statements above sets the boolean to true, and print all of the remaining numbers in the array into the file.
		System.out.println("\n\n");
		while(noMoreNumInArray1 == true) {
			if(arrayIndex2 == array2.length-1) {
				noMoreNumInArray1 = false ;
			}
			System.out.println("Writing remainder: " + array2[arrayIndex2]);
			resultsFile.println(array2[arrayIndex2]);

			arrayIndex2++;
		}

		while(noMoreNumInArray2 == true) {
			if(arrayIndex == array1.length-1) {
				noMoreNumInArray2 = false ;
			}
			System.out.println("Writing remainder: " + array1[arrayIndex]);
			resultsFile.println(array1[arrayIndex]);

			arrayIndex++;

		}

		//Finally, once the file is complete and sorted, the file must be closed.
		resultsFile.close();

		//The following scanner reopens the file for reading
		Scanner readFile = new Scanner(fileName);

		//Initializing a new array without duplicates, this array may be too big considering we're removing duplicates
		int[] array3 = new int[size1+size2];


		//The following for loop will fill the array with numbers, setting the duplicates to 0;
		//Because the array is currently {0 , 0 , 0 , 0 , 0...} we have to check the previous number as we place them in to find duplicates.
		for(int i = 1; i < array3.length ; i++) {
			int nextNumber = readFile.nextInt();
			if(nextNumber != array3[i-1]) {
				array3[i]= nextNumber;
			}
			
			
		}

		//The following for loop will print out the resulting array, without printing any of the 0's, which I don't think is hard-coding.
		System.out.println("");
		System.out.println("Array without duplicates");
		for(int i = 0 ; i < array3.length ; i++) {
			if(array3[i] != 0) {
			System.out.println(array3[i]);
			}
		}

		readFile.close();
		
	}//main

}//Assignment1 Class



