package string;
import java.util.HashMap;
import java.util.Scanner;

public class MakeitAnagram {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.nextLine();
		String b = in.nextLine();
		int num = numofLetterNeedtoDelete(a,b)+numofLetterNeedtoDelete(b,a);
		System.out.println(num);
		in.close();
	}

	private static int numofLetterNeedtoDelete(String a,String b) {
		int count = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < a.length(); i++) {
			char c = a.charAt(i);
			if (map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else {
				map.put(c, 1);
			}
		}
		for (int i = 0; i < b.length(); i++) {
			char c = b.charAt(i);
			if (map.containsKey(c)) {
				if (map.get(c) != 0)
					map.put(c, map.get(c) - 1);
				else
					count++;
			} else
				count++;
		}
		return count;
	}
}
