package Graph_Theory;

/* 
Commented by ChatGPT
This code is designed to simulate the formation and counting of various towns in a 2D grid. The code uses recursion to traverse the grid and increment the town count. 

*/

import java.io.*;
import java.util.*;

public class Q2667_Address_S1 {

	// Declaring global variables
	static int town[][]; // 2D grid representing the area
	static int cur = 0; // Current position in the grid

	// Recursion function to traverse the grid
	public static void recur(int x, int y) {

		cur++; // Increase current position count
		town[x][y] = 0; // Visited position in town is marked as 0

		// If there's a town in the adjacent cells, recursive call is made
		if (town[x + 1][y] == 1)
			recur(x + 1, y);
		if (town[x][y + 1] == 1)
			recur(x, y + 1);
		if (town[x - 1][y] == 1)
			recur(x - 1, y);
		if (town[x][y - 1] == 1)
			recur(x, y - 1);

		return;

	}

	// Main function to handle the logic
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine()); // Size of the grid
		int t = 0; // Total towns count
		ArrayList<Integer> cnt = new ArrayList<>(); // List to store the number of towns
		town = new int[n + 2][n + 2]; // Initializing the 2D grid

		// Fill the outermost row and column with 0 as they don't represent a town
		Arrays.fill(town[0], 0);
		Arrays.fill(town[n + 1], 0);

		// Fill the 2D grid with input values
		for (int i = 1; i <= n; i++) {
			Arrays.fill(town[i], 0);
			String inp[] = br.readLine().split("");
			for (int j = 1; j <= n; j++) {
				town[i][j] = Integer.parseInt(inp[j - 1]);
			}
		}

		// Traversing the grid to find and count towns
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (town[i][j] == 1) { // If a town is found
					t++; // Increment town count
					cur = 0; // Reset current position count
					recur(i, j); // Call the recursion function
					cnt.add(cur); // Add the current town count to the list
				}
			}
		}

		// Sort the towns count list
		Collections.sort(cnt);

		// Write the total towns count to the output
		bw.write(t + "\n");

		// Write each town's count to the output
		for (int i = 0; i < t; i++)
			bw.write(cnt.get(i) + "\n");

		bw.flush();
		bw.close();

	}
}
