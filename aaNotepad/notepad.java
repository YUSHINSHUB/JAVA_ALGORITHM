package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {

	static int N;
	static int road[][];
	static int mem[][];
	static int lmem[][];

	static int recur(int y, int x) {

		if (y == N)
			return road[y][x];

		if (mem[y][x] >= 0)
			return mem[y][x];

		if (x == 1) {

			mem[y][x] = Math.max(mem[y][x], recur(y + 1, 0) + road[y][x]);
			mem[y][x] = Math.max(mem[y][x], recur(y + 1, 1) + road[y][x]);
			mem[y][x] = Math.max(mem[y][x], recur(y + 1, 2) + road[y][x]);

		} else if (x == 0) {
			mem[y][x] = Math.max(mem[y][x], recur(y + 1, 0) + road[y][x]);
			mem[y][x] = Math.max(mem[y][x], recur(y + 1, 1) + road[y][x]);
		} else {
			mem[y][x] = Math.max(mem[y][x], recur(y + 1, 1) + road[y][x]);
			mem[y][x] = Math.max(mem[y][x], recur(y + 1, 2) + road[y][x]);
		}

		return mem[y][x];
	}

	static int recur2(int y, int x) {

		if (y == N)
			return road[y][x];

		if (lmem[y][x] < 1000000)
			return lmem[y][x];

		if (x == 1) {

			lmem[y][x] = Math.min(lmem[y][x], recur2(y + 1, 0) + road[y][x]);
			lmem[y][x] = Math.min(lmem[y][x], recur2(y + 1, 1) + road[y][x]);
			lmem[y][x] = Math.min(lmem[y][x], recur2(y + 1, 2) + road[y][x]);

		} else if (x == 0) {
			lmem[y][x] = Math.min(lmem[y][x], recur2(y + 1, 0) + road[y][x]);
			lmem[y][x] = Math.min(lmem[y][x], recur2(y + 1, 1) + road[y][x]);
		} else {
			lmem[y][x] = Math.min(lmem[y][x], recur2(y + 1, 1) + road[y][x]);
			lmem[y][x] = Math.min(lmem[y][x], recur2(y + 1, 2) + road[y][x]);
		}

		return lmem[y][x];
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		road = new int[N + 1][3];
		mem = new int[N + 1][3];
		lmem = new int[N + 1][3];
		for (int i = 0; i < N; i++) {
			Arrays.fill(mem[i], -1);
			Arrays.fill(lmem[i], Integer.MAX_VALUE);
			String inp[] = br.readLine().split(" ");
			road[i + 1][0] = Integer.parseInt(inp[0]);
			road[i + 1][1] = Integer.parseInt(inp[1]);
			road[i + 1][2] = Integer.parseInt(inp[2]);
		}
		mem[0][1] = -1;
		lmem[0][1] = Integer.MAX_VALUE;

		bw.write(recur(0, 1) + " " + recur2(0, 1));
		bw.flush();
		bw.close();

	}

}
