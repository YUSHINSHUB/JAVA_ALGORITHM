package Graph_Traversal;

/*
Commented by ChatGPT
Summary: This Java program implements a Depth-First Search (DFS) algorithm to traverse a given graph and record the order of traversal.
*/

import java.io.*;
import java.util.*;

public class Q24479_DFS_1_S2 {

	static int node[]; // Node array
	static int visited[]; // Array to track visited nodes
	static ArrayList<Integer>[] edge; // Edge list for each node
	static int res[]; // Array to store result
	static int idx = 0; // Index counter

	// DFS method
	static void dfs(int r) {
		idx++;
		res[r] = idx; // Set traversal order for node r
		visited[r] = 1; // Mark node r as visited

		for (int v : edge[r]) { // Loop through nodes adjacent to node r
			if (visited[v] < 1) // If the node is not visited
				dfs(v); // Visit the node
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" "); // Input reading
		int n = Integer.parseInt(inp[0]); // Number of nodes
		int m = Integer.parseInt(inp[1]); // Number of edges
		int r = Integer.parseInt(inp[2]); // Root node

		node = new int[n + 1];
		visited = new int[n + 1];
		res = new int[n + 1];
		edge = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) { // Initialize edge lists
			edge[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) { // Read edges
			inp = br.readLine().split(" ");
			int u = Integer.parseInt(inp[0]); // First node of edge
			int v = Integer.parseInt(inp[1]); // Second node of edge
			edge[u].add(v); // Add v to the edge list of u
			edge[v].add(u); // Add u to the edge list of v
		}

		for (int i = 1; i <= n; i++) { // Sort the edge lists
			Collections.sort(edge[i]);
		}

		res[r] = 1;
		visited[r] = 1; // Set root as visited
		dfs(r); // Start DFS from root

		for (int i = 1; i <= n; i++) // Output the result
			bw.write(res[i] + "\n");

		bw.flush();
		bw.close();
	}
}
