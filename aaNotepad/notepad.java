package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {

	static int M, N, K;
	static int board[][];
	static ArrayList<Integer> list = new ArrayList<>();
	static int nexty[] = { 1, -1, 0, -1 };
	static int nextx[] = { 0, -1, 2, -1 };

	static void bfs(int y, int x) {

		int idx = 1;
		Queue<Integer> yq = new LinkedList<>();
		Queue<Integer> xq = new LinkedList<>();
		yq.add(y);
		xq.add(x);
		board[y][x] = 1;

		while (!yq.isEmpty()) {
			int cury = yq.poll();
			int curx = xq.poll();
			for (int i = 0; i < 4; i++) {
				cury += nexty[i];
				curx += nextx[i];
				if (cury >= M || curx >= N || cury < 0 || curx < 0)
					continue;
				else if (board[cury][curx] == 1)
					continue;
				board[cury][curx] = 1;
				idx++;
				yq.add(cury);
				xq.add(curx);
			}
		}

		list.add(idx);

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int dx, dy, ux, uy;
		int cnt = 0;

		String inp[] = br.readLine().split(" ");
		M = Integer.parseInt(inp[0]);
		N = Integer.parseInt(inp[1]);
		K = Integer.parseInt(inp[2]);
		board = new int[M][N];
		for (int i = 0; i < M; i++) {
			Arrays.fill(board[i], 0);
		}
		for (int i = 0; i < K; i++) {
			inp = br.readLine().split(" ");
			dx = Integer.parseInt(inp[0]);
			dy = Integer.parseInt(inp[1]);
			ux = Integer.parseInt(inp[2])-1;
			uy = Integer.parseInt(inp[3])-1;
			for (int j = dy; j <= uy; j++) {
				for (int k = dx; k <= ux; k++)
					board[j][k] = 1;
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 0) {
					cnt++;
					bfs(i, j);
				}
			}
		}

		Collections.sort(list);
		bw.write(cnt + "\n");
		for (int i = 0; i < list.size(); i++)
			bw.write(list.get(i) + " ");

		bw.flush();
		bw.close();

	}

}
