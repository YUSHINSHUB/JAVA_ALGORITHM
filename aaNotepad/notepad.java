package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {

	static int grid[][] = new int[100][100];
	static Boolean visited[][] = new Boolean[100][100];
	static int r, c;
	static int ny[] = { 1, -1, 0, -1 };
	static int nx[] = { 0, -1, 2, -1 };

	static int bfs() {
		int cnt = 0;

		Queue<Integer> yq = new LinkedList<>();
		Queue<Integer> xq = new LinkedList<>();
		yq.add(0);
		xq.add(0);
		for (int i = 0; i < r; i++) {
			Arrays.fill(visited[i], false);
			for (int j = 0; j < c; j++) {
				if (grid[i][j] == 1)
					cnt++;
			}
		}

		while (!yq.isEmpty()) {
			int cy = yq.poll();
			int cx = xq.poll();
			if (grid[cy][cx] == 1) {
				grid[cy][cx] = 0;
				continue;
			}
			for (int i = 0; i < 4; i++) {
				cy += ny[i];
				cx += nx[i];
				if (cy < 0 || cx < 0 || cy >= r || cx >= c)
					continue;
				else if (visited[cy][cx])
					continue;

				visited[cy][cx] = true;
				yq.add(cy);
				xq.add(cx);
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[];
		int idx = 0;
		int cnt = 0;

		inp = br.readLine().split(" ");
		r = Integer.parseInt(inp[0]);
		c = Integer.parseInt(inp[1]);

		for (int i = 0; i < r; i++) {
			inp = br.readLine().split(" ");
			for (int j = 0; j < c; j++)
				grid[i][j] = Integer.parseInt(inp[j]);
		}

		while (true) {
			int temp = bfs();
			if (temp == 0)
				break;
			cnt = temp;
			idx++;
		}

		bw.write(idx + "\n" + cnt);
		bw.flush();
		bw.close();
	}
}