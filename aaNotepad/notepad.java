package aaNotepad;

import java.io.*;
import java.util.*;
import java.math.*;

public class notepad {

	static int N, M;
	static int grid[][] = new int[100][100];
	static int ny[] = { 1, 0, 0, -1 };
	static int nx[] = { 0, -1, 1, 0 };

	static void bfs() {

		Queue<Integer> yq = new LinkedList<>();
		Queue<Integer> xq = new LinkedList<>();
		Boolean visited[][] = new Boolean[100][100];

		yq.add(0);
		xq.add(0);

		for (int i = 0; i < N; i++)
			Arrays.fill(visited[i], false);

		while (!yq.isEmpty()) {

			int cy = yq.poll();
			int cx = xq.poll();

			for (int i = 0; i < 4; i++) {
				int y = cy + ny[i];
				int x = cx + nx[i];
				if (y < 0 || x < 0 || y >= N || x >= M)
					continue;
				if (visited[y][x])
					continue;
				if (grid[y][x] > 0) {
					grid[y][x]++;
					continue;
				}
				visited[y][x] = true;
				yq.add(y);
				xq.add(x);
			}

		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (grid[i][j] > 2)
					grid[i][j] = 0;
				else if (grid[i][j] == 2)
					grid[i][j] = 1;
			}
		}

	}

	static Boolean check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (grid[i][j] > 0)
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int res = 0;
		String inp[];

		inp = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]);
		M = Integer.parseInt(inp[1]);

		for (int i = 0; i < N; i++) {
			inp = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(inp[j]);
			}
		}

		while (true) {
			if (check())
				break;
			res++;
			bfs();
		}

		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}