
public class AnimalTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Lion maxTheLion = new Lion("Max");

	}//main

}//AnimalTester


	private String name;
	private double weight;
	private String food;
	private String location;


	public Animal() {

		System.out.println("Animal Default Constructor");
		this.name= "";
		this.weight= 0 ;
		this.food = "";
		this.location = "";


	}
	public Animal(String name) {
		System.out.println("Animal Constructor - name");
		this.name = name;


	}

	public void setName(String name) {
		this.name = name;
	}

}


	public Lion() {
		super();
		System.out.println("Lion Default Constructor");
	}

	public Lion(String name) {
		System.out.println("Lion Constructor - name");
		setName(name);
	}
}
