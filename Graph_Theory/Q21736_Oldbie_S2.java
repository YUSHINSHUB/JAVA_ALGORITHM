package Graph_Theory;

//Commented by ChatGPT
//This program determines the number of 'P' cells reachable from the cell with 'I' character in a grid using BFS traversal.

import java.io.*;
import java.util.*;

public class Q21736_Oldbie_S2 {

	// Define global variables
	static String grp[]; // Grid represented as an array of strings
	static boolean visited[][]; // 2D boolean array to keep track of visited cells in the grid
	static int trax[] = { 1, 0, -1, 0 }; // Array representing possible moves in x-direction during BFS traversal
	static int tray[] = { 0, 1, 0, -1 }; // Array representing possible moves in y-direction during BFS traversal
	static int n, m; // Integers representing the dimensions of the grid
	static int res = 0; // Integer representing the number of reachable 'P' cells

	// BFS traversal function starting from cell with coordinates (y, x)
	static void bfs(int y, int x) {

		// Mark the starting cell as visited
		visited[y][x] = true;

		// Declare queues to store coordinates of cells in BFS traversal
		Queue<Integer> px = new LinkedList<>();
		Queue<Integer> py = new LinkedList<>();

		// Add the starting cell coordinates to the queues
		px.add(x);
		py.add(y);

		// Continue BFS traversal while there are cells in the queue
		while (!px.isEmpty()) {

			// Get the coordinates of the current cell
			int curx = px.poll();
			int cury = py.poll();

			// Iterate through possible moves from the current cell
			for (int i = 0; i < 4; i++) {
				int xnext = curx + trax[i];
				int ynext = cury + tray[i];

				// Check for valid next cell coordinates
				if (xnext < 0 || ynext < 0 || xnext >= m || ynext >= n)
					continue;
				// Check if the next cell is an 'X' cell
				if (grp[ynext].charAt(xnext) == 'X')
					continue;
				// Check if the next cell has already been visited
				if (visited[ynext][xnext] == true)
					continue;

				// Mark the next cell as visited
				visited[ynext][xnext] = true;

				// Increment the count of reachable 'P' cells
				if (grp[ynext].charAt(xnext) == 'P')
					res++;

				// Add the next cell coordinates to the queues
				px.add(xnext);
				py.add(ynext);

			}
		}

	}

	public static void main(String[] args) throws IOException {

		// Set up buffered readers and writers for I/O operations
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read the dimensions of the grid from the input
		String inp[] = br.readLine().split(" ");
		n = Integer.parseInt(inp[0]);
		m = Integer.parseInt(inp[1]);
		int y = 0, x = 0;

		// Initialize the grp and visited arrays
		grp = new String[n];
		visited = new boolean[n][m];

		// Read the input grid and find the coordinates of the cell with 'I' character
		for (int i = 0; i < n; i++) {
			grp[i] = br.readLine();
			Arrays.fill(visited[i], false);
			for (int j = 0; j < m; j++) {
				if (grp[i].charAt(j) == 'I') {
					y = i;
					x = j;
				}
			}
		}

		// Call the BFS traversal function with the coordinates of the cell with 'I'
		// character
		bfs(y, x);

		// Write the result to the output
		if (res == 0)
			bw.write("TT");
		else
			bw.write(res + "");

		// Flush and close the buffered writer
		bw.flush();
		bw.close();

	}
}
