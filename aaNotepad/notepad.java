package aaNotepad;

import java.io.*;
import java.util.*;
import java.math.*;

public class notepad {

	static int mat[] = new int[501];
	static int mem[][] = new int[500][500];

	static int dp(int start, int end) {

		if (mem[start][end] < Integer.MAX_VALUE)
			return mem[start][end];

		for (int i = start; i < end; i++) {
			mem[start][end] = Math.min(mem[start][end],
					dp(start, i) + dp(i + 1, end) + (mat[start] * mat[i + 1] * mat[end + 1]));
		}

		return mem[start][end];
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N;

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String inp[] = br.readLine().split(" ");
			mat[i] = Integer.parseInt(inp[0]);
			mat[i + 1] = Integer.parseInt(inp[1]);
			Arrays.fill(mem[i], Integer.MAX_VALUE);
			mem[i][i] = 0;
		}

		bw.write(dp(0, N - 1) + "");

		bw.flush();
		bw.close();
	}
}