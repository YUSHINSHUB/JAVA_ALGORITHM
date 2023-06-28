package Dynamic_Programming;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q1010_Construct_Bridge_S5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		String inp[] = new String[2];
		long n = 0, m = 0, r = 0;
		long res = 1;

		for (int i = 0; i < t; i++) {
			res = 1;
			inp = br.readLine().split(" ");
			n = Integer.parseInt(inp[0]);
			m = Integer.parseInt(inp[1]);
			r = m - n;
			if (r == 0)
				r = 1;

			for (long z = Math.max(r, n) + 1; z <= m; z++) {
				res *= z;
			}

			if (r >= n) {
				for (long z = 2; z <= n; z++) {
					res /= z;
				}
			} else {
				for (long z = 2; z <= r; z++) {
					res /= z;
				}
			}

			bw.write(res + "\n");

		}

		bw.flush();
		bw.close();

	}
}