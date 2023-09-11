package Geometry;

/*
commented by ChatGPT
Summary: The Java program calculates the area of a circle using two different methods and outputs both results. The first method employs the traditional formula (pi*r^2), and the second uses the "taxicab" or "Manhattan" geometry formula (2*r^2).
*/

import java.io.*;
import java.util.*;

public class Q3053_Taxi_Geometry_B3 {

	public static void main(String[] args) throws IOException {

		// Setup for reading input and writing output.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read the radius of the circle.
		int r = Integer.parseInt(br.readLine());

		// Calculate the area using standard Euclidean geometry.
		double uc = (double) r * (double) r * Math.PI;
		// Calculate the area using taxicab (Manhattan) geometry.
		int tx = r * r * 2;

		// Write both results to the output.
		bw.write(String.valueOf(uc) + "\n" + String.valueOf(tx));

		// Flush and close the writer.
		bw.flush();
		bw.close();
	}
}
