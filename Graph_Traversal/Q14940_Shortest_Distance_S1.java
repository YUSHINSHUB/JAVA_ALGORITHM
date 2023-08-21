package Graph_Traversal;

//Commented by ChatGPT
//Summary: This Java program calculates the shortest path from a specified point to each cell in a grid using BFS. 
//If a cell is not reachable, it outputs -1.

import java.io.*;
import java.util.*;

public class Q14940_Shortest_Distance_S1 {
	// Declare arrays to hold input grid, result, and visited status
	static int grp[][]; // Input grid with cell values
	static int res[][]; // Array to store the shortest path to each cell
	static int nexty[] = { 1, 0, -1, 0 }; // Array to indicate vertical direction for BFS (down, none, up, none)
	static int nextx[] = { 0, 1, 0, -1 }; // Array to indicate horizontal direction for BFS (none, right, none, left)
	static boolean visited[][]; // Array to track whether each cell has been visited or not
	static int n, m; // Dimensions of the input grid (rows and columns)

	// BFS function to calculate the shortest path from a specified cell to all
	// other cells in the grid
	static void bfs(int i, int j) {
		// Declare queues to hold the coordinates of cells to be visited
		Queue<Integer> yq = new LinkedList<>(); // Queue for y-coordinates (vertical)
		Queue<Integer> xq = new LinkedList<>(); // Queue for x-coordinates (horizontal)

		// Add the initial cell coordinates to the queues and mark it as visited
		yq.add(i);
		xq.add(j);
		visited[i][j] = true;

		// BFS algorithm to explore the cells
		while (!yq.isEmpty()) {
			// Get the current cell coordinates from the queues
			int cy = yq.poll(); // Current y-coordinate
			int cx = xq.poll(); // Current x-coordinate

			// Loop through the four possible directions from the current cell
			for (int k = 0; k < 4; k++) {
				int ny = cy + nexty[k]; // Calculate next y-coordinate
				int nx = cx + nextx[k]; // Calculate next x-coordinate

				// Check for out-of-bound coordinates, already visited cells, or cells marked as
				// inaccessible (res = 0)
				if (ny < 0 || nx < 0 || ny >= n || nx >= m)
					continue;
				else if (visited[ny][nx])
					continue;
				else if (res[ny][nx] == 0)
					continue;

				// Mark the next cell as visited and update the shortest path in the result
				// array
				visited[ny][nx] = true;
				res[ny][nx] = res[cy][cx] + 1; // Increment path length

				// Add the next cell coordinates to the queues for further exploration
				yq.add(ny);
				xq.add(nx);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// Set up buffered readers and writers for input and output
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read the dimensions of the grid from the input
		String inp[] = br.readLine().split(" ");
		n = Integer.parseInt(inp[0]);
		m = Integer.parseInt(inp[1]);
		int x = 0, y = 0;

		// Initialize the input grid, result array, and visited status array
		grp = new int[n][m];
		res = new int[n][m];
		visited = new boolean[n][m];

		// Initialize the result array with a large value and visited status as false
		for (int i = 0; i < n; i++) {
			Arrays.fill(res[i], 10000000);
			Arrays.fill(visited[i], false);
		}

		// Read the input grid and identify the starting point (cell with value 2)
		for (int i = 0; i < n; i++) {
			inp = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				int t = Integer.parseInt(inp[j]);
				grp[i][j] = t;
				if (t == 0 || t == 2) {
					if (t == 2) {
						y = i; // Starting point y-coordinate
						x = j; // Starting point x-coordinate
					}
					res[i][j] = 0; // Mark starting and inaccessible cells as 0 in result array
				}
			}
		}

		// Call the BFS function with the starting point coordinates
		bfs(y, x);

		// Write the result array to the output, replacing unreachable cells with -1
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (res[i][j] == 10000000)
					bw.write("-1 ");
				else
					bw.write(res[i][j] + " ");
			}
			bw.write("\n");
		}

		// Flush and close the output writer
		bw.flush();
		bw.close();
	}
}
