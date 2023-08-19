package Dynamic_Programming;

//Commented by ChatGPT
//Summary: This Java program calculates the number of ways to reach the nth step using 1, 2, or 3 steps at a time.

import java.io.*;

public class Q9095_Add_1_2_3_S3 {

	public static void main(String[] args) throws IOException {

		// Set up the BufferedReader and BufferedWriter for input and output operations.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Create an array 'dp' to store the number of ways to reach each step.
		int dp[] = new int[11];
		// Initialize the first three elements of the array as per the base cases.
		dp[1] = 1; // 1 way to reach the 1st step (1 step)
		dp[2] = 2; // 2 ways to reach the 2nd step (1+1 or 2 steps)
		dp[3] = 4; // 4 ways to reach the 3rd step (1+1+1, 1+2, 2+1, or 3 steps)

		// Use dynamic programming to calculate the number of ways to reach each step
		// from 4 to 10.
		for (int i = 4; i <= 10; i++) {
			// The number of ways to reach step 'i' is the sum of the number of ways to
			// reach steps 'i-1', 'i-2', and 'i-3'.
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}

		// Read the number of test cases (t) from the input.
		int t = Integer.parseInt(br.readLine());

		// Process each test case.
		for (int i = 0; i < t; i++) {
			// Read the step number (temp) for this test case.
			int temp = Integer.parseInt(br.readLine());
			// Write the number of ways to reach the given step (dp[temp]) to the output.
			bw.write(String.valueOf(dp[temp]) + "\n");
		}

		// Flush the BufferedWriter to ensure all output is written and then close it.
		bw.flush();
		bw.close();
	}
}
