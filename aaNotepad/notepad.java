package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {

	static int sea[][];
	static int nexty[] = { 1, 0, 0, -1, 0, -1, 0, 0 };
	static int nextx[] = { -1, 1, 1, -2, 2, -2, 1, 1 };

	static void bfs(int w, int h, int y, int x) {

		Queue<Integer> yq = new LinkedList<>();
		Queue<Integer> xq = new LinkedList<>();
		yq.add(y);
		xq.add(x);

		while (!yq.isEmpty()) {
			int cury = yq.poll();
			int curx = xq.poll();
			for (int i = 0; i < 8; i++) {
				cury += nexty[i];
				curx += nextx[i];
				if (cury < 0 || curx < 0 || cury >= h || curx >= w)
					continue;
				if (sea[cury][curx] == 0)
					continue;
				sea[cury][curx] = 0;
				yq.add(cury);
				xq.add(curx);
			}
		}

	}

	static int search(int w, int h) {

		int res = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (sea[i][j] == 1) {
					res++;
					sea[i][j] = 0;
					bfs(w, h, i, j);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int w, h;

		while (true) {
			String inp[] = br.readLine().split(" ");
			w = Integer.parseInt(inp[0]);
			h = Integer.parseInt(inp[1]);
			if (w + h == 0)
				break;
			sea = new int[h][w];
			
			for (int i = 0; i < h; i++) {
				inp = br.readLine().split(" ");
				for (int j = 0; j < w; j++) {
					sea[i][j] = Integer.parseInt(inp[j]);
				}
			}

			bw.write(search(w, h) + "\n");
		}

		bw.flush();
		bw.close();

	}

}
