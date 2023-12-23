package Shortest_Path;

/*
commented by ChatGPT
This Java code implements the Dijkstra's shortest path algorithm using a priority queue for a given graph. 
The objective is to find the shortest path from a given source node (K) to all other nodes in the graph.
이 Java 코드는 주어진 그래프에 대해 우선 순위 큐를 사용하여 Dijkstra의 최단 경로 알고리즘을 구현합니다. 
목적은 주어진 시작 노드(K)로부터 그래프의 모든 다른 노드까지의 최단 경로를 찾는 것입니다.
*/

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Q1753_Path_G4 {

	static class vertex<s, e> {
		int s;
		int e;

		vertex(int s, int e) {
			this.s = s;
			this.e = e;
		}

		// Check for object equality (객체 간의 동일성을 확인)
		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			vertex position = (vertex) o;
			return s == position.s && e == position.e;
		}

		// Generate hash code for the object (객체의 해시 코드 생성)
		@Override
		public int hashCode() {
			return Objects.hash(s, e);
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Reading number of vertices, edges and source vertex (정점, 간선 및 시작 정점 읽기)
		String inp[] = br.readLine().split(" ");
		int V = Integer.parseInt(inp[0]);
		int E = Integer.parseInt(inp[1]);
		int K = Integer.parseInt(br.readLine());

		// Initializing hashmaps for edge weights and other necessary arrays (간선 가중치 및
		// 기타 필요한 배열에 대한 해시맵 초기화)
		HashMap<Integer, Integer> hm[] = new HashMap[V + 1];
		for (int i = 1; i <= V; i++)
			hm[i] = new HashMap<>();

		int mem[] = new int[V + 1];
		boolean visited[] = new boolean[V + 1];
		Arrays.fill(mem, 100000000);
		Arrays.fill(visited, false);
		mem[K] = 0;
		visited[K] = true;

		// Setting up the priority queue for Dijkstra's algorithm with custom comparator
		// (Dijkstra 알고리즘용 우선 순위 큐 설정 및 사용자 지정 비교기 구성)
		PriorityQueue<vertex> pq = new PriorityQueue<>(new Comparator<vertex>() {
			@Override
			public int compare(vertex o1, vertex o2) {
				return mem[o1.s] - mem[o2.s];
			}
		});

		// Reading the edges and weights and updating the priority queue accordingly (간선
		// 및 가중치 읽기 및 우선 순위 큐 업데이트)
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

		// Dijkstra's algorithm: finding shortest paths (Dijkstra 알고리즘: 최단 경로 찾기)
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

		// Writing the shortest path results (최단 경로 결과 작성)
		for (int i = 1; i <= V; i++) {
			if (mem[i] >= 100000000)
				bw.write("INF\n");
			else
				bw.write(mem[i] + "\n");
		}

		// Flushing and closing the BufferedWriter (BufferedWriter를 플러시하고 닫기)
		bw.flush();
		bw.close();
	}
}