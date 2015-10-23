package sorting;

import java.util.Scanner;

public class InsertionSortII {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int len = in.nextInt();
		in.nextLine();
		int[] num = new int[len];
		for (int i = 0; i < len; i++) {
			num[i] = in.nextInt();
		}
		insertionSortPart2(num);
		in.close();
		
	}
	public static void insertionSortPart2(int[] ar)
    {       
		for(int i=1;i<ar.length;i++){
			insertIntoSorted(ar,i);
		}
    }
	
	private static void insertIntoSorted(int[] num,int n) {
		int temp = num[n];
		for (int i = n; i > 0; i--) {
			if (temp < num[i - 1]) {
				num[i] = num[i - 1];
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
