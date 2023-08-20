package Graph_Theory;

//Commented by ChatGPT
//This Java program reads a graph as input and calculates the number of connected components in the graph using a BFS algorithm. 
//The graph is represented using an adjacency list.

import java.util.*;
import java.io.*;

class Q11724_Connected_Component_S2 {
	// BFS algorithm to traverse the connected component starting from vertex i
	static void get(int i, int[][] Line, boolean[] bl) {
		// Initialize a queue to store vertices to be visited
		Queue<Integer> q = new LinkedList<>();

		// Add the starting vertex to the queue
		q.add(i);

		// While there are vertices to be visited
		while (!q.isEmpty()) {
			// Dequeue a vertex from the queue
			int z = q.poll();

			// For each adjacent vertex
			for (int x = 0; x < Line[z][0]; x++) {
				int y = Line[z][x + 1];

				// If the adjacent vertex is not visited, add it to the queue and mark it as
				// visited
				if (!bl[y]) {
					q.add(y);
					bl[y] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// Initialize a BufferedReader to read input from standard input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// Number of vertices and number of edges
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		// Counter to track the number of connected components
		int cnt = 0;

		// Array to represent the adjacency list of the graph
		int[][] Line = new int[1001][1001];
		// Array to track whether a vertex is visited or not
		boolean[] bl = new boolean[a + 1];

		// Read the edges of the graph
		for (int i = 0; i < b; i++) {

			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			// Add the edge to the adjacency list
			Line[n][++Line[n][0]] = m;
			Line[m][++Line[m][0]] = n;
		}

		// For each vertex
		for (int i = 1; i <= a; i++) {
			// If the vertex is not visited
			if (!bl[i]) {
				// Mark it as visited
				bl[i] = true;

				// Traverse the connected component starting from the vertex
				get(i, Line, bl);

				// Increase the counter of connected components
				cnt++;

			}
		}

		// Print the number of connected components
		System.out.println(cnt);

	}
}
