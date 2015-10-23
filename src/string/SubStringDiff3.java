package string;
import java.util.Scanner;

public class SubStringDiff3 {
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
		int L = 0;
		for (int gap = 0; gap < p.length(); gap++) {
			L = Math.max(L, searchString(s, p, q, gap));
			L = Math.max(L, searchString(s, q, p, gap));
		}
		return L;
	}

	private static int searchString(int s, String p, String q, int gap) {
		int front = 0;
		int back = 0;
		int mismatch = 0;
		int L = 0;
		while (true) {
			while (mismatch < s) {
				if (p.charAt(front) != q.charAt(front + gap)) {
					mismatch++;
					front++;
				} else {
					front++;
				}
				if (front + gap >= q.length())
					break;
			}
			L = front - back > L ? front - back : L;
			if (front + gap >= q.length())
				break;
			while (p.charAt(front) == q.charAt(front + gap)) {
				front++;
				if (front + gap >= q.length())
					break;
			}
			L = front - back > L ? front - back : L;
			if (front + gap >= q.length())
				break;
			while (mismatch >= s) {
				if (p.charAt(back) != q.charAt(back + gap)) {
					mismatch--;
					back++;
				} else {
					back++;
				}
			}
		}
		return L;
	}
}
