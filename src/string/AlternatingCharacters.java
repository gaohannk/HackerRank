package string;

import java.util.Scanner;

public class AlternatingCharacters {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testNum = in.nextInt();
		in.nextLine();
		while (testNum-- > 0) {
			String str = in.nextLine();
			int num = numofDelete(str);
			System.out.println(num);
		}
		in.close();
	}

	private static int numofDelete(String str) {
		int count=0;
		for (int i = 1; i < str.length(); i++) {
			if(str.charAt(i)==str.charAt(i-1))
				count++;
		}
		return count;
	}
}
