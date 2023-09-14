package Geometry;

/* 
commented by ChatGPT
Summary: The Java program reads sets of 8 numbers (coordinates of 4 points) and determines 
the coordinates of a parallelogram's fourth point based on the other three points.
*/

import java.io.*;
import java.math.*;
import java.util.*;

public class Q1894_Fourth_Point_B1 {

	public static void main(String[] args) throws IOException {

		// Setting up buffered reader and writer for efficient IO operations
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s;

		// Infinite loop to continuously read inputs until a specific condition is met
		while (true) {

			// Reading the input line
			s = br.readLine();

			// Break condition: If the input string is null or empty, the loop terminates
			if (s == null || s.isEmpty())
				break;

			// Split the input string by spaces to retrieve individual coordinates
			String inp[] = s.split(" ");

			// Parsing coordinates of the 4 points
			double x1, x2, x3, x4;
			double y1, y2, y3, y4;

			x1 = Double.parseDouble(inp[0]);
			y1 = Double.parseDouble(inp[1]);
			x2 = Double.parseDouble(inp[2]);
			y2 = Double.parseDouble(inp[3]);
			x3 = Double.parseDouble(inp[4]);
			y3 = Double.parseDouble(inp[5]);
			x4 = Double.parseDouble(inp[6]);
			y4 = Double.parseDouble(inp[7]);

			// Using the properties of parallelograms to determine the coordinates of the
			// fourth point
			// The parallelogram sides are parallel and equal in length
			// Based on given 3 points, we determine the fourth point's coordinates
			if (x1 == x2 && y1 == y2) {
				x3 += x4 - x1;
				y3 += y4 - y1;
				bw.write(String.format("%.3f", x3) + " " + String.format("%.3f", y3) + "\n");
			} else if (x1 == x3 && y1 == y3) {
				x2 += x4 - x1;
				y2 += y4 - y1;
				bw.write(String.format("%.3f", x2) + " " + String.format("%.3f", y2) + "\n");
			} else if (x1 == x4 && y1 == y4) {
				x3 += x2 - x1;
				y3 += y2 - y1;
				bw.write(String.format("%.3f", x3) + " " + String.format("%.3f", y3) + "\n");
			} else if (x2 == x3 && y2 == y3) {
				x1 += x4 - x2;
				y1 += y4 - y2;
				bw.write(String.format("%.3f", x1) + " " + String.format("%.3f", y1) + "\n");
			} else if (x2 == x4 && y2 == y4) {
				x1 += x3 - x2;
				y1 += y3 - y2;
				bw.write(String.format("%.3f", x1) + " " + String.format("%.3f", y1) + "\n");
			} else {
				x1 += x2 - x3;
				y1 += y2 - y3;
				bw.write(String.format("%.3f", x1) + " " + String.format("%.3f", y1) + "\n");
			}
		}

		// Flush the buffered writer to ensure all data is written and close it
		bw.flush();
		bw.close();
	}
}
