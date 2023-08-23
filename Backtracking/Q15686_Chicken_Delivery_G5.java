package Backtracking;

/*
 * Problem Description:
 * Find the minimum distance between houses and chicken houses in a 2D grid.
 *
 * commented by ChatGPT
 * Summary:
 * 1. Create an ArrayList for chicken places and homes.
 * 2. Use backtracking to compute minimum distance.
 * 3. Read input, call the backtracking function, and write the result.
 */

import java.io.*;
import java.util.*;

// Class to store coordinates of places (either chicken house or home).
class place {
	int x;
	int y;

	// Constructor initializes with given coordinates.
	place(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Q15686_Chicken_Delivery_G5 {

	// Global variables for grid size, the count of chicken houses to be chosen, and
	// result.
	static int n;
	static int m;
	static ArrayList<place> chp = new ArrayList<place>(); // Stores chicken house coordinates.
	static ArrayList<place> hop = new ArrayList<place>(); // Stores home coordinates.
	static boolean[] pick; // Used in backtracking to mark picked chicken houses.
	static int res;

	// Backtracking function.
	static void bt(int sidx, int cnt) {
		int sum = 0;
		int temp = 0;
		int min = Integer.MAX_VALUE;

		// If m chicken houses are selected.
		if (cnt == m) {
			// For each home, find its distance to the nearest chicken house.
			for (int z = 0; z < hop.size(); z++) {
				min = Integer.MAX_VALUE;
				for (int i = 0; i < chp.size(); i++) {
					if (pick[i]) {
						temp = Math.abs(hop.get(z).x - chp.get(i).x) + Math.abs(hop.get(z).y - chp.get(i).y);
						min = Math.min(temp, min);
					}
				}
				sum += min; // Accumulate the total distance for this combination of chicken houses.
			}
			res = Math.min(sum, res); // Update the result if this is a better solution.
			return;
		} else {
			// Recurse by selecting next chicken house.
			for (int i = sidx; i < chp.size(); i++) {
				if (!pick[i]) {
					pick[i] = true;
					bt(i + 1, cnt + 1);
					pick[i] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String in[] = br.readLine().split(" ");
		n = Integer.parseInt(in[0]);
		m = Integer.parseInt(in[1]);
		res = Integer.MAX_VALUE;

		// Reading input grid.
		for (int i = 0; i < n; i++) {
			in = br.readLine().split(" ");
			for (int z = 0; z < n; z++) {
				if (in[z].equals("1")) { // Home.
					hop.add(new place(z, i));
				} else if (in[z].equals("2")) { // Chicken house.
					chp.add(new place(z, i));
				}
			}
		}

		// Initialize pick array and call the backtracking function.
		pick = new boolean[chp.size()];
		bt(0, 0);

		// Write the result and close resources.
		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}
