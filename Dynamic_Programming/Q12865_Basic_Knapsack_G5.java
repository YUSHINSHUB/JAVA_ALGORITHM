package Dynamic_Programming;

import java.io.*;
import java.util.*;

// commented by ChatGPT
// Summary:
// A program to solve the 0-1 knapsack problem using dynamic programming. 
// The program calculates the maximum value obtainable while ensuring the 
// total weight doesn't exceed a specified limit.

public class Q12865_Basic_Knapsack_G5 {

	// 2D array storing the weight (index 0) and value (index 1) of items
	static int item[][] = new int[100][2];

	// Memoization table, where mem[i][j] stores the maximum value obtainable
	// using the first j items and a total weight of i
	static int mem[][] = new int[100001][100];

	// n = number of items, k = weight capacity of the knapsack
	static int n, k;

	// Dynamic programming function to compute the maximum value
	static int dp(int w, int idx) {

		// Return the memorized result if available
		if (mem[w][idx] >= 0) {
			return mem[w][idx];
		}

		// Check if we can include the current item in the knapsack
		if (item[idx][0] <= w)
			// Either include the current item or skip it,
			// and store the maximum of the two options
			mem[w][idx] = Math.max(item[idx][1] + dp(w - item[idx][0], idx - 1), dp(w, idx - 1));
		else
			// Current item cannot be included, so skip it
			mem[w][idx] = dp(w, idx - 1);

		return mem[w][idx];
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Parse the number of items and the knapsack's capacity
		String inp[] = br.readLine().split(" ");
		n = Integer.parseInt(inp[0]);
		k = Integer.parseInt(inp[1]);

		// Input the weight and value for each item
		for (int i = 0; i < n; i++) {
			inp = br.readLine().split(" ");
			item[i][0] = Integer.parseInt(inp[0]);
			item[i][1] = Integer.parseInt(inp[1]);
		}

		// Initialize the memoization table
		for (int i = 1; i <= k; i++) {
			Arrays.fill(mem[i], -1);

			// If the total weight allows including the first item, do so
			if (i >= item[0][0])
				mem[i][0] = item[0][1];
			else
				mem[i][0] = 0;
		}

		// Base case: for total weight = 0, the maximum value is always 0
		Arrays.fill(mem[0], 0);

		// Output the maximum value for weight = k using all n items
		bw.write(dp(k, n - 1) + "");

		bw.flush();
		bw.close();
	}
}
