package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	static int n;
	static char rgb[][];
	static int nres = 0;
	static int yres = 0;
	static Queue<Integer> yq = new LinkedList<>();
	static Queue<Integer> xq = new LinkedList<>();
	static int ypos[] = { 1, -1, -1, 1, };
	static int xpos[] = { 0, 1, -1, -1, };

	static void bfs() {

		char yrgb[][] = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				yrgb[i][j] = rgb[i][j];
		}

		while (true) {

			char chk = ' ';

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (rgb[i][j] != 'C') {
						chk = rgb[i][j];
						rgb[i][j] = 'C';
						yq.add(i);
						xq.add(j);
						break;
					}
				}
				if (chk != ' ')
					break;
			}

			if (chk == ' ')
				break;

			nres++;

			while (!yq.isEmpty()) {

				int y = yq.poll();
				int x = xq.poll();

				for (int i = 0; i < 4; i++) {
					y += ypos[i];
					x += xpos[i];

					if (y < 0 || y >= n || x < 0 || x >= n)
						continue;

					if (rgb[y][x] == chk) {
						yq.add(y);
						xq.add(x);
						rgb[y][x] = 'C';
					}

				}

			}

		}

		while (true) {

			char chk = ' ';

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (yrgb[i][j] != 'C') {
						chk = yrgb[i][j];
						yrgb[i][j] = 'C';
						yq.add(i);
						xq.add(j);
						break;
					}
				}
				if (chk != ' ')
					break;
			}

			if (chk == ' ')
				break;

			yres++;

			while (!yq.isEmpty()) {

				int y = yq.poll();
				int x = xq.poll();

				for (int i = 0; i < 4; i++) {
					y += ypos[i];
					x += xpos[i];

					if (y < 0 || y >= n || x < 0 || x >= n)
						continue;

					if (yrgb[y][x] == chk || (yrgb[y][x] == 'R' && chk == 'G') || (yrgb[y][x] == 'G' && chk == 'R')) {
						yq.add(y);
						xq.add(x);
						yrgb[y][x] = 'C';
					}

				}

			}

		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		rgb = new char[n][n];

		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < n; j++) {
				rgb[i][j] = temp.charAt(j);
			}
		}

		bfs();

		bw.write(nres + " " + yres);
		bw.flush();
		bw.close();

	}
}
