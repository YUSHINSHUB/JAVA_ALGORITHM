package Graph_Traversal;

//Commented by ChatGPT
//This Java program calculates the transitive closure of a directed graph using the Floyd-Warshall algorithm. 
//It reads the adjacency matrix of the graph, computes the transitive closure, and prints the resulting matrix.

import java.io.*;

public class Q11403_Find_Route_S1 {
	public static void main(String[] args) throws IOException {
		// Initialize a BufferedReader to read input from standard input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Initialize a BufferedWriter to write output to standard output
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read the number of vertices in the graph
		int n = Integer.parseInt(br.readLine());
		// Create a 2D array to represent the adjacency matrix of the graph
		int grp[][] = new int[n][n];

		// Read and populate the adjacency matrix from the input
		for (int i = 0; i < n; i++) {
			String inp[] = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				grp[i][j] = Integer.parseInt(inp[j]);
			}
		}

		// Compute the transitive closure using the Floyd-Warshall algorithm
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// Check if there is a direct edge from vertex j to vertex i
				if (grp[j][i] == 1) {
					for (int k = 0; k < n; k++) {
						// If there is an edge from vertex i to vertex k,
						// set grp[j][k] to 1 to indicate that there is a path from vertex j to vertex k
						if (grp[i][k] == 1)
							grp[j][k] = 1;
					}
				}
			}
		}

		// Write the transitive closure matrix to the output
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				bw.write(grp[i][j] + " "); // Write each cell of the matrix followed by a space
			bw.write("\n"); // Write a newline character to separate rows
		}

		// Flush the buffer and close the BufferedWriter
		bw.flush();
		bw.close();
	}
}
