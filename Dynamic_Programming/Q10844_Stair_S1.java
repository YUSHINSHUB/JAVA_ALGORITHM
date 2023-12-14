package Dynamic_Programming;

import java.io.*;
import java.util.*;

public class Q10844_Stair_S1 {

	// A 2D array to store our dynamic programming table
	static int cnt[][] = new int[101][10];

	// Dynamic programming function to calculate the counts
	static void dp(int n) {
		// If the count for n-1 hasn't been calculated and n != 1, calculate it
		// recursively
		if (cnt[n - 1][0] < 0 && n != 1) {
			dp(n - 1);
		}

		// If n is not 1, calculate the count for current n using the counts from n-1
		if (n != 1) {
			for (int i = 1; i <= 8; i++)
				cnt[n][i] = (cnt[n - 1][i - 1] + cnt[n - 1][i + 1]) % 1000000000;
			// Handle the edge cases for digits 0 and 9 separately
			cnt[n][0] = cnt[n - 1][1] % 1000000000;
			cnt[n][9] = cnt[n - 1][8] % 1000000000;
		}

		return;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int res = 0;
		// Read the input length
		int n = Integer.parseInt(br.readLine());

		// Initialize the DP table
		for (int i = 2; i <= 100; i++) {
			Arrays.fill(cnt[i], -1);
		}
		// Base case: there is one stair number for each single digit (except 0)
		cnt[1][0] = 0;
		for (int i = 1; i <= 9; i++) {
			cnt[1][i] = 1;
		}

		// Calculate the counts using DP
		dp(n);

		// Calculate the total count
		for (int i = 0; i <= 9; i++) {
			res += cnt[n][i];
			res %= 1000000000;
		}

		// Write the result
		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}