package string;
import java.util.Arrays;
import java.util.Scanner;

public class BiggerisGreater {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testNum = in.nextInt();
		in.nextLine();
		while (testNum-- > 0) {
			String string = in.nextLine();
			String nextString = getNextString(string);
			if (nextString == null)
				System.out.println("no answer");
			else
				System.out.println(nextString);
		}
		in.close();
	}

	private static String getNextString(String string) {
		char[] chars = string.toCharArray();
		int peak = -1;
		for (int i = chars.length - 1; i > 0; i--) {
			if (chars[i-1] >= chars[i])
				continue;
			else {
				char c = chars[i-1];
				peak = i;
				for (int j = chars.length - 1; j >= i-1; j--) {
					if (chars[j] > c) {
						swap(chars,j,i-1);
						break;
					}
				}
				break;
			}
		}
		if (peak == -1)
			return null;
		int s = peak;
		int e = chars.length;
		Arrays.sort(chars,s,e);
		//reverse(chars, s, e);
		return new String(chars); // can not use toString() method
	}

	private static void swap(char[] chars, int j, int i) {
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;		
	}
}
