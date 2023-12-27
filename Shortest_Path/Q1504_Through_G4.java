package Shortest_Path;

/*
commented by ChatGPT
This Java code implements Dijkstra's algorithm to find the shortest path in a graph. 
The main goal is to determine the shortest path from node 1 to node N, passing through two specified nodes v1 and v2 in either order. 
It calculates two possible routes (1 -> v1 -> v2 -> N and 1 -> v2 -> v1 -> N) and chooses the one with the minimum total distance. 
If no such path exists, it outputs -1.
이 Java 코드는 그래프에서 최단 경로를 찾기 위해 다익스트라 알고리즘을 구현합니다. 
주요 목적은 두 지정된 노드 v1과 v2를 통과하여 노드 1에서 노드 N까지의 최단 경로를 결정하는 것입니다. 
두 가지 가능한 경로(1 -> v1 -> v2 -> N 및 1 -> v2 -> v1 -> N)를 계산하고 최소 총 거리를 갖는 경로를 선택합니다. 
만약 그러한 경로가 존재하지 않으면 -1을 출력합니다.
*/

import java.io.*;
import java.util.*;

public class Q1504_Through_G4 {

	static int N, E; // Number of nodes and edges (노드와 엣지의 수)
	static int v1, v2; // Two specified nodes to pass through (통과해야 하는 두 지정된 노드)
	static ArrayList<Integer> route[]; // Adjacency list to store routes (경로를 저장하는 인접 리스트)
	static int distance[][]; // Distance between each pair of nodes (각 노드 쌍 사이의 거리)
	static int mem[]; // Memory array for Dijkstra's algorithm (다익스트라 알고리즘을 위한 메모리 배열)
	static Boolean visited[]; // Array to track visited nodes (방문한 노드를 추적하는 배열)

	static int dijk(int start, int end) { // Dijkstra's algorithm (다익스트라 알고리즘)

		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			if (mem[o1] > mem[o2])
				return 1;
			else
				return -1;
		});

		Arrays.fill(visited, false); // Reset visited nodes (방문한 노드 초기화)
		Arrays.fill(mem, 200000000); // Initialize memory array with high values (메모리 배열을 높은 값으로 초기화)
		mem[start] = 0; // Distance to the start node is 0 (시작 노드까지의 거리는 0)
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

		return mem[end]; // Return the shortest distance to the end node (종료 노드까지의 최단 거리 반환)
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]); // Read the number of nodes (노드의 수 읽기)
		E = Integer.parseInt(inp[1]); // Read the number of edges (엣지의 수 읽기)
		route = new ArrayList[N + 1];
		distance = new int[N + 1][N + 1];
		visited = new Boolean[N + 1];
		mem = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			route[i] = new ArrayList<Integer>();
		}

		// Read edges and their distances (엣지와 그 거리 읽기)
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

		// Calculate two possible routes and find the minimum (두 가지 가능한 경로를 계산하고 최소값 찾기)
		int r1 = dijk(1, v1) + dijk(v1, v2) + dijk(v2, N);
		int r2 = dijk(1, v2) + dijk(v2, v1) + dijk(v1, N);
		int res = Math.min(r1, r2);

		// Output the result (-1 if no path exists) (결과 출력, 경로가 없으면 -1)
		if (res >= 200000000)
			bw.write("-1");
		else
			bw.write(res + "");
		bw.flush();
		bw.close();

	}
}