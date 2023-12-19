package Recursion;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q1074_Z_S1 {

	protected static int pl = 0;

	protected static int calc(int n, int r, int c, int low, int hig) {

		n--;
		int res = 0;

		int line = (int) Math.pow(2, n - 1);
		int temp = (hig - low) / 4;

		if (r > line && c > line) {
			low += temp * 3;
			r -= line;
			c -= line;
			if (line == 1)
				return low;
			else
				res = calc(n, r, c, low, hig);
		} else if (r <= line && c <= line) {
			hig = low + temp;
			if (line == 1)
				return low;
			else
				res = calc(n, r, c, low, hig);
		} else if (r > line) {
			low += temp * 2;
			hig = low + temp;
			r -= line;
			if (line == 1)
				return low;
			else
				res = calc(n, r, c, low, hig);
		} else if (c > line) {
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

		bw.write((res) + "");

		bw.flush();
		bw.close();

	}
}