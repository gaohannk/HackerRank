package string;
import java.util.Scanner;

public class PalindromeIndex {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testNum = in.nextInt();
		in.nextLine();
		while (testNum-- > 0) {
			String string = in.nextLine();
			int index = getPalindromeIndex(string);
			System.out.println(index);
		}
		in.close();
	}

	private static int getPalindromeIndex(String str) {
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				if (str.charAt(i + 1) == str.charAt(str.length() - 1 - i)) {
					if (str.charAt(i + 2) == str.charAt(str.length() - 2 - i))
						return i;
					else
						return str.length() - 1 - i;
				} else
					return str.length() - 1 - i;
			}
		}
		return -1;
	}
}
