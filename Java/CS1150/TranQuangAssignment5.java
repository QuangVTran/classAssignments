/*
 * Quang Tran
 * Assignment:Use while loops to produce statistics about coffee shops. 
 * Due October 3rd 2019
 */
import java.util.Scanner;
public class TranQuangAssignment5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Scanner as usual
		 */
		
		Scanner input = new Scanner(System.in);

		System.out.println("Please enter sales for all stores above, and end with -1");

		/*
		 * I made variables for everything I increment 
		 * Using int for smaller numbers and doubles for larger numbers(sale numbers)
		 * Most importantly is salesFromStore, which is the line of numbers the user inputs. 
		 *  In salesFromStores, the numbers the user inputed will be read by each whole number before a space
		 */

		int saleNumber = 0;
		double salesFromStores = input.nextInt();
		double largestSale = 0 ;
		double smallestSale = 2147483647; 
		double sumSales = 0;
		int numLessThanOneThousand = 0;
		int numBetweenOneAndFiveThousand =0;
		int numGreaterThanFiveThousand =0;

		/*
		 * The asterisks for the bar chart will be printed out as a string
		 * Starting by defining the string as an empty string
		 */

		String asterisks = "";

		/*
		 * Starting with the case where there is no sales,
		 * The program will stop if the sentinel value (-1) is read without any previous sales.
		 */

		if(salesFromStores == -1) {
			System.out.println("You have no sales");
			input.close();
			return;
		}

		/*
		 * The following while loop will repeat itself until the boolean expression is completed,
		 * which in this case means saleFromStores (which is every nextInt() from what the user inputed)
		 * is equal to -1 (the sentinel value)
		 * In other words, salesFromStore will keep putting sale numbers in until it reaches a -1
		 */

		while(salesFromStores != -1){

			/*
			 * Starting off from the smallest possible value, which is 0 in this case, 
			 * The program will set the variable largestSale to be equal to the current value from salesFromStores.
			 * As the while loop continues, the value of largestSale will only increase if saleFromStores is greater than the current largestSale value.
			 * In the next loop, the variable largestSale will use the previous saleFromStores value, and will only change if the next salesFromStore value is larger than the current one.
			 */

			if(largestSale < salesFromStores) {
				largestSale = salesFromStores;
			}

			/*
			 * The smallestSale variable is essentially the inverse of largestSale. 
			 * The program starts off with the largest possible int value: 2147483647,
			 * And as the while loop continues, the next smallestSale value will be set as the salesFromStore value if it's smaller than the the current smallestSale value.
			 *	The program will iterate, and smallestSale will only change if the current salesFromStores is less than the current smallestSale.
			 */

			if(smallestSale > salesFromStores) {
				smallestSale = salesFromStores;
			}

			/*
			 * The variable numLessThanOneThousand is set as 0, and will increment each time the while loop picks up a salesFromStore integer less than 1000
			 */

			if(salesFromStores < 1000 ) {
				numLessThanOneThousand++;
			}

			/*
			 * This is similar to the previous variable, however this time, the salesFromStores value must be greater than 1000, or less than 5000, for the
			 * variable numBetweenOneAndFiveThousand to increment.
			 */

			if(salesFromStores > 1000 && salesFromStores < 5000) {
				numBetweenOneAndFiveThousand++;
			}

			/*
			 * This is just like numLessThanOneThousand
			 */

			if(salesFromStores > 5000){
				numGreaterThanFiveThousand++;
			}

			/*
			 * With the following computation placed within the while loop, the variable sumSales, which starting at 0, will accumulate the values of salesFromStore
			 * in each iteration.
			 */

			sumSales = sumSales + salesFromStores;

			/*
			 * After all the calculations have been made, we can now take the value of salesFromStores, and divide it by 100 to have the numOfAsterisks 
			 * in our bar chart. 
			 */

			double numOfAsterisks = salesFromStores/100;

			/*
			 * While the numOfAsterisks is greater than 0, for every numOfAsterisks we have, we add an asterisk to the empty string "asterisk", and at the same time, decrement the
			 * variable numOfAsterisks to have a stopping point which ends the while loop. This will result in the string ending up with an asterisk for every $100 of sale. 
			 */

			while(numOfAsterisks > 0 ){
				numOfAsterisks--;
				asterisks += "*";
			}

			/*
			 * The sale number, which is currently 0, will increment each and every time the loop is iterated. 
			 */

			saleNumber++;

			/*
			 * This is the format of the bar chart, which will have an incrementing saleNumber with corresponding asterisks to each int value the user inputed.
			 * If the user placed a -1 at the end, the bottom line of code will make sure that salesFromStores = -1, which is the sentinel value which will make the while loop
			 * false, ending it.
			 */

			System.out.println("Sales #" + (saleNumber) +": " + asterisks);
			asterisks ="";
			salesFromStores = input.nextInt();

		}

		/*
		 * Using the example and the variables we defined above, the rest of it was just print statements.
		 */


		System.out.println("");

		System.out.println("Number of sale amounts: " + saleNumber);

		System.out.println("The largest sale was : " + largestSale);

		System.out.println("The smallest sale was : " + smallestSale);

		System.out.println("The sum of the sales is: " + sumSales);

		System.out.println("The range of the sales is " + (largestSale - smallestSale));

		System.out.println("The average of the sales is " + (sumSales/saleNumber));

		System.out.println("The number of sales below $1000 is : " + (numLessThanOneThousand));

		System.out.println("The number of sales between $1000 and $5000 is : " + numBetweenOneAndFiveThousand);

		System.out.println("The numberof sales above $5000 is " + numGreaterThanFiveThousand);



	}

}	
