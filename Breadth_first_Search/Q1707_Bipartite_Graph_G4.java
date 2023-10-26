package Breadth_first_Search;

/*
commented by ChatGPT
This Java code determines whether a given graph can be bicolorable using BFS (Breadth-First Search).
A graph is bicolorable if the vertices can be divided into two groups where no two adjacent vertices are in the same group.
이 Java 코드는 BFS(너비 우선 탐색)을 사용하여 주어진 그래프가 이분 그래프인지 확인합니다.
그래프는 정점을 두 그룹으로 나누었을 때 인접한 두 정점이 같은 그룹에 속하지 않으면 이분 그래프라고 할 수 있습니다.
*/

import java.io.*;
import java.util.*;

public class Q1707_Bipartite_Graph_G4 {

	static int V, E; // Number of vertices and edges (정점과 간선의 수)
	static Queue<Integer>[] q = new LinkedList[20001]; // Adjacency list to represent the graph (그래프를 표현하는 인접 리스트)
	static int chk[] = new int[20001]; // Array to track vertex colors (정점 색상을 추적하는 배열)

	static boolean bfs() { // BFS function to determine if the graph is bicolorable (그래프가 이분 그래프인지 결정하기 위한
							// BFS 함수)
		boolean res = true; // Result variable (결과 변수)
		int idx = 0; // Index to determine the current vertex's color (현재 정점의 색상을 결정하기 위한 인덱스)
		Queue<Integer> bq = new LinkedList<>(); // BFS queue (BFS 큐)

		for (int i = 1; i <= V; i++) { // Loop through all vertices (모든 정점을 순회)
			if (chk[i] == 0) { // If the vertex is not visited (정점이 방문되지 않은 경우)
				idx = 1; // Start with color 1 (색상 1로 시작)
				chk[i] = 1;
				bq.add(i);

				while (!bq.isEmpty()) {
					int temp = bq.poll();
					idx = chk[temp];

					while (!q[temp].isEmpty()) { // Loop through adjacent vertices (인접한 정점들을 순회)
						int t = q[temp].poll();

						if (chk[t] == 0) { // If adjacent vertex is not visited (인접한 정점이 방문되지 않은 경우)
							if (idx == 1) {
								chk[t] = 2;
								bq.add(t);
							} else {
								bq.add(t);
								chk[t] = 1;
							}
						} else if ((idx == 1 && chk[t] == 1) || (idx == 2 && chk[t] == 2)) { // If adjacent vertex has
																								// same color (인접한 정점이
																								// 같은 색상을 가진 경우)
							res = false;
							break;
						}
					}

					if (!res)
						break;
				}
				if (!res)
					break;
				idx = 0;
			}
		}
		return res; // Return result (결과 반환)
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int K = Integer.parseInt(br.readLine()); // Number of test cases (테스트 케이스의 수)

		for (int i = 0; i < K; i++) {
			String inp[] = br.readLine().split(" ");
			V = Integer.parseInt(inp[0]);
			E = Integer.parseInt(inp[1]);
			Arrays.fill(chk, 0);

			for (int j = 1; j <= V; j++)
				q[j] = new LinkedList<>(); // Initialize the adjacency list for each test case (각 테스트 케이스에 대해 인접 리스트
											// 초기화)

			for (int j = 0; j < E; j++) { // Reading edges (간선 읽기)
				inp = br.readLine().split(" ");
				int a = Integer.parseInt(inp[0]);
				int b = Integer.parseInt(inp[1]);

				q[a].add(b); // Add edge to adjacency list (간선을 인접 리스트에 추가)
				q[b].add(a); // Add reverse edge as graph is undirected (그래프가 무향이므로 역 간선 추가)
			}

			if (bfs()) { // If graph is bicolorable (그래프가 이분 그래프인 경우)
				bw.write("YES\n");
			} else {
				bw.write("NO\n");
			}
		}

		bw.flush();
		bw.close(); // Close the BufferedWriter (BufferedWriter 닫기)
	}
}
