package Graph_Theory;

//Commented by ChatGPT
//Summary: This Java program calculates the person with the smallest total number of connections in a social network represented by a graph. 
//It updates the adjacency matrix to reflect the shortest path between any two nodes and calculates the total number of connections for each person.

import java.io.*;
import java.util.*;

public class Q1389_Small_World_Effect_S1 {

	public static void main(String[] args) throws IOException {

		// Initialize BufferedReader to read input and BufferedWriter to write output
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read the first line of input, split it, and store the values of n and m
		String inp[] = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]); // Number of people
		int m = Integer.parseInt(inp[1]); // Number of connections
		int res = 0; // Variable to store the person with the smallest total number of connections
		int low = Integer.MAX_VALUE; // Variable to store the smallest total number of connections

		// Define a 2D array kev to store connections between people
		int kev[][] = new int[n + 1][n + 1];

		// Fill the 2D array kev with -1 to indicate no known connections
		for (int i = 1; i <= n; i++)
			Arrays.fill(kev[i], -1);

		// Read the connections (edges) between people and update the 2D array kev
		for (int i = 0; i < m; i++) {
			inp = br.readLine().split(" "); // Split the input line
			int a = Integer.parseInt(inp[0]); // Person a
			int b = Integer.parseInt(inp[1]); // Person b

			// Indicate a connection between people a and b in the 2D array kev
			kev[a][b] = 1;
			kev[b][a] = 1;
		}

		// Update the 2D array kev to reflect the shortest path between any two nodes
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) // Ignore self-loops
					continue;
				if (kev[j][i] > 0) {
					for (int k = 1; k <= n; k++) {
						if (k == i || k == j) // Ignore direct connections
							continue;
						if (kev[i][k] > 0 && kev[j][k] < 0) { // Update the matrix if there is an indirect connection
							kev[j][k] = kev[j][i] + kev[i][k];
							kev[k][j] = kev[j][i] + kev[i][k];
						} else if (kev[i][k] > 0) { // Update the matrix if a shorter path is found
							kev[j][k] = Math.min(kev[j][k], kev[j][i] + kev[i][k]);
							kev[k][j] = Math.min(kev[j][k], kev[k][j]);
						}
					}
				}
			}
		}

		// Calculate the total number of connections for each person
		for (int i = 1; i <= n; i++) {
			int temp = 0; // Variable to store the total number of connections for person i
			for (int j = 1; j <= n; j++) {
				temp += kev[i][j]; // Accumulate the total number of connections for person i
			}
			if (temp < low) { // Update the person with the smallest total number of connections and the value
								// of the smallest total number of connections
				low = temp;
				res = i;
			}
		}

		// Write the person with the smallest total number of connections to the output
		bw.write(res + "");

		// Flush and close the output stream
		bw.flush();
		bw.close();
	}
}
