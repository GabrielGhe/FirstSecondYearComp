package xp;

import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Q10 {

	public static void displayCalendar(int year) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, 0, 1);
		String[] months = { "January", "February", "March", "April", "May",
				"June", "July", "August", "September", "October", "November",
				"December" };

		String[] days = { "", "Su", "Mo", "Tu", "We", "Th", "Fr", "Sa" };

		int x = 11 - months[0].length() / 2;

		for (int i = 0; i < 12; i++) {
			// display month
			for (int j = 0; j < x; j++)
				System.out.print(" ");
			System.out.println(months[i]);

			// display days
			for (String day : days)
				System.out.print(day + " ");
			System.out.println();

			int index = 1;
			while (cal.get(Calendar.MONTH) == i) {
				if (cal.get(Calendar.DAY_OF_WEEK) == index) {
					System.out.printf("%3d", cal.get(Calendar.DAY_OF_MONTH));
					index++;
					cal.add(Calendar.DAY_OF_MONTH, 1);
				} else {
					System.out.print("   ");
					index++;
				}
				if (index == 8) {
					System.out.println();
					index = 1;
				}
			}
			System.out.println("\n");
		}
	}

	public static void main(String[] args) {
		int year;
		Scanner keyboard = new Scanner(System.in);
		boolean invalid = true;
		System.out.println("Question 10: Calendar");
		do {
			try {
				System.out.print("Enter a year (integer): ");
				year = keyboard.nextInt();
				invalid = false;
				displayCalendar(year);
			} catch (InputMismatchException e) {
				System.out.println("Invalid! Input isn't an integer!");
				keyboard.nextLine();
			}
		} while (invalid);
		keyboard.close();
	}
}
