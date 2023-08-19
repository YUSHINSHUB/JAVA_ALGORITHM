package Greedy;

//Commented by ChatGPT
//Summary: This Java program reads an integer 'n' and an array of 'n' integers. It calculates the cumulative sum of the sorted integers and then finds the total sum of the cumulative sums.

import java.io.*;
import java.util.*;

public class Q11399_ATM_S4 {
	public static void main(String[] args) throws IOException {
		// Create a BufferedReader object for reading input and a BufferedWriter object
		// for writing output.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read the number of integers 'n' from input.
		int n = Integer.parseInt(br.readLine());

		// Read the array of integers and parse them into the 'times' array.
		String inp[] = br.readLine().split(" ");
		int times[] = new int[n];
		int sum = 0;
		int res = 0;

		// Parse the integers into the 'times' array.
		for (int i = 0; i < n; i++) {
			times[i] = Integer.parseInt(inp[i]);
		}

		// Sort the array of integers in ascending order.
		Arrays.sort(times);

		// Calculate the cumulative sum of the sorted integers and find the total sum of
		// the cumulative sums.
		for (int i = 0; i < n; i++) {
			sum += times[i];
			res += sum;
		}

		// Write the result to output.
		bw.write(res + "");

		// Flush and close the BufferedWriter.
		bw.flush();
		bw.close();
	}
}
