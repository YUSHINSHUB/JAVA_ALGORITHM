package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {

	static int N, X;
	static ArrayList<Integer> route[];
	static int distance[][];
	static int mem[];
	static Boolean visited[];
	static int dist[];

	static int dijk(int dep) {

		Arrays.fill(visited, false);
		Arrays.fill(mem, Integer.MAX_VALUE);
		mem[dep] = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			if (mem[o1] > mem[o2])
				return 1;
			else
				return -1;
		});

		pq.add(dep);

		while (!pq.isEmpty()) {

			int cur = pq.poll();
			if (visited[cur])
				continue;
			visited[cur] = true;

			for (int i = 0; i < route[cur].size(); i++) {
				int next = route[cur].get(i);
				mem[next] = Math.min(mem[next], mem[cur] + distance[cur][next]);
				if (!visited[next]) {
					pq.add(next);
				}
			}
		}

		return mem[X];
	}

	static int back() {

		int res = 0;
		Arrays.fill(visited, false);
		Arrays.fill(mem, Integer.MAX_VALUE);
		mem[X] = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			if (mem[o1] > mem[o2])
				return 1;
			else
				return -1;
		});

		pq.add(X);

		while (!pq.isEmpty()) {

			int cur = pq.poll();
			if (visited[cur])
				continue;
			visited[cur] = true;

			for (int i = 0; i < route[cur].size(); i++) {
				int next = route[cur].get(i);
				mem[next] = Math.min(mem[next], mem[cur] + distance[cur][next]);
				if (!visited[next]) {
					pq.add(next);
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			if (i == X)
				continue;
			dist[i] += mem[i];
			res = Math.max(res, dist[i]);
		}
		return res;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int dep, arr, dis;
		int M;
		int res = 0;

		String inp[] = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]);
		M = Integer.parseInt(inp[1]);
		X = Integer.parseInt(inp[2]);

		dist = new int[N + 1];
		route = new ArrayList[N + 1];
		distance = new int[N + 1][N + 1];
		mem = new int[N + 1];
		visited = new Boolean[N + 1];
		Arrays.fill(visited, false);
		for (int i = 1; i <= N; i++) {
			route[i] = new ArrayList<>();
			Arrays.fill(distance[i], 101);
		}

		for (int i = 0; i < M; i++) {
			inp = br.readLine().split(" ");
			dep = Integer.parseInt(inp[0]);
			arr = Integer.parseInt(inp[1]);
			dis = Integer.parseInt(inp[2]);
			if (distance[dep][arr] > 100)
				route[dep].add(arr);
			distance[dep][arr] = Math.min(distance[dep][arr], dis);
		}

		visited[X] = true;

		for (int i = 1; i <= N; i++) {
			if (i == X)
				continue;
			dist[i] = dijk(i);
		}

		for (int i = 1; i <= N; i++) {

		}

		bw.write(back() + "");
		bw.flush();
		bw.close();

	}

}
