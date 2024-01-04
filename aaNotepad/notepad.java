package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {

	static int dice[] = new int[7];

	static void mn() {
		int d1 = dice[1];
		int d3 = dice[3];
		int d5 = dice[5];
		int d6 = dice[6];

		dice[1] = d6;
		dice[3] = d1;
		dice[5] = d3;
		dice[6] = d5;
	}

	static void ms() {
		int d1 = dice[1];
		int d3 = dice[3];
		int d5 = dice[5];
		int d6 = dice[6];

		dice[1] = d3;
		dice[3] = d5;
		dice[5] = d6;
		dice[6] = d1;
	}

	static void me() {
		int d2 = dice[2];
		int d3 = dice[3];
		int d4 = dice[4];
		int d6 = dice[6];

		dice[2] = d3;
		dice[3] = d4;
		dice[4] = d6;
		dice[6] = d2;
	}

	static void mw() {
		int d2 = dice[2];
		int d3 = dice[3];
		int d4 = dice[4];
		int d6 = dice[6];

		dice[2] = d6;
		dice[3] = d2;
		dice[4] = d3;
		dice[6] = d4;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N, M, y, x, K;
		Arrays.fill(dice, 0);
		int cur = 6;
		int grid[][];

		String inp[] = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]);
		M = Integer.parseInt(inp[1]);
		y = Integer.parseInt(inp[2]);
		x = Integer.parseInt(inp[3]);
		K = Integer.parseInt(inp[4]);
		grid = new int[N][M];

		for (int i = 0; i < N; i++) {
			inp = br.readLine().split(" ");
			for (int j = 0; j < M; j++)
				grid[i][j] = Integer.parseInt(inp[j]);
		}

		inp = br.readLine().split(" ");
		for (int cs = 0; cs < K; cs++) {
			switch (Integer.parseInt(inp[cs])) {
			case 1:
				if (x + 1 >= M)
					break;
				x++;
				me();
				if (grid[y][x] == 0) {
					grid[y][x] = dice[6];
				} else {
					dice[6] = grid[y][x];
					grid[y][x] = 0;
				}
				bw.write(dice[3] + "\n");
				break;
			case 2:
				if (x - 1 < 0)
					break;
				x--;
				mw();
				if (grid[y][x] == 0) {
					grid[y][x] = dice[6];
				} else {
					dice[6] = grid[y][x];
					grid[y][x] = 0;
				}
				bw.write(dice[3] + "\n");
				break;
			case 3:
				if (y - 1 < 0)
					break;
				y--;
				mn();
				if (grid[y][x] == 0) {
					grid[y][x] = dice[6];
				} else {
					dice[6] = grid[y][x];
					grid[y][x] = 0;
				}
				bw.write(dice[3] + "\n");
				break;
			case 4:
				if (y + 1 >= N)
					break;
				y++;
				ms();
				if (grid[y][x] == 0) {
					grid[y][x] = dice[6];
				} else {
					dice[6] = grid[y][x];
					grid[y][x] = 0;
				}
				bw.write(dice[3] + "\n");
				break;
			}
		}

		bw.flush();
		bw.close();

	}

}
