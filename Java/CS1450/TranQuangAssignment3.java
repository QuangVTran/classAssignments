import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/*
 * Quang Tran
 * CS1450 Section 2
 * Assignment #3
 * Due 2-12-2020
 * Description:
 */

public class TranQuangAssignment3 {
	
	//Since we're reading files, we need to throw IOException
	public static void main(String[] args) throws IOException {

		File insectFile = new File("insects.txt");

		Scanner readFile = new Scanner(insectFile);

		//The first line of the text file gives us the length of the array 
		int insectArraySize = readFile.nextInt();

		//Initializes a polymorphic array of insects
		Insect[] insects = new Insect[insectArraySize];
		
		//The following for loop will read the file, and based on what the file contains, will create insects, whose type depends on what is written on the file. This involves polymorphism.
		for(int i = 0; i < insectArraySize ; i++) {

			String type = readFile.next(); 

			String name = readFile.next();

			int pollinateAbility = readFile.nextInt();

			int buildAbility = readFile.nextInt();

			int predatorAbility = readFile.nextInt();

			int decomposeAbility = readFile.nextInt();

			//Here we can use a switch statement, if and else statements, or instanceof keyword for boolean statements
			if(type.equals("h")) {
				insects[i] = new Honeybee(name, pollinateAbility,buildAbility);
				insects[i].setType("Honeybee");
			}
			else if(type.equals("l")) {
				insects[i] = new Ladybug(name, pollinateAbility, predatorAbility);
				insects[i].setType("Ladybug");
			}
			else if(type.equals("a")) {
				insects[i] = new Ant(name, buildAbility, predatorAbility,decomposeAbility);
				insects[i].setType("Ant");
			}
			else if(type.equals("p")) {
				insects[i] = new PrayingMantis(name,predatorAbility);
				insects[i].setType("PrayingMantis");
			}

		}

		
		//Closing the file after reading it
		readFile.close();
		
		//Using the method below, initializing an arrayList of insects that are not decomposers
		ArrayList<Insect> doNotDecompose = findDoNotDecompose(insects);
		
		//Printing out in console.
		System.out.println("Insects that dont help with decomposition\n\n");
			
		//Calling the method to return an arrayList of insects that are not decomposers, and displaying their abilities
		for(int i = 0 ; i < doNotDecompose.size() ; i++) {
			displayAbilities(doNotDecompose.get(i));
		
		}
		
		System.out.println("Insect with most abilities\n\n");
		
		//Calling the method that returns an index integer of the insect with the highest level of abilities, and displays the abilities of that specific insect
		displayAbilities(insects[findMostAble(insects)]);
		
	}//main

	//The following method takes all of the insects in the insects[] array that are not decomposers, and adds them into an arrayList	
	public static ArrayList<Insect> findDoNotDecompose(Insect[] insects){

		//Initializing an arrayList of Insects datatype
		ArrayList<Insect>doNotDecompose = new ArrayList<>();

		//The following for loop goes through the array, and fills the array with insects that are not an instance of a decomposer
		for(int i = 0; i < insects.length; i ++) {

			boolean isNotADecomposer = (!(insects[i] instanceof Decomposer)); 

			if(isNotADecomposer) {
				doNotDecompose.add(insects[i]);
			}
		}

		return doNotDecompose;

	}

	//The following method returns an index value for the insect with the highest sum of ability points
	public static int findMostAble(Insect[] insects) {
		int findMostAble = 0;
		int sum = 0;
		int returnIndex = 0;

		//The following for loop will scan through the insect array, and search for the index with the highest ability points
		for (int i = 0 ; i < insects.length ; i++) {

			if(insects[i].getType().equals("Ant")) {
				sum = ( ((Ant) insects[i]).build() ) + (  ((Ant) insects[i]).predator() ) + ( ((Ant) insects[i]).decompose() );
				if(findMostAble < sum) {
					findMostAble = sum;
					returnIndex = i;
				}
			}

				else if(insects[i].getType().equals("Honeybee")) {
					sum = ( ((Honeybee) insects[i]).pollinate() ) + (  ((Honeybee) insects[i]).build() );
					if(findMostAble < sum) {
						findMostAble = sum;
						returnIndex = i;
					}
				}
				else if(insects[i].getType().equals("Ladybug")) {
					sum = ( ((Ladybug) insects[i]).pollinate() ) + (  ((Ladybug) insects[i]).predator() );
					if(findMostAble < sum) {
						findMostAble = sum;
						returnIndex = i;
					}
				}


				else if(insects[i].getType().equals("PrayingMantis")) {
					sum = (  ((PrayingMantis) insects[i]).predator() );
					if(findMostAble < sum) {
						findMostAble = sum;
						returnIndex = i;
					}

				}
			
		}
		return returnIndex;

	}//findMostAble
	
	//The following method will print out the name and abilities 
	public static void displayAbilities(Insect insects) {
		
			System.out.print(insects.getName() + " is a ");
			System.out.print(insects.getType());
			
			if(!(insects instanceof Decomposer)) {
				System.out.println(" and does not help with decomposition");
			}
			else {
				System.out.println(" is a decomposer");
			}
			
			insects.purpose();
			
			if(insects instanceof Honeybee) {
				System.out.println("Pollinating ability : " + ( ((Honeybee) insects).pollinate() ));
				System.out.println("Building ability : " + ( ((Honeybee) insects).build() ));
				System.out.println();
			}
			
			if(insects instanceof Ladybug) {
				System.out.println("Pollinating ability : " + ( ((Ladybug) insects).pollinate() ));
				System.out.println("Predatory ability : " + ( ((Ladybug) insects).predator() ));
				System.out.println();
			}
			
			if(insects instanceof Ant) {
				System.out.println("Building ability : " + ( ((Ant) insects).build()));
				System.out.println("Predatory ability : " + ( ((Ant) insects).predator()));
				System.out.println("Decomposting ability : " + ( ((Ant)insects).decompose()));
				System.out.println();
			}
			
			if(insects instanceof PrayingMantis) {
				System.out.println("Predatory ability : " + ( ((PrayingMantis) insects).predator()));
				System.out.println();
			}
			
			
		
	}

}//assignment


interface Pollinator{
	public abstract int pollinate();
}

interface Builder{
	public abstract int build();
}

interface Predator{
	public abstract int predator();
}

interface Decomposer{
	public abstract int decompose();
}

//This insect class is abstract
abstract class Insect{
	private String type;
	private String name;

	public String getType(){
		return type;
	}

	public String getName() {
		return name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract void purpose();


}//Animal


class Honeybee extends Insect implements Pollinator,Builder{
	private int pollinateAbility;
	private int buildAbility;

	public Honeybee(String name, int pollinateAbility, int buildAbility){

		setName(name);
		this.pollinateAbility = pollinateAbility;
		this.buildAbility = buildAbility;
	}

	@Override
	public void purpose(){
		System.out.println("I'm popular for producing honey but I also pollinate 35% of the crops! Without me, 1/3 of the food you eat would not be available!");
	}

	@Override
	public int pollinate() {
		return pollinateAbility;
	}

	@Override
	public int build() {
		return buildAbility;
	}


}//Honeybee

class Ladybug extends Insect implements Pollinator,Predator {
	private int pollinateAbility;
	private int predatorAbility;

	public Ladybug(String name, int pollinateAbility, int predatorAbility) {

		setName(name);
		this.pollinateAbility = pollinateAbility;
		this.predatorAbility = predatorAbility;

	}

	@Override
	public void purpose() {
		System.out.println("Named after the Virgin Mary, I'm considered good luck if I land on you! I'm a pest control expert eating up to 5,000 plant pests during my life span.");
	}

	@Override
	public int pollinate() {
		return pollinateAbility;
	}

	@Override
	public int predator() {
		return predatorAbility;
	}
}//Ladybug

class Ant extends Insect implements Builder,Predator,Decomposer{
	private int predatorAbility;
	private int buildAbility;
	private int decomposerAbility;

	public Ant(String name, int buildAbility, int predatorAbility, int decomposerAbility) {
		setName(name);
		this.buildAbility = buildAbility;
		this.predatorAbility = predatorAbility;
		this.decomposerAbility = decomposerAbility;
	}

	@Override
	public void purpose() {
		System.out.println("Don't squash me, I'm an ecosystem engineer! Me and my 20 million friends accelerate decomposition of dead wood, aerate soil, improve drainage, and eat insects like ticks and termites!");
	}

	@Override
	public int build() {
		return buildAbility;
	}

	@Override
	public int predator() {
		return predatorAbility;
	}

	@Override
	public int decompose() {
		return decomposerAbility;
	}
}//Ant

class PrayingMantis extends Insect implements Predator{
	private int predatorAbility;

	public PrayingMantis(String name, int predatorAbility) {
		setName(name);
		this.predatorAbility = predatorAbility;
	}

	@Override
	public void purpose() {
		System.out.println("I'm an extreme predator quick enough to catch a fly. Release me in a garden and I'll eat beetles, grasshoppers, crickets and even pesky moths.");
	}

	@Override
	public int predator() {
		return predatorAbility;
	}
}//Praying Mantis
