package Divide_and_Conquer;

/*
Commented by ChatGPT
Summary: This Java program recursively calculates the value of a cell in a Z-shaped matrix. 
The matrix is created by recursively partitioning it into four equal quadrants, following a Z-shaped pattern. The program receives three integers, n, r, and c, and calculates the value of 
the cell located at row r and column c of the matrix of size 2^n x 2^n.
*/

import java.io.*;

public class Q1074_Z_S1 {

	protected static int pl = 0;

	// Recursive function to calculate the value of a cell in a Z-shaped matrix
	protected static int calc(int n, int r, int c, int low, int hig) {
		n--;
		int res = 0;

		int line = (int) Math.pow(2, n - 1); // Calculate the midpoint of the matrix
		int temp = (hig - low) / 4; // Calculate the interval size for each quadrant

		if (r > line && c > line) { // Bottom-right quadrant
			low += temp * 3;
			r -= line;
			c -= line;
			if (line == 1)
				return low;
			else
				res = calc(n, r, c, low, hig);
		} else if (r <= line && c <= line) { // Top-left quadrant
			hig = low + temp;
			if (line == 1)
				return low;
			else
				res = calc(n, r, c, low, hig);
		} else if (r > line) { // Bottom-left quadrant
			low += temp * 2;
			hig = low + temp;
			r -= line;
			if (line == 1)
				return low;
			else
				res = calc(n, r, c, low, hig);
		} else if (c > line) { // Top-right quadrant
			low += temp;
			hig = low + temp;
			c -= line;
			if (line == 1)
				return low;
			else
				res = calc(n, r, c, low, hig);
		}
		return res;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int r = Integer.parseInt(inp[1]);
		int c = Integer.parseInt(inp[2]);
		r++;
		c++;

		int hig = (int) Math.pow(4, n);
		int line = (int) Math.pow(2, n - 1);

		n++;
		int res = calc(n, r, c, 0, hig);

		bw.write((res) + ""); // Output the result

		bw.flush();
		bw.close();
	}
}
