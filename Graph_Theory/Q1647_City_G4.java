package Graph_Theory;

/*
commented by ChatGPT
This Java code implements Kruskal's algorithm to find the Minimum Spanning Tree (MST) of a graph and then subtracts the cost of the most expensive edge from the total cost of the MST. '
The graph's edges are stored in a priority queue to ensure they are processed in order of increasing cost. 
Each edge connects two nodes (s and e) and has an associated cost. 
The program uses Union-Find data structure to detect cycles and avoid adding edges that would create a cycle in the MST. 
The goal is to minimize the total cost of connecting all nodes while ensuring there are no cycles. 
After finding the MST, the code calculates the total cost minus the cost of the most expensive edge, effectively finding the second-best MST or minimizing the total connection cost under a slightly different constraint.
이 Java 코드는 그래프의 최소 신장 트리(MST)를 찾기 위해 크루스칼 알고리즘을 구현하고, MST의 총 비용에서 가장 비싼 간선의 비용을 뺍니다. 
그래프의 간선들은 우선순위 큐에 저장되어 비용이 증가하는 순서대로 처리됩니다. 각 간선은 두 노드(s와 e)를 연결하며 비용이 연결되어 있습니다. 
프로그램은 Union-Find 자료 구조를 사용하여 사이클을 감지하고 MST에서 사이클을 생성할 간선을 추가하지 않습니다. 
목표는 모든 노드를 연결하는 총 비용을 최소화하면서 사이클이 없도록 하는 것입니다. 
MST를 찾은 후, 코드는 가장 비싼 간선의 비용을 뺀 총 비용을 계산하여 두 번째로 좋은 MST를 찾거나 약간 다른 제약 조건하에서 총 연결 비용을 최소화합니다.
*/

import java.io.*;
import java.util.*;

public class Q1647_City_G4 {

	static int parent[] = new int[100001]; // Parent array for Union-Find

	static class node implements Comparable<node> { // Node class representing an edge

		int s, e, cost; // Start node, end node, and cost of the edge

		node(int s, int e, int cost) {
			this.s = s;
			this.e = e;
			this.cost = cost;
		}

		@Override
		public int compareTo(node o) { // Compare function for priority queue
			return this.cost - o.cost; // Order by edge cost
		}

	}

	static int getpar(int n) { // Find parent function for Union-Find

		if (n == parent[n]) // If node is its own parent
			return parent[n];
		else { // Path compression
			parent[n] = getpar(parent[n]); // Find and set the ultimate parent
			return parent[n]; // Return the ultimate parent
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		PriorityQueue<node> pq = new PriorityQueue<>(); // Priority queue for edges
		int N, M; // Number of nodes, number of edges
		int sum = 0; // Total cost of MST
		int maxcost = 0; // Cost of the most expensive edge in the MST
		String inp[];

		inp = br.readLine().split(" "); // Reading N and M
		N = Integer.parseInt(inp[0]); // Number of nodes
		M = Integer.parseInt(inp[1]); // Number of edges

		for (int i = 1; i <= N; i++) // Initialize parent array
			parent[i] = i;

		for (int i = 0; i < M; i++) { // Read and add edges to priority queue
			inp = br.readLine().split(" ");
			pq.add(new node(Integer.parseInt(inp[0]), Integer.parseInt(inp[1]), Integer.parseInt(inp[2])));
		}

		while (!pq.isEmpty()) { // Process edges in order of increasing cost
			node cur = pq.poll(); // Get the next cheapest edge
			if (getpar(cur.s) == getpar(cur.e)) // If adding this edge creates a cycle
				continue; // Skip this edge

			parent[getpar(cur.e)] = getpar(cur.s); // Union operation
			sum += cur.cost; // Add cost to total
			maxcost = cur.cost; // Update most expensive edge if applicable

		}

		bw.write((sum - maxcost) + ""); // Write total cost minus cost of most expensive edge
		bw.flush();
		bw.close();
	}
}