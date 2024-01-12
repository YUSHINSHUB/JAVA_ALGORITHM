package Geometry;

import java.io.*;

public class Q9063_Land_B3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int lx = Integer.MAX_VALUE;
		int ly = Integer.MAX_VALUE;
		int hx = Integer.MIN_VALUE;
		int hy = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			String inp[] = br.readLine().split(" ");
			int y = Integer.parseInt(inp[0]);
			int x = Integer.parseInt(inp[1]);
			if (y < ly)
				ly = y;
			if (y > hy)
				hy = y;
			if (x < lx)
				lx = x;
			if (x > hx)
				hx = x;
		}

		hy -= ly;
		hx -= lx;

		bw.write(hy * hx + "");
		bw.flush();
		bw.close();

	}
}