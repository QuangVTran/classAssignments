
/*
 * Quang Tran
 * Due November 7th 2019
 * CS1150
 * Assignment 9 : This assignment will demonstrate my knowledge on arrays and methods. This assignment goes more in depth by by introducing the merging and sorting of arrays. 
 */

//just like scanner, there is a java.util package for arrays(in this case, to sort)
import java.util.Arrays;
public class TranQuangAssignment9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//initializing an empty array with 10 integers
		int[] evenArray = new int[10];
		//filling that empty array with 10 even values
		fillWithEvenValues(evenArray);
		//using Arrays.sort to sort out the array
		Arrays.sort(evenArray);


		//same as above, but with odd values
		int[] oddArray = new int[10];
		fillWithOddValues(oddArray);
		Arrays.sort(oddArray);

		//Initializing the string variable to an empty string
		String arrayName ="";
		//initializing an empty array with 20 integers this time
		int[] mergedArray = new int [20];
		//calling the method to merge the two arrays
		mergeArrays(evenArray,oddArray,mergedArray);
		//using the sort method from Array.util package
		Arrays.sort(mergedArray);

		//calling the method that will take the sorted merged array and reverse the ordering.
		descendingOrderSort(mergedArray,evenArray); 

		int[] sortedArray1 = { 10, 12, 15, 42, 68, 102 };

		int[] sortedArray2 = { 14, 16, 18, 101, 107, 108 };

		int[] sortedMergedArray = new int[sortedArray1.length+sortedArray2.length];

		sortedMerge(sortedArray1,sortedArray2, sortedMergedArray);


		//The following method will display both each array list with their respective outputs.
		displayList(evenArray,oddArray,mergedArray,sortedMergedArray,arrayName);



	}//main

	public static void fillWithEvenValues (int[] evenArray) {
		//use a for loop to fill up the array with random integers between/including 1 and 75 that are only even numbers.

		for(int i = 0 ; i < evenArray.length ; i++ ) {
			//initializing a newNumber integer as a random number
			int newNumber = ((int) (Math.random()* 75 ) + 1);

			//setting the newNumber integer to a random number between 1 and 75 that is even
			while(newNumber%2 == 1) {

				newNumber = ( (int) (Math.random()* 75 ) + 1);

			}
			//due to pass by reference, changes in arrays within methods will be shown in main
			evenArray[i] = newNumber;
		}


	}

	public static void fillWithOddValues (int[] oddArray) {
		//The exact same method as fillWithOddValues, only this time, the index will only be set if the random int generated is odd. 

		for(int i = 0 ; i < oddArray.length ; i++ ) {
			//initializing the newNumber integer
			int newNumber = ( (int) (Math.random()* 75 ) + 1);

			//setting the newNumber integer to a random number between 1 and 75 that is odd
			while(newNumber%2 == 0) {

				newNumber = ( (int) (Math.random()* 75 ) + 1);

			}

			oddArray[i] = newNumber;
		}



	}

	public static void displayList (int[] evenArray, int[] oddArray, int[] mergedArray,int[] sortedMergedArray, String arrayName) {
		//starting off with the even array
		arrayName = "Even Array";

		System.out.println(arrayName + " " + "sorted");
		System.out.println();
		System.out.println("-------------------------------------------------------------");
		System.out.println();

		//the following for loop will iterate and print out the value for each corresponding array index.
		for(int i = 0 ; i < evenArray.length ; i ++) {
			System.out.println("array [" + i + "]" + "\t\t= " + evenArray[i]);
		}

		System.out.println("\n");	

		//Same as above, but with the odd Array this time.
		arrayName = "Odd Array";

		System.out.println(arrayName + " " + "sorted");
		System.out.println();
		System.out.println("-------------------------------------------------------------");
		System.out.println();

		for(int i = 0 ; i < oddArray.length ; i ++) {
			System.out.println("array [" + i + "]" + "\t\t= " + oddArray[i] );
		}

		System.out.println("\n");
		
		arrayName = "Merged Array";

		System.out.println(arrayName + " " + "sorted");
		System.out.println();
		System.out.println("-------------------------------------------------------------");
		System.out.println();

		for(int i = 0 ; i < mergedArray.length ; i ++) {
			System.out.println("array [" + i + "]" + "\t\t= " + mergedArray[i] );
		}

		System.out.println("\n");
		
		arrayName = "Manual Merged Array";

		System.out.println(arrayName + " " + "sorted");
		System.out.println();
		System.out.println("-------------------------------------------------------------");
		System.out.println();

		for(int i = 0 ; i < sortedMergedArray.length ; i ++) {
			System.out.println("array [" + i + "]" + "\t\t= " + sortedMergedArray[i] );
		}


	}

	public static void mergeArrays(int[] evenArray, int[] oddArray, int[] mergedArray) {

		//creating the merged array that is unsorted
		for(int i = 0; i < evenArray.length ; i++) {
			mergedArray[i] = evenArray[i];


		}

		for(int i = 0; i < oddArray.length ; i++) {
			mergedArray[10+i] = oddArray[i];


		}

	}

	public static void descendingOrderSort (int[] mergedArray, int[]evenArray) {

		//the following for loop will iterate for the length of one of the two lists, which is to prevent the swapping from canceling itself out.
		for(int i = 0 ;i < evenArray.length ; i++) {
			// using a swap method, with a temp variable, var i ,and the index we want to swap, which in each case, is the length -1 because length is 20, but the bounds goes up to [19]
			// which allows the swapping of the two values by taking advantage of the temp value that was held. 
			int temp = mergedArray[i];
			int swapIndex = mergedArray.length - 1 - i;

			mergedArray[i] = mergedArray[swapIndex];
			mergedArray[swapIndex] = temp;

		}


	}

	public static void sortedMerge(int[] sortedArray1, int[] sortedArray2, int[] sortedMergedArray) {

		//the following code will merge the two arrays 
		for(int i = 0; i < sortedArray1.length  ; i++) {
			sortedMergedArray[i] = sortedArray1[i];
		}

		for(int i = 0; i < sortedArray2.length  ; i++) {
			sortedMergedArray[(sortedArray1.length)+i] = sortedArray2[i];
		}


		//The following code will sort the numbers around in descending order. The idea is similar to the swap method, using a temp variable. 
		for (int i = 0; i < sortedMergedArray.length; i++) {
			for (int j = i + 1; j < sortedMergedArray.length; j++) {
				int temp = 0;
				//if the current number read is smaller than the next index's number, it will switch places. the for loop will make sure that every number is read and compared. 
				if (sortedMergedArray[i] < sortedMergedArray[j]) {
					temp = sortedMergedArray[i];
					sortedMergedArray[i] = sortedMergedArray[j];
					sortedMergedArray[j] = temp;
				}
			}
		}

	}
}

