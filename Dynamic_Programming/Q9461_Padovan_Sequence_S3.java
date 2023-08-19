package Dynamic_Programming;

//Commented by ChatGPT
//Summary: This Java program calculates the Padovan sequence using dynamic programming with memoization and prints the nth element for each test case.

import java.io.*;
import java.util.*;

public class Q9461_Padovan_Sequence_S3 {

	// Declare an array 'visited' to keep track of whether the corresponding 'pad'
	// value has been computed.
	static boolean visited[] = new boolean[101];
	// Declare an array 'pad' to store the computed Padovan sequence values as long
	// integers.
	static long pad[] = new long[101];

	// The 'dp' function calculates the nth element of the Padovan sequence using
	// dynamic programming with memoization.
	static long dp(int n) {
		// If the nth element has been computed, return the stored value.
		if (visited[n] == true) {
			return pad[n];
		} else {
			// Otherwise, calculate the nth element using the recurrence relation and store
			// the result in the 'pad' array.
			pad[n] = dp(n - 2) + dp(n - 3);
			visited[n] = true;
			return pad[n];
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Initialize the 'visited' array to false.
		Arrays.fill(visited, false);
		// Read the number of test cases.
		int t = Integer.parseInt(br.readLine());

		// Initialize the base cases of the Padovan sequence.
		pad[1] = 1;
		pad[2] = 1;
		pad[3] = 1;
		visited[1] = true;
		visited[2] = true;
		visited[3] = true;

		// Process each test case.
		for (int i = 0; i < t; i++) {
			// Read the input value 'n'.
			int n = Integer.parseInt(br.readLine());
			// Write the nth element of the Padovan sequence to the output.
			bw.write(dp(n) + "\n");
		}

		bw.flush();
		bw.close();

	}
}
