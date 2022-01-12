import java.util.Arrays;

public class TranQuangQuiz2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[]nums = {1 , 2 , 4 ,7 , 3 , 8 , 6};



		int[]evenArray = new int[nums.length];


		displayArray(nums,evenArray);
	}// main



	public static void displayArray(int[]nums, int evenArray[]) {

		//this is the for loop that will print out the array list
		for(int i = 0 ; i < nums.length ; i++ ) {
			String arrayName = "array [" + i + "]";
			System.out.println(arrayName + "\t" + nums[i]);
		}

		//This for loop increments each time an even number is read
		int numOfEven = 0;
		for(int i = 0 ; i < nums.length ; i++) {
			if(nums[i]%2 == 0) {
				numOfEven++; 
			}

			//This for loop iterates each time an odd number is read
		}
		int numOfOdd = 0;
		for(int i = 0 ; i < nums.length ; i++) {
			if(nums[i]%2 == 1) {
				numOfOdd++; 
			}
		}

		System.out.println("\nThere are " + numOfEven + " even numbers, " + " and " + numOfOdd + " odd numbers.");

		boolean sortedOrder = false;
		boolean stillTrue = true;

		for(int i = 0 ; i < nums.length -1 ; i ++){

			if(nums[i] < nums[i+1]) {
				sortedOrder = true;

			}
			else if(sortedOrder = true && nums[i] > nums[i+1] ) {
				stillTrue = false;

			}
		}

		if(sortedOrder && stillTrue) {
			System.out.println("\nThe array is sorted from lowest to highest\n");
		}
		System.out.println("\nThe array is not sorted from lowest to highest\n");

		for(int i = 0 ; i < nums.length ; i ++){
			if(nums[i]%2 == 0) {
				evenArray[i] = nums[i];
			}

		}

		for(int i = 0 ; i < nums.length ; i++ ) {
			String arrayName = "even array [" + i + "]";
			System.out.println(arrayName + "\t" + evenArray[i]);
		}

	}//displayArray

}// main


