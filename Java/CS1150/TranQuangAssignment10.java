/*
 * Quang Tran
 * CS 1150
 * due 11-14-19
 * Assignment 10
 * Professor Michaela Gonzalez 
 * Learning how to create objects and manipulation of objects, objects in arrays, and objects in objects.
 */
public class TranQuangAssignment10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Test program

		String[] bookTitleArray = {"Data Structures & Algorithms", "The C++ Programming Language", "Don’t Make Me Think", "The Elements of Java Style", "The Design of Everyday Things"};
		String[] authorArray = {"Michael Goodrich" , "Bjarne Stroustrup" , "Steve Krug" , "Jim Shur", "Don Norman"};
		int[] pagesArray = {720,1376,216,144,368 };

		final int MAXNUMBOOKS = 100;	



		//The following Book datatyped array bookArray holds books.	
		Book[] bookArray = new Book[5];

		bookArray[0] = new Book(bookTitleArray[0] , authorArray[0] ,pagesArray[0]);
		bookArray[1] = new Book(bookTitleArray[1] , authorArray[1] ,pagesArray[1]);
		bookArray[2] = new Book(bookTitleArray[2] , authorArray[2] ,pagesArray[2]);
		bookArray[3] = new Book(bookTitleArray[3] , authorArray[3] ,pagesArray[3]);
		bookArray[4] = new Book(bookTitleArray[4] , authorArray[4] ,pagesArray[4]);

		//The following for loop will print each book and it's contents
		System.out.println("------------------------------------------------------\nBooks in array\n");
		System.out.println("------------------------------------------------------");
		System.out.println("Title\t\t\tAuthor\t\t\tPages\n");
		System.out.println("------------------------------------------------------");
		for(int i = 0; i < bookArray.length; i++) {
			String title = bookTitleArray[i];
			String author = authorArray[i];
			int pages = pagesArray[i];
			String space = "\t";

			System.out.println(title + space + author + space + pages);
		}


		System.out.println("------------------------------------------------------\nBook with least number of pages\n");
		System.out.println("------------------------------------------------------");
		//The following for loop will find the book with the least amount of pages

		int index= 0;
		int leastPages = bookArray[0].getPages();

		for(int i = 0 ; i < bookArray.length ; i++) {

			if(bookArray[i].getPages() < leastPages) {
				leastPages = bookArray[i].getPages();
				index = i;



			}

		}

		System.out.println("Title = " + bookArray[index].getTitle());
		System.out.println("Author = " + bookArray[index].getAuthor());

		System.out.println("------------------------------------------------------\nBook with longest title \n");
		System.out.println("------------------------------------------------------");

		//The following for loop will find the book with the longest title
		int index2= 0;
		String longestTitle = "";

		for(int i = 0 ; i < bookArray.length ; i++) {


			if(bookArray[i].getTitle().length() > longestTitle.length()) {

				longestTitle = (bookArray[i].getTitle());

				index2 = i;


			}
		}		

		System.out.println("Title = " + bookArray[index2].getTitle());
		System.out.println("Author = " + bookArray[index2].getAuthor());


		//Now this is the library object 


		System.out.println("------------------------------------------------------\nBooks in library\n");
		System.out.println("------------------------------------------------------");
		System.out.println("Title\t\t\tAuthor\t\t\tPages\n");
		System.out.println("------------------------------------------------------");

		Library library = new Library(5);

		//The following for loop will add books into the library array

		for(int i = 0 ; i < bookArray.length ; i++) {
			library.addBook(bookArray[i]);

		}

		int numBooks = library.getNumBooks();


		//The following for loop will call every single book from the library

		for(int i = 0 ; i < numBooks; i++) {
			library.getBookAtIndex(i);
			System.out.println(library.getBookAtIndex(i).getTitle() + "\t" + library.getBookAtIndex(i).getAuthor()  +"\t"+ library.getBookAtIndex(i).getPages());
		}

		//The following for loop will find the book from the library that has the least amount of pages from the library object.
		int index3= 0;
		int leastPagesInLibrary = library.getBookAtIndex(0).getPages();

		for(int i = 0 ; i < numBooks ; i++) {

			if(library.getBookAtIndex(i).getPages() < leastPagesInLibrary) {
				leastPagesInLibrary = library.getBookAtIndex(i).getPages();
				index3 = i;
			}
		}

		System.out.println("------------------------------------------------------\nBook with least number of pages\n");
		System.out.println("------------------------------------------------------");
		System.out.println("Title = " + library.getBookAtIndex(index3).getTitle());
		System.out.println("Author = " + library.getBookAtIndex(index3).getAuthor());


		System.out.println("------------------------------------------------------\nBook with longest title \n");
		System.out.println("------------------------------------------------------");

		//The following for loop will find the book with the longest title from library this time.
		int index4= 0;
		String longestTitle2 = "";

		for(int i = 0 ; i < numBooks ; i++) {


			if(library.getBookAtIndex(i).getTitle().length() > longestTitle2.length()) {

				longestTitle2 = (library.getBookAtIndex(i).getTitle());

				index4 = i;


			}
		}		

		System.out.println("Title = " + bookArray[index4].getTitle());
		System.out.println("Author = " + bookArray[index4].getAuthor());



	}//main

}//Assignment 10

class Book {

	//These three private data fields must be defined as private
	private String title;
	private String author;
	private int pages;

	public Book(String title, String author, int pages) {
		this.title =title;
		this.author=author;
		this.pages=pages;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getPages() {
		return pages;
	}


}

class Library {


	private Book[] books ;
	private int numBooks ;

	public Library(int maxNumBooks) {
		books = new Book[maxNumBooks];
		numBooks=0;
	}

	public int getNumBooks() {
		return numBooks;
	}

	public Book getBookAtIndex(int index) {
		return books[index];
	}

	public void addBook (Book bookToAdd) {
		books[numBooks]=bookToAdd;
		numBooks++;
	}

}


