package dynamicProgramming;
import java.util.Scanner;

public class StockMaximize {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		try {
			int testNum = in.nextInt();
			while (testNum-- > 0) {
				int len = in.nextInt();
				String str = in.nextLine();
				String[] strs = str.split(" ");
				int[] num = new int[len];
				for (int i = 0; i < strs.length; i++) {
					num[i] = Integer.parseInt(strs[i]);
				}
				int start = 0;
				long profit = 0;
				System.out.println(MaxProfit(num, profit, start));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} finally {
			in.close();
		}
	}

	public static long MaxProfit(int[] num, long profit, int start) {
		if (start >= num.length)
			return profit;
		int max = 0;
		int index = 0;
		for (int i = start; i < num.length; i++) {
			if (num[i] > max) {
				max = num[i];
				index = i;
			}
		}
		for (int i = start; i <= index; i++) {
			profit += max - num[i];
		}
		return MaxProfit(num, profit, index + 1);
	}
}
