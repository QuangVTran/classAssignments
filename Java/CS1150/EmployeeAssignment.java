
public class EmployeeAssignment {

	public static void main(String[] args) {
		
		
		
		Employee newEmployee = new Employee("John Doe");
		
		newEmployee.setAge(28);
		newEmployee.setPosition("Software Developer");
		newEmployee.setSalary(10000);
		
		newEmployee.printEmployee();
		
	}

}

class Employee {

	String name;
	String position;
	int age;
	double salary;
	
	public Employee(){
		
	}
	
	public Employee(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age; 
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public void printEmployee() {
		System.out.println("Name \t  : " + name);
		System.out.println("Age \t  : " + age);
		System.out.println("Position  : " + position);
		System.out.println("Salary \t  : " + salary);
	}
	
}
