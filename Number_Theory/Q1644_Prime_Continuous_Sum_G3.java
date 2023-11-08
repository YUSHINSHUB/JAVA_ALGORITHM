package Number_Theory;

/*
commented by ChatGPT
This Java code is designed to count the number of ways a given number N can be expressed as a sum of consecutive prime numbers. 
It utilizes the Sieve of Eratosthenes algorithm to find all prime numbers up to N and then checks for consecutive prime sums that equal N.
이 Java 코드는 주어진 숫자 N을 연속된 소수의 합으로 표현할 수 있는 방법의 수를 계산하기 위해 설계되었습니다. 
에라토스테네스의 체 알고리즘을 사용하여 N까지의 모든 소수를 찾은 다음 N과 같은 연속된 소수의 합을 확인합니다.
*/

import java.io.*;
import java.util.*;

public class Q1644_Prime_Continuous_Sum_G3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine()); // The given number (주어진 숫자)

		// Using Sieve of Eratosthenes to find prime numbers (에라토스테네스의 체를 사용하여 소수 찾기)
		int era[] = new int[N + 1];
		Arrays.fill(era, 0); // Fill the array with 0s (배열을 0으로 채우기)
		era[1] = 1; // 1 is not a prime number (1은 소수가 아님)

		// Mark all non-prime numbers (모든 비소수 표시하기)
		for (int i = 2; i <= N; i++) {
			if (era[i] == 0) { // If i is prime (i가 소수라면)
				for (int j = i * 2; j <= N; j += i) {
					era[j] = 1; // Mark multiples of i as non-prime (i의 배수를 비소수로 표시)
				}
			}
		}

		int sum = 0; // Sum of consecutive primes (연속된 소수의 합)
		int les = 2; // Least consecutive prime number (가장 작은 연속 소수)
		int res = 0; // Result counter for number of ways (방법의 수를 세는 결과 카운터)

		// Check for consecutive prime sums (연속된 소수의 합을 확인하기)
		for (int i = 2; i <= N; i++) {
			if (era[i] == 0) { // If i is a prime number (i가 소수라면)
				sum += i; // Add to sum (합에 추가하기)

				// Remove least primes until sum is less than or equal to N (합이 N 이하가 될 때까지 가장
				// 작은 소수 제거)
				while (sum > N) {
					sum -= les; // Subtract least prime from sum (합에서 가장 작은 소수를 빼기)
					// Find the next least prime number (다음 가장 작은 소수 찾기)
					for (int j = les + 1; j <= N; j++) {
						if (era[j] == 0) { // If j is prime (j가 소수라면)
							les = j; // Update least prime (가장 작은 소수 업데이트)
							break; // Exit the loop (루프 종료)
						}
					}
				}

				// If the sum equals N, increment result counter (합이 N과 같다면 결과 카운터 증가)
				if (sum == N) {
					res++;
				}
			}
		}

		bw.write(res + ""); // Write the result (결과를 쓰기)
		bw.flush(); // Flush the stream (스트림을 플러시하기)
		bw.close(); // Close the writer (쓰기 도구를 닫기)
	}
}
