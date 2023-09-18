package Geometry_3d;

/*
commented by ChatGPT
Summary: Java program that reads a set of coordinates (dx, dy, dz) and calculates the number 
of points that lie inside multiple spheres with given coordinates and radii.
*/

import java.io.*;
import java.math.*;
import java.util.*;

public class Q13552_Sphere_and_Quarry_B1 {

	public static void main(String[] args) throws IOException {

		// Buffer Reader and Writer for efficient I/O operations
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read the number of points to consider
		int n = Integer.parseInt(br.readLine());

		// Initialize arrays to store the coordinates for each point
		int dx[] = new int[n];
		int dy[] = new int[n];
		int dz[] = new int[n];

		// Populate the dx, dy, dz arrays with input coordinates
		for (int i = 0; i < n; i++) {
			String inp[] = br.readLine().split(" ");
			dx[i] = Integer.parseInt(inp[0]);
			dy[i] = Integer.parseInt(inp[1]);
			dz[i] = Integer.parseInt(inp[2]);
		}

		// Read the number of spheres to consider
		int m = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder(""); // StringBuilder for efficient string concatenation

		// Iterate through each sphere and calculate how many points lie within it
		for (int i = 0; i < m; i++) {
			String inp[] = br.readLine().split(" ");
			int x = Integer.parseInt(inp[0]);
			int y = Integer.parseInt(inp[1]);
			int z = Integer.parseInt(inp[2]);
			long r = Integer.parseInt(inp[3]);
			r *= r; // Square the radius for distance comparisons
			int res = 0;

			// Check each point's distance to the sphere's center and determine if it's
			// inside the sphere
			for (int j = 0; j < n; j++) {
				long a = x - dx[j];
				long b = y - dy[j];
				long c = z - dz[j];
				if ((a * a + b * b + c * c) <= r)
					res++;
			}
			sb.append(res + "\n"); // Add the result for the current sphere to the output string
		}

		// Write the final output and close the BufferedWriter
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
