package Mathematics;

import java.util.Scanner;

class Q2884_Alarm_B3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		for (int i = 0; i < 45; i++) {
			b--;
			if (b == -1) {
				b = 59;
				a--;
				if (a == -1) {
					a = 23;
				}
			}
		}
		System.out.print(a + " " + b);
	}
}