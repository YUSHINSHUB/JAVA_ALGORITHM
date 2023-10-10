package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	static int idx = 0;
	static int n, m;
	static int sea[][];
	static int by[] = { 1, -1, -1, 1 };
	static int bx[] = { 0, 1, -1, -1 };

	static int bfs() {

		Queue<Integer> yq = new LinkedList<>();
		Queue<Integer> xq = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (sea[i][j] != 0) {
					yq.add(i);
					xq.add(j);
					break;
				}
			}
			if (!yq.isEmpty())
				break;
		}

		if (yq.isEmpty())
			return 0;

		int tsea[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			tsea[i] = sea[i].clone();
		}
		tsea[yq.peek()][xq.peek()] = 0;

		while (!yq.isEmpty()) {

			int y = yq.poll();
			int x = xq.poll();

			for (int i = 0; i < 4; i++) {
				y += by[i];
				x += bx[i];
				if (y < 0 || x < 0 || y >= n || x >= m)
					continue;

				if (tsea[y][x] > 0) {
					yq.add(y);
					xq.add(x);
					tsea[y][x] = 0;
				}

			}

		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tsea[i][j] > 0)
					return 1;
			}
		}

		return 2;

	}

	static void melt() {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (sea[i][j] == 0) {
					int y = i;
					int x = j;
					for (int k = 0; k < 4; k++) {
						y += by[k];
						x += bx[k];
						if (y < 0 || x < 0 || y >= n || x >= m)
							continue;
						else if (sea[y][x] > 0) {
							sea[y][x]--;
							if (sea[y][x] == 0)
								sea[y][x]--;
						}
					}
				} else if (sea[i][j] < 0)
					sea[i][j]++;
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		int chk = 2;
		n = Integer.parseInt(inp[0]);
		m = Integer.parseInt(inp[1]);
		sea = new int[n][m];

		for (int i = 0; i < n; i++) {
			inp = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				sea[i][j] = Integer.parseInt(inp[j]);
			}
		}

		while (true) {
			chk = bfs();
			if (chk == 0) {
				idx = 0;
				break;
			} else if (chk == 1)
				break;

			idx++;
			melt();
		}

		bw.write(idx + "");

		bw.flush();
		bw.close();

	}
}
