package String;

import java.util.Scanner;

class Q10953_AplusB_3_B3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int i = sc.nextInt();
		sc.nextLine();

		for (int a = 0; a < i; a++) {
			String s = sc.nextLine();
			System.out.println(((int) s.charAt(0) - 48) + ((int) s.charAt(2) - 48));
		}
	}
}