/*Quang Tran
 * Due 11-1-19
 * CS1150
 * Description: The following assignment tests my knowledge on methods and arrays. This assignment uses an array for rainfall and specific dog barks. The dog barks also introduces us to new classes.
 */
public class TranQuangAssignment8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		//Initializing rainfall array, and allocates memory for the rainfall array	
		double [] rainfall = new double[7];
		//Assigning each rainfall number, starting at 0
		rainfall[0] = 15.54;
		rainfall[1] = 37.19;
		rainfall[2] = 53.19;
		rainfall[3] = 34.25;
		rainfall[4] = 46.00;
		rainfall[5] = 35.82;
		rainfall[6] = 61.90;


		//Now initialize the array of strings for cities
		//Denver is 0 and Miami is 6 the length is 7
		String[] cityName = new String[] {"Denver", "Seattle", "Orlando", "Austin", "Vancouver", "Chicago", "Miami"};

		//Initializing the average variable, by calling the average computation method, which returns a double value.
		double average = computeAverageRainfall(rainfall);

		//Calling a void method, which returns nothing, but prints lines for a table.
		displayRainfalls(rainfall,cityName);

		//Printing a statement that shows the total rainfall for all cities
		System.out.println("\n" + "Total rainfall for all cities is " + computeTotalRainfall(rainfall));

		System.out.println("");

		//using printf format to truncate decimals properly
		System.out.printf("%s%.2f%s","Average rainfall for all cities is ",computeAverageRainfall(rainfall)," inches per year");

		//The method used returns an int value used to call the specific array, which in this case, is the one with the most rainfall.
		System.out.println("\n" + "\n" + "City with the most rain is " + cityName[findCityWithMostRainfall(rainfall)] + " with " + rainfall[findCityWithMostRainfall(rainfall)] + " inches per year" );

		System.out.println("");

		//This method is also void, so it doesn't return any parameter values. It does print out multiple lines of text. 
		displayCitiesWithAboveAverageRainfall(rainfall,cityName,average);

		// Now for the dog part

		//Copied from assignment 9
		Dog[] dogArray = new Dog[5];	

		Dog dog1 = new Dog("Rover", "woof woof");

		Dog dog2 = new Dog("Max", "arf arf arf");

		Dog dog3 = new Dog("Tiny", "yap yap yap");

		Dog dog4 = new Dog("Trooper", "ruff ruff ruff");

		Dog dog5 = new Dog("Magoo", "bow wow bow wow");

		dogArray[0] = dog1;

		dogArray[1] = dog2;

		dogArray[2] = dog3;

		dogArray[3] = dog4;

		dogArray[4] = dog5;

		System.out.println();
		makeDogsBark(dogArray);	


	}//main

	public static void displayRainfalls(double[] rainfall, String[] cityName) {

		//Here I will print out the table 

		System.out.println("------------------------------------");
		System.out.println("");
		System.out.println("City " + "			" + "Yearly Rainfall");
		System.out.println("");
		System.out.println("------------------------------------");
		System.out.println("");

		//Formatting a table that uses arrays instead of individual variables
		System.out.println(cityName[0] + "\t\t\t" + rainfall[0] + "\n" + cityName[1] + "\t\t\t" + rainfall[1] + "\n" + cityName[2] + "\t\t\t" + rainfall[2] + "\n" + cityName[3] + "\t\t\t" + rainfall[3]);
		System.out.print(cityName[4] + "\t\t" + rainfall[4] + "\n" + cityName[5] + "\t\t\t" + rainfall[5] + "\n" + cityName[6] + "\t\t\t" + rainfall[6] +"\n");

	}

	public static double computeTotalRainfall(double[] rainfall) {
		//Initializing total rainfall
		double sumRainfall = 0;

		//The following for loop checks each individual value of the array, and will find sum by incrementing sumRainfall by each of their respective rainfall amounts.
		for(int i = 0 ; i < rainfall.length; i++) {
			sumRainfall += rainfall[i];
		}
		//This method will return the double value, sumRainfall
		return sumRainfall;
	}


	public static double computeAverageRainfall(double[] rainfall) {
		//Initialize a double variable that is equal to the sum of all the rainfall, which is called by the computeTotalRainfall method, divided by the number of values within the array.
		double avgRainfall = computeTotalRainfall(rainfall) / rainfall.length;
		return avgRainfall;
	}

	public static int findCityWithMostRainfall(double[] rainfall) {
		//Initialize the value for the largest number, starting off with the initial value in the array
		double largestAmtOfRain = rainfall[0];
		//Initialize the i value, for the cityNames array, in this case, starting with the initial i value; 0.
		int largestAmtOfRainCityName = 0;
		//The following for loop will reassign the largest number variable if the rainfall array value it reads is higher than the current largest number variable
		for(int i = 0 ; i < rainfall.length ; i++) {
			if(rainfall[i] > largestAmtOfRain) {
				largestAmtOfRain = rainfall[i];
				//The next line will make sure that the city and rainfall number match up and correspond 
				largestAmtOfRainCityName = i;
			}

		}
		// This method will return with an array value, which corresponds to which city and how much rain that city had.
		return largestAmtOfRainCityName; 
	}

	public static void displayCitiesWithAboveAverageRainfall(double[] rainfall,  String[] cityName,   double average) {
		//Initialize an average value by calling the method to calculate it.
		average = computeAverageRainfall(rainfall);
		// the following for loop will print the city and it's rainfall value if that value is greater than the average rainfall.
		for(int i = 0 ; i < rainfall.length ; i++) {
			if(rainfall[i] > average){
				System.out.println(cityName[i] + " gets " + rainfall[i] + " inches of rain, which is above average.");
			}
		}

	}

	public static void makeDogsBark(Dog[] dogArray) {
		
		//using a for loop like the one above...
		for(int i = 0 ; i < dogArray.length ; i++) {
			//print out the dog barks by calling each parameter using the arrays and methods from the new Dog Class
			System.out.println(dogArray[i].getName() + " barks like this " +  dogArray[i].getBark() +"\n" );

		}

	}


}//Assignment 8

class Dog {							
	private String name;					
	private String bark;					

	public Dog (String name, String bark) {
		this.name = name;
		this.bark = bark;
	}

	public String getName() {				
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBark() {
		return bark;
	}

	public void setBark(String bark) {
		this.bark = bark;
	}
} // Dog

