package Simulation;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q3985_Swiss_Roll_B1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int l = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		Boolean cake[] = new Boolean[l];
		int scr[] = new int[n];
		Arrays.fill(scr, 0);
		Arrays.fill(cake, true);
		String inp[];

		int pscr = Integer.MIN_VALUE;
		int res1 = 0;
		int mscr = Integer.MIN_VALUE;
		int res2 = 0;
		int a, b;

		for (int i = 0; i < n; i++) {
			inp = br.readLine().split(" ");
			a = Integer.parseInt(inp[0]);
			b = Integer.parseInt(inp[1]);

			if (b - a > pscr) {
				res1 = i;
				pscr = b - a;
			}
			for (int j = a - 1; j < b; j++) {
				if (cake[j]) {
					cake[j] = false;
					scr[i]++;
				}
			}
			if (scr[i] > mscr) {
				mscr = scr[i];
				res2 = i;
			}
		}

		bw.write((res1 + 1) + "\n" + (res2 + 1));

		bw.flush();
		bw.close();

	}
}