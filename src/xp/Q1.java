package xp;

import java.util.Scanner;

public class Q1 {
	public static boolean isPalindrome(String str) {
		for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
			char a = str.charAt(i);
			char b = str.charAt(j);
			if (!(Character.isLowerCase(a) || Character.isUpperCase(a))) {
				j++;
				continue;
			}
			if (!(Character.isLowerCase(b) || Character.isUpperCase(b))) {
				i--;
				continue;
			}
			String aStr = "" + a;
			String bStr = "" + b;

			if (!aStr.equalsIgnoreCase(bStr))
				return false;

		}
		return true;
	}

	public static void main(String[] args) {

		System.out.println("Question 1: Palindrome: ");
		String str = "Mr. Owl ate my metal worm";
		System.out.println("Str: " + str);
		System.out.println("Is a palindrome? " + isPalindrome(str));

		System.out.print("\nEnter palindrome string: ");
		Scanner keyboard = new Scanner(System.in);
		String str2 = keyboard.nextLine();
		System.out.println("Your String: " + str2);
		System.out.println("Is a palindrome? " + isPalindrome(str2));
		keyboard.close();

	}
}
