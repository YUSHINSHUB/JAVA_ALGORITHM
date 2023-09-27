package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int x[] = new int[n];
		int y[] = new int[n];
		double xs = 0;
		double ys = 0;

		for (int i = 0; i < n; i++) {
			String inp[] = br.readLine().split(" ");
			x[i] = Integer.parseInt(inp[0]);
			y[i] = Integer.parseInt(inp[1]);
		}

		for (int i = 0; i < n - 1; i++) {
			xs += x[i] * y[i + 1];
			ys += y[i] * x[i + 1];
		}

		xs += x[n - 1] * y[0];
		ys += y[n - 1] * x[0];

		xs -= ys;
		xs = Math.abs(xs);
		bw.write(xs / 2 + "");

		bw.flush();
		bw.close();

	}
}
