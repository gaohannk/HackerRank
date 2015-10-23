package string;
import java.util.Scanner;

public class MorganandaString {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testNum = in.nextInt();
		in.nextLine();
		while (testNum-- > 0) {
			String a = in.nextLine();
			String b = in.nextLine();
			String res = SmallestString(a, b);
			System.out.println(res);
		}
		in.close();
	}

	private static String SmallestString(String a, String b) {
		// Stack<Character> stack_a =new Stack<Character>();
		// Stack<Character> stack_b =new Stack<Character>();
		StringBuffer sb = new StringBuffer();
		int i = 0, j = 0;
		while (i < a.length() && j < b.length()) {
			if (a.charAt(i) < b.charAt(j)) {
				sb.append(a.charAt(i));
				i++;
			} else if (a.charAt(i) > b.charAt(j)) {
				sb.append(b.charAt(j));
				j++;
			} else {
				int m = i;
				int n = j;
				while (m < a.length() && n < b.length() && a.charAt(m) == b.charAt(n)) {
					m++;
					n++;
				}	    
				if (m < a.length() && n < b.length()){
					if (a.charAt(m) < b.charAt(n)) {
						sb.append(a.charAt(i));
						i++;
					} else {
						sb.append(b.charAt(i));
						j++;
					}
				}else {
					sb.append(a.charAt(i));
					i++;
				}
			}
		}
		if (i == a.length()) {
			sb.append(b.substring(j));
		} else if (j == b.length()) {
			sb.append(a.substring(i));
		}
		return sb.toString();
	}
}
