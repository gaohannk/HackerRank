package sorting;

import java.util.Scanner;

public class InsertionSortI {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int len = in.nextInt();
		in.nextLine();
		int[] num = new int[len];
		for (int i = 0; i < len; i++) {
			num[i] = in.nextInt();
		}
		insertIntoSorted(num,num.length-1);
		in.close();
	}

	private static void insertIntoSorted(int[] num,int n) {
		int temp = num[n];
		for (int i = num.length - 1; i > 0; i--) {
			if (temp < num[i - 1]) {
				num[i] = num[i - 1];
				print(num);
				System.out.println();
			} else {
				num[i]=temp;
				print(num);
				return;
			}
		}
		num[0]=temp;
		print(num);
	}

	private static void print(int[] num) {
		for (int n:num) {
			System.out.print(n + " ");
		}		
		System.out.println("");
	}
}
