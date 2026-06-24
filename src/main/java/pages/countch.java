package pages;

public class countch {
	public static void main(String[] args) {

		String str = "Hello World JAVA";

		int upperCount = 0;
		int lowerCount = 0;

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			if (Character.isUpperCase(ch)) {
				upperCount++;
			} else if (Character.isLowerCase(ch)) {
				lowerCount++;
			}
		}

		System.out.println("Uppercase letters: " + upperCount);
		System.out.println("Lowercase letters: " + lowerCount);
	}
}
