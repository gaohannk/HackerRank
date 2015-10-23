package bitManipulation;
import java.util.Scanner;

public class Flippingbits {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testNum = in.nextInt();
		in.nextLine();
		while (testNum-- > 0) {
			int num = in.nextInt();
			int res = flipbits(num);
			System.out.println(res);
		}
		in.close();
	}

	private static int flipbits(int num) {
		String str;
		for (int i = 0; i < 32; i++) {
			num = num ^ (1 << i);
		}
		
		// return (long) num;
		return num;
	}
}
