package Graph_Traversal;

//Commented by ChatGPT
//This Java program is for a recursive breadth-first search (BFS) in a 2D maze. 

import java.io.*;
import java.math.*;
import java.util.*;

public class Q2178_Maze_Traversal_S1 {

	// 2D arrays to hold the maze and the distances calculated by BFS.
	static int maze[][];
	static int bfs[][];

	// This recursive method implements the BFS algorithm.
	public static void recur(int n, int m) {

		// Checks the validity of the cell above and updates the distance if needed.
		if (maze[n - 1][m] == 1 && bfs[n - 1][m] > bfs[n][m] + 1) {
			bfs[n - 1][m] = bfs[n][m] + 1;
			recur(n - 1, m);
		}

		// Checks the validity of the cell to the right and updates the distance if
		// needed.
		if (maze[n][m + 1] == 1 && bfs[n][m + 1] > bfs[n][m] + 1) {
			bfs[n][m + 1] = bfs[n][m] + 1;
			recur(n, m + 1);
		}

		// Checks the validity of the cell below and updates the distance if needed.
		if (maze[n + 1][m] == 1 && bfs[n + 1][m] > bfs[n][m] + 1) {
			bfs[n + 1][m] = bfs[n][m] + 1;
			recur(n + 1, m);
		}

		// Checks the validity of the cell to the left and updates the distance if
		// needed.
		if (maze[n][m - 1] == 1 && bfs[n][m - 1] > bfs[n][m] + 1) {
			bfs[n][m - 1] = bfs[n][m] + 1;
			recur(n, m - 1);
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int m = Integer.parseInt(inp[1]);

		maze = new int[n + 2][m + 2];
		bfs = new int[n + 2][m + 2];

		// Initializing the BFS distances to a large number.
		Arrays.fill(bfs[0], Integer.MAX_VALUE);
		Arrays.fill(bfs[n + 1], Integer.MAX_VALUE);

		for (int i = 1; i <= n; i++) {
			Arrays.fill(bfs[i], Integer.MAX_VALUE);
			inp = br.readLine().split("");
			for (int j = 1; j <= m; j++) {
				maze[i][j] = Integer.parseInt(inp[j - 1]);
			}
		}

		// The BFS distance from the first cell to itself is 1.
		bfs[1][1] = 1;

		// Starting the BFS from the first cell.
		recur(1, 1);

		// Writing the shortest distance to the last cell.
		bw.write(bfs[n][m] + "");

		bw.flush();
		bw.close();
	}
}
