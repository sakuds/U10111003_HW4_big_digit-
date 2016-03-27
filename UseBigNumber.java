
//U10111003 朱永捷

import java.util.Scanner;

public class UseBigNumber {
	public static void main(String[] args){

		// Prompt the user to enter using which one 
		Scanner scanner = new Scanner(System.in);
		System.out.println("Two numbers is: (1)Integer  (2)Float");
		int input = scanner.nextInt();		

		if (input==1) {
			// Prompt the user to enter number
			Scanner scanner2 = new Scanner(System.in);
			System.out.println("Enter first number: ");
			String str1 = scanner2.nextLine();
			System.out.println("Enter second number: ");
			String str2 = scanner2.nextLine();

			// Create BigInteger class
			BigInteger newBigInteger = new BigInteger(str1,str2);

			// Print the result : adding and subtraction
			System.out.println("Adding : ");
			newBigInteger.addInt();
			System.out.println(" ");
			System.out.println("Subtraction : ");
			newBigInteger.subtracInt();

		} else if (input==2) {
			// Prompt the user to enter number
			Scanner scanner2 = new Scanner(System.in);
			System.out.println("Enter first number: ");
			String str1 = scanner2.nextLine();
			System.out.println("Enter second number: ");
			String str2 = scanner2.nextLine();

			// Create BigInteger class
			BigFloat newBigFloat = new BigFloat(str1,str2);

			// Print the result : adding and subtraction
			System.out.println("Adding : ");
			newBigFloat.addFlo();
			System.out.println(" ");
			System.out.println("Subtraction : ");
			newBigFloat.subtracFlo();

		} else {
			System.out.println("Sorry,please enter 1 or 2.");
		}	
	}
}


