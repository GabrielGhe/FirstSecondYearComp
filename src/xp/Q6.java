package xp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Q6 {
	public static void main(String[] args) {
		int num;
		Scanner keyboard = new Scanner(System.in);
		boolean invalid = true;
		System.out.println("Question 6: Sum");
		do {
			try {
				System.out.print("Enter an integer: ");
				num = keyboard.nextInt();
				invalid = false;
				int temp, sum = 0;
				while (num != 0) {
					temp = num % 10;
					sum += temp;
					num /= 10;
				}
				System.out.println("Sum of digits: " + sum);
			} catch (InputMismatchException e) {
				System.out.println("Invalid! Input isn't an integer!");
				keyboard.nextLine();
			}
		} while (invalid);
		keyboard.close();
	}
}
