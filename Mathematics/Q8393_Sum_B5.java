package Mathematics;

import java.util.Scanner;

class Q8393_Sum_B5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = 0;

		for (int i = 1; i <= a; i++) {
			b = b + i;
		}
		System.out.println(b);
	}
}