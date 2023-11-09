package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {

	static int N;
	static int area[][];
	static int dist[][];
	static Queue<Integer> yq = new LinkedList<>();
	static Queue<Integer> xq = new LinkedList<>();
	static int ny[] = { -1, 1, 0, 1 };
	static int nx[] = { 0, -1, 2, -1 };
	static int cnt = 0;
	static int size = 2;
	static int res = 0;

	static void search() {

		int curd = 1000;
		int cury = 0;
		int curx = 0;

		while (!yq.isEmpty()) {

			int y = yq.poll();
			int x = xq.poll();

			int nexty = y;
			int nextx = x;

			for (int i = 0; i < 4; i++) {
				nexty += ny[i];
				nextx += nx[i];

				if (nexty < 0 || nexty >= N || nextx < 0 || nextx >= N)
					continue;
				else if (area[nexty][nextx] < size && area[nexty][nextx] > 0) {
					dist[nexty][nextx] = dist[y][x] + 1;
					if (dist[nexty][nextx] < curd) {
						curd = dist[nexty][nextx];
						cury = nexty;
						curx = nextx;
					} else if (dist[nexty][nextx] == curd && (cury > nexty || (cury == nexty && curx > nextx))) {
						curd = dist[nexty][nextx];
						cury = nexty;
						curx = nextx;
					} else if (dist[nexty][nextx] > curd) {
						area[cury][curx] = 0;
						cnt++;
						if (cnt == size) {
							cnt = 0;
							size++;
						}
						while (!yq.isEmpty()) {
							yq.poll();
							xq.poll();
						}
						yq.add(cury);
						xq.add(curx);
						res += curd;
						for (int j = 0; j < N; j++)
							Arrays.fill(dist[j], 0);
						curd = 1000;

						break;
					}
				} else if ((area[nexty][nextx] == 0 || area[nexty][nextx] == size) && dist[nexty][nextx] == 0) {
					dist[nexty][nextx] = dist[y][x] + 1;
					yq.add(nexty);
					xq.add(nextx);
				}

			}

			if (yq.isEmpty() && curd < 1000) {
				area[cury][curx] = 0;
				cnt++;
				if (cnt == size) {
					cnt = 0;
					size++;
				}
				yq.add(cury);
				xq.add(curx);
				res += curd;
				for (int j = 0; j < N; j++)
					Arrays.fill(dist[j], 0);

				curd = 1000;
			}

		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		area = new int[N][N];
		dist = new int[N][N];

		for (int i = 0; i < N; i++) {
			String inp[] = br.readLine().split(" ");
			Arrays.fill(dist[i], 0);
			for (int j = 0; j < N; j++) {
				area[i][j] = Integer.parseInt(inp[j]);
				if (area[i][j] == 9) {
					yq.add(i);
					xq.add(j);
					area[i][j] = 0;
				}
			}
		}

		search();

		bw.write(res + "");

		bw.flush();
		bw.close();

	}

}
