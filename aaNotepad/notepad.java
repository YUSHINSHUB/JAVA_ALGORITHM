package aaNotepad;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.math.*;

public class notepad {

	static Queue<Integer> jy = new LinkedList<>();
	static Queue<Integer> jx = new LinkedList<>();
	static Queue<Integer> fy = new LinkedList<>();
	static Queue<Integer> fx = new LinkedList<>();
	static int ny[] = { 1, 0, 0, -1 };
	static int nx[] = { 0, -1, 1, 0 };
	static int R, C;
	static Boolean visited[][] = new Boolean[1000][1000];
	static int grid[][] = new int[1000][1000];

	static int bfs() {

		while (!jy.isEmpty()) {
			int s = jy.size();
			for (int i = 0; i < s; i++) {

				int y = jy.poll();
				int x = jx.poll();
				if (grid[y][x] == -1)
					continue;

				for (int j = 0; j < 4; j++) {
					int cy = y + ny[j];
					int cx = x + nx[j];
					if (cy >= R || cx >= C || cy < 0 || cx < 0)
						return grid[y][x] + 1;
					if (grid[cy][cx] == -1)
						continue;
					if (visited[cy][cx])
						continue;
					jy.add(cy);
					jx.add(cx);
					grid[cy][cx] = grid[y][x] + 1;
					visited[cy][cx] = true;
				}

			}

			s = fy.size();

			for (int i = 0; i < s; i++) {
				int y = fy.poll();
				int x = fx.poll();
				for (int j = 0; j < 4; j++) {
					int cy = y + ny[j];
					int cx = x + nx[j];
					if (cy < 0 || cx < 0 || cy >= R || cx >= C)
						continue;
					if (grid[cy][cx] == -1)
						continue;
					fy.add(cy);
					fx.add(cx);
					grid[cy][cx] = -1;
				}
			}

		}

		return -1;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[];

		inp = br.readLine().split(" ");
		R = Integer.parseInt(inp[0]);
		C = Integer.parseInt(inp[1]);

		for (int i = 0; i < R; i++) {
			Arrays.fill(visited[i], false);
			String in = br.readLine();
			for (int j = 0; j < C; j++) {
				grid[i][j] = 0;
				if (in.charAt(j) == '#')
					grid[i][j] = -1;
				else if (in.charAt(j) == 'J') {
					visited[i][j] = true;
					jy.add(i);
					jx.add(j);
				} else if (in.charAt(j) == 'F') {
					grid[i][j] = -1;
					fy.add(i);
					fx.add(j);
				}
			}
		}

		int res = bfs();
		if (res < 0)
			bw.write("IMPOSSIBLE");
		else
			bw.write(res + "");

		bw.flush();
		bw.close();
	}
}