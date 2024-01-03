package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {

	static int N, M;
	static int res = 65;
	static int grid[][];
	static ArrayList<Integer> ylist = new ArrayList<>();
	static ArrayList<Integer> xlist = new ArrayList<>();

	static void up(int yt, int xt) {
		for (int i = yt + 1; i < N; i++) {
			if (grid[i][xt] == 6)
				break;
			else if (grid[i][xt] < 10)
				continue;
			grid[i][xt]++;
		}
	}

	static void dp(int yt, int xt) {
		for (int i = yt - 1; i >= 0; i--) {
			if (grid[i][xt] == 6)
				break;
			else if (grid[i][xt] < 10)
				continue;
			grid[i][xt]++;
		}
	}

	static void lp(int yt, int xt) {
		for (int i = xt - 1; i >= 0; i--) {
			if (grid[yt][i] == 6)
				break;
			else if (grid[yt][i] < 10)
				continue;
			grid[yt][i]++;
		}
	}

	static void rp(int yt, int xt) {
		for (int i = xt + 1; i < M; i++) {
			if (grid[yt][i] == 6)
				break;
			else if (grid[yt][i] < 10)
				continue;
			grid[yt][i]++;
		}
	}

	static void um(int yt, int xt) {
		for (int i = yt + 1; i < N; i++) {
			if (grid[i][xt] == 6)
				break;
			else if (grid[i][xt] < 10)
				continue;
			grid[i][xt]--;
		}
	}

	static void dm(int yt, int xt) {
		for (int i = yt - 1; i >= 0; i--) {
			if (grid[i][xt] == 6)
				break;
			else if (grid[i][xt] < 10)
				continue;
			grid[i][xt]--;
		}
	}

	static void lm(int yt, int xt) {
		for (int i = xt - 1; i >= 0; i--) {
			if (grid[yt][i] == 6)
				break;
			else if (grid[yt][i] < 10)
				continue;
			grid[yt][i]--;
		}
	}

	static void rm(int yt, int xt) {
		for (int i = xt + 1; i < M; i++) {
			if (grid[yt][i] == 6)
				break;
			else if (grid[yt][i] < 10)
				continue;
			grid[yt][i]--;
		}
	}

	static void bt(int idx) {

		if (idx == ylist.size()) {
			int r = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (grid[i][j] == 10)
						r++;
				}
			}
			res = Math.min(res, r);
			return;
		} else {

			int yt = ylist.get(idx);
			int xt = xlist.get(idx);

			switch (grid[yt][xt]) {
			case 1:
				up(yt, xt);
				bt(idx + 1);
				um(yt, xt);

				dp(yt, xt);
				bt(idx + 1);
				dm(yt, xt);

				lp(yt, xt);
				bt(idx + 1);
				lm(yt, xt);

				rp(yt, xt);
				bt(idx + 1);
				rm(yt, xt);

				break;
			case 2:

				up(yt, xt);
				dp(yt, xt);
				bt(idx + 1);
				um(yt, xt);
				dm(yt, xt);

				lp(yt, xt);
				rp(yt, xt);
				bt(idx + 1);
				lm(yt, xt);
				rm(yt, xt);

				break;
			case 3:

				up(yt, xt);
				rp(yt, xt);
				bt(idx + 1);
				um(yt, xt);
				rm(yt, xt);

				rp(yt, xt);
				dp(yt, xt);
				bt(idx + 1);
				rm(yt, xt);
				dm(yt, xt);

				dp(yt, xt);
				lp(yt, xt);
				bt(idx + 1);
				dm(yt, xt);
				lm(yt, xt);

				up(yt, xt);
				lp(yt, xt);
				bt(idx + 1);
				um(yt, xt);
				lm(yt, xt);

				break;
			case 4:

				up(yt, xt);
				lp(yt, xt);
				rp(yt, xt);
				bt(idx + 1);
				um(yt, xt);
				lm(yt, xt);
				rm(yt, xt);

				rp(yt, xt);
				up(yt, xt);
				dp(yt, xt);
				bt(idx + 1);
				rm(yt, xt);
				um(yt, xt);
				dm(yt, xt);

				dp(yt, xt);
				lp(yt, xt);
				rp(yt, xt);
				bt(idx + 1);
				dm(yt, xt);
				lm(yt, xt);
				rm(yt, xt);

				lp(yt, xt);
				up(yt, xt);
				dp(yt, xt);
				bt(idx + 1);
				lm(yt, xt);
				um(yt, xt);
				dm(yt, xt);

				break;
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]);
		M = Integer.parseInt(inp[1]);
		grid = new int[N][M];

		for (int i = 0; i < N; i++) {
			inp = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(inp[j]);
				if (grid[i][j] >= 1 && grid[i][j] <= 5) {
					ylist.add(i);
					xlist.add(j);
				} else if (grid[i][j] == 0)
					grid[i][j] = 10;
			}
		}

		for (int i = 0; i < ylist.size(); i++) {
			if (grid[ylist.get(i)][xlist.get(i)] == 5) {
				int yt = ylist.get(i);
				int xt = xlist.get(i);
				up(yt, xt);
				dp(yt, xt);
				lp(yt, xt);
				rp(yt, xt);
				ylist.remove(i);
				xlist.remove(i);
				i--;
			}
		}

		bt(0);
		bw.write(res + "");
		bw.flush();
		bw.close();

	}

}
