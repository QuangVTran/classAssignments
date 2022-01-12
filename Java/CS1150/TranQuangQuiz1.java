
import java.util.Scanner; 
public class TranQuangQuiz1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub



		final char PREMIUM = 'P';
		final char DELUXE = 'D';
		final char STANDARD ='S';

		System.out.println("Hi there, what kind of car wash would you like?");
		System.out.println("Please type in the letter:");
		System.out.println("P for Premium");
		System.out.println("D for Deluxe");
		System.out.println("S for Standard");




		Scanner input = new Scanner(System.in) ;
		String washType =  input.next();

		final int COMPACT = 1;
		final int STANDARD_CAR = 2;
		final int TRUCK = 3;
		final int SUV = 4;

		if(washType.equals("P")) {

			String washName = ("Premium");
		}
		else if(washType.equals("D")) {
			String washName = ("Deluxe");
		}

		else if(washType.equals("S")) {
			String washName = ("Standard");
		}

		 
		System.out.println();

		if ( washType.equals("P")) {
			System.out.println("You selected the " + "Premium" + " wash");
			System.out.println("");
			System.out.println("Now, which type of vehicle do you have?");
			System.out.println("Please select a number below");
			System.out.println("1 for Compact");
			System.out.println("2 for Standard");
			System.out.println("3 for Truck");
			System.out.println("4 for SUV");
		}



		else if (washType.equals("D")) {
			System.out.println("You selected the " + "Deluxe" + " wash");
			System.out.println("");
			System.out.println("Now, which type of vehicle do you have?");
			System.out.println("Please select a number below");
			System.out.println("1 for Compact");
			System.out.println("2 for Standard");
			System.out.println("3 for Truck");
			System.out.println("4 for SUV");
		}


		else if (washType.equals("S")) {
			System.out.println("You selected the " + "Standard" + " wash");
			System.out.println("");
			System.out.println("Now, which type of vehicle do you have?");
			System.out.println("Please select a number below");
			System.out.println("1 for Compact");
			System.out.println("2 for Standard");
			System.out.println("3 for Truck");
			System.out.println("4 for SUV");
		}
		else  {
			System.out.println("That is not an option listed above, Good Bye ");

		}	

		final int baseCost = 5;

		Scanner vehicleInput = new Scanner(System.in);
		int vehicleType = vehicleInput.nextInt();

		if(vehicleType == 1) {
			int totalCost = baseCost + 0;
			System.out.println("This car wash will cost " + totalCost + " dollars");
		}

		else if (vehicleType == 2){
			int totalCost = baseCost + 1;
			System.out.println("This car wash will cost " + totalCost + " dollars");
		}
		else if (vehicleType == 3 || vehicleType == 4){
			int totalCost = baseCost + 3;
			System.out.println("This car wash will cost " + totalCost + " dollars");

		}
		else {
			System.out.println("Invalid vehicle type, Good Bye");

		}
	}
}