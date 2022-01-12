import java.util.Scanner;
public class LectureDec10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] data = new int[100];
		
		for(int i = 0; i < data.length ; i++) {
			data[i] = (int)(Math.random() * 10000);
		}
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an index");
		int index = input.nextInt();
		
		try {
			System.out.println("The element is " + data[index]);
		}
		
		catch(Exception ex){
			System.out.println("In catch clause!");
			System.out.println("Array index " + index + " is out of bounds");
		}
		
		
		
	}

}
