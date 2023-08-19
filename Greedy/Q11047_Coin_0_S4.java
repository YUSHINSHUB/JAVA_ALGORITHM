package Greedy;

//Commented by ChatGPT
//Summary: This Java program calculates the minimum number of coins needed to make a given amount 'k' using a list of 'n' coin denominations.

import java.io.*;

public class Q11047_Coin_0_S4 {

	public static void main(String[] args) throws IOException {

		// Initialize buffered reader and writer for efficient I/O.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read input values from the first line.
		String inp[] = br.readLine().split(" ");

		// Parse input values for 'n' (the number of coin denominations) and 'k' (the
		// target amount).
		int n = Integer.parseInt(inp[0]);
		int k = Integer.parseInt(inp[1]);

		// Initialize an array to store the coin denominations.
		int coin[] = new int[n];

		// Initialize variables for output and summation.
		int out = 0;

		// Read coin denominations and store them in the 'coin' array.
		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		// Iterate over the coin denominations in reverse order.
		for (int i = n - 1; i >= 0; i--) {
			// Increment the output counter by the quotient of 'k' and the current coin
			// denomination.
			out += k / coin[i];
			// Update the value of 'k' with the remainder.
			k %= coin[i];
		}

		// Write the final output value to the buffered writer.
		bw.write(out + "");

		// Flush and close the buffered writer.
		bw.flush();
		bw.close();
	}
}
