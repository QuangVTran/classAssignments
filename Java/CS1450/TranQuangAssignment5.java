import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/*
 * Name: Quang Tran
 * Class: CS1450
 * Assignment : Assignment #5
 * Due : 2-26-2020
 * Description: This assignment teaches me how to use stacks, as well as generics. Also, since we implemented the comparable interface, it allows use to use compareTo as well. Similar to how
 * I've done array manipulations before, this assignment will test my ability to manipulate stacks, through classes and operations such as push pop and peek.
 * 
 */
public class TranQuangAssignment5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Initializing the stacks(using array list) of generic values in terms of integers and strings
		GenericStack<Integer> numStack1 = new GenericStack<>();

		GenericStack<Integer> numStack2 = new GenericStack<>();

		GenericStack<String> stringsStack1 = new GenericStack<>();

		GenericStack<String> stringsStack2 = new GenericStack<>();

		//Reading the file 
		File fileNumbers1 = new File("numbers1.txt");

		Scanner readNum1 = new Scanner(fileNumbers1);


		//Adding the next numbers into the stack by pushing

		while(readNum1.hasNext()) {
			int nextNumber = readNum1.nextInt();
			numStack1.push(nextNumber);

		}

		readNum1.close();

		File fileNumbers2 = new File("numbers2.txt");

		Scanner readNum2 = new Scanner(fileNumbers2);


		while(readNum2.hasNext()) {
			int nextNumber = readNum2.nextInt();
			numStack2.push(nextNumber);

		}

		readNum2.close();

		System.out.println("Numbers Stack 1 - filled with values from numbers1.txt ");
		System.out.println("----------------------------------------------------------\n");


		printStack(numStack1);

		System.out.println("Numbers Stack 2 - filled with values from numbers2.txt ");
		System.out.println("----------------------------------------------------------\n");

		printStack(numStack2);

		GenericStack<Integer> mergedNumStack = new GenericStack<>();

		mergeStacks(numStack1,numStack2,mergedNumStack);
		

		System.out.println("Merged Stack, lowest value on top \n---------------------------------------\n");
		
		printStack(mergedNumStack);
		
		File fileStrings1 = new File("mountains1.txt");
		
		Scanner readStrings1 = new Scanner(fileStrings1);
		
		while(readStrings1.hasNext()) {
			String nextLine = readStrings1.nextLine();
			stringsStack1.push(nextLine);

		}
		
		readStrings1.close();
		
		File fileStrings2 = new File("mountains2.txt");
		
		Scanner readStrings2= new Scanner(fileStrings2);

		while(readStrings2.hasNext()) {
			String nextLine = readStrings2.nextLine();
			stringsStack2.push(nextLine);

		}
		
		readStrings2.close();
		
		System.out.println("\n\nString Stack 1 - filled with values from mountains1.txt");
		System.out.println("------------------------------------------------------------------\n");
		
		printStack(stringsStack1);
		
		System.out.println("\n\nString Stack 2 - filled with values from mountains2.txt");
		System.out.println("------------------------------------------------------------------\n");
		
		printStack(stringsStack2);
		
		GenericStack<String> mergedStringStack = new GenericStack<>();
		
		mergeStacks(stringsStack1,stringsStack2,mergedStringStack);
		
		System.out.println("Merged Stack, lowest value on top \n---------------------------------------\n");
		
		printStack(mergedStringStack);

		System.out.println("Printing Merged Stacks side by side - lowest value on top\n");
		System.out.println("------------------------------------------------------------------\n");
		System.out.println("Integers\t\t\tStrings\n");
		System.out.println("------------------------------------------------------------------\n");
		
		GenericStack<Integer>finalNumStack = new GenericStack<>();
		
		GenericStack<String>finalStringStack = new GenericStack<>();
		
		reverseStack(mergedNumStack,finalNumStack);
		
		reverseStack(mergedStringStack,finalStringStack);
		
		printTwoStacks(finalNumStack,finalStringStack);
		
		
	}//main

	public static <E> void printStack(GenericStack<E> someE) {

		//peeking at the top number 
		//Printing/popping out the 1st stack

		final int NUMSTACKSIZE = someE.getSize();

		ArrayList<E>tempElements = new ArrayList<>();

		for(int i = 0; i < NUMSTACKSIZE ; i++ ) {

			E peekedNumber = someE.peek();

			tempElements.add(peekedNumber);

			System.out.println(peekedNumber + "\n");

			someE.pop(peekedNumber);

		}


		//Filling the stack back up
		for(int i = 0 ; i < tempElements.size(); i ++) {
			someE.push(tempElements.get(i));
		}


		

	}//printStack

	public static <E extends Comparable<E>> void mergeStacks(GenericStack<E> stack1 , GenericStack<E> stack2 , GenericStack<E> mergedStack ) {

		boolean noMoreValuesInStack1 = false;
		boolean noMoreValuesInStack2 = false;


		while(noMoreValuesInStack1 == false && noMoreValuesInStack2 == false) {
			E currentTopOfStack1 = stack1.peek();
			E currentTopOfStack2 = stack2.peek();

			if(currentTopOfStack1.compareTo(currentTopOfStack2) > 0) {
				//This means if stack 1's value is greater than stack 2's value 
				E biggerValue = currentTopOfStack1; 
				mergedStack.push(biggerValue);
				stack1.pop(currentTopOfStack1);

			}

			else if(currentTopOfStack1.compareTo(currentTopOfStack2) < 0) {
				//This means if stack 1's value is less than stack 2's value
				E biggerValue = currentTopOfStack2;
				mergedStack.push(biggerValue);
				stack2.pop(currentTopOfStack2);
			}

			else if(currentTopOfStack1.compareTo(currentTopOfStack2) == 0) {
				//This is if stack 1 and stack 2's values are equal
				mergedStack.push(currentTopOfStack1);
				mergedStack.push(currentTopOfStack2);
				stack1.pop(currentTopOfStack1);
				stack2.pop(currentTopOfStack2);

			}

			if(stack1.isEmpty()) {
				noMoreValuesInStack1 = true;

				while(!(stack2.isEmpty()) ) {
					mergedStack.push(stack2.peek());
					stack2.pop(stack2.peek());
				}

			}

			if(stack2.isEmpty()) {
				noMoreValuesInStack2 = true;

				while(!(stack1.isEmpty())) {
					mergedStack.push(stack1.peek());
					stack1.pop(stack1.peek());
					
				}
			}

		}

	}//mergeStack
	
	public static <E> void reverseStack(GenericStack<E>stack1,GenericStack<E>finalMergedStack) {
		
		
		while(!(stack1.isEmpty())) {
			finalMergedStack.push(stack1.peek());
			stack1.pop(stack1.peek());
		}
		
	}
	
	//The following method should print out the two stacks side by side, however, there is an out of bounds exception.
	public static <E,F> void printTwoStacks(GenericStack<E>stack1,GenericStack<F>stack2) {
		
		final int ELEMENT1STACKSIZE = stack1.getSize();
		
		final int ELEMENT2STACKSIZE = stack2.getSize();

		int largerSize = 0;
		
		E topOfStack1 = stack1.peek();
		
		F topOfStack2 = stack2.peek();
		
		if(ELEMENT1STACKSIZE <ELEMENT2STACKSIZE) {
			largerSize = ELEMENT2STACKSIZE;
		}
		else{
			 largerSize = ELEMENT1STACKSIZE;
		}
		
		
		for(int i = 0; i < largerSize ; i++ ) {

			
			E peekedElement = stack1.peek();
			
			F peekedElement2 = stack2.peek();
			
			System.out.print(peekedElement + "\t" + peekedElement2 + "\n\n");

			stack1.pop(peekedElement);
			stack2.pop(peekedElement2);
			

		}
		//Right around here, there will be an index out of bounds exception due to the strings stack index being greater than the stack size at that point.
		
		System.out.println("Number stack top : " + topOfStack1);
		System.out.println("String stack top :" + topOfStack2);
		
	}

}//Assignment

class GenericStack <E>{
	private ArrayList<E> list;

	public GenericStack() {
		this.list = new ArrayList<>();

	}

	public int getSize() {
		return list.size();
	}

	public boolean isEmpty() {
		if(list.size() == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public E peek() {
		E topOfStack = list.get(list.size()-1);
		return topOfStack;
	}

	public void push(E someE) {
		list.add(someE);
	}

	public void pop(E EOnTop) {
		list.remove(EOnTop);
	}


}