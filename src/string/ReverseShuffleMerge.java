package string;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class ReverseShuffleMerge {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String string = in.nextLine();
		String res = lexicographicallySmallest(string);
		System.out.println(res);
        
		in.close();
	}

	private static String lexicographicallySmallest(String string) {
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < string.length(); i++) {
			if (!map.containsKey(string.charAt(i))){
				map.put(string.charAt(i),1);
			}else {
				map.put(string.charAt(i), map.get(string.charAt(i))+1);
			}
		}
		for(Character c:map.keySet()){
			int num=map.get(c);
			num/=2;
			while(num-->0)
				sb.append(c);
		}
        char[] chars= sb.toString().toCharArray();
        Arrays.sort(chars);
        String res= new String(chars);
        return res;
	}
}
