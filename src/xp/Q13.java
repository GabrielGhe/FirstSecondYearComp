package xp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Q13 {

	public static void printFactorization(int num) {
		int temp = num;
		ArrayList<Integer> array = new ArrayList<Integer>();
		while (temp != 1) {
			for (int i = 2; i <= temp; i++)
				if (temp % i == 0) {
					array.add(i);
					temp /= i;
					break;
				}
		}
		
		Collections.sort(array);
		System.out.print(num + " = 1x");
		for (int i = 0; i < array.size(); i++) {
			if (i > 0)
				System.out.print("x");
			System.out.print(array.get(i));
		}
	}

	public static void main(String[] args) {
		int num;
		Scanner keyboard = new Scanner(System.in);
		boolean invalid = true;
		System.out.println("Question 13: Primed");
		do {
			try {
				System.out.print("Enter an integer: ");
				num = keyboard.nextInt();
				invalid = false;
				System.out.println("Factorization: ");
				printFactorization(num);
			} catch (InputMismatchException e) {
				System.out.println("Invalid! Input isn't an integer!");
				keyboard.nextLine();
			}
		} while (invalid);
		keyboard.close();
	}

}
