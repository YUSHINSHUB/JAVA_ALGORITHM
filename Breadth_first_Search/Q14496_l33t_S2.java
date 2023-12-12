package Breadth_first_Search;

/*
commented by ChatGPT
This Java code implements a Breadth-First Search (BFS) algorithm to find the shortest path between two nodes in an undirected graph. 
The graph's vertices and edges are represented using an adjacency list. 
The algorithm calculates the minimum number of edges required to travel from node 'a' to node 'b'.
이 Java 코드는 무방향 그래프에서 두 노드 간의 최단 경로를 찾기 위해 너비 우선 탐색(BFS) 알고리즘을 구현합니다. 
그래프의 정점과 간선은 인접 리스트를 사용하여 표현됩니다. 
이 알고리즘은 노드 'a'에서 노드 'b'까지 이동하는 데 필요한 최소 간선 수를 계산합니다.
*/

import java.io.*;
import java.util.*;

public class Q14496_l33t_S2 {

	static Queue<Integer> q = new LinkedList<>(); // Queue used for BFS (BFS에 사용되는 큐)
	static ArrayList<Integer> list[]; // Adjacency list to represent the graph (그래프를 나타내는 인접 리스트)
	static int mem[]; // Array to store the minimum number of edges to reach each node (각 노드에 도달하는 데
						// 필요한 최소 간선 수를 저장하는 배열)
	static int a, b; // Nodes between which the shortest path is to be found (최단 경로를 찾을 두 노드)
	static int N, M; // N: Number of nodes, M: Number of edges (N: 노드 수, M: 간선 수)

// Function to perform BFS and find the shortest path
	static int bfs() {

		q.add(a); // Start BFS from node 'a' (노드 'a'에서 BFS 시작)

		while (!q.isEmpty()) {
			int idx = q.poll(); // Current node (현재 노드)
			// Iterate through all adjacent nodes (모든 인접 노드를 반복)
			for (int i = 0; i < list[idx].size(); i++) {
				int temp = list[idx].get(i); // Adjacent node (인접 노드)
				if (mem[temp] < 0) { // If the node is not visited yet (노드가 아직 방문되지 않았다면)
					mem[temp] = mem[idx] + 1; // Update the number of edges (간선 수 업데이트)
					q.add(temp); // Add the node to the queue (큐에 노드 추가)
				}
			}
		}

		return mem[b]; // Return the number of edges from 'a' to 'b' (노드 'a'에서 'b'까지의 간선 수 반환)
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Reading input for the nodes 'a' and 'b'
		String inp[] = br.readLine().split(" ");
		a = Integer.parseInt(inp[0]);
		b = Integer.parseInt(inp[1]);

		// Reading input for the number of nodes (N) and edges (M)
		inp = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]);
		M = Integer.parseInt(inp[1]);

		// Initializing adjacency list and memory array
		list = new ArrayList[N + 1];
		mem = new int[N + 1];
		Arrays.fill(mem, -1); // Filling memory array with -1 (unvisited)
		mem[a] = 0; // Starting node 'a' has 0 edges
		for (int i = 1; i <= N; i++)
			list[i] = new ArrayList<>();

		// Reading input for the edges and updating the adjacency list
		for (int i = 0; i < M; i++) {
			inp = br.readLine().split(" ");
			list[Integer.parseInt(inp[0])].add(Integer.parseInt(inp[1]));
			list[Integer.parseInt(inp[1])].add(Integer.parseInt(inp[0]));
		}

		bw.write(bfs() + ""); // Perform BFS and write the result
		bw.flush(); // Flush the BufferedWriter
		bw.close(); // Close the BufferedWriter

	}
}