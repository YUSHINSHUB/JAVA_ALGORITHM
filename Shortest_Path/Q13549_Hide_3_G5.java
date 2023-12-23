package Shortest_Path;

//Commented by ChatGPT
//Summary: The Java program calculates the minimum operations required to convert an integer 'n' to 'm'. The allowed operations are adding 1, subtracting 1, or doubling the current number. It uses a dynamic programming approach to compute the minimum operations.

import java.io.*;
import java.math.*;
import java.util.*;

public class Q13549_Hide_3_G5 {

	public static void main(String[] args) throws IOException {

		// Set up for reading input and writing output
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read input values of 'n' and 'm'
		String inp[] = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int m = Integer.parseInt(inp[1]);

		// If 'n' is greater than or equal to 'm', directly write their difference as
		// output
		if (n >= m)
			bw.write(n - m + "");
		else {

			// Initialize the search array with a size m + 3, filled with high values
			int search[] = new int[m + 3];
			Arrays.fill(search, Integer.MAX_VALUE - 1);
			search[0] = n;

			// Compute initial values for search array starting from 'n'
			for (int i = n; i >= 1; i--) {
				search[i] = n - i;
				for (int j = i * 2; j <= m + 1; j *= 2) {
					if (search[j] > search[i])
						search[j] = search[i];
					else
						break;
				}
			}

			// Update values in the search array for all numbers greater than 'n' and up to
			// 'm'
			for (int i = n + 1; i <= m; i++) {
				// If 'i' is odd, compute the minimum operations for that number
				if (i % 2 == 1)
					search[i] = Math.min(search[i], Math.min(search[i + 1] + 1,
							Math.min(search[i - 1] + 1, Math.min(search[i / 2] + 1, search[i / 2 + 1] + 1))));
				else
					// If 'i' is even, compute the minimum operations for that number
					search[i] = Math.min(search[i],
							Math.min(search[i + 1] + 1, Math.min(search[i - 1] + 1, search[i / 2])));

				// Update the values in the search array for multiples of 'i' up to 'm'
				for (int j = i * 2; j <= m + 1; j *= 2) {
					if (search[j] > search[i])
						search[j] = search[i];
					else
						break;
				}
			}

			// Write the minimum operations required to convert 'n' to 'm'
			bw.write(search[m] + "");
		}

		// Flush and close the output writer
		bw.flush();
		bw.close();
	}
}