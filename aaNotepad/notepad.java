package aaNotepad;

import java.io.*;
import java.util.*;
import java.math.*;

public class notepad {

	static int chapter[] = new int[500];
	static long mem[][] = new long[500][500];

	static long dp(int start, int end) {

		if (mem[start][end] < Long.MAX_VALUE)
			return mem[start][end];

		long val = 0;
		for (int i = start; i <= end; i++)
			val += chapter[i];

		for (int i = start; i < end; i++) {
			mem[start][end] = Math.min(mem[start][end], dp(start, i) + dp(i + 1, end) + val);
		}

		return mem[start][end];
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T, N;
		String inp[];

		T = Integer.parseInt(br.readLine());

		for (int cs = 0; cs < T; cs++) {

			N = Integer.parseInt(br.readLine());
			inp = br.readLine().split(" ");

			for (int i = 0; i < N; i++) {
				chapter[i] = Integer.parseInt(inp[i]);
				Arrays.fill(mem[i], Long.MAX_VALUE);
			}

			for (int i = 0; i < N; i++) {
				mem[i][i] = 0;
				if (i > 0)
					mem[i - 1][i] = chapter[i - 1] + chapter[i];
			}
			bw.write(dp(0, N - 1) + "\n");

		}

		bw.flush();
		bw.close();
	}
}