package Backtracking;

/*
commented by ChatGPT
This Java code is a backtracking algorithm to find all prime numbers with 'n' digits. 
It starts with the single-digit prime numbers 2, 3, 5, and 7 and builds up to 'n' digits by appending digits from 0 to 9, 
checking the primality of each new number. If a number with 'n' digits is prime, it prints the number.
이 Java 코드는 'n' 자리의 모든 소수를 찾기 위한 백트래킹 알고리즘입니다.
한 자리 소수인 2, 3, 5, 7에서 시작하여 0부터 9까지의 숫자를 추가하며 'n' 자리 수를 만들어가고,
각 새로운 숫자의 소수 여부를 확인합니다. 'n' 자리 수가 소수인 경우 그 숫자를 출력합니다.
*/

import java.io.*;

public class Q2023_Amazing_Prime_G5 {

	static int n; // The number of digits for the prime numbers to find

	// Backtracking function to find and print 'n' digit prime numbers
	static void bt(int cnt, int x) {
		if (cnt == n) {
			// If the count of digits equals 'n', print the number as it is prime
			System.out.println(x);
		} else {
			// Increment digit count
			cnt++;
			// Try appending each digit from 0 to 9 to the current number 'x'
			for (int i = x * 10; i <= (x * 10) + 9; i++) {
				boolean isPrime = true; // Flag to check if 'i' is prime
				// Check if 'i' is a prime number by trying to divide it by all numbers from 2
				// to i/2
				for (int z = 2; z <= i / 2; z++) {
					if (i % z == 0) {
						isPrime = false; // 'i' is not prime if it is divisible by 'z'
						break;
					}
				}
				// If 'i' is prime, continue backtracking with the new number 'i'
				if (isPrime)
					bt(cnt, i);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine()); // Read the number of digits 'n'

		// Start backtracking with single-digit prime numbers
		bt(1, 2);
		bt(1, 3);
		bt(1, 5);
		bt(1, 7);

		bw.flush();
		bw.close();
	}
}
