package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.Entry;

class vertex<s, e> {
	int s;
	int e;

	vertex(int s, int e) {
		this.s = s;
		this.e = e;
	}

	// 객체 간의 동일성을 확인 (Check for object equality)
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		vertex position = (vertex) o;
		return s == position.s && e == position.e;
	}

	// 객체의 해시 코드 생성 (Generate hash code for the object)
	@Override
	public int hashCode() {
		return Objects.hash(s, e);
	}
}

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		int V = Integer.parseInt(inp[0]);
		int E = Integer.parseInt(inp[1]);
		int K = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> hm[] = new HashMap[V + 1];
		for (int i = 1; i <= V; i++)
			hm[i] = new HashMap<>();

		int mem[] = new int[V + 1];
		boolean visited[] = new boolean[V + 1];
		Arrays.fill(mem, 100000000);
		Arrays.fill(visited, false);
		mem[K] = 0;
		visited[K] = true;

		PriorityQueue<vertex> pq = new PriorityQueue<>(new Comparator<vertex>() {
			@Override
			public int compare(vertex o1, vertex o2) {
				return mem[o1.s] - mem[o2.s];
			}
		});

		for (int i = 0; i < E; i++) {
			inp = br.readLine().split(" ");
			int u = Integer.parseInt(inp[0]);
			int v = Integer.parseInt(inp[1]);
			int w = Integer.parseInt(inp[2]);

			if (hm[u].getOrDefault(v, 11) > w) {
				pq.add(new vertex(u, v));
				hm[u].put(v, w);
			}
		}

		while (!pq.isEmpty()) {
			vertex vt = pq.poll();

			int s = vt.s;
			int e = vt.e;

			if (mem[s] >= 100000000)
				continue;

			if (e != K && mem[e] > mem[s] + hm[s].get(e)) {
				mem[e] = mem[s] + hm[s].get(e);
				for (Entry<Integer, Integer> en : hm[e].entrySet()) {
					pq.add(new vertex(e, en.getKey()));
				}
			}

		}

		for (int i = 1; i <= V; i++) {
			if (mem[i] >= 100000000)
				bw.write("INF\n");
			else
				bw.write(mem[i] + "\n");
		}

		bw.flush();
		bw.close();

	}

}
