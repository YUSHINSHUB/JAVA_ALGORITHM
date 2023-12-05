package Implementation;

import java.util.Scanner;

class Q10817_Three_Numbers_B3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		if (A >= B) {
			if (B >= C) {
				System.out.println(B);
			} else {
				if (A >= C) {
					System.out.println(C);
				} else {
					System.out.println(A);
				}
			}
		} else {
			if (A >= C) {
				System.out.println(A);
			} else {
				if (B >= C) {
					System.out.println(C);
				} else {
					System.out.println(B);
				}
			}
		}
	}
}