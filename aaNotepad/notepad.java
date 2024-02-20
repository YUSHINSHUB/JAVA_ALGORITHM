package aaNotepad;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.math.*;

public class notepad {

	static int cost[] = new int[1001];
	static int edge[][] = new int[1001][1001];
	static ArrayList<Integer> next[] = new ArrayList[1001];
	static ArrayList<Integer> prev[] = new ArrayList[1001];
	static ArrayList<Integer> path = new ArrayList<>();
	static int from, to;
	static Boolean visited[] = new Boolean[1001];

	static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
		return cost[o1] - cost[o2];
	});

	static int dajikstra() {

		pq.add(from);
		cost[from] = 0;

		while (!pq.isEmpty()) {
			int cur = pq.poll();
			visited[cur] = true;
			for (int i = 0; i < next[cur].size(); i++) {
				int temp = next[cur].get(i);
				if (visited[temp])
					continue;
				if (cost[temp] > cost[cur] + edge[cur][temp]) {
					cost[temp] = cost[cur] + edge[cur][temp];
					pq.add(temp);
				}
			}
		}

		return cost[to];
	}

	static void find_path() {

		int cur = to;
		path.add(to);

		while (cur != from) {
			for (int i = 0; i < prev[cur].size(); i++) {
				int p = prev[cur].get(i);
				if (cost[p] + edge[p][cur] == cost[cur]) {
					path.add(p);
					cur = p;
					break;
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[];
		int n, m, res;

		Arrays.fill(visited, false);
		Arrays.fill(cost, Integer.MAX_VALUE);
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			next[i] = new ArrayList<>();
			prev[i] = new ArrayList<>();
			Arrays.fill(edge[i], Integer.MAX_VALUE);
		}
		for (int i = 0; i < m; i++) {
			inp = br.readLine().split(" ");
			int a = Integer.parseInt(inp[0]);
			int b = Integer.parseInt(inp[1]);
			int c = Integer.parseInt(inp[2]);
			
			next[a].add(b);
			prev[b].add(a);
			edge[a][b]= Math.min(edge[a][b], c);
		}

		inp = br.readLine().split(" ");
		from = Integer.parseInt(inp[0]);
		to = Integer.parseInt(inp[1]);

		res = dajikstra();
		find_path();

		bw.write(res + "\n" + path.size() + "\n");
		for (int i = path.size() - 1; i >= 0; i--)
			bw.write(path.get(i) + " ");
		bw.flush();
		bw.close();
	}
}