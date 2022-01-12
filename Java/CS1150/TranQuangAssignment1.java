/*
 * Name: Quang Tran
 * 	Class: CS1150
 * Due: Sept 5th, 2019
 * Description: Assignment #1
 * This program demonstrates that I understand basic program structure by printing a couple of paragraphs that tell the instructor what I'm passionate about. It also gives a little practice with arithmetic in Java.
 */
public class TranQuangAssignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* This is the first part of the assignment, displaying outputs with sentences about yourself */

		System.out.println("	My name is Quang Tran, and I am a freshman starting out at UCCS.");
		System.out.println("I am currently majoring in Computer Science, but I'm not quite sure where");
		System.out.println("I'll go in life. Some of my favorite hobbies include playing video games,");	
		System.out.println("cooking, and hanging out with friends. Over the past summer, I mostly");
		System.out.println("worked at my part time job, but I also spend time with many of my friends");
		System.out.println("whom have parted ways after high school. I really do miss many of my friends, ");
		System.out.println("but many of my close friends have continued their education at UCCS, which");
		System.out.println("is nice because I get to go through college with my closest friends.");
		System.out.println();
		System.out.println("	Here are a few fun facts about myself. I was born in Vietnam, but my family");
		System.out.println("moved over to America when I was only two years old. My favorite place to eat at");
		System.out.println("is Chick-Fil-A. I love their chicken sandwiches and the Chick-Fil-A sauce. One of my");
		System.out.println("biggest pet peeves is when people come into my room and leave the door open");
		System.out.println("when they leave. It's pretty annoying to have to remind someone to close the door");
		System.out.println("every single time. If I had to choose a fear, I would say I'm very afraid of public");
		System.out.println("speaking. While most people say I like socializing around, I would say I'm the most");
		System.out.println("comfortable as an introvert. There's just something very calming about peace and quiet.");
		System.out.println();

		/* This is the 2nd part of the assignment, the weight conversion with expressions */

		System.out.println("For 1 pound on Earth,");
		System.out.print("Weight on Moon = ");
		System.out.print("(1 * 1.622) / (9.81) = ");
		System.out.print((1 * 1.622) / (9.81));
		System.out.println(" lbs");
		System.out.print("Weight on Mars =");
		System.out.print("(1 * 3.711) / (9.81) = ");
		System.out.print((1 * 3.711) / (9.81));
		System.out.println(" lbs");
		System.out.print("Weight on Jupiter =");
		System.out.print("(1 * 24.79) / (9.81) = ");
		System.out.print((1 * 24.79) / (9.81) );
		System.out.println(" lbs");
		System.out.println();

		System.out.println("For 10 pounds on Earth,");
		System.out.print("Weight on Moon = ");
		System.out.print("(10 * 1.622) / (9.81) = ");
		System.out.print((10 * 1.622) / (9.81));
		System.out.println(" lbs");
		System.out.print("Weight on Mars =");
		System.out.print("(10 * 3.711) / (9.81) = ");
		System.out.print((10 * 3.711) / (9.81));
		System.out.println(" lbs");
		System.out.print("Weight on Jupiter =");
		System.out.print("(10 * 24.79) / (9.81) = ");
		System.out.print((10 * 24.79) / (9.81) );
		System.out.println(" lbs");
		System.out.println();

		System.out.println("For 100 pounds,");
		System.out.print("Weight on Moon = ");
		System.out.print("(100 * 1.622) / (9.81) = ");
		System.out.print((100 * 1.622) / (9.81));
		System.out.println(" lbs");
		System.out.print("Weight on Mars =");
		System.out.print("(100 * 3.711) / (9.81) = ");
		System.out.print((100 * 3.711) / (9.81));
		System.out.println(" lbs");
		System.out.print("Weight on Jupiter =");
		System.out.print("(100 * 24.79) / (9.81) = ");
		System.out.print((100 * 24.79) / (9.81) );
		System.out.println(" lbs");
		System.out.println();

		System.out.println("For 1000 pounds,");
		System.out.print("Weight on Moon = ");
		System.out.print("(1000 * 1.622) / (9.81) = ");
		System.out.print((1000 * 1.622) / (9.81));
		System.out.println(" lbs");
		System.out.print("Weight on Mars =");
		System.out.print("(1000 * 3.711) / (9.81) = ");
		System.out.print((1000 * 3.711) / (9.81));
		System.out.println(" lbs");
		System.out.print("Weight on Jupiter =");
		System.out.print("(1000 * 24.79) / (9.81) = ");
		System.out.print((1000 * 24.79) / (9.81) );
		System.out.println(" lbs");
		System.out.println();

		/* This is the 3rd part of the assignment, with the table */
		System.out.println("Earth    Moon                 Mars                   Jupiter");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("1       " + (1 * 1.622) / (9.81)  +   "    " +  (1 * 3.711) / (9.81)  +"   " + (1 * 24.79) / (9.81) );
		System.out.println("10      " + (10 * 1.622) / (9.81)  +  "    " +  (10 * 3.711) / (9.81)  +"     " + (10 * 24.79) / (9.81) );
		System.out.println("100     " + (100 * 1.622) / (9.81)  + "     " +  (100 * 3.711) / (9.81)  +"     " + (100 * 24.79) / (9.81) );
		System.out.println("1000    " + (1000 * 1.622) / (9.81)  +"     " +  (1000 * 3.711) / (9.81)  +"     " + (1000 * 24.79) / (9.81) );

	}
}