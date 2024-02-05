package Dynamic_Programming;

import java.io.*;
import java.util.*;

public class Q17070_Pipe_1_G5 {

	static int mem[][][] = new int[16][16][3];
	static int grid[][] = new int[16][16];
	static int N;

	static int dp(int y, int x, int cur) {

		if (y < 0 || x < 0 || y >= N || x >= N)
			return 0;

		if (mem[y][x][cur] >= 0) {
			return mem[y][x][cur];
		}

		if (cur == 0) {
			mem[y][x][0] = dp(y, x - 1, 0) + dp(y, x - 1, 2);
			return mem[y][x][0];
		} else if (cur == 1) {
			mem[y][x][1] = dp(y - 1, x, 1) + dp(y - 1, x, 2);
			return mem[y][x][1];
		} else {
			mem[y][x][2] = dp(y - 1, x - 1, 0) + dp(y - 1, x - 1, 1) + dp(y - 1, x - 1, 2);
			return mem[y][x][2];
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int res;

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String inp[] = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				Arrays.fill(mem[i][j], -1);
				grid[i][j] = Integer.parseInt(inp[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j] == 1) {
					Arrays.fill(mem[i][j], 0);
					if (j + 1 < N) {
						mem[i][j + 1][0] = 0;
						mem[i][j + 1][2] = 0;
					}
					if (i + 1 < N) {
						mem[i + 1][j][1] = 0;
						mem[i + 1][j][2] = 0;
					}
					if (i + 1 < N && j + 1 < N)
						mem[i + 1][j + 1][2] = 0;
				}
			}
		}

		mem[0][1][0] = 1;

		res = dp(N - 1, N - 1, 0) + dp(N - 1, N - 1, 1) + dp(N - 1, N - 1, 2);

		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}