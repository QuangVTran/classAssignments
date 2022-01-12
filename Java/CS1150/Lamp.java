
public class Lamp {

	public static void main(String[] args) {
		
		TheLamp lamp1 = new TheLamp();
		TheLamp lamp2 = new TheLamp();
		
		if (lamp1.getStatus() == false) {
			System.out.println("lamp1 is off");
		}
		else {
			System.out.println("lamp1 is on");
		}
		if (lamp2.getStatus() == false) {
			System.out.println("lamp2 is off");
		}
		else {
			System.out.println("lamp2 is on");
		}
		
		lamp1.turnOn();
		lamp2.turnOn();
		System.out.println();
		
		if (lamp1.getStatus() == false) {
			System.out.println("lamp1 is off");
		}
		else {
			System.out.println("lamp1 is on");
		}
		if (lamp2.getStatus() == false) {
			System.out.println("lamp2 is off");
		}
		else {
			System.out.println("lamp2 is on");
		}
		
	}//main

}//Lamp
class TheLamp{
	
	private boolean isOn;
	
	public void turnOn() {
		isOn = true;
	}
	
	public void turnOff() {
		isOn = false;
	}
	
	public boolean getStatus() {
		return isOn;
	}
	
	
}