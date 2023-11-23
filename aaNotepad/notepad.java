package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {

	static int N, M;
	static int grp[][];
	static int visited[][];
	static int ny[] = { -1, 1, 0, 1 };
	static int nx[] = { 0, -1, 2, -1 };

	static void search() {

		Queue<Integer> yq = new LinkedList<>();
		Queue<Integer> xq = new LinkedList<>();
		Queue<Integer> wyq = new LinkedList<>();
		Queue<Integer> wxq = new LinkedList<>();
		yq.add(0);
		xq.add(0);

		while (!yq.isEmpty()) {
			int cy = yq.poll();
			int cx = xq.poll();

			int y = cy;
			int x = cx;

			for (int i = 0; i < 4; i++) {
				y += ny[i];
				x += nx[i];
				if (y < 0 || x < 0 || y >= N || x >= M)
					continue;
				else if (visited[y][x] >= 0)
					continue;
				else if (grp[y][x] == 1) {
					visited[y][x] = visited[cy][cx] + 1;
					wyq.add(y);
					wxq.add(x);
					continue;
				}

				visited[y][x] = visited[cy][cx] + 1;
				yq.add(y);
				xq.add(x);

			}
		}

		while (!wyq.isEmpty()) {
			yq.add(wyq.poll());
			xq.add(wxq.poll());

			while (!yq.isEmpty()) {
				int cy = yq.poll();
				int cx = xq.poll();

				int y = cy;
				int x = cx;

				for (int i = 0; i < 4; i++) {
					y += ny[i];
					x += nx[i];
					if (y < 0 || y >= N || x < 0 || x >= M)
						continue;
					else if (grp[y][x] == 1)
						continue;
					else if (visited[y][x] >= 0 && visited[y][x] <= visited[cy][cx] + 1)
						continue;

					visited[y][x] = visited[cy][cx] + 1;
					yq.add(y);
					xq.add(x);
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]);
		M = Integer.parseInt(inp[1]);
		grp = new int[N][M];
		visited = new int[N][M];

		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			Arrays.fill(visited[i], -1);
			for (int j = 0; j < M; j++)
				grp[i][j] = Integer.parseInt(Character.toString(temp.charAt(j)));
		}

		visited[N-1][M-1] = -2;
		visited[0][0] = 0;
		
		search();

		bw.write(visited[N - 1][M - 1] + 1 + "");

		bw.flush();
		bw.close();

	}

}
