package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	static int board[][] = new int[9][9];
	static int cnt = 0;
	static int y[][] = new int[9][10];
	static int x[][] = new int[9][10];
	static int area[][][] = new int[3][3][10];
	static boolean end = false;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static void bt(int yidx, int idx) throws IOException {

		if (idx == cnt) {
			end = true;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					bw.write(board[i][j] + " ");
				}
				bw.write("\n");
			}
			return;
		}

		for (int i = yidx; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == 0) {
					for (int k = 1; k <= 9; k++) {
						if (y[i][k] == 0 && x[j][k] == 0 && area[i / 3][j / 3][k] == 0) {
							board[i][j] = k;
							y[i][k] = 1;
							x[j][k] = 1;
							area[i / 3][j / 3][k] = 1;
							bt(i, idx + 1);
							if (end)
								return;
							y[i][k] = 0;
							x[j][k] = 0;
							area[i / 3][j / 3][k] = 0;
							board[i][j] = 0;
						}
					}
					return;
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			Arrays.fill(y[i], 0);
			Arrays.fill(x[i], 0);
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				Arrays.fill(area[i][j], 0);
		}
		for (int i = 0; i < 9; i++) {
			String inp[] = br.readLine().split(" ");
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(inp[j]);
				if (board[i][j] == 0)
					cnt++;
				y[i][board[i][j]] = 1;
				x[j][board[i][j]] = 1;
				area[i / 3][j / 3][board[i][j]] = 1;
			}
		}

		bt(0, 0);

		bw.flush();
		bw.close();

	}

}
