/*
 * Name:Quang Tran
 * Class: CS1150 
 * Date:September 25th,2019
 * 	Description: Credit Card Number Generator
 */
import java.util.Scanner; 
public class TranQuangAssignment4 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub


		//Scanner as usual
		Scanner input = new Scanner(System.in);

		//Constants and formulas 

		final char VISA = 'V' ;
		final char AMEXPRESS = 'A';
		final char FAKEINTERNATIONAL = 'F';

		final int regularClass = 1;
		final int platinumClass = 2;
		final int signatureClass= 3;

		System.out.println("Enter two characters together");
		System.out.println("V: Visa,	A:	American Express,	F: Fake International");
		System.out.println("1: Regular	2:Platinum 3:	Signature");


		String userInput = input.next();



		/*
		 * Not sure how to get the second part past the && operator to work
		 * Perhaps you cannot use multiple logical operators (V || A ||F ) && (1 || 2 || 3)
		 * I also tried replacing the 'char' (like 'V') with the constants char above (userInput.charAt(0)== VISA),
		 *  however it changed the output so I left it as such, hopefully its not hard coding
		 *  Struggling with nested ifs
		 */
		if( ((userInput.charAt(0)== 'V' || userInput.charAt(0) == 'A' || userInput.charAt(0) == 'F') && (userInput.charAt(1)== '1' || userInput.charAt(1)== '2' || userInput.charAt(1)== '3')) == true ) {
			System.out.println("Your Credit Card is:");
			if((userInput.charAt(0)== 'V' && userInput.charAt(1)=='1')) {

				System.out.println("VISA "  + ((int)(4000+ Math.random() *999)) + " " +((int) (1000+Math.random() *8999)) + " " + ((int)(1000+Math.random() *8999)) + " " + ((int)(1000+Math.random() *8999)));

			}
			else if((userInput.charAt(0)== 'V' && userInput.charAt(1)=='2')) {
				System.out.println("Platinum VISA "  + ((int)(4000+ Math.random() *999)) + " " +((int) (1000+Math.random() *8999)) + " " + ((int)(1000+Math.random() *8999)) + " " + ((int)(1000+Math.random() *8999)));


			}
			else if((userInput.charAt(0)== 'V' && userInput.charAt(1)=='3')) {
				System.out.println("Signature VISA "  + ((int)(4000+ Math.random() *999)) + " " +((int) (1000+Math.random() *8999)) + " " + ((int)(1000+Math.random() *8999)) + " " + ((int)(1000+Math.random() *8999)));
			}
			else if((userInput.charAt(0)== 'A' && userInput.charAt(1)=='1')) {
				System.out.println("American Express " + ((int)(3700+ Math.random() *99)) + " " +((int) (100000+Math.random() *99999)) + " " + ((int)(10000+Math.random()*9999)));

			}
			else if((userInput.charAt(0)== 'A' && userInput.charAt(1)=='2')) {
				System.out.println("Platinum American Express " + ((int)(3700+ Math.random() *99)) + " " +((int) (100000+Math.random() *99999)) + " " + ((int)(10000+Math.random()*9999)));

			}
			else if((userInput.charAt(0)== 'A' && userInput.charAt(1)=='3')) {
				System.out.println("Signature American Express " + ((int)(3700+ Math.random() *99)) + " " +((int) (100000+Math.random() *99999)) + " " + ((int)(10000+Math.random()*9999)));

			}
			else if((userInput.charAt(0)== 'F' && userInput.charAt(1)=='1')) {
				System.out.println( ( (char)(65+Math.random() *25) )  + "" + ((char)(65+Math.random() *25)) + "" + ((char)(65+Math.random() *25)) + "" + ((char)(65+Math.random() *25)) + "" + " " +((int) (1000+Math.random() *8999)) + " " + ((int)(10000+Math.random()*9999)) ) ;
			}
			else if((userInput.charAt(0)== 'F' && userInput.charAt(1)=='2')) {
				System.out.println("Platinum " + ( (char)(65+Math.random() *25) )  + "" + ((char)(65+Math.random() *25)) + "" + ((char)(65+Math.random() *25)) + "" + ((char)(65+Math.random() *25)) + "" + " " +((int) (1000+Math.random() *8999)) + " " + ((int)(10000+Math.random()*9999)) ) ;
				
			}
			else if((userInput.charAt(0)== 'F' && userInput.charAt(1)=='3')) {
				System.out.println("Signature " + ( (char)(65+Math.random() *25) )  + "" + ((char)(65+Math.random() *25)) + "" + ((char)(65+Math.random() *25)) + "" + ((char)(65+Math.random() *25)) + "" + " " +((int) (1000+Math.random() *8999)) + " " + ((int)(10000+Math.random()*9999)) ) ;
				
			}
		}

		/*
		 * Band-aid fixed it using == true	
		 */
		else if((userInput.charAt(0)!= 'V'|| userInput.charAt(0)!= 'A'|| userInput.charAt(0)!= 'F') == true && (userInput.charAt(1)== '1' || userInput.charAt(1)== '2' || userInput.charAt(1)== '3') ==true )    {
			System.out.println("Invalid choice for Card Type");
		}
		/*
		 * Not sure how to integrate this second else if into it
		 */
		else if ((userInput.charAt(1)!= '1' || userInput.charAt(1)!= '2' || userInput.charAt(1)!= '3') == true) {
			System.out.println("Invalid choice for Credit Level");
		}

	}
}