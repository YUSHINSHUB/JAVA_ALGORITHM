package aaNotepad;

import java.io.*;
import java.util.*;
import java.math.*;

public class notepad {

	static int ny[] = { -1, 0, 0, 1 };
	static int nx[] = { 0, -1, 1, 0 };
	static int grid[][] = new int[100][100];
	static Boolean visited[][] = new Boolean[100][100];
	static int N;
	static int res = 0;

	static void find_island() {

		Queue<Integer> yq = new LinkedList<>();
		Queue<Integer> xq = new LinkedList<>();
		int idx = 2;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j] == 1) {
					yq.add(i);
					xq.add(j);
					grid[i][j] = idx;

					while (!yq.isEmpty()) {

						int cy = yq.poll();
						int cx = xq.poll();

						for (int k = 0; k < 4; k++) {
							int ynext = cy + ny[k];
							int xnext = cx + nx[k];
							if (ynext < 0 || xnext < 0 || ynext >= N || xnext >= N)
								continue;
							if (grid[ynext][xnext] == 0 || grid[ynext][xnext] == idx)
								continue;

							grid[ynext][xnext] = idx;
							yq.add(ynext);
							xq.add(xnext);
						}

					}
					idx++;
				}
			}
		}

	}

	static int bridge(int y, int x, int idx) {

		for (int i = 0; i < N; i++)
			Arrays.fill(visited[i], false);

		Queue<Integer> yq = new LinkedList<>();
		Queue<Integer> xq = new LinkedList<>();
		Queue<Integer> b = new LinkedList<>();
		yq.add(y);
		xq.add(x);
		b.add(0);

		while (!yq.isEmpty()) {

			int cy = yq.poll();
			int cx = xq.poll();
			int cb = b.poll();

			for (int i = 0; i < 4; i++) {
				int ynext = cy + ny[i];
				int xnext = cx + nx[i];
				if (ynext < 0 || xnext < 0 || ynext >= N || xnext >= N)
					continue;
				if (visited[ynext][xnext])
					continue;
				if (grid[ynext][xnext] == idx)
					continue;
				if (grid[ynext][xnext] > 0 && grid[ynext][xnext] != idx)
					return cb;

				yq.add(ynext);
				xq.add(xnext);
				b.add(cb + 1);
				visited[ynext][xnext] = true;
			}

		}

		return Integer.MAX_VALUE;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int res = Integer.MAX_VALUE;

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String inp[] = br.readLine().split(" ");
			for (int j = 0; j < N; j++)
				grid[i][j] = Integer.parseInt(inp[j]);
		}

		find_island();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j] > 1) {
					res = Math.min(res, bridge(i, j, grid[i][j]));
				}
			}
		}

		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}