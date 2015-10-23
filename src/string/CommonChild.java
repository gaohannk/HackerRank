package string;
import java.util.Scanner;

/*Given two strings a and b of equal length, what's the longest string (S) that can be constructed such that it is a child of both? 
A string x is said to be a child of a string y if x can be formed by deleting 0 or more characters from y. 
For example, ‘‘abcd" and ‘‘abdc" has two children with maximum length 3, ‘‘abc" and ‘‘abd". Note that we will not consider ‘‘abcd" as a common child because ′c′ doesn't occur before ′d′ in the second string.
Input format
Two strings, a and b, with a newline separating them.
Constraints
All characters are upper cased and lie between ASCII values 65-90. The maximum length of the strings is 5000.
Output format
Length of string S.
Sample Input #0
HARRY
SALLY
Sample Output #0
2
The longest possible subset of characters that is possible by deleting zero or more characters from HARRY and SALLY is AY, whose length is 2.
Sample Input #1
AA
BB
Sample Output #1
0
AA and BB has no characters in common and hence the output is 0.
Sample Input #2
SHINCHAN
NOHARAAA
Sample Output #2
3
The largest set of characters, in order, between SHINCHAN and NOHARAAA is NHA.
Sample Input #3
ABCDEF
FBDAMN
Sample Output #3
2
BD is the longest child of these strings.
*/
public class CommonChild {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.nextLine();
		String b=in.nextLine();
			int res = LongestCommonSubSequence(a, b);
			System.out.println(res);
		in.close();
	}

	private static int LongestCommonSubSequence(String a, String b) {
		int[][] dp=new int[a.length()][b.length()];
		int max=0;
	    if(a.charAt(0)==b.charAt(0))
	    	dp[0][0]=1;
	    dp[0][1]=a.charAt(0)==b.charAt(1)?1:dp[0][0];
	    dp[1][0]=a.charAt(1)==b.charAt(0)?1:dp[0][0];

	    for(int i=1;i<a.length();i++){
	    	for(int j=1;j<b.length();j++){
	    		dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
	    		int curSame=a.charAt(i)==b.charAt(j)?1:0;  			
	    		dp[i][j]=Math.max(dp[i][j], dp[i-1][j-1]+curSame);
	    		max=max<dp[i][j]?dp[i][j]:max;
	    	}
	    }
		return max;
	}

}
