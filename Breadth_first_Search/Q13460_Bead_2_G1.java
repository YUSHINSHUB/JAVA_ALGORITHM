package Breadth_first_Search;

import java.io.*;
import java.util.*;

public class Q13460_Bead_2_G1 {

	static char grid[][];
	static int mem[][][][];
	static Boolean pass = true;

	static int bfs(int fby, int fbx, int fry, int frx) {

		Queue<Integer> byq = new LinkedList<>();
		Queue<Integer> bxq = new LinkedList<>();
		Queue<Integer> ryq = new LinkedList<>();
		Queue<Integer> rxq = new LinkedList<>();
		byq.add(fby);
		bxq.add(fbx);
		ryq.add(fry);
		rxq.add(frx);

		while (!byq.isEmpty()) {
			int cby = byq.poll();
			int cbx = bxq.poll();
			int cry = ryq.poll();
			int crx = rxq.poll();
			if (mem[cry][crx][cby][cbx] >= 10)
				break;

			int by = cby;
			int bx = cbx;
			int ry = cry;
			int rx = crx;

			while (true) {
				if (grid[by + 1][bx] == '#' && grid[ry + 1][rx] == '#')
					break;
				else if (grid[by + 1][bx] == '#' && by == ry + 1 && bx == rx)
					break;
				else if (grid[ry + 1][rx] == '#' && ry == by + 1 && bx == rx)
					break;
				else if (grid[by + 1][bx] == '#')
					ry++;
				else if (grid[ry + 1][rx] == '#')
					by++;
				else {
					ry++;
					by++;
				}

				if (grid[by][bx] == 'O' || grid[ry][rx] == 'O')
					break;
			}

			if (grid[by][bx] != 'O' && (by != cby || bx != cbx || ry != cry || rx != crx)
					&& (mem[ry][rx][by][bx] < 0)) {

				if (grid[ry][rx] == 'O') {
					if (by < ry && bx == rx) {
						while (grid[by][bx] != '#') {
							by++;
							if (grid[by][bx] == 'O') {
								pass = false;
								break;
							}
						}
					}
					if (pass)
						return mem[cry][crx][cby][cbx] + 1;
					else
						pass = true;
				} else {
					mem[ry][rx][by][bx] = mem[cry][crx][cby][cbx] + 1;
					ryq.add(ry);
					rxq.add(rx);
					byq.add(by);
					bxq.add(bx);
				}
			}

			by = cby;
			bx = cbx;
			ry = cry;
			rx = crx;
			while (true) {
				if (grid[by - 1][bx] == '#' && grid[ry - 1][rx] == '#')
					break;
				else if (grid[by - 1][bx] == '#' && by == ry - 1 && bx == rx)
					break;
				else if (grid[ry - 1][rx] == '#' && ry == by - 1 && bx == rx)
					break;
				else if (grid[by - 1][bx] == '#')
					ry--;
				else if (grid[ry - 1][rx] == '#')
					by--;
				else {
					ry--;
					by--;
				}

				if (grid[by][bx] == 'O' || grid[ry][rx] == 'O')
					break;
			}

			if (grid[by][bx] != 'O' && (by != cby || bx != cbx || ry != cry || rx != crx)
					&& (mem[ry][rx][by][bx] < 0)) {
				if (grid[ry][rx] == 'O') {
					if (by > ry && bx == rx) {
						while (grid[by][bx] != '#') {
							by--;
							if (grid[by][bx] == 'O') {
								pass = false;
								break;
							}
						}
					}
					if (pass)
						return mem[cry][crx][cby][cbx] + 1;
					else
						pass = true;
				} else {
					mem[ry][rx][by][bx] = mem[cry][crx][cby][cbx] + 1;
					ryq.add(ry);
					rxq.add(rx);
					byq.add(by);
					bxq.add(bx);
				}
			}

			by = cby;
			bx = cbx;
			ry = cry;
			rx = crx;
			while (true) {
				if (grid[by][bx + 1] == '#' && grid[ry][rx + 1] == '#')
					break;
				else if (grid[by][bx + 1] == '#' && bx == rx + 1 && by == ry)
					break;
				else if (grid[ry][rx + 1] == '#' && rx == bx + 1 && by == ry)
					break;
				else if (grid[by][bx + 1] == '#')
					rx++;
				else if (grid[ry][rx + 1] == '#')
					bx++;
				else {
					rx++;
					bx++;
				}

				if (grid[by][bx] == 'O' || grid[ry][rx] == 'O')
					break;
			}

			if (grid[by][bx] != 'O' && (by != cby || bx != cbx || ry != cry || rx != crx)
					&& (mem[ry][rx][by][bx] < 0)) {

				if (grid[ry][rx] == 'O') {
					if (bx < rx && by == ry) {
						while (grid[by][bx] != '#') {
							bx++;
							if (grid[by][bx] == 'O') {
								pass = false;
								break;
							}
						}
					}
					if (pass)
						return mem[cry][crx][cby][cbx] + 1;
					else
						pass = true;
				} else {
					mem[ry][rx][by][bx] = mem[cry][crx][cby][cbx] + 1;
					ryq.add(ry);
					rxq.add(rx);
					byq.add(by);
					bxq.add(bx);
				}
			}

			by = cby;
			bx = cbx;
			ry = cry;
			rx = crx;
			while (true) {
				if (grid[by][bx - 1] == '#' && grid[ry][rx - 1] == '#')
					break;
				else if (grid[by][bx - 1] == '#' && bx == rx - 1 && by == ry)
					break;
				else if (grid[ry][rx - 1] == '#' && rx == bx - 1 && by == ry)
					break;
				else if (grid[by][bx - 1] == '#')
					rx--;
				else if (grid[ry][rx - 1] == '#')
					bx--;
				else {
					rx--;
					bx--;
				}

				if (grid[by][bx] == 'O' || grid[ry][rx] == 'O')
					break;
			}

			if (grid[by][bx] != 'O' && (by != cby || bx != cbx || ry != cry || rx != crx)
					&& (mem[ry][rx][by][bx] < 0)) {

				if (grid[ry][rx] == 'O') {
					if (bx > rx && by == ry) {
						while (grid[by][bx] != '#') {
							bx--;
							if (grid[by][bx] == 'O') {
								pass = false;
								break;
							}
						}
					}
					if (pass)
						return mem[cry][crx][cby][cbx] + 1;
					else
						pass = true;
				} else {
					mem[ry][rx][by][bx] = mem[cry][crx][cby][cbx] + 1;
					ryq.add(ry);
					rxq.add(rx);
					byq.add(by);
					bxq.add(bx);
				}
			}

		}

		return -1;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N, M;
		int by = 0;
		int bx = 0;
		int ry = 0;
		int rx = 0;

		String inp[] = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]);
		M = Integer.parseInt(inp[1]);

		grid = new char[N][M];
		mem = new int[N][M][N][M];
		for (int i = 0; i < N; i++) {
			String in = br.readLine();
			for (int j = 0; j < M; j++) {
				grid[i][j] = in.charAt(j);
				if (grid[i][j] == 'R') {
					ry = i;
					rx = j;
				}
				if (grid[i][j] == 'B') {
					by = i;
					bx = j;
				}
				for (int k = 0; k < N; k++)
					Arrays.fill(mem[i][j][k], -1);
			}
		}

		mem[ry][rx][by][bx] = 0;

		bw.write(bfs(by, bx, ry, rx) + "");
		bw.flush();
		bw.close();

	}

}