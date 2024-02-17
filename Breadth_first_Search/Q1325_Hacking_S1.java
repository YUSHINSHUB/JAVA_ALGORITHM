package Breadth_first_Search;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.math.*;

public class Q1325_Hacking_S1 {

	static int N, M;
	static int hig = 0;
	static int res[] = new int[10001];
	static ArrayList<Integer> list[] = new ArrayList[10001];
	static Boolean visited[] = new Boolean[10001];

	static void bfs(int idx) {

		Queue<Integer> q = new LinkedList<>();
		q.add(idx);
		visited[idx] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int next : list[cur]) {
				if (visited[next])
					continue;
				q.add(next);
				res[next]++;
				hig = Math.max(hig, res[next]);
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[];

		inp = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]);
		M = Integer.parseInt(inp[1]);

		for (int i = 1; i <= N; i++)
			list[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			inp = br.readLine().split(" ");
			list[Integer.parseInt(inp[0])].add(Integer.parseInt(inp[1]));
		}

		Arrays.fill(res, 0);
		for (int i = 1; i <= N; i++) {
			Arrays.fill(visited, false);
			bfs(i);
		}

		for (int i = 1; i <= N; i++)
			if (res[i] == hig)
				bw.write(i + " ");
		bw.flush();
		bw.close();
	}
}