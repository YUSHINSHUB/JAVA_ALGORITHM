package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {

	static int N;
	static int board[][];
	static long mem[][];

	static long dp(int y, int x) {

		if (mem[y][x] >= 0)
			return mem[y][x];
		else if (board[y][x] == 0) {
			mem[y][x] = 0;
			return 0;
		} else if (y + board[y][x] >= N && x + board[y][x] >= N)
			mem[y][x] = 0;
		else if (y + board[y][x] >= N)
			mem[y][x] = dp(y, x + board[y][x]);
		else if (x + board[y][x] >= N)
			mem[y][x] = dp(y + board[y][x], x);
		else
			mem[y][x] = dp(y, x + board[y][x]) + dp(y + board[y][x], x);

		return mem[y][x];

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		mem = new long[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(mem[i], -1);
			String inp[] = br.readLine().split(" ");
			for (int j = 0; j < N; j++)
				board[i][j] = Integer.parseInt(inp[j]);
		}
		mem[N - 1][N - 1] = 1;

		bw.write(dp(0, 0) + "");
		bw.flush();
		bw.close();

	}

}
