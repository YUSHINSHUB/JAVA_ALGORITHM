package Mathematics;

import java.util.Scanner;

class Q10952_AplusB_5_B5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (;;) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			if (x == 0 && y == 0) {
				return;
			}
			System.out.println(x + y);
		}
	}
}