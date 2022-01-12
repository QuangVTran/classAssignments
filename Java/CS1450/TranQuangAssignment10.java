/*
 * Quang Tran
 * Assignment 9 
 * CS 1450
 * Due April 29th-2020
 * 
 * Description: This assignment will consist of creating a binary tree with nodes and abstract data types. By creating our own Binary Tree class, it will have all the functions that 
 * the java ADT contains, such as insertions, deletions, and traversing through leveled ordering.
 * 
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;

public class TranQuangAssignment10 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Initializing the binary tree object
		BinaryTree myBinaryTree = new BinaryTree();
		
		//Reading from the file
		File parrotFile = new File("parrots.txt");
		
		Scanner readFile = new Scanner(parrotFile);
		
		//Initializing a new parrot obj each time it reads a line from the file
		while(readFile.hasNext()) {
			int id = readFile.nextInt();
			String name = readFile.next();
			String songWord = readFile.next();
			
			Parrot newParrot = new Parrot(id,name,songWord);
			
			myBinaryTree.insert(newParrot);
		}
		
		readFile.close();
		
		myBinaryTree.levelOrder();
		
		
		
		
	}//main

}

class Parrot {
	private int id;
	private String name;
	private String songWord;
	
	public Parrot(int id, String name, String songWord) {
		this.id = id;
		this.name = name;
		this.songWord = songWord;
	}
		
	public String getName() {
		return name;
	}
	
	public String sing() {
		return songWord;
	}
	
	//As usual, using compare to to return a positive integer if it's bigger, negative if smaller, and 0 if equal
	public int compareTo(Parrot otherParrot) {
		if(this.id > otherParrot.id) {
			return 1;
		}
		else if(this.id < otherParrot.id) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
}

class BinaryTree{
	private TreeNode root;
	
	public BinaryTree() {
		this.root = null;
	}
	
	public boolean insert(Parrot parrotToAdd) {

		//If the current pointer is null, create a node at that point, and make it the root
		if(root == null) {
			root = new TreeNode(parrotToAdd);
		}
		//Else, traverse the binary tree down until it reaches an empty node, and places it on the left or right depending if the value of the current node is greater or lesser than the current parent node.
		else{
			TreeNode parent = null;
			TreeNode current = root;
			
			while(current != null) {
				
				if(parrotToAdd.compareTo(current.parrot) < 0) {
					parent = current;
					current = current.left;
				}
				
				else if(parrotToAdd.compareTo(current.parrot) > 0) {
					parent = current;
					current = current.right;
				}
				
				else {
					return false;
				}
				
			}
			
			if(parrotToAdd.compareTo(parent.parrot) < 0) {
				parent.left = new TreeNode(parrotToAdd);
			}
			
			else {
				parent.right = new TreeNode(parrotToAdd);
			}
			
			
		}
		
		return true;
		
	}//insert
	
	public void levelOrder() {
		
		if (root != null) {
			Queue<TreeNode> aQueue = new LinkedList<>();
			aQueue.add(root);
			
			System.out.println("Now printing out the queue of song words:\n");
			
			while(aQueue.isEmpty() != true) {
				TreeNode tempNode = aQueue.remove();
				
				String songWord = tempNode.parrot.sing();
				
				System.out.print(songWord + " ");
				
				if(tempNode.left != null) {
					aQueue.add(tempNode.left);
				}
				
				if(tempNode.right != null) {
					aQueue.add(tempNode.right);
				}
				
				
			}//while

			
		}//if
		System.out.println("\n\nNow printing out the names of parrots: \n");
		visitLeaf(root);
		
	}//levelOrder
	
	//The following visitLeaf method utilizes recursive methods
	private void visitLeaf(TreeNode aNode) {
		if(aNode==null)
			return;
 
		if(aNode.left == null && aNode.right == null) {
			System.out.printf("%s \n",aNode.parrot.getName());
		}
		visitLeaf(aNode.left);
		visitLeaf(aNode.right);
	}
	
	private static class TreeNode{
		private Parrot parrot;
		private TreeNode left;
		private TreeNode right;
		
		public TreeNode(Parrot parrot) {
			this.parrot = parrot;
			this.left = null;
			this.right = null;
		}
		
	}
	
}