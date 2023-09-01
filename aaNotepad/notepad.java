package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	static int tom[][];
	static int res = 0;
	static Queue<Integer> y = new LinkedList<>();
	static Queue<Integer> x = new LinkedList<>();
	static int yp[] = { 1, -1, -1, 1 };
	static int xp[] = { 0, 1, -1, -1 };
	static int n, m;

	static void bfs() {

		while (!y.isEmpty()) {

			int s = y.size();

			for (int j = 0; j < s; j++) {
				int ypos = y.poll();
				int xpos = x.poll();

				for (int i = 0; i < 4; i++) {
					ypos += yp[i];
					xpos += xp[i];
					if (ypos == 0 || ypos == m + 1 || xpos == 0 || xpos == n + 1)
						continue;
					else if (tom[ypos][xpos] == -1 || tom[ypos][xpos] == 1)
						continue;
					else {
						tom[ypos][xpos] = 1;
						y.add(ypos);
						x.add(xpos);
					}

				}

			}

			res++;
		}

		res--;

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");

		n = Integer.parseInt(inp[0]);
		m = Integer.parseInt(inp[1]);

		tom = new int[m + 2][n + 2];

		for (int i = 1; i <= m; i++) {
			inp = br.readLine().split(" ");
			for (int j = 1; j <= n; j++) {
				tom[i][j] = Integer.parseInt(inp[j - 1]);
				if (tom[i][j] == 1) {
					y.add(i);
					x.add(j);
				}
			}
		}

		bfs();

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (tom[i][j] == 0)
					res = -1;
			}
		}

		bw.write(res + "");

		bw.flush();
		bw.close();

	}
}
