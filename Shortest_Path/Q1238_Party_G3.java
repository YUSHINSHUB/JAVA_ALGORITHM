package Shortest_Path;

/*
commented by ChatGPT
This Java code implements a modified version of Dijkstra's algorithm to find the longest round trip distance to a target node X. 
It first calculates the shortest distance from every node to X, then finds the longest return trip from X to every other node.
이 Java 코드는 대상 노드 X까지의 최장 왕복 여행 거리를 찾기 위해 다익스트라 알고리즘의 수정된 버전을 구현합니다. 
먼저 모든 노드에서 X까지의 최단 거리를 계산한 다음, X에서 다른 모든 노드로 돌아가는 최장 여행을 찾습니다.
*/

import java.io.*;
import java.util.*;

public class Q1238_Party_G3 {

	static int N, X; // Number of nodes and the target node X (노드의 수와 대상 노드 X)
	static ArrayList<Integer> route[]; // Array of ArrayLists to store routes (노선을 저장하는 ArrayList 배열)
	static int distance[][]; // 2D array to store distances between nodes (노드 간 거리를 저장하는 2D 배열)
	static int mem[]; // Array to store minimum distances in Dijkstra's algorithm (다익스트라 알고리즘에서 최소 거리를
						// 저장하는 배열)
	static Boolean visited[]; // Array to track visited nodes (방문한 노드를 추적하는 배열)
	static int dist[]; // Array to store distances for the longest round trip (최장 왕복 여행 거리를 저장하는 배열)

	static int dijk(int dep) { // Dijkstra's algorithm implementation (다익스트라 알고리즘 구현)

		Arrays.fill(visited, false); // Reset visited nodes (방문한 노드 초기화)
		Arrays.fill(mem, Integer.MAX_VALUE); // Initialize minimum distances (최소 거리 초기화)
		mem[dep] = 0; // Set the starting node's distance to 0 (시작 노드의 거리를 0으로 설정)
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> { // Priority queue for nodes (노드를 위한 우선순위 큐)
			if (mem[o1] > mem[o2])
				return 1;
			else
				return -1;
		});

		pq.add(dep); // Add the starting node to the queue (시작 노드를 큐에 추가)

		while (!pq.isEmpty()) { // Processing nodes in the queue (큐의 노드 처리)

			int cur = pq.poll(); // Current node (현재 노드)
			if (visited[cur]) // Skip if already visited (이미 방문한 경우 건너뛰기)
				continue;
			visited[cur] = true; // Mark as visited (방문으로 표시)

			for (int i = 0; i < route[cur].size(); i++) { // Iterate over connected nodes (연결된 노드 반복)
				int next = route[cur].get(i); // Connected node (연결된 노드)
				mem[next] = Math.min(mem[next], mem[cur] + distance[cur][next]); // Update minimum distance (최소 거리 업데이트)
				if (!visited[next]) { // If the connected node is not visited (연결된 노드가 방문되지 않았다면)
					pq.add(next); // Add connected node to the queue (연결된 노드를 큐에 추가)
				}
			}
		}

		return mem[X]; // Return minimum distance to node X (노드 X까지의 최소 거리 반환)
	}

	static int back() { // Function to calculate the longest return trip (최장 귀환 여행을 계산하는 함수)

		int res = 0; // Variable to store the result (결과를 저장할 변수)
		Arrays.fill(visited, false); // Reset visited nodes (방문한 노드 초기화)
		Arrays.fill(mem, Integer.MAX_VALUE); // Initialize minimum distances (최소 거리 초기화)
		mem[X] = 0; // Set the return starting node's distance to 0 (귀환 시작 노드의 거리를 0으로 설정)
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> { // Priority queue for nodes (노드를 위한 우선순위 큐)
			if (mem[o1] > mem[o2])
				return 1;
			else
				return -1;
		});

		pq.add(X); // Add node X to the queue (노드 X를 큐에 추가)

		while (!pq.isEmpty()) { // Processing nodes in the queue (큐의 노드 처리)

			int cur = pq.poll(); // Current node (현재 노드)
			if (visited[cur]) // Skip if already visited (이미 방문한 경우 건너뛰기)
				continue;
			visited[cur] = true; // Mark as visited (방문으로 표시)

			for (int i = 0; i < route[cur].size(); i++) { // Iterate over connected nodes (연결된 노드 반복)
				int next = route[cur].get(i); // Connected node (연결된 노드)
				mem[next] = Math.min(mem[next], mem[cur] + distance[cur][next]); // Update minimum distance (최소 거리 업데이트)
				if (!visited[next]) { // If the connected node is not visited (연결된 노드가 방문되지 않았다면)
					pq.add(next); // Add connected node to the queue (연결된 노드를 큐에 추가)
				}
			}
		}
		for (int i = 1; i <= N; i++) { // Iterate over all nodes (모든 노드 반복)
			if (i == X) // Skip node X (노드 X 건너뛰기)
				continue;
			dist[i] += mem[i]; // Add return trip distance to the total distance (귀환 여행 거리를 총 거리에 추가)
			res = Math.max(res, dist[i]); // Update the result with the maximum distance (최대 거리로 결과 업데이트)
		}
		return res; // Return the longest round trip distance (최장 왕복 여행 거리 반환)
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader for input (입력을 위한
																					// BufferedReader)
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // BufferedWriter for output (출력을 위한
																					// BufferedWriter)

		int dep, arr, dis; // Variables for input (입력을 위한 변수)
		int M; // Number of routes (노선 수)
		int res = 0; // Variable to store the final result (최종 결과를 저장할 변수)

		String inp[] = br.readLine().split(" "); // Read input line (입력 라인 읽기)
		N = Integer.parseInt(inp[0]); // Number of nodes (노드 수)
		M = Integer.parseInt(inp[1]); // Number of routes (노선 수)
		X = Integer.parseInt(inp[2]); // Target node X (대상 노드 X)

		dist = new int[N + 1]; // Initialize distance array (거리 배열 초기화)
		route = new ArrayList[N + 1]; // Initialize route array (노선 배열 초기화)
		distance = new int[N + 1][N + 1]; // Initialize distance 2D array (거리 2D 배열 초기화)
		mem = new int[N + 1]; // Initialize memory array for Dijkstra's algorithm (다익스트라 알고리즘을 위한 메모리 배열 초기화)
		visited = new Boolean[N + 1]; // Initialize visited array (방문 배열 초기화)
		Arrays.fill(visited, false); // Set all nodes as not visited (모든 노드를 미방문으로 설정)
		for (int i = 1; i <= N; i++) { // Initialize arrays for each node (각 노드에 대한 배열 초기화)
			route[i] = new ArrayList<>();
			Arrays.fill(distance[i], 101); // Set initial distances to a large number (초기 거리를 큰 수로 설정)
		}

		for (int i = 0; i < M; i++) { // Input routes and distances (노선 및 거리 입력)
			inp = br.readLine().split(" "); // Read input line (입력 라인 읽기)
			dep = Integer.parseInt(inp[0]); // Departure node (출발 노드)
			arr = Integer.parseInt(inp[1]); // Arrival node (도착 노드)
			dis = Integer.parseInt(inp[2]); // Distance (거리)
			if (distance[dep][arr] > 100) // If distance is greater than 100 (거리가 100보다 큰 경우)
				route[dep].add(arr); // Add route (노선 추가)
			distance[dep][arr] = Math.min(distance[dep][arr], dis); // Update distance (거리 업데이트)
		}

		visited[X] = true; // Mark node X as visited (노드 X를 방문으로 표시)

		for (int i = 1; i <= N; i++) { // Calculate distances to X (X까지의 거리 계산)
			if (i == X) // Skip node X (노드 X 건너뛰기)
				continue;
			dist[i] = dijk(i); // Calculate distance using Dijkstra's algorithm (다익스트라 알고리즘을 사용하여 거리 계산)
		}

		bw.write(back() + ""); // Write the longest round trip distance (최장 왕복 여행 거리 작성)
		bw.flush(); // Flush the buffer (버퍼 플러시)
		bw.close(); // Close the writer (작성자 닫기)

	}

}
