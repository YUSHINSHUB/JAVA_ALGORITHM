package aaNotepad;

import java.io.*;
import java.util.*;
import java.math.*;

public class notepad {

	static int out = 0;
	static int N, M, D;
	static int ny[] = { 0, -1, 0 };
	static int nx[] = { -1, 0, 1 };
	static int grid[][] = new int[16][15];
	static Boolean check[] = new Boolean[16];
	static int sel[] = new int[3];

	static void backtracking(int cur, int idx) {

		if (idx == 3) {
			bfs();
			return;
		}

		for (int i = cur; i < M; i++) {
			if (check[i])
				continue;
			sel[idx] = i;
			check[i] = true;
			backtracking(i + 1, idx + 1);
			check[i] = false;
		}

	}

	static void bfs() {

		Queue<Integer> yq = new LinkedList<>();
		Queue<Integer> xq = new LinkedList<>();

		int res = 0;
		int remy[] = new int[3];
		int remx[] = new int[3];
		int dis[][] = new int[16][15];
		int tgrid[][] = new int[16][15];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tgrid[i][j] = grid[i][j];
			}
		}

		while (true) {
			Arrays.fill(remy, N);
			Arrays.fill(remx, 0);

			for (int j = 0; j < 3; j++) {
				for (int i = 0; i <= N; i++)
					Arrays.fill(dis[i], 0);
				yq.add(N);
				xq.add(sel[j]);
				while (!yq.isEmpty()) {
					int y = yq.poll();
					int x = xq.poll();
					if (dis[y][x] == D) {
						remy[j] = N;
						remx[j] = 1;
						break;
					}
					for (int i = 0; i < 3; i++) {
						int cy = y + ny[i];
						int cx = x + nx[i];
						if (cy >= N || cx >= M || cy < 0 || cx < 0)
							continue;
						if (dis[cy][cx] > 0)
							continue;
						if (tgrid[cy][cx] == 1) {
							remy[j] = cy;
							remx[j] = cx;
							break;
						}
						yq.add(cy);
						xq.add(cx);
						dis[cy][cx] = dis[y][x] + 1;
					}
					if (remy[j] != N)
						break;
				}
				yq.clear();
				xq.clear();
			}

			for (int i = 0; i < 3; i++) {
				if (tgrid[remy[i]][remx[i]] == 1) {
					tgrid[remy[i]][remx[i]] = 0;
					res++;
				}
			}

			for (int i = 0; i < M; i++)
				tgrid[N - 1][i] = 0;
			int cnt = 0;
			for (int i = N - 2; i >= 0; i--) {
				for (int j = 0; j < M; j++) {
					if (tgrid[i][j] == 1) {
						tgrid[i][j] = 0;
						tgrid[i + 1][j] = 1;
						cnt++;
					}
				}
			}
			if (cnt == 0)
				break;

		}

		out = Math.max(out, res);

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]);
		M = Integer.parseInt(inp[1]);
		D = Integer.parseInt(inp[2]);

		for (int i = 0; i < N; i++) {
			inp = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(inp[j]);
			}
		}

		Arrays.fill(check, false);
		backtracking(0, 0);

		bw.write(out + "");
		bw.flush();
		bw.close();
	}
}