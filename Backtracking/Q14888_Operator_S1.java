package Backtracking;

/*
Commented by ChatGPT
Summary: This Java program performs operations on an array of numbers. The program reads an array of numbers and a set of operations, then uses recursion to calculate the highest and lowest possible outcomes using the available operations.
*/

import java.io.*;
import java.math.*;
import java.util.*;

public class Q14888_Operator_S1 {

	static int n; // Number of elements
	static int num[]; // Array of numbers
	static int op[] = new int[4]; // Array to hold the count of each operation
	static int hig = Integer.MIN_VALUE; // Maximum possible result
	static int low = Integer.MAX_VALUE; // Minimum possible result

	// Recursive function to calculate the highest and lowest possible outcomes
	static void bt(int cur, int idx) {
		if (idx == n) { // If all numbers have been processed
			hig = Math.max(hig, cur);
			low = Math.min(low, cur);
		} else {
			for (int i = 0; i < 4; i++) { // Loop through the operations
				if (op[i] > 0) { // If operation count is greater than 0
					op[i]--; // Decrement operation count
					switch (i) { // Perform operation based on the index
					case 0:
						bt(cur + num[idx], idx + 1); // Addition
						break;
					case 1:
						bt(cur - num[idx], idx + 1); // Subtraction
						break;
					case 2:
						bt(cur * num[idx], idx + 1); // Multiplication
						break;
					case 3:
						bt(cur / num[idx], idx + 1); // Division
						break;
					}
					op[i]++; // Increment operation count
				}
			}
		}

		return;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		num = new int[n];
		String inp[] = br.readLine().split(" ");

		for (int i = 0; i < n; i++) // Store the numbers
			num[i] = Integer.parseInt(inp[i]);

		inp = br.readLine().split(" ");

		for (int i = 0; i < 4; i++) // Store the operation counts
			op[i] = Integer.parseInt(inp[i]);

		bt(num[0], 1); // Start the recursive function

		bw.write(hig + "\n" + low); // Output the highest and lowest possible results

		bw.flush();
		bw.close();
	}
}
