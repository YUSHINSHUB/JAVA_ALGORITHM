package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	static String grp[];
	static boolean visited[][];
	static int trax[] = { 1, 0, -1, 0 };
	static int tray[] = { 0, 1, 0, -1 };
	static int n, m;
	static int res = 0;

	static void bfs(int y, int x) {

		visited[y][x] = true;
		Queue<Integer> px = new LinkedList<>();
		Queue<Integer> py = new LinkedList<>();

		px.add(x);
		py.add(y);

		while (!px.isEmpty()) {

			int curx = px.poll();
			int cury = py.poll();

			for (int i = 0; i < 4; i++) {
				int xnext = curx + trax[i];
				int ynext = cury + tray[i];

				if (xnext < 0 || ynext < 0 || xnext >= m || ynext >= n)
					continue;
				if (grp[ynext].charAt(xnext) == 'X')
					continue;
				if (visited[ynext][xnext] == true)
					continue;

				visited[ynext][xnext] = true;
				if (grp[ynext].charAt(xnext) == 'P')
					res++;

				px.add(xnext);
				py.add(ynext);

			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		n = Integer.parseInt(inp[0]);
		m = Integer.parseInt(inp[1]);
		int y = 0, x = 0;

		grp = new String[n];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			grp[i] = br.readLine();
			Arrays.fill(visited[i], false);
			for (int j = 0; j < m; j++) {
				if (grp[i].charAt(j) == 'I') {
					y = i;
					x = j;
				}
			}
		}

		bfs(y, x);

		if (res == 0)
			bw.write("TT");
		else
			bw.write(res + "");

		bw.flush();
		bw.close();

	}
}
