package xp;

public class Q14 {

	public static void goingTheDistance(String str1, String str2) {
		String commonStr;
		int indexOfCommonStr;

		for (int i = str2.length(); i > 0; i--)
			for (int j = 0; i < str2.length(); j++) {
				commonStr = str2.substring(j, i);
				indexOfCommonStr = str1.indexOf(commonStr);
				if (indexOfCommonStr != -1) {
					System.out.println("Found common string: " + commonStr);
					for (int z = 0; z < j; z++)
						str1 = removeFrontChar(str1);
					for (int z = str2.length(); z > i; z--)
						str1 = removeBackChar(str1);
					for (int z = j; z > 0; z--)
						str1 = replaceCharAtIndex(str1, str2.charAt(z), 0);
					for (int z = (str2.length() - i); z > 0; z--)
						str1 = replaceCharAtIndex(str1, str2.charAt(z),
								str1.length() - 1);
				}
			}
	}

	private static String replaceCharAtIndex(String str, char c, int index) {
		String newStr = "";
		if (index != 0)
			newStr = str.substring(0, index);

		newStr += c;
		if (index != newStr.length() - 1)
			newStr += str.substring(index + 1, str.length() - 1);
		return newStr;
	}

	private static String removeFrontChar(String str) {
		return str.substring(1);
	}

	private static String removeBackChar(String str) {
		return str.substring(0, str.length() - 2);
	}

	public static void main(String[] args) {
		goingTheDistance("Moosee", "Goose");
	}

}
