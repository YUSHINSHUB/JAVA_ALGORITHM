package Geometry;

//Commented by ChatGPT
//Summary: This Java program determines the maximum and minimum perimeter of a parallelogram formed by three input points and one calculated point, 
//		then computes the difference between the maximum and minimum perimeter.

import java.io.*;
import java.math.*;

public class Q1064_PARALLELOGRAM_S4 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read input and parse coordinates of the three points.
		String inp[] = br.readLine().split(" ");
		int x1 = Integer.parseInt(inp[0]);
		int y1 = Integer.parseInt(inp[1]);
		int x2 = Integer.parseInt(inp[2]);
		int y2 = Integer.parseInt(inp[3]);
		int x3 = Integer.parseInt(inp[4]);
		int y3 = Integer.parseInt(inp[5]);

		// Check if the three points are collinear.
		if ((x2 - x1) * (y3 - y1) == (x3 - x1) * (y2 - y1)) {
			System.out.println(-1);
			return;
		}

		else {
			// Variables to store coordinates of start, middle and end points respectively.
			double sx, sy, mx, my, ex, ey, x4, y4;
			// Variables to store lengths of sides.
			double len1, len2;
			// Variables to store computed perimeters.
			double res1, res2, res3;

			// 1st configuration of points
			sx = x2;
			sy = y2;
			mx = x1;
			my = y1;
			ex = x3;
			ey = y3;
			x4 = sx + (ex - mx);
			y4 = sy + (ey - my);
			len1 = Math.sqrt(Math.pow(mx - sx, 2) + Math.pow(my - sy, 2));
			len2 = Math.sqrt(Math.pow(sx - x4, 2) + Math.pow(sy - y4, 2));
			res1 = 2 * len1 + 2 * len2;

			// 2nd configuration of points
			sx = x1;
			sy = y1;
			mx = x2;
			my = y2;
			ex = x3;
			ey = y3;
			x4 = sx + (ex - mx);
			y4 = sy + (ey - my);
			len1 = Math.sqrt(Math.pow(mx - sx, 2) + Math.pow(my - sy, 2));
			len2 = Math.sqrt(Math.pow(sx - x4, 2) + Math.pow(sy - y4, 2));
			res2 = 2 * len1 + 2 * len2;

			// 3rd configuration of points
			sx = x1;
			sy = y1;
			mx = x3;
			my = y3;
			ex = x2;
			ey = y2;
			x4 = sx + (ex - mx);
			y4 = sy + (ey - my);
			len1 = Math.sqrt(Math.pow(mx - sx, 2) + Math.pow(my - sy, 2));
			len2 = Math.sqrt(Math.pow(sx - x4, 2) + Math.pow(sy - y4, 2));
			res3 = 2 * len1 + 2 * len2;

			// Compute maximum and minimum perimeter.
			double r1 = Math.min(res1, Math.min(res2, res3));
			double r2 = Math.max(res1, Math.max(res2, res3));

			// Write the difference of maximum and minimum perimeter to output.
			bw.write(r2 - r1 + "");
		}

		bw.flush();
		bw.close();
	}
}