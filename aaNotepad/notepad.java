package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {

	static int mem[];
	static ArrayList<Integer> fam[];
	static int parent[];
	static int a, b;

	static int search() {

		Queue<Integer> q = new LinkedList<>();
		q.add(a);
		mem[a] = 0;

		while (!q.isEmpty()) {
			int cur = q.poll();
			if (parent[cur] > 0 && mem[parent[cur]] < 0) {
				q.add(parent[cur]);
				mem[parent[cur]] = mem[cur] + 1;
				if (parent[cur] == b)
					break;
			}
			for (int i = 0; i < fam[cur].size(); i++) {
				if (mem[fam[cur].get(i)] >= 0)
					continue;
				q.add(fam[cur].get(i));
				mem[fam[cur].get(i)] = mem[cur] + 1;
				if (fam[cur].get(i) == b)
					break;
			}
		}

		return mem[b];

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n, m;

		n = Integer.parseInt(br.readLine());
		String inp[] = br.readLine().split(" ");
		a = Integer.parseInt(inp[0]);
		b = Integer.parseInt(inp[1]);
		m = Integer.parseInt(br.readLine());
		fam = new ArrayList[n + 1];
		parent = new int[n + 1];
		mem = new int[n + 1];
		Arrays.fill(parent, 0);
		Arrays.fill(mem, -1);
		for (int i = 1; i <= n; i++)
			fam[i] = new ArrayList<Integer>();

		for (int i = 0; i < m; i++) {
			inp = br.readLine().split(" ");
			int x, y;
			x = Integer.parseInt(inp[0]);
			y = Integer.parseInt(inp[1]);
			fam[x].add(y);
			parent[y] = x;
		}

		bw.write(search() + "");
		bw.flush();
		bw.close();

	}

}
