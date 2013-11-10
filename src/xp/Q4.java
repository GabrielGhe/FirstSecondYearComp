package xp;

public class Q4 {
	public static void main(String[] args) {

		System.out.println("Question 4: Concordia");

		for (int i = 1; i < 101; i++) {
			boolean printI = true;
			if (i % 3 == 0) {
				System.out.print("Con");
				printI = false;
			}
			if (i % 5 == 0) {
				System.out.print("cordia");
				printI = false;
			}
			if (printI)
				System.out.print(i);
			System.out.println();
		}
	}
}
