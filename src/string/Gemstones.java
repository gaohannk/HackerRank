package string;
import java.util.HashSet;
import java.util.Scanner;

public class Gemstones {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testNum = in.nextInt();
		in.nextLine();
		
		String[] string = new String[testNum];
		int i = 0;
		while (testNum-- > 0) {
			string[i++] = in.nextLine();
		}
		int num = numofCommonChar(string);
		System.out.println(num);
		in.close();
	}

	private static int numofCommonChar(String[] string) {
		int count = 0;
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < string[0].length(); i++) {
			char c = string[0].charAt(i);
			if (!set.contains(c)) {
				set.add(c);
				boolean exist = true;
				for (int j = 1; j < string.length; j++) {
					if (string[j].indexOf(c) == -1) {
						exist = false;
						break;
					}
				}
				if (exist)
					count++;
			}
		}
		return count;
	}
}
