package Shortest_Path;

/*
commented by ChatGPT
This Java code implements the Bellman-Ford algorithm to find the shortest paths from a single source to all other vertices in a weighted graph. 
It handles the case of negative weight edges, making it suitable for detecting negative cycles in a graph. 
If a negative cycle is detected (meaning a shorter path can always be found), the algorithm reports its presence. 
The graph's vertices and edges are input, and the algorithm initializes distance values, setting the source vertex's distance to 0 and all others to infinity. 
It then iteratively relaxes edges, updating distances to provide the shortest paths. 
If any distance can be reduced in the Nth iteration (where N is the number of vertices), a negative cycle exists, and the algorithm indicates this. 
Otherwise, it outputs the shortest distances to all vertices from the source.

이 Java 코드는 가중 그래프에서 단일 출발점으로부터 모든 다른 정점까지의 최단 경로를 찾기 위해 벨만-포드 알고리즘을 구현합니다. 
음수 가중치 간선을 처리할 수 있어 그래프 내 음수 사이클을 탐지하는 데 적합합니다. 음수 사이클이 감지되면(항상 더 짧은 경로를 찾을 수 있다는 의미), 알고리즘은 그 존재를 보고합니다. 
그래프의 정점과 간선이 입력되고, 알고리즘은 거리 값을 초기화하여 출발점의 거리를 0으로 설정하고 다른 모든 것을 무한대로 설정합니다. 
그런 다음 반복적으로 간선을 완화하여 최단 경로를 제공하는 거리를 업데이트합니다. N번째 반복에서 거리를 줄일 수 있다면(여기서 N은 정점의 수), 음수 사이클이 존재하며 알고리즘은 이를 나타냅니다. 
그렇지 않으면 출발점에서 모든 정점까지의 최단 거리를 출력합니다.
*/

import java.io.*;
import java.util.*;

public class Q11657_TimeMachine_G4 {

	static Long dist[] = new Long[6001]; // Stores the shortest distance from the source to each vertex
	static ArrayList<edge> list = new ArrayList<>(); // List to store all edges in the graph
	static int N, M; // N: Number of vertices, M: Number of edges

	static class edge { // Represents an edge in the graph

		int s; // Start vertex
		int e; // End vertex
		int w; // Weight of the edge

		edge(int s, int e, int w) { // Constructor
			this.s = s;
			this.e = e;
			this.w = w;
		}

	}

	static Boolean bellman() { // Implements Bellman-Ford algorithm

		for (int i = 1; i <= N; i++) { // For each vertex
			for (int j = 0; j < M; j++) { // For each edge
				edge e = list.get(j);
				if (dist[e.s] == Long.MAX_VALUE) // If the start vertex has not been reached yet
					continue;
				else {
					if (dist[e.s] + e.w < dist[e.e]) { // If a shorter path to the end vertex is found
						if (i == N) // If we are still finding shorter paths in the Nth iteration, a negative cycle
									// exists
							return false;
						dist[e.e] = dist[e.s] + e.w; // Update the shortest path to the end vertex
					}
				}
			}
		}

		return true; // No negative cycle found

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[];

		inp = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]); // Number of vertices
		M = Integer.parseInt(inp[1]); // Number of edges

		Arrays.fill(dist, Long.MAX_VALUE); // Initialize all distances to infinity
		dist[1] = (long) 0; // Distance from the source to itself is 0

		for (int i = 0; i < M; i++) { // Input all edges
			inp = br.readLine().split(" ");
			int s = Integer.parseInt(inp[0]); // Start vertex
			int e = Integer.parseInt(inp[1]); // End vertex
			int w = Integer.parseInt(inp[2]); // Weight of the edge
			list.add(new edge(s, e, w)); // Add edge to the list
		}

		if (!bellman()) // If a negative cycle is detected
			bw.write("-1");
		else {
			for (int i = 2; i <= N; i++) { // Output shortest distances to all vertices except the source
				if (dist[i] == Long.MAX_VALUE) // If a vertex is unreachable
					bw.write("-1\n");
				else
					bw.write(dist[i] + "\n");
			}
		}

		bw.flush();
		bw.close();
	}
}
