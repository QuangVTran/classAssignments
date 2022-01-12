
public class Worksheet9 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		// Create some SUVs and some Sport Cars

		SUV aFordSUV = new SUV("Ford");

		SportsCar aBMW = new SportsCar("BMW");

		SUV aChevySUV = new SUV("Chevy");
		
	}

}

class Automobile{
	
	private String manufacturer;
	
	public Automobile(String manufacturer){
		this.manufacturer=manufacturer;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	
	
}

class SUV extends Automobile{
	
	public SUV(String manufacturer){
		
		super(manufacturer);
	}
	
}

class SportsCar extends Automobile{
	
	public SportsCar(String manufacturer) {
		super(manufacturer);
	}
	
}