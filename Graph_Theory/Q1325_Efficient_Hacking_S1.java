package Graph_Theory;

/*
Commented by ChatGPT

Summary: 
This program performs a Breadth-First Search (BFS) from each node in a directed graph. It counts the number of reachable nodes from each node, and identifies the node(s) from which the maximum number of other nodes can be reached.

Detailed Comments:
*/

import java.io.*;
import java.util.*;

public class Q1325_Efficient_Hacking_S1 {

	static int visited[]; // Array to keep track of visited nodes during BFS
	static int cur = 0; // Variable to count the number of nodes visited during a BFS
	static ArrayList<Integer>[] node; // Adjacency list to represent the graph

	public static void bfs(int idx) { // Function to perform a BFS starting from node idx

		Queue<Integer> q = new LinkedList<>(); // Queue to manage the BFS
		q.add(idx); // Adding the starting node to the queue
		cur++; // Incrementing the count of nodes visited
		visited[idx] = 1; // Marking the starting node as visited

		while (!q.isEmpty()) { // While there are still nodes to visit in the queue
			int n = q.poll(); // Remove the node from the queue
			for (int temp : node[n]) { // Go through all the adjacent nodes
				if (visited[temp] == 0) { // If the node has not been visited
					q.add(temp); // Add it to the queue
					visited[temp] = 1; // Mark it as visited
					cur++; // Increment the count of nodes visited
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" "); // Read the input
		int n = Integer.parseInt(inp[0]); // Number of nodes
		int hig = 0; // Initialize maximum reachable nodes
		int m = Integer.parseInt(inp[1]); // Number of edges
		int scr[] = new int[n + 1]; // Array to store the number of reachable nodes for each node
		visited = new int[n + 1]; // Initialize visited array
		node = new ArrayList[n + 1]; // Initialize adjacency list

		for (int i = 1; i <= n; i++)
			node[i] = new ArrayList<>(); // Initialize the array list for each node

		for (int i = 0; i < m; i++) { // Read edges
			inp = br.readLine().split(" ");
			int a = Integer.parseInt(inp[0]);
			int b = Integer.parseInt(inp[1]);
			node[b].add(a); // Add 'a' to the list of nodes reachable from 'b'
		}

		for (int i = 1; i <= n; i++) { // For each node
			visited = new int[n + 1]; // Reset visited array
			cur = 0; // Reset count of nodes visited
			bfs(i); // Perform BFS from node i
			scr[i] = cur; // Store the number of reachable nodes from node i
			if (cur > hig) // If this number is greater than the current maximum
				hig = cur; // Update the maximum
		}

		StringBuilder res = new StringBuilder("");
		for (int i = 1; i <= n; i++) { // For each node
			if (scr[i] == hig) // If the number of reachable nodes from this node is equal to the maximum
				res.append(i + " "); // Add the node to the result
		}

		bw.write(res.toString()); // Write the result
		bw.flush();
		bw.close();
	}
}
