package string;
/*Problem Statement
You are given two integers, N and M. Count the number of strings of length N under the alphabet set of size M that doesn't contain any palindromic string of the length greater than 1 as a consecutive substring.
Input Format
Several test cases will be given to you in a single file. The first line of the input will contain a single integer, T, the number of test cases.
Then there will be T lines, each containing two space-separated integers, N and M, denoting a single test case. The meanings of N and M are described in the Problem Statement above.
Output Format
For each test case, output a single integer - the answer to the corresponding test case. This number can be huge, so output it modulo 109+7.
Constraints
1≤T≤105
1≤N,M≤109
Sample Input
2
2 2
2 3
Sample Output
2
6
Explanation
For the 1st testcase, we have an alphabet of size M = 2. For the sake of simplicity, let's consider the alphabet as [A, B]. We can construct four strings of size N = 2 using these letters.
AA
AB
BA
BB
Out of these, we have two strings, AB and BA, that satisfy the condition of not having a palindromic string of length greater than 1. Hence, the answer 2.
For the 2nd test case, we have an alphabet of size M = 3. For the sake of simplicity, let's consider the alphabet as [A, B, C]. We can construct nine strings of size N = 2 using these letters.
AA
AB
AC
BA
BB
BC
CA
CB
CC
Save AA, BB, and CC, all the strings satisfy the given condition; hence, the answer 6.
*/
import java.util.LinkedList;
import java.util.Scanner;
//TLE
public class AntiPalindromicStrings {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testNum = in.nextInt();
		in.nextLine();
		while (testNum-- > 0) {
			int len = in.nextInt();
			int size = in.nextInt();
			int res = numofString(len, size);
			System.out.println(res);
		}
		in.close();
	}

	private static int numofString(int len, int size) {
		StringBuffer sb = new StringBuffer();
		LinkedList<String> res = new LinkedList<String>();
		constructorString(len, size, sb, res);
		return res.size();
	}

	private static boolean existPalindrominSubString(String str) {
		for (int i = 0; i < str.length(); i++) {
            if(isPalindrom(str.substring(i)))
            	return true;
		}
		return false;
	}

	private static boolean isPalindrom(String str) {
		if (str.length() == 1)
			return false;
		for(int i=0;i<str.length()/2;i++){
			if(str.charAt(i)!=str.charAt(str.length()-1-i))
				return false;
		}
		
		return true;
	}

	private static void constructorString(int len, int size, StringBuffer sb, LinkedList<String> res) {
		if (len == 0) {
			res.add(sb.toString());
			return;
		}
		for (int i = 0; i < size; i++) {
			sb.append((char) (i + 'a'));
			if (!existPalindrominSubString(sb.toString()))
				constructorString(len - 1, size, sb, res);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
