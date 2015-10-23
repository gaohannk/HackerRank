package string;

import java.util.Scanner;

/* Figure out whether any anagram of the string can be a palindrome or not.
 * Input Format 
 * A single line which contains the input string.
 * Constraints 
 * 1≤ length of string ≤105 
 * Each character of the string is a lowercase English letter.
 * Output Format 
 * A single line which contains YES or NO in uppercase.
 */
public class GameofThronesI {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String string = in.nextLine();
		boolean res = canformPalindrome(string);
		System.out.println(res == true ? "YES" : "NO");
		in.close();
	}

	private static boolean canformPalindrome(String string) {
		int[] letter = new int[26];
		for (int i = 0; i < string.length(); i++) {
			letter[string.charAt(i) - 97]++;
		}
		int count = 0;
		for (int i = 0; i < letter.length; i++) {
			if (letter[i] % 2 == 1)
				count++;
			if (count > 2)
				return false;
		}
		return true;
	}
}
