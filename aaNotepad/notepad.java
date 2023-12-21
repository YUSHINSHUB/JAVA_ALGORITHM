package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {

	static int ny[] = { -1, 1, 0, 1 };
	static int nx[] = { 0, -1, 2, -1 };
	static int N, L, R;
	static int grid[][];
	static Boolean visited[][];

	static void bfs(int y, int x) {

		int sum = grid[y][x];
		int size = 1;
		Queue<Integer> ay = new LinkedList<>();
		Queue<Integer> ax = new LinkedList<>();
		Queue<Integer> yq = new LinkedList<>();
		Queue<Integer> xq = new LinkedList<>();
		yq.add(y);
		xq.add(x);
		ay.add(y);
		ax.add(x);

		while (!yq.isEmpty()) {

			int cy = yq.poll();
			int cx = xq.poll();
			int ly = cy;
			int lx = cx;

			for (int i = 0; i < 4; i++) {
				ly += ny[i];
				lx += nx[i];
				if (ly >= N || lx >= N || ly < 0 || lx < 0)
					continue;
				else if (visited[ly][lx])
					continue;
				else if ((int) Math.abs(grid[ly][lx] - grid[cy][cx]) >= L
						&& (int) Math.abs(grid[ly][lx] - grid[cy][cx]) <= R) {
					visited[ly][lx] = true;
					yq.add(ly);
					xq.add(lx);
					ay.add(ly);
					ax.add(lx);
					sum += grid[ly][lx];
					size++;
				}
			}

		}

		sum /= size;

		while (!ay.isEmpty()) {
			int ly = ay.poll();
			int lx = ax.poll();
			grid[ly][lx] = sum;
		}

	}

	static int search() {

		int res = 0;
		int y, x;

		while (true) {

			for (int i = 0; i < N; i++)
				Arrays.fill(visited[i], false);

			Boolean pass = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j])
						continue;
					y = i;
					x = j;
					for (int k = 0; k < 4; k++) {
						y += ny[k];
						x += nx[k];
						if (y >= N || x >= N || y < 0 || x < 0)
							continue;
						else if (visited[y][x])
							continue;
						if ((int) Math.abs(grid[i][j] - grid[y][x]) >= L
								&& (int) Math.abs(grid[i][j] - grid[y][x]) <= R) {
							pass = true;
							visited[i][j] = true;
							bfs(i, j);
							break;
						}
					}
				}
			}

			if (!pass)
				break;
			else
				res++;
		}

		return res;

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]);
		L = Integer.parseInt(inp[1]);
		R = Integer.parseInt(inp[2]);
		grid = new int[N][N];
		visited = new Boolean[N][N];

		for (int i = 0; i < N; i++) {
			inp = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(inp[j]);
			}
		}

		bw.write(search() + "");
		bw.flush();
		bw.close();

	}

}
