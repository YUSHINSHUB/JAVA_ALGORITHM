package Dynamic_Programming;

//Commented by ChatGPT
//This Java program calculates the number of sequences with a certain length 
//and sum of numbers using dynamic programming. The solution is modded by 1,000,000,000.

import java.io.*;
import java.util.*;

public class Q2225_Divide_Sum_G5 {

	// Using a 2D array 'dp' to store results of subproblems
	static long dp[][] = new long[201][201];
	// 'chk' is a boolean array to keep track of which subproblems have already been
	// solved
	static boolean chk[][] = new boolean[201][201];

	// Recursive function to compute the number of sequences
	public static long recur(int a, int b) {
		// Check if the subproblem is already solved
		if (!chk[a][b]) {
			dp[a][b] = 0;
			// Loop through possible numbers and accumulate results from subproblems
			for (int i = 0; i <= b; i++) {
				if (chk[a - 1][i]) {
					dp[a][b] += dp[a - 1][i];
				} else {
					dp[a][b] += recur(a - 1, i);
				}
				// Ensure that the result doesn't exceed 1,000,000,000
				if (dp[a][b] >= 1000000000)
					dp[a][b] %= 1000000000;
			}
			chk[a][b] = true;
		}
		return dp[a][b];
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Reading the two input numbers
		String inp[] = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int k = Integer.parseInt(inp[1]);

		// Initializing the base cases
		for (int i = 0; i <= n; i++) {
			dp[1][i] = 1;
			chk[1][i] = true;
		}

		// Getting the result using the recursive function
		long res = recur(k, n);

		// Writing the result
		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}
