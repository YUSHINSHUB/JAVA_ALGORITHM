package Geometry;

/* 
commented by ChatGPT
Summary: The program reads a series of triplets, computes the squared value of the largest number 
and the squared sum of the other two, then outputs the results.
*/

import java.io.*;
import java.math.*;
import java.util.*;

public class Q11880_ANT_B2 {

	public static void main(String[] args) throws IOException {
		// Initialize BufferedReader to read input from the console
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Initialize BufferedWriter to write output to the console
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Declare necessary variables
		int n;
		long a, b, c, res;

		// Read the number of test cases
		n = Integer.parseInt(br.readLine());

		// Loop through each test case
		for (int i = 0; i < n; i++) {
			// Split the input line into an array of strings based on spaces
			String inp[] = br.readLine().split(" ");

			// Parse the split strings to long variables a, b, and c
			a = Long.parseLong(inp[0]);
			b = Long.parseLong(inp[1]);
			c = Long.parseLong(inp[2]);

			// Find the largest number among a, b, and c
			long big = Math.max(a, Math.max(b, c));

			// Compute the sum of a, b, and c, then subtract the largest number from the sum
			long sum = a + b + c;
			sum -= big;

			// Compute the result as the square of the largest number added to the square of
			// the sum
			res = (big * big) + (sum * sum);

			// Write the result to the console
			bw.write(res + "\n");
		}

		// Flush and close the BufferedWriter to ensure all output is printed
		bw.flush();
		bw.close();
	}
}
