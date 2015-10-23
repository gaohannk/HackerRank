package string;

import java.util.HashSet;
import java.util.Scanner;

/* Given a sentence s, tell if it is a pangram or not.
 * Pangrams are sentences constructed by using every letter of the alphabet at least once.
 * Input Format Input consists of a line containing s.
 * Constraints 
 * Length of s can be at most 103 (1≤|s|≤103) and it may contain spaces, lower case and upper case letters. Lower case and upper case instances of a letter are considered the same.
 * Output Format Output a line containing pangram if s is a pangram, otherwise output not pangram.
 */
public class Pangrams {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String string = in.nextLine();
		boolean res = isPangrams(string);
		//System.out.println((int));
		System.out.println(res==true?"pangram":"not pangram");
		in.close();
	}

	private static boolean isPangrams(String str) {
		HashSet<Character> set = new HashSet<>();
		str = str.toLowerCase();
		for (int i = 0; i < str.length(); i++) {
			if (!set.contains(str.charAt(i))&&str.charAt(i)!=' ')
				set.add(str.charAt(i));
		}
		return set.size() == 26;
	}
}
