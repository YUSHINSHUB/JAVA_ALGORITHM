package Recursion;

//Commented by ChatGPT
//Summary: This Java program performs a recursive counting or partitioning operation on a matrix based on a certain criterion. It divides the matrix into smaller sub-matrices and determines if they meet the criteria for incrementing a counter.

import java.io.*;
import java.util.*;

public class Q2630_Paper_S2 {

	// Define 2D array pap to store the matrix, 1D array res to store the count for
	// each category, and integer n for the dimension of the matrix
	static int pap[][];
	static int n;
	static int res[] = new int[2];

	// Recursive function to count or partition the matrix based on certain criteria
	static void recur(int m) {
		boolean pass = true;

		// Loop through the matrix in steps of size m
		for (int i = 0; i < n; i += m) {
			for (int j = 0; j < n; j += m) {
				if (pap[i][j] == 2)
					continue;
				int t = pap[i][j];
				pass = true;
				// Check if all elements in the sub-matrix of size m have the same value as the
				// top-left element
				for (int k = i; k < i + m; k++) {
					for (int l = j; l < j + m; l++) {
						if (pap[k][l] != t) {
							pass = false;
							break;
						}
					}
					if (!pass)
						break;
				}
				if (!pass)
					continue;

				// If all elements are equal, increment the corresponding counter in res array
				// and mark the sub-matrix elements as 2
				res[t]++;
				for (int k = i; k < i + m; k++) {
					for (int l = j; l < j + m; l++) {
						pap[k][l] = 2;
					}
				}
			}
		}

		// Check if the entire matrix has been marked as 2
		pass = true;
		for (int i = 0; i < n; i += m) {
			for (int j = 0; j < n; j += m) {
				if (pap[i][j] != 2) {
					pass = false;
					break;
				}
			}
			if (!pass)
				break;
		}

		// If the entire matrix is not marked as 2, continue the recursion with smaller
		// sub-matrix size
		if (pass)
			return;
		else
			recur(m / 2);
	}

	public static void main(String[] args) throws IOException {

		// Initialize BufferedReader to read input and BufferedWriter to write output
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read the dimension of the matrix
		n = Integer.parseInt(br.readLine());
		boolean pass = true;
		pap = new int[n][n];

		// Read the elements of the matrix
		for (int i = 0; i < n; i++) {
			String inp[] = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				pap[i][j] = Integer.parseInt(inp[j]);
			}
		}

		// Check if all elements of the matrix have the same value
		int t = pap[0][0];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (pap[i][j] != t) {
					pass = false;
					break;
				}
			}
			if (!pass)
				break;
		}

		// If all elements are equal, write the appropriate count for each category
		if (pass) {
			if (pap[0][0] == 0)
				bw.write("1\n0");
			else
				bw.write("0\n1");
		} else {
			// If elements are not equal, start the recursive counting or partitioning
			recur(n / 2);
			bw.write(res[0] + "\n" + res[1]);
		}

		// Flush and close the output stream
		bw.flush();
		bw.close();
	}
}
