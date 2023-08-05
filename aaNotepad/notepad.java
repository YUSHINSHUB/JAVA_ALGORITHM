package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	static int node[];
	static int visited[];
	static ArrayList<Integer>[] edge;
	static int res[];
	static int idx = 0;

	static void dfs(int r) {

		idx++;
		res[r] = idx;
		visited[r] = 1;

		for (int v : edge[r]) {
			if (visited[v] < 1)
				dfs(v);
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int m = Integer.parseInt(inp[1]);
		int r = Integer.parseInt(inp[2]);

		node = new int[n + 1];
		visited = new int[n + 1];
		res = new int[n + 1];
		edge = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			edge[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			inp = br.readLine().split(" ");
			int u = Integer.parseInt(inp[0]);
			int v = Integer.parseInt(inp[1]);
			edge[u].add(v);
			edge[v].add(u);
		}

		for (int i = 1; i <= n; i++) {
			Collections.sort(edge[i]);
		}

		res[r] = 1;
		visited[r] = 1;
		dfs(r);

		for (int i = 1; i <= n; i++)
			bw.write(res[i] + "\n");

		bw.flush();
		bw.close();

	}
}