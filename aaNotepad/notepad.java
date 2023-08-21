package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	static int grp[][];
	static int res[][];
	static int nexty[] = { 1, 0, -1, 0 };
	static int nextx[] = { 0, 1, 0, -1 };
	static boolean visited[][];
	static int n, m;

	static void bfs(int i, int j) {

		Queue<Integer> yq = new LinkedList<>();
		Queue<Integer> xq = new LinkedList<>();

		yq.add(i);
		xq.add(j);

		visited[i][j] = true;

		while (!yq.isEmpty()) {

			int cy = yq.poll();
			int cx = xq.poll();

			for (int k = 0; k < 4; k++) {
				int ny = cy + nexty[k];
				int nx = cx + nextx[k];

				if (ny < 0 || nx < 0 || ny >= n || nx >= m)
					continue;
				else if (visited[ny][nx] == true)
					continue;
				else if (res[ny][nx] == 0)
					continue;

				visited[ny][nx] = true;
				res[ny][nx] = res[cy][cx] + 1;
				yq.add(ny);
				xq.add(nx);

			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");

		n = Integer.parseInt(inp[0]);
		m = Integer.parseInt(inp[1]);
		int x = 0, y = 0;

		grp = new int[n][m];
		res = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			Arrays.fill(res[i], 10000000);
			Arrays.fill(visited[i], false);
		}

		for (int i = 0; i < n; i++) {
			inp = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				int t = Integer.parseInt(inp[j]);
				grp[i][j] = t;
				if (t == 0 || t == 2) {
					if (t == 2) {
						y = i;
						x = j;
					}
					res[i][j] = 0;
				}
			}
		}

		bfs(y, x);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (res[i][j] == 10000000)
					bw.write("-1 ");
				else
					bw.write(res[i][j] + " ");
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();

	}
}
