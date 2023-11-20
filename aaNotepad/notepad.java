package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {

	static int mem[][];
	static int grp[][];
	static int ny[] = { -1, 1, 0, 1 };
	static int nx[] = { 0, -1, 2, -1 };
	static int N;

	static int dp(int y, int x) {

		if (mem[y][x] >= 0)
			return mem[y][x];
		else {
			mem[y][x] = 1;
			int cy = y;
			int cx = x;
			for (int i = 0; i < 4; i++) {
				cy += ny[i];
				cx += nx[i];
				if (cx < 0 || cy < 0 || cx >= N || cy >= N)
					continue;
				else if (grp[cy][cx] <= grp[y][x])
					continue;
				mem[y][x] = Math.max(mem[y][x], dp(cy, cx) + 1);
			}

			return mem[y][x];
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		int res = 0;
		grp = new int[N][N];
		mem = new int[N][N];

		for (int i = 0; i < N; i++) {
			Arrays.fill(mem[i], -1);
			String inp[] = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				grp[i][j] = Integer.parseInt(inp[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				res = Math.max(res, dp(i, j));
			}
		}

		bw.write(res + "");

		bw.flush();
		bw.close();

	}

}
