package Implementation;

import java.util.Scanner;

class Q2753_Leap_Year_B5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();

		if (A % 4 == 0 && A % 100 != 0) {
			System.out.println("1");
		} else if (A % 400 == 0) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
	}
}