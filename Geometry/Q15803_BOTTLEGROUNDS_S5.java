package Geometry;

//Commented by ChatGPT
//Summary: This Java code determines if three given points are collinear. If they are, it prints "WHERE IS MY CHICKEN?", otherwise, it prints "WINNER WINNER CHICKEN DINNER!".

import java.io.*;
import java.math.*;
import java.util.*;

//Define a pos class to hold the x and y coordinates of points.
//class pos {
//	int x;
//	int y;
//
//	pos(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//}

public class Q15803_BOTTLEGROUNDS_S5 {

	public static void main(String[] args) throws IOException {

		// Set up I/O and create a flag for the result.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean win = true;

		// Declare an array of pos objects to hold the 3 points.
		pos p[] = new pos[3];

		// Read the 3 points and initialize the pos objects.
		for (int i = 0; i < 3; i++) {
			String inp[] = br.readLine().split(" ");
			p[i] = new pos(Integer.parseInt(inp[0]), Integer.parseInt(inp[1]));
		}

		// Sort the points based on their x-values.
		Arrays.sort(p, (o1, o2) -> {
			return o1.x - o2.x;
		});

		// Calculate the slopes between the pairs of points.
		double x1 = p[1].x - p[0].x;
		double x2 = p[2].x - p[1].x;
		double y1 = p[1].y - p[0].y;
		double y2 = p[2].y - p[1].y;

		// Normalize the slopes.
		x1 /= y1;
		x2 /= y2;

		// If the slopes are equal, set the win flag to false.
		if (x1 == x2)
			win = false;

		// Write the output based on the win flag.
		if (win)
			bw.write("WINNER WINNER CHICKEN DINNER!");
		else
			bw.write("WHERE IS MY CHICKEN?");

		bw.flush();
		bw.close();

	}
}