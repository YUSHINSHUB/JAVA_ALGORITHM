package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	static int maze[][];
	static int bfs[][];

	public static void recur(int n, int m) {

		if (maze[n - 1][m] == 1 && bfs[n - 1][m] > bfs[n][m] + 1) {
			bfs[n - 1][m] = bfs[n][m] + 1;
			recur(n - 1, m);
		}

		if (maze[n][m + 1] == 1 && bfs[n][m + 1] > bfs[n][m] + 1) {
			bfs[n][m + 1] = bfs[n][m] + 1;
			recur(n, m + 1);
		}

		if (maze[n + 1][m] == 1 && bfs[n + 1][m] > bfs[n][m] + 1) {
			bfs[n + 1][m] = bfs[n][m] + 1;
			recur(n + 1, m);
		}

		if (maze[n][m - 1] == 1 && bfs[n][m - 1] > bfs[n][m] + 1) {
			bfs[n][m - 1] = bfs[n][m] + 1;
			recur(n, m - 1);
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int m = Integer.parseInt(inp[1]);

		maze = new int[n + 2][m + 2];
		bfs = new int[n + 2][m + 2];

		Arrays.fill(bfs[0], Integer.MAX_VALUE);
		Arrays.fill(bfs[n + 1], Integer.MAX_VALUE);

		for (int i = 1; i <= n; i++) {
			Arrays.fill(bfs[i], Integer.MAX_VALUE);
			inp = br.readLine().split("");
			for (int j = 1; j <= m; j++) {
				maze[i][j] = Integer.parseInt(inp[j - 1]);
			}
		}

		bfs[1][1] = 1;

		recur(1, 1);

		bw.write(bfs[n][m] + "");

		bw.flush();
		bw.close();

	}
}