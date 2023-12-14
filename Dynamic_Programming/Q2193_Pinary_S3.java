package Dynamic_Programming;

/*
commented by ChatGPT
This Java program calculates the number of binary strings of length N that do not contain consecutive ones, using dynamic programming. 
It employs memoization to optimize the computation of the number of such strings for each length and starting digit.
이 Java 프로그램은 연속된 1이 포함되지 않는 길이 N의 이진 문자열의 수를 동적 프로그래밍을 사용하여 계산합니다. 
각 길이와 시작 숫자에 대한 이러한 문자열의 수를 계산하는 데 메모이제이션을 사용하여 최적화합니다.
*/

import java.io.*;
import java.util.*;

public class Q2193_Pinary_S3 {

	static int N; // Length of the binary string (이진 문자열의 길이)
	static long mem1[] = new long[91]; // Memoization array for strings starting with 1 (1로 시작하는 문자열을 위한 메모이제이션 배열)
	static long mem0[] = new long[91]; // Memoization array for strings starting with 0 (0으로 시작하는 문자열을 위한 메모이제이션 배열)

	// Recursive function to calculate the number of valid strings
	static long dp(int idx, int cur) {
		if (cur == 1) { // If current digit is 1
			if (mem1[idx] > 0) // If already computed, return the value (이미 계산된 경우 값을 반환)
				return mem1[idx];
			mem1[idx] = dp(idx + 1, 0); // Compute for the next digit being 0 (다음 자리가 0인 경우 계산)
			return mem1[idx];
		} else { // If current digit is 0
			if (mem0[idx] > 0) // If already computed, return the value (이미 계산된 경우 값을 반환)
				return mem0[idx];
			// Compute for the next digit being 1 and 0 (다음 자리가 1과 0인 경우 계산)
			mem0[idx] = dp(idx + 1, 1) + dp(idx + 1, 0);
			return mem0[idx];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Arrays.fill(mem1, -1); // Initialize memoization arrays with -1 (메모이제이션 배열을 -1로 초기화)
		Arrays.fill(mem0, -1);
		N = Integer.parseInt(br.readLine()); // Read the length of the binary string (이진 문자열의 길이 읽기)
		mem1[N] = 1; // Base case: One valid string of length N starting with 1 (기본 사례: 1로 시작하는 길이 N의
						// 유효한 문자열 하나)
		mem0[N] = 1; // Base case: One valid string of length N starting with 0 (기본 사례: 0으로 시작하는 길이
						// N의 유효한 문자열 하나)

		dp(1, 1); // Start the dynamic programming process (동적 프로그래밍 프로세스 시작)

		bw.write(mem1[1] + ""); // Output the result (결과 출력)

		bw.flush(); // Flush the buffer (버퍼 플러시)
		bw.close(); // Close the writer (쓰기 닫기)
	}
}
