package Graph_Theory;

import java.util.*;
import java.io.*;

class Q11724_Link_S2 {

	static void get(int i, int[][] Line, boolean[] bl) {
		Queue<Integer> q = new LinkedList<>();

		q.add(i);

		while (!q.isEmpty()) {
			int z = q.poll();

			for (int x = 0; x < Line[z][0]; x++) {
				int y = Line[z][x + 1];

				if (!bl[y]) {
					q.add(y);
					bl[y] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int cnt = 0;

		int[][] Line = new int[1001][1001];
		boolean[] bl = new boolean[a + 1];

		for (int i = 0; i < b; i++) {

			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			Line[n][++Line[n][0]] = m;
			Line[m][++Line[m][0]] = n;
		}

		for (int i = 1; i <= a; i++) {
			if (!bl[i]) {
				bl[i] = true;

				get(i, Line, bl);

				cnt++;

			}
		}

		System.out.println(cnt);

	}
}