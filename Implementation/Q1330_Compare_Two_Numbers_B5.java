package Implementation;

import java.util.Scanner;

class Q1330_Compare_Two_Numbers_B5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();

		if (A > B) {
			System.out.println('>');
		}

		if (A < B) {
			System.out.println('<');
		}

		if (A == B) {
			System.out.println("==");
		}
	}
}