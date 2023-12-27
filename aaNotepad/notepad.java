package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {

	static int N, E;
	static int v1, v2;
	static int f = 0;
	static int s = 0;
	static ArrayList<Integer> route[];
	static int distance[][];
	static int mem[];
	static Boolean visited[];

	static int dijk(int start, int end) {

		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			if (mem[o1] > mem[o2])
				return 1;
			else
				return -1;
		});

		Arrays.fill(visited, false);
		Arrays.fill(mem, 200000000);
		mem[start] = 0;
		pq.add(start);

		while (!pq.isEmpty()) {
			int cur = pq.poll();
			if (visited[cur])
				continue;
			visited[cur] = true;
			for (int i = 0; i < route[cur].size(); i++) {
				int temp = route[cur].get(i);
				mem[temp] = Math.min(mem[temp], mem[cur] + distance[cur][temp]);
				pq.add(temp);
			}
		}

		return mem[end];
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]);
		E = Integer.parseInt(inp[1]);
		route = new ArrayList[N + 1];
		distance = new int[N + 1][N + 1];
		visited = new Boolean[N + 1];
		mem = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			route[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < E; i++) {
			inp = br.readLine().split(" ");
			int a = Integer.parseInt(inp[0]);
			int b = Integer.parseInt(inp[1]);
			int d = Integer.parseInt(inp[2]);
			route[a].add(b);
			route[b].add(a);
			distance[a][b] = d;
			distance[b][a] = d;
		}
		inp = br.readLine().split(" ");
		v1 = Integer.parseInt(inp[0]);
		v2 = Integer.parseInt(inp[1]);

		int r1 = dijk(1, v1) + dijk(v1, v2) + dijk(v2, N);
		int r2 = dijk(1, v2) + dijk(v2, v1) + dijk(v1, N);
		int res = Math.min(r1, r2);

		if (res >= 200000000)
			bw.write("-1");
		else
			bw.write(res + "");
		bw.flush();
		bw.close();

	}

}
