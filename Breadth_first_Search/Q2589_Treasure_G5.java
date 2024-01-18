package Breadth_first_Search;

//commented by ChatGPT
//Summary: The Java program finds the maximum distance from a starting point 'L' on a grid (with obstacles marked as 'W') using a breadth-first search (BFS) algorithm.

import java.io.*;
import java.util.*;

public class Q2589_Treasure_G5 {

	// Map to store the grid. It's static since it's used across static methods.
	static char map[][] = new char[50][50];
	// 2D array to store calculated BFS distances from a starting point.
	static int calc[][] = new int[50][50];
	// Movement vectors for BFS
	static int ypos[] = { 1, 0, -1, 0 };
	static int xpos[] = { 0, 1, 0, -1 };
	// Dimensions of the map.
	static int n, m;
	// Result to store the maximum distance found.
	static int res = 0;

	// BFS method to traverse the grid.
	static void bfs(int y, int x) {

		Queue<Integer> yq = new LinkedList<>();
		Queue<Integer> xq = new LinkedList<>();
		yq.add(y);
		xq.add(x);

		while (!yq.isEmpty()) {

			int yt = yq.poll();
			int xt = xq.poll();

			for (int i = 0; i < 4; i++) {
				int yp = yt + ypos[i];
				int xp = xt + xpos[i];
				if (yp < 0 || yp >= n || xp < 0 || xp >= m) // Boundary check
					continue;
				else if (map[yp][xp] == 'W') // Obstacle check
					continue;
				else if (calc[yp][xp] >= 0) // Visited node check
					continue;
				else {
					calc[yp][xp] = calc[yt][xt] + 1; // Increment distance
					yq.add(yp);
					xq.add(xp);
					if (calc[yp][xp] > res)
						res = calc[yp][xp]; // Update max distance if current distance is larger
				}
			}

		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Parse the dimensions of the grid
		String inp[] = br.readLine().split(" ");
		n = Integer.parseInt(inp[0]);
		m = Integer.parseInt(inp[1]);

		// Input the map
		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = temp.charAt(j);
			}
		}

		// Start BFS from each 'L' point on the grid
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'L') {
					// Reset calculated distances for BFS
					for (int k = 0; k < n; k++)
						Arrays.fill(calc[k], -1);
					calc[i][j] = 0; // Starting point distance is 0
					bfs(i, j); // Run BFS from this point
				}
			}
		}

		// Write out the maximum distance found
		bw.write(res + "");
		bw.flush();
		bw.close();

	}
}