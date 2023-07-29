package Greedy;

/*
Short Summary: 
This Java program uses a priority queue to perform a specific operation m times on a set of n integers and calculates the sum of the final elements. 
The operation consists of removing the smallest two elements, summing them, and adding the sum twice back to the queue.

Commented by ChatGPT
*/

import java.io.*;
import java.util.*;

public class Q15903_Merge_Cards_S1 {

	public static void main(String[] args) throws IOException {
		// Instantiate BufferedReader to read input from console and BufferedWriter to
		// write output to console
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read first line of input and split it into an array of strings
		String inp[] = br.readLine().split(" ");

		// Parse the first two inputs as integers n and m
		int n = Integer.parseInt(inp[0]);
		int m = Integer.parseInt(inp[1]);

		// Read second line of input and split it into an array of strings
		inp = br.readLine().split(" ");

		// Instantiate a priority queue of long integers
		PriorityQueue<Long> pq = new PriorityQueue<>();

		// Populate the queue with parsed long integers from the input
		for (int i = 0; i < n; i++) {
			pq.add(Long.parseLong(inp[i]));
		}

		// If there's more than one element in the queue, perform operations
		if (n > 1) {
			// Perform m operations
			for (int i = 0; i < m; i++) {
				// For each operation, remove the smallest two elements from the queue, sum them
				long a = pq.poll();
				long b = pq.poll();
				a += b;

				// Add the sum back to the queue twice
				pq.add(a);
				pq.add(a);
			}
		}

		// Initialize a variable to hold the final result
		long res = 0;

		// Sum up all remaining elements in the queue
		while (!pq.isEmpty()) {
			res += pq.poll();
		}

		// Write the result to console, flush and close BufferedWriter
		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}
