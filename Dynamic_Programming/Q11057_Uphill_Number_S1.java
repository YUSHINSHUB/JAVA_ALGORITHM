package Dynamic_Programming;

/*
commented by ChatGPT
This Java code implements a dynamic programming solution to a combinatorics problem. 
It calculates the number of non-decreasing sequences that can be formed using digits from 0 to 9, with a length specified by the user. 
The solution uses memoization to efficiently compute the number of valid sequences of a given length starting with each digit.
이 Java 코드는 조합론 문제에 대한 동적 프로그래밍 솔루션을 구현합니다. 
사용자가 지정한 길이로 0부터 9까지의 숫자를 사용하여 만들 수 있는 비감소 수열의 수를 계산합니다. 
이 솔루션은 각 숫자로 시작하는 주어진 길이의 유효한 수열의 수를 효율적으로 계산하기 위해 메모이제이션을 사용합니다.
*/

import java.io.*;
import java.util.*;

public class Q11057_Uphill_Number_S1 {

	static int N; // Length of the sequence to be formed
	static int res = 0; // Variable to store the final result
	static long mem[][] = new long[1002][10]; // 2D array for memoization to store results for subproblems

// Recursive function for dynamic programming
	static long dp(int idx, int start) {

		// If the value is already computed, return it
		if (mem[idx][start] > 0) {
			return mem[idx][start];
		}

		mem[idx][start] = 0; // Initialize the memoization value
		// Iterate over all possible starting digits for the sequence
		for (int i = start; i <= 9; i++) {
			mem[idx][start] += dp(idx - 1, i); // Add the number of sequences of length idx-1 starting with digit i
			mem[idx][start] %= 10007; // Take modulo to avoid overflow
		}

		return mem[idx][start]; // Return the computed value
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine()); // Read the length of the sequence

		// Initialize base case for sequences of length 1
		for (int i = 0; i <= 9; i++) {
			mem[1][i] = 1;
		}
		// Fill remaining memoization array with -1 to indicate uncomputed values
		for (int i = 2; i <= N + 1; i++)
			Arrays.fill(mem[i], -1);

		bw.write(dp(N + 1, 0) + ""); // Write the result of the number of sequences of length N
		bw.flush(); // Flush the BufferedWriter
		bw.close(); // Close the BufferedWriter
	}
}