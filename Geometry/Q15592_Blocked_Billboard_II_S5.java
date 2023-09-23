package Geometry;

//Commented by ChatGPT
//Summary: This Java code calculates the area of a rectangle (L) that remains visible after being possibly overlapped by another rectangle (F).

import java.io.*;

public class Q15592_Blocked_Billboard_II_S5 {

	public static void main(String[] args) throws IOException {

		// Initialize input and output streams.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read and parse the coordinates of the first rectangle (L).
		String inp[] = br.readLine().split(" ");
		int lx1 = Integer.parseInt(inp[0]);
		int ly1 = Integer.parseInt(inp[1]);
		int lx2 = Integer.parseInt(inp[2]);
		int ly2 = Integer.parseInt(inp[3]);

		// Calculate the lengths of the sides of rectangle L.
		int lxlen = lx2 - lx1;
		int lylen = ly2 - ly1;
		int res = lxlen * lylen; // Initial area of rectangle L.

		// Read and parse the coordinates of the second rectangle (F).
		inp = br.readLine().split(" ");
		int fx1 = Integer.parseInt(inp[0]);
		int fy1 = Integer.parseInt(inp[1]);
		int fx2 = Integer.parseInt(inp[2]);
		int fy2 = Integer.parseInt(inp[3]);

		// Calculate the lengths of the sides of rectangle F.
		int fxlen = fx2 - fx1;
		int fylen = fy2 - fy1;

		// Check the overlapping conditions between rectangle L and rectangle F.
		if (fy1 <= ly1 && fy2 >= ly2) {
			// When F entirely overlaps L vertically.
			if (fx1 <= lx1 && fx2 >= lx2) {
				// When F entirely overlaps L.
				res = 0;
			} else if (fx1 >= lx1 && fx1 <= lx2 && fx2 >= lx2) {
				// When F overlaps the right side of L.
				res = lylen * (fx1 - lx1);
			} else if (fx1 <= lx1 && fx2 <= lx2 && fx2 >= lx1) {
				// When F overlaps the left side of L.
				res = lylen * (lx2 - fx2);
			}
		} else if (fx1 <= lx1 && fx2 >= lx2) {
			// When F entirely overlaps L horizontally.
			if (fy1 >= ly1 && fy1 <= ly2 && fy2 >= ly2) {
				// When F overlaps the top of L.
				res = lxlen * (fy1 - ly1);
			} else if (fy1 <= ly1 && fy2 <= ly2 && fy2 >= ly1) {
				// When F overlaps the bottom of L.
				res = lxlen * (ly2 - fy2);
			}
		}

		// Write the resulting area to the output.
		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}