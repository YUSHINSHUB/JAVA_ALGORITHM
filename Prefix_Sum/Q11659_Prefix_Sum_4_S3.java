package Prefix_Sum;

//Commented by ChatGPT
//This Java program reads a sequence of integers and for each query, it calculates the sum of a subsequence of the sequence and prints it. 
//The program uses an optimized approach by computing the prefix sum of the entire sequence.

import java.io.*;

public class Q11659_Prefix_Sum_4_S3 {
	public static void main(String[] args) throws IOException {
		// Initialize a BufferedReader to read input from standard input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Initialize a BufferedWriter to write output to standard output
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read the first line of input and split it into two integers n and m
		String inp[] = br.readLine().split(" ");
		// Number of elements in the sequence
		int n = Integer.parseInt(inp[0]);
		// Number of queries
		int m = Integer.parseInt(inp[1]);

		// Create an array to store the sequence of integers
		int num[] = new int[n + 1];
		// Create an array to store the prefix sum of the sequence
		int psum[] = new int[n + 1];
		// Initialize the prefix sum at index 0 to be 0
		psum[0] = 0;

		// Read the sequence of integers and store it in the array num
		inp = br.readLine().split(" ");
		for (int i = 1; i <= n; i++) {
			num[i] = Integer.parseInt(inp[i - 1]);
			// Update the prefix sum array by adding the current element to the prefix sum
			// of the previous elements
			psum[i] = psum[i - 1] + num[i];
		}

		// Process each query
		for (int i = 0; i < m; i++) {
			// Read the start and end index of the subsequence
			inp = br.readLine().split(" ");
			int a = Integer.parseInt(inp[0]);
			int b = Integer.parseInt(inp[1]);

			// Calculate the sum of the subsequence using the prefix sum array
			bw.write(psum[b] - psum[a - 1] + "\n");
		}

		// Flush the buffer and close the BufferedWriter
		bw.flush();
		bw.close();
	}
}
