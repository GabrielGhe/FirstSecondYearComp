package xp;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q8 {

	public static void duped(int[] array) {
		Set<Integer> set = new HashSet<Integer>();
		boolean noDuplicates = true;
		for (int i = 0; i < array.length; i++)
			if (!set.add(array[i])) {
				System.out.println("duplicate");
				noDuplicates = false;
				break;
			}
		if (noDuplicates)
			System.out.println("no duplicates");
	}

	public static void main(String[] args) {
		System.out.println("Question 8: Duped");

		Scanner keyboard = new Scanner(System.in);
		boolean invalid = true;
		String inputStr;
		do {
			System.out.print("Enter integers separated by commas: ");
			inputStr = keyboard.nextLine();
			String[] strArray = inputStr.split(",");
			int[] array = new int[strArray.length];
			try {
				for (int i = 0; i < strArray.length; i++) {
					array[i] = Integer.parseInt(strArray[i]);
				}
				invalid = false;
				System.out.println("Array of integers: ");
				for (int a : array)
					System.out.print(a + " ");
				System.out.println("\nResult:");
				duped(array);
			} catch (NumberFormatException e) {
				System.out
						.println("Invalid input! You did not give integers seperated by commas!");
			}
		} while (invalid);
		keyboard.close();
	}
}
