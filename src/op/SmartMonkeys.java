package op;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class SmartMonkeys {
	private static final boolean DEBUG = false;
	private static final String FILE_NAME = "testScarlet.txt";

	/**
	 * Monkey1
	 * 
	 * @param text
	 * @return
	 */
	private static String monkey1(String text) {
		String monkeyText = "";
		if (DEBUG)
			System.out.println("Text length: " + text.length());
		ArrayList<String> characters = new ArrayList<String>();
		if (DEBUG)
			System.out.println("Going through each character.");
		for (int i = 0; i < text.length(); i++) {
			String key = "" + text.charAt(i);
			characters.add(key);
		}
		if (DEBUG)
			System.out
					.println("Randomizing characters. Characters to go through: "
							+ characters.size());
		while (!characters.isEmpty()) {
			int index = (int) (Math.random() * characters.size());
			if (DEBUG)
				if (characters.size() % 100 == 0)
					System.out.println("Progress: " + characters.size());
			monkeyText += characters.remove(index);
		}
		return monkeyText;
	}

	/**
	 * MonkeyTwo
	 * 
	 * @param text
	 * @return
	 */
	private static String monkey2(String text) {
		String monkeyText = "";
		ArrayList<String> characters = new ArrayList<String>();
		Map<String, Letter> map = new HashMap<String, Letter>();

		if (DEBUG)
			System.out.println("Text length: " + text.length());
		if (DEBUG)
			System.out.println("Going through each character.");

		for (int i = 0; i < text.length(); i++) {
			String key = "" + text.charAt(i);
			characters.add(key);

			// if it contains the letter
			if (map.containsKey(key)) {
				Letter letter = (Letter) map.get(key); // get the object

				// add after letter
				if (i < text.length() - 1)
					letter.addAfter("" + text.charAt(i + 1));

			} else {
				Letter letter = new Letter();

				// add after letter
				if (i < text.length() - 1)
					letter.addAfter("" + text.charAt(i + 1));
				map.put(key, letter);
			}
		}
		if (DEBUG)
			System.out
					.println("Randomizing characters. Characters to go through: "
							+ characters.size());

		// create monkey text
		while (!characters.isEmpty()) {
			int index = (int) (Math.random() * characters.size());
			if (DEBUG)
				if (characters.size() % 100 == 0)
					System.out.println("Progress: " + characters.size());
			String temp = characters.remove(index);
			Letter letter = map.get(temp);
			monkeyText += letter.get();
		}
		return monkeyText;
	}

	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Smart Monkeys Optimization");
		String monkeyText = null;
		String fileName;
		int monkeyN = 0;
		int length = 0;
		boolean invalid = true;
		String file = null;
		Scanner keyboard = new Scanner(System.in);
		do {
			try {
				System.out
						.print("Enter the file name to read, or enter D for default: ");
				fileName = keyboard.nextLine();
				if (fileName.equalsIgnoreCase("d"))
					fileName = FILE_NAME;
				if (DEBUG)
					System.out.println("Reading file: ");
				file = readFile(FILE_NAME);
				invalid = false;
			} catch (Exception e) {
				System.out.println("File not found!");
				keyboard.nextLine();
			}
		} while (invalid);
		invalid = true;
		do {
			try {
				System.out
						.print("Enter the Nth monkey to use (1, or 2 only): ");
				monkeyN = keyboard.nextInt();
				if (monkeyN == 1 || monkeyN == 2)
					invalid = false;
				else
					System.out.println("Enter 1 or 2!");
			} catch (InputMismatchException ime) {
				System.out.println("You did not enter an integer!");
				keyboard.nextLine();
			}
		} while (invalid);
		invalid = true;
		do {
			try {
				System.out.print("Enter the number of characters to display: ");
				length = keyboard.nextInt();
				invalid = false;
			} catch (InputMismatchException ime) {
				System.out.println("You did not enter an integer!");
				keyboard.nextLine();
			}
		} while (invalid);

		int realLength = Math.min(file.length(), length);
		switch (monkeyN) {
		case 1:
			System.out.println("Getting Monkey1 text: ");
			monkeyText = monkey1(file);
			if (DEBUG)
				System.out.println("Printing Monkey1 text: ");
			System.out.println(monkeyText.substring(0, realLength - 1));
			break;
		case 2:
			System.out.println("Getting Monkey2 text: ");
			monkeyText = monkey2(file);
			if (DEBUG)
				System.out.println("Printing Monkey2 text: ");
			System.out.println(monkeyText.substring(0, realLength - 1));
			break;
		}
		if (keyboard != null)
			keyboard.close();
	}

	private static String readFile(String filename) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filename));
			String line = null;
			String text = "";
			while ((line = reader.readLine()) != null) {
				text += line + "\n";
			}
			reader.close();
			return text;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			if (reader != null)
				e.printStackTrace();
		}
		if (reader != null)
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return null;
	}
}
