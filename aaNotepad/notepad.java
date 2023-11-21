package aaNotepad;

import java.io.*;
import java.util.*;

class route {
	int to, lim;

	route(int to, int lim) {
		this.to = to;
		this.lim = lim;
	}
}

public class notepad {

	static int N, M;
	static boolean visited[];
	static int f1, f2;
	static int hig = Integer.MIN_VALUE;
	static int low = Integer.MAX_VALUE;
	static int mid = 0;
	static ArrayList<route>[] list;

	static boolean search(int idx) {

		Arrays.fill(visited, false);
		visited[f1] = true;
		Queue<Integer> q = new LinkedList<>();
		q.add(f1);
		while (!q.isEmpty()) {
			int t = q.poll();
			if (t == f2) {
				return true;
			}
			for (int i = 0; i < list[t].size(); i++) {
				if (list[t].get(i).lim >= idx && !visited[list[t].get(i).to]) {
					q.add(list[t].get(i).to);
					visited[list[t].get(i).to] = true;
				}
			}

		}

		return false;

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int res = 0;
		String inp[] = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]);
		M = Integer.parseInt(inp[1]);
		visited = new boolean[N + 1];
		list = new ArrayList[N + 1];

		Arrays.fill(visited, false);
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			inp = br.readLine().split(" ");
			int A = Integer.parseInt(inp[0]);
			int B = Integer.parseInt(inp[1]);
			int C = Integer.parseInt(inp[2]);

			list[A].add(new route(B, C));
			list[B].add(new route(A, C));

			hig = Math.max(hig, C);
			low = Math.min(low, C);
		}

		mid = (low + hig) / 2;

		inp = br.readLine().split(" ");
		f1 = Integer.parseInt(inp[0]);
		f2 = Integer.parseInt(inp[1]);
		visited[f1] = true;

		while (low <= hig) {
			mid = (low + hig) / 2;
			if (search(mid)) {
				low = mid + 1;
				res = mid;
			} else {
				hig = mid - 1;
			}
		}

		bw.write(res + "");
		bw.flush();
		bw.close();

	}

}
