package Sorting;

/*
Commented by ChatGPT
Summary: This Java program takes three integers as input and prints the second largest number.
*/

import java.util.Scanner;

class Q10817_Three_Numbers_B3 {
	public static void main(String[] args) {
		// Create a Scanner object to read input
		Scanner sc = new Scanner(System.in);

		// Read the three integers
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		// Compare the integers and print the second largest
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
