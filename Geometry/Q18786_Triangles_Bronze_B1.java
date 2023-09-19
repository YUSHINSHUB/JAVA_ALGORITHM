package Geometry;

//Commented by ChatGPT
//Summary: This code finds the maximum area of a rectangle that can be formed using a given set of 2D points.

import java.io.*;

public class Q18786_Triangles_Bronze_B1 {

	public static void main(String[] args) throws IOException {

		// Setting up buffered reader and writer for efficient I/O operations.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Reading the total number of points.
		int n = Integer.parseInt(br.readLine());

		// Arrays to store x and y coordinates of each point.
		int x[] = new int[n];
		int y[] = new int[n];

		// Populating the x and y arrays with coordinates from user input.
		for (int i = 0; i < n; i++) {
			String inp[] = br.readLine().split(" "); // Splitting input based on space to get x and y.
			x[i] = Integer.parseInt(inp[0]);
			y[i] = Integer.parseInt(inp[1]);
		}

		int res = 0; // Variable to store the maximum area found so far.

		// Loop through each pair of points to check if they can form one of the edges
		// of a potential rectangle.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				// Check if the points (i and j) have the same x-coordinates (indicating a
				// vertical edge).
				if (x[i] == x[j] && y[i] != y[j]) {

					int temp = (int) Math.abs(y[i] - y[j]); // Calculating length of the vertical edge.

					// For the found vertical edge, searching for a horizontal edge using another
					// loop.
					for (int k = 0; k < n; k++) {
						if (y[i] == y[k] && x[i] != x[k]) {
							temp *= (int) Math.abs(x[i] - x[k]); // Calculating area of potential rectangle.

							// Update the result if the calculated area is larger than previous maximum.
							if (temp > res)
								res = temp;

							// Resetting the temp value to check for other potential horizontal edges.
							temp /= (int) Math.abs(x[i] - x[k]);
						}
					}
				}
			}
		}

		// Writing the maximum rectangle area to the output.
		bw.write(res + "");

		// Flushing and closing the writer.
		bw.flush();
		bw.close();
	}
}
