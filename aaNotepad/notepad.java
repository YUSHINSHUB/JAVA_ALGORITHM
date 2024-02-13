package aaNotepad;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.math.*;

public class notepad {

	static int R, C, M;
	static int res = 0;
	static int grid[][] = new int[101][101];
	static Boolean visited[][] = new Boolean[101][101];
	static HashMap<Integer, shark> hm = new HashMap<>();

	static class shark {

		int r;
		int c;
		int idx;
		int speed;
		int dir;
		int size;

		shark(int idx, int r, int c, int speed, int dir, int size) {
			this.r = r;
			this.c = c;
			this.idx = idx;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}

		void move() {
			switch (dir) {
			case 1:
				r--;
				break;
			case 2:
				r++;
				break;
			case 3:
				c++;
				break;
			case 4:
				c--;
				break;
			}
		}

		void revdir() {
			switch (dir) {
			case 1:
				dir = 2;
				break;
			case 2:
				dir = 1;
				break;
			case 3:
				dir = 4;
				break;
			case 4:
				dir = 3;
				break;
			}
		}
	}

	static void sim() {

		Queue<Integer> rem = new LinkedList<>();

		for (int i = 1; i <= C; i++) {

			for (int j = 1; j <= R; j++)
				Arrays.fill(visited[j], false);

			for (int j = 1; j <= R; j++) {
				if (grid[j][i] > 0) {
					res += hm.get(grid[j][i]).size;
					hm.remove(grid[j][i]);
					grid[j][i] = 0;
					break;
				}
			}

			for (Entry<Integer, shark> en : hm.entrySet()) {
				shark s = en.getValue();
				if (!visited[s.r][s.c])
					grid[s.r][s.c] = 0;
				for (int j = 0; j < s.speed; j++) {
					if ((s.dir == 1 && s.r == 1) || (s.dir == 2 && s.r == R) || (s.dir == 3 && s.c == C)
							|| (s.dir == 4 && s.c == 1))
						s.revdir();
					s.move();
				}
				if (visited[s.r][s.c]) {
					shark s2 = hm.get(grid[s.r][s.c]);
					if (s2.size < s.size) {
						rem.add(s2.idx);
						hm.put(s.idx, s);
						grid[s.r][s.c] = s.idx;
					} else {
						rem.add(s.idx);
					}
				} else {
					visited[s.r][s.c] = true;
					hm.put(s.idx, s);
					grid[s.r][s.c] = s.idx;
				}
			}
			while (!rem.isEmpty()) {
				hm.remove(rem.poll());
			}

		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[];
		int r, c, s, d, z;

		inp = br.readLine().split(" ");
		R = Integer.parseInt(inp[0]);
		C = Integer.parseInt(inp[1]);
		M = Integer.parseInt(inp[2]);

		for (int i = 1; i <= R; i++)
			Arrays.fill(grid[i], 0);

		for (int i = 1; i <= M; i++) {
			inp = br.readLine().split(" ");
			r = Integer.parseInt(inp[0]);
			c = Integer.parseInt(inp[1]);
			s = Integer.parseInt(inp[2]);
			d = Integer.parseInt(inp[3]);
			z = Integer.parseInt(inp[4]);
			hm.put(i, new shark(i, r, c, s, d, z));
			grid[r][c] = i;
		}

		sim();

		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}