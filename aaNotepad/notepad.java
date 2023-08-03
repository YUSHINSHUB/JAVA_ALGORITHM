package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	static int visited[];
	static int cur = 0;
	static ArrayList<Integer>[] node;

	public static void bfs(int idx) {

		Queue<Integer> q = new LinkedList<>();
		q.add(idx);
		cur++;
		visited[idx] = 1;

		while (!q.isEmpty()) {
			int n = q.poll();
			for (int temp : node[n]) {
				if (visited[temp] == 0) {
					q.add(temp);
					visited[temp] = 1;
					cur++;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int hig = 0;
		int m = Integer.parseInt(inp[1]);
		int scr[] = new int[n + 1];
		visited = new int[n + 1];
		node = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++)
			node[i] = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			inp = br.readLine().split(" ");
			int a = Integer.parseInt(inp[0]);
			int b = Integer.parseInt(inp[1]);
			node[b].add(a);
		}

		for (int i = 1; i <= n; i++) {
			visited = new int[n + 1];
			cur = 0;
			bfs(i);
			scr[i] = cur;
			if (cur > hig)
				hig = cur;
		}

		StringBuilder res = new StringBuilder("");
		for (int i = 1; i <= n; i++) {
			if (scr[i] == hig)
				res.append(i + " ");
		}

		bw.write(res.toString());
		bw.flush();
		bw.close();

	}
}