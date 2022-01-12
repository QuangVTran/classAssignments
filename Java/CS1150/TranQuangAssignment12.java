/*
 * Quang Tran
 * Due 12-5-19
 * CS1150
 * Michaela Gonzalez
 * The following assignment dives deeper into OOP, and in particular, polymorphism and inheritance.
 * By creating the parent class Animal, which has several subclass/child classes, I will create a zoo  
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class TranQuangAssignment12 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//The following scanner reads the file that was given in the assignment
		File inputFileName = new File("assignment12.txt");
		Scanner inputFile = new Scanner (inputFileName);

		//Building an animal array
		Animal[] Animals = new Animal[5];

		
		//By using a for loop to scan through the file, I assigned each part of each line to a type, name, weight, food, and location. 
		//The type will determine which object is created. 
		for(int i = 0; i< Animals.length; i++) {
			String type = inputFile.next();
			String name = inputFile.next();
			double weight = inputFile.nextDouble();
			String food = inputFile.next();
			String location = inputFile.next();
			//The following line assigns each animal object to the specific animal from the file
			
			if(type.equals("Bear")) {
				Animals[i] = new Bear(name,weight,food,location); 
			
			}
			else if(type.equals("Penguin")) {
				Animals[i] = new Penguin(name,weight,food,location);
				
			}
			else if(type.equals("Panther")) {
				Animals[i] = new Panther(name,weight,food,location);
				
			}
			else if(type.equals("Wolf")) {
				Animals[i] = new Wolf(name, weight, food, location);
			
			}
			
			
		}
		
		
		//Using the instanceof operator, I am able to decipher which animal is which, and then I can call the methods.
		for(int i = 0; i < Animals.length ; i++) {
			
			String food = Animals[i].getFood();
			String location = Animals[i].getLocation();
			double weight = Animals[i].getWeight();
			String name = Animals[i].getName();
			
			
			if(Animals[i] instanceof Bear) {
				System.out.println("Animals["+ i + "] is a bear");
				Animals[i].toString(name,weight,location);
				Animals[i].eat(food);
				Animals[i].sleep();
				Animals[i].swim();
				System.out.println();
			}
			else if(Animals[i] instanceof Penguin) {
				System.out.println("Animals["+ i + "] is a penguin");
				Animals[i].toString(name,weight,location);
				Animals[i].eat(food);
				Animals[i].sleep();
				Animals[i].swim();
				System.out.println();
			}
			else if(Animals[i] instanceof Panther) {
				System.out.println("Animals["+ i + "] is a panther");
				Animals[i].toString(name,weight,location);
				Animals[i].eat(food);
				Animals[i].sleep();
				Animals[i].swim();
				System.out.println();
			}
			else if (Animals[i] instanceof Wolf) {
				System.out.println("Animals["+ i + "] is a wolf");
				Animals[i].toString(name,weight,location);
				Animals[i].eat(food);
				Animals[i].sleep();
				Animals[i].swim();
				System.out.println();
			}
		}
		
		
	}

}

//The superclass Animal
class Animal{
	private String name;
	private double weight;
	private String food;
	private String location;

	public Animal (String name, double weight, String food, String location) {
		this.name =name;
		this.weight= weight;
		this.food = food;
		this.location = location;

	}

	
	public String getName(){
		return name;
	}

	public double getWeight() {
		return weight;
	}

	public String getFood() {
		return food;
	}

	public String getLocation() {
		return location;

	}
	public void eat(String food) {
		System.out.println("Animal is eating " + food);
	}

	public void sleep() {
		System.out.println("Animal is sleeping - do not disturb");
	}

	public void swim() {
		System.out.println("Animal is swimming");
	}
	
	//These methods are going to be overridden in the subclasses
	public void toString(String name, double weight, String location) {

		System.out.println("Animal: name: " + name + " weighs: " + weight + " lbs - location: " + location);
		
	}


}

//The subclass Panther
class Panther extends Animal{

	public Panther(String name, double weight, String food, String location) {
		super(name,weight,food,location);

	}

	//These methods are Overridden
	public void eat(String food) {
		System.out.println("Panther is eating " + food);
	}

	public void sleep() {
		System.out.println("Panther is Sleeping");

	}
	
	public void toString(String name, double weight, String location) {

		System.out.println("Panther: name: " + name + " weighs: " + weight + " lbs - location: " + location);
		
	}

	

}
//The subclass penguin, child of Animal
class Penguin extends Animal{

	public Penguin(String name, double weight, String food, String location){
		super(name,weight,food,location);
	}

	//The following methods are overridden
	public void eat(String food) {
		System.out.println("Penguin is eating " + food);
	}

	public void swim() {
		System.out.println("Penguin is swimming");
	}

	public void toString(String name, double weight, String location) {

		System.out.println("Penguin: name: " + name + " weighs: " + weight + " lbs - location: " + location);
		
	}

}

class Bear extends Animal{

	public Bear(String name, double weight, String food, String location) {
		super(name,weight,food,location);
	}

	//The following methods are overridden

	public void eat(String food) {
		System.out.println("Bear is eating " + food);
	}

	public void sleep() {
		System.out.println("Bear is sleeping");
	}

	public void swim() {
		System.out.println("Bear is swimming");
	}
	
	public void toString(String name, double weight, String location) {

		System.out.println("Bear: name: " + name + " weighs: " + weight + " lbs - location: " + location);
		
	}
}
class Wolf extends Animal{

	public Wolf(String name, double weight, String food, String location){
		super(name,weight,food,location);
	}

	public void toString(String name, double weight, String location) {

		System.out.println("Wolf: name: " + name + " weighs: " + weight + " lbs - location: " + location);
		
	}
}


