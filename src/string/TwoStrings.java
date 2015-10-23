package string;
import java.util.Scanner;
/* Problem Statement
You are given two strings, A and B. Find if there is a substring that appears in both A and B.
Input Format
Several test cases will be given to you in a single file. The first line of the input will contain a single integer T, the number of test cases.
Then there will be T descriptions of the test cases. Each description contains two lines. The first line contains the string A and the second line contains the string B.
Output Format
For each test case, display YES (in a newline), if there is a common substring. Otherwise, display NO.
Constraints
All the strings contain only lowercase Latin letters.
1<=T<=10
1<=|A|,|B|<=105
 */
//TLE

public class TwoStrings {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testNum = in.nextInt();
		in.nextLine();
		while (testNum-- > 0) {
			String a = in.nextLine();
			String b = in.nextLine();
			if (hasCommonSubstring(a, b))
				System.out.println("YES");
			else
				System.out.println("No");

		}
		in.close();
	}

	private static boolean hasCommonSubstring(String a, String b) {
		for (int i = 1; i < a.length(); i++) {
			for (int j = 0; j <= a.length() - i; j++) {
				if (b.indexOf(a.substring(j, j + i)) != -1)
					return true;
			}
		}
		return false;
	}
}
