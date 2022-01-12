
public class Worksheet10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Automobile[] automobiles = new Automobile[5];
		automobiles[0] = new SUV("Ford");
		automobiles[1] = new SUV("Chevy");
		automobiles[2] = new SUV("Toyota");
		automobiles[3] = new SportsCar("BMW");
		automobiles[4] = new SportsCar("Audi");
		
		for(int i = 0 ; i < automobiles.length ; i++) {
			String manufacturer = automobiles[i].getManufacturer();
			System.out.println("This automobile's manufacturer is " + manufacturer);
		}
		
	}

}//Worksheet10

class Automobile {

	String manufacturer;

	public Automobile(String manufacturer) {

		this.manufacturer = manufacturer;

	}

	public String getManufacturer() {

		return manufacturer;

	}

}

class SUV extends Automobile {
	public SUV(String manufacturer) {

		super(manufacturer);

	}
}

class SportsCar extends Automobile {

	public SportsCar(String manufacturer) {

		super(manufacturer);

	}

}