package Breadth_first_Search;

/*
Commented by ChatGPT
The program performs a breadth-first search (BFS) to count the maximum number of clusters in a 2D grid.
*/

import java.io.*;
import java.math.*;
import java.util.*;

public class Q2468_Safe_Area_S1 {

	// Global variables for the 2D grid area and the BFS visitation grid
	static int area[][];
	static int bfs[][];

	// Recursive method for the BFS traversal
	public static void recur(int x, int y, int idx) {

		bfs[x][y] = 1; // Mark the current grid cell as visited

		// Checks the surrounding cells and performs recursive calls if they meet the
		// condition
		if (area[x + 1][y] >= idx && bfs[x + 1][y] == 0)
			recur(x + 1, y, idx);
		if (area[x][y + 1] >= idx && bfs[x][y + 1] == 0)
			recur(x, y + 1, idx);
		if (area[x - 1][y] >= idx && bfs[x - 1][y] == 0)
			recur(x - 1, y, idx);
		if (area[x][y - 1] >= idx && bfs[x][y - 1] == 0)
			recur(x, y - 1, idx);

		return;

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine()); // Read the size of the grid
		int res = 0; // Variable to store the maximum number of clusters found
		int cur = 0; // Variable to track the current count of clusters
		area = new int[n + 2][n + 2]; // Initialize the area grid
		bfs = new int[n + 2][n + 2]; // Initialize the BFS grid

		// Initialize the boundaries of the grid with zeros
		Arrays.fill(area[0], 0);
		Arrays.fill(area[n + 1], 0);

		// Read and populate the grid
		for (int i = 1; i <= n; i++) {
			Arrays.fill(area[i], 0);
			String inp[] = br.readLine().split(" ");
			for (int j = 1; j <= n; j++) {
				area[i][j] = Integer.parseInt(inp[j - 1]);
			}
		}

		// For each possible value, perform the cluster counting
		for (int i = 1; i <= 100; i++) {

			cur = 0; // Reset the current count

			// Reset the BFS grid for the current iteration
			for (int j = 1; j <= n; j++) {
				Arrays.fill(bfs[j], 0);
			}

			// For each grid cell, check if it meets the condition and initiate the
			// recursion
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					if (area[j][k] >= i && bfs[j][k] == 0) {
						cur++; // Increase the count of clusters
						recur(j, k, i); // Initiate the recursive BFS
					}
				}
			}

			// If no clusters were found, break the loop
			if (cur == 0)
				break;
			else
				res = Math.max(res, cur); // Update the maximum count of clusters
		}

		bw.write(res + ""); // Write the maximum count of clusters to the output

		bw.flush();
		bw.close();
	}
}
