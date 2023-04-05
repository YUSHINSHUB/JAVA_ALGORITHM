package Mathematics;

import java.util.Scanner;

class Q1110_Addition_Cycle_B1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int a = n;
		int b = 0;

		do {
			a = (((a % 10) + (a / 10)) % 10) + ((a % 10) * 10);
			b++;
		} while (a != n);

		System.out.println(b);
	}
}