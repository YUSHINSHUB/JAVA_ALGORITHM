package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {

	static int fee[][];
	static ArrayList<Integer> route[];
	static int departure, arrival;
	static Boolean visited[];
	static long mem[];

	static long dijk() {

		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			if (mem[o1] > mem[o2])
				return 1;
			else
				return -1;
		});

		pq.add(departure);

		while (!pq.isEmpty()) {
			int idx = pq.poll();
			if (visited[idx])
				continue;
			visited[idx] = true;
			for (int i = 0; i < route[idx].size(); i++) {
				int temp = route[idx].get(i);
				mem[temp] = Math.min(mem[temp], mem[idx] + fee[idx][temp]);
				pq.add(temp);
			}
		}

		return mem[arrival];

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int dep, arr, pri;
		int N, M;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		fee = new int[N + 1][N + 1];
		route = new ArrayList[N + 1];
		visited = new Boolean[N + 1];
		mem = new long[N + 1];

		Arrays.fill(visited, false);
		Arrays.fill(mem, Long.MAX_VALUE);
		for (int i = 1; i <= N; i++) {
			Arrays.fill(fee[i], Integer.MAX_VALUE);
			route[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			String inp[] = br.readLine().split(" ");
			dep = Integer.parseInt(inp[0]);
			arr = Integer.parseInt(inp[1]);
			pri = Integer.parseInt(inp[2]);

			fee[dep][arr] = Math.min(fee[dep][arr], pri);
			route[dep].add(arr);
		}

		String inp[] = br.readLine().split(" ");
		departure = Integer.parseInt(inp[0]);
		arrival = Integer.parseInt(inp[1]);
		mem[departure] = 0;

		bw.write(dijk() + "");
		bw.flush();
		bw.close();

	}

}
