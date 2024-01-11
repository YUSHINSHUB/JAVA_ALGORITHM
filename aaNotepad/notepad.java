package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {

	static int n;
	static node nodes[];
	static Boolean visited[];
	static int edge = 0;
	static int res = 0;

	static class node {
		ArrayList<Integer> child = new ArrayList<>();
		ArrayList<Integer> dist = new ArrayList<>();

		node() {
		}
	}

	static void dfs(int idx, int len) {

		if (len > res) {
			res = len;
			edge = idx;
		}

		for (int i = 0; i < nodes[idx].child.size(); i++) {
			if (visited[nodes[idx].child.get(i)])
				continue;
			visited[nodes[idx].child.get(i)] = true;
			dfs(nodes[idx].child.get(i), len + nodes[idx].dist.get(i));
			visited[nodes[idx].child.get(i)] = false;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[];
		int in;

		n = Integer.parseInt(br.readLine());
		nodes = new node[n + 1];
		visited = new Boolean[n + 1];
		Arrays.fill(visited, false);

		for (int i = 1; i <= n; i++)
			nodes[i] = new node();
		for (int i = 0; i < n; i++) {
			inp = br.readLine().split(" ");
			in = Integer.parseInt(inp[0]);
			for (int j = 1; !inp[j].equals("-1"); j += 2) {
				nodes[in].child.add(Integer.parseInt(inp[j]));
				nodes[in].dist.add(Integer.parseInt(inp[j + 1]));

			}
		}

		visited[1] = true;
		dfs(1, 0);
		visited[1] = false;

		visited[edge] = true;
		dfs(edge, 0);

		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}