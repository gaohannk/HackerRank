package string;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Problem Statement
 Given a string S, find the number of unordered anagramic pairs of substrings.
 Input Format
 First line contains T, the number of testcases. Each testcase consists of string S in one line.
 Constraints 
 1≤T≤10 
 2≤length(S)≤100 
 String S contains only the lowercase letters of the English alphabet.
 Output Format
 For each testcase, print the required answer in one line.
 Sample Input
 2
 abba
 abcd
 Sample Output
 4
 0
 Explanation
 Let's say S[i,j] denotes the substring Si,Si+1,⋯,Sj.
 testcase 1: 
 For S=abba, anagramic pairs are: {S[1,1],S[4,4]}, {S[1,2],S[3,4]}, {S[2,2],S[3,3]} and {S[1,3],S[2,4]}.
 testcase 2: 
 No anagramic pairs.
 */
public class SherlockandAnagrams {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testNum = in.nextInt();
		in.nextLine();
		while (testNum-- > 0) {
			String string = in.nextLine();
			int num = numofPairs(string);
			System.out.println(num);
		}
		in.close();
	}

	private static int numofPairs(String string) {
		int count = 0;
		for (int i = 1; i <= string.length(); i++) {
			for (int j = 0; j <= string.length() - i; j++) {
				String str = string.substring(j, j + i);
				for (int k = j + 1; k <= string.length() - i; k++) {
					if (isAnagram(string.substring(k, k + i), str)) {
						count++;
					}
				}
			}
		}
		return count;
	}

	private static boolean isAnagram(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		if (new String(c1).equals(new String(c2)))
			return true;
		return false;
	}
}
