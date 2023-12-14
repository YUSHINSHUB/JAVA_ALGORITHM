package Breadth_first_Search;

//commented by ChatGPT
//Summary: A Java program that simulates the spreading process in a 2D grid using BFS. 
//The result indicates the days required for complete spread or -1 if not all cells are reached.

import java.io.*;
import java.util.*;

public class Q7576_Tomato_G5 {

	// The main grid where the spread is simulated.
	static int tom[][];

	// Variable to keep track of the number of days for complete spread.
	static int res = 0;

	// Queues to keep track of the y and x coordinates for BFS traversal.
	static Queue<Integer> y = new LinkedList<>();
	static Queue<Integer> x = new LinkedList<>();

	// Possible movement directions in the y and x axis.
	static int yp[] = { 1, -1, -1, 1 };
	static int xp[] = { 0, 1, -1, -1 };

	// Dimensions of the grid.
	static int n, m;

	// Function to perform Breadth-First Search on the grid.
	static void bfs() {
		while (!y.isEmpty()) {
			int s = y.size();
			for (int j = 0; j < s; j++) {
				int ypos = y.poll();
				int xpos = x.poll();

				// Attempt to spread in all 4 directions.
				for (int i = 0; i < 4; i++) {
					ypos += yp[i];
					xpos += xp[i];

					// Check boundaries and if the cell can be affected.
					if (ypos == 0 || ypos == m + 1 || xpos == 0 || xpos == n + 1)
						continue;
					else if (tom[ypos][xpos] == -1 || tom[ypos][xpos] == 1)
						continue;
					else {
						tom[ypos][xpos] = 1;
						y.add(ypos);
						x.add(xpos);
					}
				}
			}
			res++; // Increment day count after each BFS level.
		}
		res--; // Decrement as the final BFS level doesn't contribute to days.
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Reading the dimensions of the grid.
		String inp[] = br.readLine().split(" ");
		n = Integer.parseInt(inp[0]);
		m = Integer.parseInt(inp[1]);
		tom = new int[m + 2][n + 2];

		// Populating the grid and initializing the BFS start points.
		for (int i = 1; i <= m; i++) {
			inp = br.readLine().split(" ");
			for (int j = 1; j <= n; j++) {
				tom[i][j] = Integer.parseInt(inp[j - 1]);
				if (tom[i][j] == 1) {
					y.add(i);
					x.add(j);
				}
			}
		}

		// Execute BFS
		bfs();

		// Check if there are unspread cells left.
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (tom[i][j] == 0)
					res = -1; // Indicates incomplete spread.
			}
		}

		// Write the result.
		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}
