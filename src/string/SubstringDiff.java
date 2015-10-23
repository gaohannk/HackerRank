package string;
import java.util.Scanner;
/*
 * Substring Diff
Given two strings of length n, P = p1p2...pn and Q = q1q2...qn, we define M(i,j,k) as the number of mismatches between p(i),p(i+1),...p(i+k−1) and q(j),q(j+1)...,q(j+k−1). That is, in set notation, M(i,j,k) refers to the size of the set
{0 <= x < k, p[i+x]| ≠ q[j+x]}
Given an integer S, your task is to find the maximum length L, such that there exists a pair of indices (i,j) for which we have M(i,j,L)≤S. Of course, we should also have i+L−1≤n and j+L−1≤n.
Input Format
The first line of input contains a single integer, T, the number of test cases follow. 
Each test case consists of an integer, S, and two strings, P and Q, separated by a single space.
Constraints 
1≤T≤10 
0≤S≤ length of P 
P and Q has the same length, their length not exceeding 1500. All characters in P and Q are lower-case English letters.
Output Format
For each test case, output a single integer, L, which is the maximum value for which there exists a pair of indices (i,j) such that M(i,j,L)≤S.
Sample Input
3
2 tabriz torino
0 abacba abcaba
3 helloworld yellomarin
Sample Output
4
3
8
Explanation
First test case: If we take "briz" from the first string, and "orin" from the second string, then the number of mismatches between these two substrings is equal to 2, and the length of these substrings are 4. Hence we have chosen i=3, j=2, L=4, and we have M(3,2,4) = 2.
Second test case: Since S=0, we should find the longest common substring for the given input strings. We can choose "aba" as the result, and we don't have longer common substring between two strings. So, the answer is 3 for this test-case. That's we have chosen i=1, j=4, and L=3, and we have M(1,4,3)=0.
Third test case: We can choose "hellowor" from first string and "yellomar" from the second string. So, we have chosen i=1, j=1, and L=8, and we have M(1,1,8)=3. Of course we can also choose i=2, j=2, and L=8 and we still have M(2,2,8)=3.
 */
//TLE O(n^3)
public class SubstringDiff {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testNum = in.nextInt();
		in.nextLine();
		while (testNum-- > 0) {
			String str = in.nextLine();
			String[] strs = str.split(" ");
			int S = Integer.parseInt(strs[0]);
			String P = strs[1];
			String Q = strs[2];
			int res = maxL(S, P, Q);
			System.out.println(res);
		}
		in.close();
	}

	private static int maxL(int s, String p, String q) {
		for (int L = p.length(); L >= 0; L--) {
			for (int i = 0; i <= p.length() - L; i++) {
				for (int j = 0; j <= q.length() - L; j++) {
					if (getNumofMismatch(i, j, L, p, q) <= s)
						return L;
				}
			}
		}
		return 0;
	}

	private static int getNumofMismatch(int startp, int startq, int L, String p, String q) {
		int count = 0;
		for (int i = 0; i < L; i++) {
			if (p.charAt(startp + i) != q.charAt(startq + i))
				count++;
		}
		return count;
	}
}
