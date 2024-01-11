package Mathematics;

import java.util.Scanner;

class Q11022_Plus_8_B5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int i = sc.nextInt();

		for (int a = 0; a < i; a++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			System.out.println("Case #" + (a + 1) + ": " + x + " + " + y + " = " + (x + y));
		}
	}
}