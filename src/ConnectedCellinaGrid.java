import java.util.Scanner;

public class ConnectedCellinaGrid {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int row = in.nextInt();
		in.nextLine();
		int col = in.nextInt();
		in.nextLine();
		int[][] cell = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				cell[i][j] = in.nextInt();
			}
		}
		int num = maxofCellSize(cell);
		System.out.println(num);
		in.close();
	}

	private static int maxofCellSize(int[][] cell) {
		int res = 0;
		int[][] checker = new int[cell.length][cell[0].length];
		for (int i = 0; i < cell.length; i++) {
			for (int j = 0; j < cell[0].length; j++) {
				int count = 0;
				if (cell[i][j] == 1)
					count = helper(cell, i, j, checker);
				if (count > res)
					res = count;
			}
		}
		return res;
	}

	private static int helper(int[][] cell, int i, int j, int[][] checker) {
		int count = 0;
		if (checker[i][j] == 1) {
			return count;
		}
		checker[i][j] = 1;
		count++;
		if (i - 1 >= 0 && cell[i - 1][j] == 1)
			count += helper(cell, i - 1, j, checker);
		if (j - 1 >= 0 && cell[i][j - 1] == 1)
			count += helper(cell, i, j - 1, checker);
		if (i + 1 < cell.length && cell[i + 1][j] == 1)
			count += helper(cell, i + 1, j, checker);
		if (j + 1 < cell[0].length && cell[i][j + 1] == 1)
			count += helper(cell, i, j + 1, checker);
		if (i + 1 < cell.length && j + 1 < cell[0].length && cell[i + 1][j + 1] == 1)
			count += helper(cell, i + 1, j + 1, checker);
		if (i + 1 < cell.length && j - 1 >= 0 && cell[i + 1][j - 1] == 1)
			count += helper(cell, i + 1, j - 1, checker);
		if (i - 1 >= 0 && j + 1 < cell[0].length && cell[i - 1][j + 1] == 1)
			count += helper(cell, i - 1, j + 1, checker);
		if (i - 1 >= 0 && j - 1 >= 0 && cell[i - 1][j - 1] == 1)
			count += helper(cell, i - 1, j - 1, checker);
		return count;
	}
}
