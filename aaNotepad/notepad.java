package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	static int m, n, h;
	static int tom[][][];
	static int res = 0;
	static Queue<Integer> yq = new LinkedList<>();
	static Queue<Integer> xq = new LinkedList<>();
	static Queue<Integer> hq = new LinkedList<>();
	static int ypos[] = { 1, -1, -1, 1, 0, 0 };
	static int xpos[] = { 0, 1, -1, -1, 1, 0 };
	static int hpos[] = { 0, 0, 0, 0, 1, -2 };

	static void bfs() {

		while (true) {
			Queue<Integer> ytq = new LinkedList<>();
			Queue<Integer> xtq = new LinkedList<>();
			Queue<Integer> htq = new LinkedList<>();
			while (!yq.isEmpty()) {
				ytq.add(yq.poll());
				xtq.add(xq.poll());
				htq.add(hq.poll());
			}

			if (ytq.isEmpty())
				break;

			res++;

			while (!ytq.isEmpty()) {

				int y = ytq.poll();
				int x = xtq.poll();
				int z = htq.poll();

				for (int i = 0; i < 6; i++) {
					y += ypos[i];
					x += xpos[i];
					z += hpos[i];

					if (y < 0 || y >= m || x < 0 || x >= n || z < 0 || z >= h)
						continue;

					if (tom[y][x][z] == 0) {
						yq.add(y);
						xq.add(x);
						hq.add(z);
						tom[y][x][z] = 1;
					}

				}

			}

		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		m = Integer.parseInt(inp[0]);
		n = Integer.parseInt(inp[1]);
		h = Integer.parseInt(inp[2]);

		tom = new int[m][n][h];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				inp = br.readLine().split(" ");
				for (int k = 0; k < m; k++) {
					tom[k][j][i] = Integer.parseInt(inp[k]);
					if (tom[k][j][i] == 1) {
						yq.add(k);
						xq.add(j);
						hq.add(i);
					}
				}
			}
		}

		bfs();

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (tom[k][j][i] == 0) {
						res = 0;
					}
				}
			}
		}

		bw.write(res - 1 + "");
		bw.flush();
		bw.close();

	}
}
