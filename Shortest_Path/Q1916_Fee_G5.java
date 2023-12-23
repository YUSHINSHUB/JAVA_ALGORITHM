package Shortest_Path;

/*
commented by ChatGPT
This Java code implements Dijkstra's algorithm to find the shortest path in a graph. 
It calculates the minimum cost to travel from a departure node to an arrival node in a network of nodes with associated travel costs.
이 Java 코드는 다익스트라 알고리즘을 구현하여 그래프에서 최단 경로를 찾습니다. 
노드 네트워크에서 출발 노드에서 도착 노드까지의 여행에 대한 최소 비용을 계산합니다.
*/

import java.io.*;
import java.util.*;

public class Q1916_Fee_G5 {

	static int fee[][]; // 2D array to store travel costs between nodes (노드 간 여행 비용을 저장하는 2D 배열)
	static ArrayList<Integer> route[]; // Array of ArrayLists to store routes (노선을 저장하는 ArrayList의 배열)
	static int departure, arrival; // Departure and arrival nodes (출발 및 도착 노드)
	static Boolean visited[]; // Array to track visited nodes (방문한 노드를 추적하는 배열)
	static long mem[]; // Array to store minimum travel cost to each node (각 노드까지의 최소 여행 비용을 저장하는 배열)

	static long dijk() { // Dijkstra's algorithm implementation (다익스트라 알고리즘 구현)

		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> { // Priority queue for nodes (노드를 위한 우선순위 큐)
			if (mem[o1] > mem[o2]) // Comparing travel costs (여행 비용 비교)
				return 1;
			else
				return -1;
		});

		pq.add(departure); // Adding departure node to the queue (출발 노드를 큐에 추가)

		while (!pq.isEmpty()) { // Processing nodes in the queue (큐의 노드 처리)
			int idx = pq.poll(); // Current node (현재 노드)
			if (visited[idx]) // Skip if already visited (이미 방문한 경우 건너뛰기)
				continue;
			visited[idx] = true; // Mark as visited (방문으로 표시)
			for (int i = 0; i < route[idx].size(); i++) { // Iterate over connected nodes (연결된 노드 반복)
				int temp = route[idx].get(i); // Connected node (연결된 노드)
				mem[temp] = Math.min(mem[temp], mem[idx] + fee[idx][temp]); // Update minimum cost (최소 비용 업데이트)
				pq.add(temp); // Add connected node to the queue (연결된 노드를 큐에 추가)
			}
		}

		return mem[arrival]; // Return minimum cost to arrival node (도착 노드까지의 최소 비용 반환)

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int dep, arr, pri; // Variables for input (입력을 위한 변수)
		int N, M; // Number of nodes and routes (노드 및 노선 수)

		N = Integer.parseInt(br.readLine()); // Number of nodes (노드 수)
		M = Integer.parseInt(br.readLine()); // Number of routes (노선 수)
		fee = new int[N + 1][N + 1]; // Initialize travel costs array (여행 비용 배열 초기화)
		route = new ArrayList[N + 1]; // Initialize routes array (노선 배열 초기화)
		visited = new Boolean[N + 1]; // Initialize visited array (방문 배열 초기화)
		mem = new long[N + 1]; // Initialize minimum cost array (최소 비용 배열 초기화)

		Arrays.fill(visited, false); // Set all nodes as not visited (모든 노드를 미방문으로 설정)
		Arrays.fill(mem, Long.MAX_VALUE); // Set initial costs to maximum (초기 비용을 최대로 설정)
		for (int i = 1; i <= N; i++) {
			Arrays.fill(fee[i], Integer.MAX_VALUE); // Initialize travel costs to maximum (여행 비용을 최대로 초기화)
			route[i] = new ArrayList<Integer>(); // Initialize route list for each node (각 노드에 대한 노선 목록 초기화)
		}

		for (int i = 0; i < M; i++) { // Input routes and costs (노선 및 비용 입력)
			String inp[] = br.readLine().split(" ");
			dep = Integer.parseInt(inp[0]); // Departure node (출발 노드)
			arr = Integer.parseInt(inp[1]); // Arrival node (도착 노드)
			pri = Integer.parseInt(inp[2]); // Travel cost (여행 비용)

			fee[dep][arr] = Math.min(fee[dep][arr], pri); // Store minimum cost (최소 비용 저장)
			route[dep].add(arr); // Add route (노선 추가)
		}

		String inp[] = br.readLine().split(" "); // Input departure and arrival nodes (출발 및 도착 노드 입력)
		departure = Integer.parseInt(inp[0]); // Set departure node (출발 노드 설정)
		arrival = Integer.parseInt(inp[1]); // Set arrival node (도착 노드 설정)
		mem[departure] = 0; // Set cost to depart from departure node to 0 (출발 노드에서 출발하는 비용을 0으로 설정)

		bw.write(dijk() + ""); // Execute Dijkstra's algorithm and write result (다익스트라 알고리즘 실행 및 결과 작성)
		bw.flush(); // Flush the buffer (버퍼 플러시)
		bw.close(); // Close the writer (작성자 닫기)

	}
}