package string;
import java.util.Scanner;

public class SubstringDiff2 {
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
		int max = 0;
		for (int i = 0; i < p.length(); i++) {
			for (int j = 0; j < q.length(); j++) {
				int diff = s;
				int count = 0;
				int k = 1;
				while (diff > 0) {
					if (!(i + k < p.length() && j + k < q.length()))
						break;
					if (p.charAt(i + k) != q.charAt(j + k)) {
						diff--;
					}
					count++;
					k++;
				}
				while (i + k < p.length() && j + k < q.length()&&p.charAt(i + k) == q.charAt(j + k)) {
					count++;
					k++;
				}
				max = max < count ? count : max;
			}
		}
		return max;
	}

}
