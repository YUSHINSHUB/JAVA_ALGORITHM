package Geometry;

/* 
commented by ChatGPT
Summary: The Java program reads a matrix and finds the distance between the first two 
occurrences of the number "1" in the matrix.
*/

import java.io.*;
import java.util.*;

public class Q17247_Taxi_Distance_B1 {

	public static void main(String[] args) throws IOException {

		// Initial setup for reading from and writing to console
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read n and m, the dimensions of the matrix
		String inp[] = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int m = Integer.parseInt(inp[1]);

		// Initialize coordinate variables to store positions of the two occurrences of
		// "1"
		int x1 = -1;
		int x2 = -1;
		int y1 = -1;
		int y2 = -1;

		// Iterate over the matrix
		for (int i = 0; i < n; i++) {
			inp = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				if (inp[j].equals("1")) {
					if (x1 == -1) {
						// If this is the first occurrence of "1", store its position
						x1 = j;
						y1 = i;
					} else {
						// If this is the second occurrence, store its position and break out of loop
						x2 = j;
						y2 = i;
						break;
					}
				}
			}
			// If both occurrences have been found, break out of outer loop
			if (x2 >= 0)
				break;
		}

		// Compute and write the Manhattan distance between the two occurrences of "1"
		bw.write(Math.abs(x2 - x1) + Math.abs(y2 - y1) + "");

		// Flush and close the writer
		bw.flush();
		bw.close();
	}
}
