/*
 * Quang Tran
 * CS1450
 * Assignment 9
 * Due 4-22-2020
 * 
 * Description: The following assignment will test my abilities to create a linked list class, and manipulate it by adding and creating in several elephant objects written from a text file.
 * 
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class TranQuangAssignment9 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Initializing the linked list
		ElephantLinkedList myListOfElephants = new ElephantLinkedList();

		//Initializing the assignment file
		File elephantFile = new File("elephants.txt");

		//Initializing a scanner object to read the file
		Scanner readFile = new Scanner(elephantFile);


		//Reading the file, and taking the name and weight information given to create an elephant object
		while(readFile.hasNext()) {

			String name = readFile.next();

			int weight = readFile.nextInt();

			Elephant anElephant = new Elephant(name,weight);

			myListOfElephants.add(anElephant);


		}

		System.out.println("Step 1 : Created and placed Elephants in linked list\n");

		//This is step 1, where the linked list is printed out 
		myListOfElephants.printList();

		System.out.println("Step 2 : Find total weight for all elephants\n");

		//Using the getTotalWeight method, this prints out the sum of all the elephants' weights and adds them up
		System.out.println("Total weight of all elephants is : " + myListOfElephants.getTotalWeight() + " pounds");

		System.out.println("\n");

		System.out.println("Step 3 : Find and remove elephants, heaviest to lightest");

		readFile.close();
		
		//This is step 3, where the elephants are taken from the list in descending order, and printed out in that order
		while(myListOfElephants.isEmpty() == false) {
			System.out.println(myListOfElephants.isEmpty());

			myListOfElephants.findHeaviest().print();

			myListOfElephants.remove(myListOfElephants.findHeaviest());
		}
			//Unfortunately, here I ran into a null pointer exception error, as I could not stop the while loop. I assume it's because the while loop does not stop, as myListOfElephants does not empty out properly.



	}



}

class Elephant{

	private String name;
	private int weight;

	public Elephant(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	public void print() {

		System.out.println("Elephant Name: " + name + "\t Weight: " + weight);
		System.out.println();

	}

}

class ElephantLinkedList{

	private Node head;
	private Node tail;


	public ElephantLinkedList() {
		head = null;
		tail = null;
	}

	public boolean isEmpty() {
		if(head == null &&		 tail == null) {
			return true;
		}
		else {
			return false;
		}


	}

	public int getTotalWeight() {
		int totalWeight = 0;

		Node current = head;

		while(current != null) {
			int currentWeight = current.elephant.getWeight();

			totalWeight = currentWeight + totalWeight;

			current = current.next;
		}


		return totalWeight;
	}

	public void add(Elephant elephant) {
		Node newNode = new Node(elephant);


		if(tail == null) {
			head = tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	public Elephant findHeaviest() {

		Node current = head;
		Node heaviest = head;

		Elephant heaviestElephant = null;
		int currentHeaviest = 0;

		if (head == null) {
			return null;
		}
		else {

			while(current != null) {
				if(current.elephant.getWeight() >= currentHeaviest) {
					currentHeaviest = current.elephant.getWeight();
					heaviestElephant = current.elephant;
					heaviest = current;

				}

				current = current.next;

			}	

			return heaviestElephant;
		}


	}

	public void remove(Elephant elephant) {

		Node previous = null;
		Node current = head;

		boolean found = false; 
		while(current != null && !found ) {
			if(current.elephant == elephant) {
				found = true;
			}
			else {
				previous = current;
				current = current.next;
			}
		}
		if(found) {
			if(previous == null) {
				head = current.next;
			}
			else {
				previous.next = current.next;
			}

		}

	}



	public void printList() {

		Node current = head;

		System.out.println("Elephant \t Weight\n");
		System.out.println("---------------------------------\n");

		while(current != null) {
			String currentName = current.elephant.getName();
			int currentWeight = current.elephant.getWeight();

			System.out.println(currentName + "\t\t" + currentWeight);
			System.out.println();

			current = current.next;

		}

	}



	private static class Node{

		private Elephant elephant;
		private Node next;

		public Node(Elephant elephant) {
			this.elephant = elephant;
			next = null;
		}
	}
}

