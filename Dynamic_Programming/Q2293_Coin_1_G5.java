package Dynamic_Programming;

//Commented by ChatGPT
//Summary: This code calculates the number of ways to combine given coin denominations to achieve a specific total value.

import java.io.*;
import java.math.*;
import java.util.*;

public class Q2293_Coin_1_G5 {

	public static void main(String[] args) throws IOException {

		// Initialize BufferedReader and BufferedWriter for input and output operations.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Split the input line to extract the number of coin denominations and the
		// desired total value.
		String inp[] = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int k = Integer.parseInt(inp[1]);

		// Array to hold the coin denominations.
		int coin[] = new int[n];
		// DP array to store the number of ways to achieve each value up to 'k'.
		int dp[] = new int[10001];

		// Initializing the base case: there's one way to make a total value of 0.
		Arrays.fill(dp, 0);
		dp[0] = 1;

		// Read coin denominations from the input.
		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		// Update the DP array using a bottom-up approach.
		// For each coin denomination:
		for (int j = 0; j < n; j++) {
			// For each value up to 'k':
			for (int i = 1; i <= k; i++) {
				// If the current coin denomination can be used to achieve this value:
				if (coin[j] <= i) {
					// Add the number of ways to achieve the current value minus the coin
					// denomination.
					dp[i] += dp[i - coin[j]];
				}
			}
		}

		// Write the number of ways to achieve the total value 'k' using the given coin
		// denominations.
		bw.write(dp[k] + "");

		// Complete the output operation.
		bw.flush();
		bw.close();

	}
}
