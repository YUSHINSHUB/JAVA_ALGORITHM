package Mathematics;

import java.util.Scanner;

class Q11021_AplusB_7_B5 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			System.out.println("Case #" + (i + 1) + ": " + (x + y));
		}
	}
}