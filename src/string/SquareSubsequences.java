package string;
import java.util.Scanner;


public class SquareSubsequences {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testNum = in.nextInt();
		in.nextLine();
		while (testNum-- > 0) {
			String string = in.nextLine();
			int index = numofSquareSubsequences(string);
			System.out.println(index);
		}
		in.close();
	}

	private static int numofSquareSubsequences(String string) {
		// TODO Auto-generated method stub
		return 0;
	}
}
