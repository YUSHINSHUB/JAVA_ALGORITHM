package Dynamic_Programming;

//Commented by ChatGPT
//Summary: This code determines the minimum number of coins needed to make up the total value 'k' given 'n' coin denominations.

import java.io.*;
import java.util.*;

public class Q2294_COIN_2_G5 {

	public static void main(String[] args) throws IOException {

		// Using BufferedReader and BufferedWriter for efficient IO operations
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// `n` represents the number of coin denominations and `k` is the desired total
		// value.
		int n, k;
		// Array to hold the coin denominations.
		int coin[] = new int[100];
		// Memory table to store the minimum coins required for each value up to `k`.
		int mem[] = new int[110001];

		// Splitting the input line to get `n` and `k` values.
		String inp[] = br.readLine().split(" ");
		n = Integer.parseInt(inp[0]);
		k = Integer.parseInt(inp[1]);

		// Initialize the memory table to -1, indicating value is not yet computed.
		Arrays.fill(mem, -1);

		// Read each coin denomination from input.
		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
			// Directly mark that the specific denomination can be achieved using one coin.
			mem[coin[i]] = 1;
		}

		// Populate the memoization table using a bottom-up approach.
		for (int i = 1; i <= k; i++) {
			// If current value `i` can be achieved using the coins read.
			if (mem[i] > 0) {
				// Check for each coin denomination.
				for (int j = 0; j < n; j++) {
					// If the combination value hasn't been seen before, mark it as achievable.
					if (mem[i + coin[j]] < 0)
						mem[i + coin[j]] = mem[i] + 1;
					// If the combination value was seen before, update to the minimum coins
					// required.
					else
						mem[i + coin[j]] = Math.min(mem[i + coin[j]], mem[i] + 1);
				}
			}
		}

		// Output the minimum coins required for the total value `k`.
		bw.write(mem[k] + "");

		// Flush and close the BufferedWriter.
		bw.flush();
		bw.close();

	}
}
