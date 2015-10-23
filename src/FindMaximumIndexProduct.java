import java.util.Scanner;
/*Problem Statement
You are given a list of n numbers a1,a2,…,an. For each i (1≤i≤n), define LEFT(i) to be the nearest index j before i such that aj>ai. Note that if j does not exist, we should consider LEFT(i) to be 0. Similarly, define RIGHT(i) to be the nearest index j after i such that aj>ai. Note that if j does not exist, we should consider RIGHT(i) to be 0.
Define INDEXPRODUCT(i) as the product of LEFT(i) and RIGHT(i). Find the maximum INDEXPRODUCT(i) among all 1≤i≤n.
Input Format
The first line contains an integer n, the number of integers. The next line contains the N integers.
Constraints:
1≤N≤105
Each of the N integers will range from 0 to 109
Output Format
Output the maximum INDEXPRODUCT among all indices from 1 to N.
Sample Input
5
5 4 3 4 5
Sample Output
8
Explanation
We can compute the following:
INDEXPRODUCT(1)=0 
INDEXPRODUCT(2)=1×5=5 
INDEXPRODUCT(3)=2×4=8 
INDEXPRODUCT(4)=1×5=5 
INDEXPRODUCT(5)=0
The largest of these is 8, so it is the answer.
*/
public class FindMaximumIndexProduct {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int len = in.nextInt();
		int[] num = new int[len];
		for (int i = 0; i < len; i++)
			num[i] = in.nextInt();
		int max = 0;
		for (int i = 0; i < len; i++) {
			if (max < getIndexProduct(i, num))
				max = getIndexProduct(i, num);
		}
		System.out.println(max);
		in.close();
	}

	private static int getIndexProduct(int i, int[] num) {
		return getLeft(i, num) * getRight(i, num);
	}

	private static int getRight(int index, int[] num) {
		for (int i = index + 1; i < num.length; i++) {
			if (num[i] > num[index])
				return i + 1;
		}
		return 0;

	}

	private static int getLeft(int index, int[] num) {
		for (int i = index - 1; i >= 0; i--) {
			if (num[i] > num[index])
				return i + 1;
		}
		return 0;
	}
}
