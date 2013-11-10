package xp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Q11 {

	public static void main(String[] args) {
		int num;
		Scanner keyboard = new Scanner(System.in);
		boolean invalid = true;
		System.out.println("Question 11: Binary");
		do {
			try {
				System.out.print("Enter an integer: ");
				num = keyboard.nextInt();
				invalid = false;
				System.out.println("Binary: " + Integer.toBinaryString(num));
			} catch (InputMismatchException e) {
				System.out.println("Invalid! Input isn't an integer!");
				keyboard.nextLine();
			}
		} while (invalid);
		keyboard.close();
	}

}
