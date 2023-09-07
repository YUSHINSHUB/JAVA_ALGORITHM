package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	static char map[][] = new char[50][50];
	static int calc[][] = new int[50][50];
	static int ypos[] = { 1, 0, -1, 0 };
	static int xpos[] = { 0, 1, 0, -1 };
	static int n, m;
	static int res = 0;

	static void bfs(int y, int x) {

		Queue<Integer> yq = new LinkedList<>();
		Queue<Integer> xq = new LinkedList<>();
		yq.add(y);
		xq.add(x);

		while (!yq.isEmpty()) {

			int yt = yq.poll();
			int xt = xq.poll();

			for (int i = 0; i < 4; i++) {
				int yp = yt + ypos[i];
				int xp = xt + xpos[i];
				if (yp < 0 || yp >= n || xp < 0 || xp >= m)
					continue;
				else if (map[yp][xp] == 'W')
					continue;
				else if (calc[yp][xp] >= 0)
					continue;
				else {
					calc[yp][xp] = calc[yt][xt] + 1;
					yq.add(yp);
					xq.add(xp);
					if (calc[yp][xp] > res)
						res = calc[yp][xp];
				}
			}

		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		n = Integer.parseInt(inp[0]);
		m = Integer.parseInt(inp[1]);

		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = temp.charAt(j);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'L') {
					for (int k = 0; k < n; k++)
						Arrays.fill(calc[k], -1);
					calc[i][j] = 0;
					bfs(i, j);
				}
			}
		}

		bw.write(res + "");
		bw.flush();
		bw.close();

	}
}
