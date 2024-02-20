package Shortest_Path;

/*
commented by ChatGPT
This Java code implements Dijkstra's algorithm to find the shortest path and its cost from a source node to a destination node in a graph.
It also constructs the path taken to reach the destination from the source. The graph is represented using adjacency lists for both directions,
and a priority queue is utilized to select the next node with the lowest cost. After finding the shortest path, the program backtracks from the destination to the source to reconstruct the path.
이 Java 코드는 그래프에서 소스 노드에서 목적지 노드로 가는 최단 경로와 그 비용을 찾기 위해 다익스트라 알고리즘을 구현합니다.
또한 소스에서 목적지에 도달하기 위해 취한 경로를 구성합니다. 그래프는 양방향의 인접 리스트를 사용하여 표현되며,
우선순위 큐를 사용하여 가장 낮은 비용의 다음 노드를 선택합니다. 최단 경로를 찾은 후, 프로그램은 목적지에서 소스로 되돌아가 경로를 재구성합니다.
*/

import java.io.*;
import java.util.*;
import java.math.*;

public class Q11779_Fee_2_G3 {

	static int cost[] = new int[1001]; // 각 노드까지의 최소 비용을 저장하는 배열
	static int edge[][] = new int[1001][1001]; // 각 노드 간의 비용(가중치)을 저장하는 2차원 배열
	static ArrayList<Integer> next[] = new ArrayList[1001]; // 각 노드에서 이동할 수 있는 다음 노드 목록
	static ArrayList<Integer> prev[] = new ArrayList[1001]; // 각 노드로 들어오는 이전 노드 목록
	static ArrayList<Integer> path = new ArrayList<>(); // 최종 경로를 저장하는 리스트
	static int from, to; // 시작 노드와 목표 노드
	static Boolean visited[] = new Boolean[1001]; // 각 노드의 방문 여부를 저장하는 배열

	// 우선순위 큐를 사용하여 다익스트라 알고리즘의 현재 노드 처리 시, 비용이 낮은 노드부터 처리
	static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
		return cost[o1] - cost[o2];
	});

	static int dajikstra() {

		pq.add(from); // 시작 노드를 우선순위 큐에 추가
		cost[from] = 0; // 시작 노드의 비용을 0으로 초기화

		while (!pq.isEmpty()) {
			int cur = pq.poll(); // 현재 처리할 노드
			visited[cur] = true; // 현재 노드를 방문 처리
			for (int i = 0; i < next[cur].size(); i++) { // 현재 노드에서 갈 수 있는 모든 노드에 대해
				int temp = next[cur].get(i); // 다음 노드
				if (visited[temp]) // 이미 방문한 노드는 건너뛰기
					continue;
				if (cost[temp] > cost[cur] + edge[cur][temp]) { // 다음 노드까지의 현재 비용보다 더 저렴한 경로 발견 시 업데이트
					cost[temp] = cost[cur] + edge[cur][temp];
					pq.add(temp); // 업데이트된 노드를 우선순위 큐에 추가
				}
			}
		}

		return cost[to]; // 목표 노드까지의 최소 비용 반환
	}

	static void find_path() {

		int cur = to; // 목표 노드부터 시작
		path.add(to); // 목표 노드를 경로에 추가

		while (cur != from) { // 시작 노드에 도달할 때까지 반복
			for (int i = 0; i < prev[cur].size(); i++) { // 현재 노드로 들어온 모든 노드에 대해
				int p = prev[cur].get(i); // 이전 노드
				if (cost[p] + edge[p][cur] == cost[cur]) { // 이전 노드를 거쳐 현재 노드로 오는 것이 최소 비용 경로일 경우
					path.add(p); // 경로에 이전 노드 추가
					cur = p; // 현재 노드를 이전 노드로 변경
					break; // 하나의 경로만 찾으면 되므로 반복 중단
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[];
		int n, m, res;

		Arrays.fill(visited, false); // 방문 배열 초기화
		Arrays.fill(cost, Integer.MAX_VALUE); // 비용 배열을 최대값으로 초기화
		n = Integer.parseInt(br.readLine()); // 노드 개수
		m = Integer.parseInt(br.readLine()); // 간선 개수

		for (int i = 1; i <= n; i++) {
			next[i] = new ArrayList<>(); // 다음 노드 리스트 초기화
			prev[i] = new ArrayList<>(); // 이전 노드 리스트 초기화
			Arrays.fill(edge[i], Integer.MAX_VALUE); // 각 노드 간 비용 배열 초기화
		}
		for (int i = 0; i < m; i++) {
			inp = br.readLine().split(" ");
			int a = Integer.parseInt(inp[0]); // 시작 노드
			int b = Integer.parseInt(inp[1]); // 도착 노드
			int c = Integer.parseInt(inp[2]); // 두 노드 간의 비용

			next[a].add(b); // 시작 노드에서 도착 노드로의 방향 추가
			prev[b].add(a); // 도착 노드에 대한 시작 노드의 역방향 추가
			edge[a][b] = Math.min(edge[a][b], c); // 두 노드 간의 최소 비용 업데이트
		}

		inp = br.readLine().split(" ");
		from = Integer.parseInt(inp[0]); // 시작 노드 설정
		to = Integer.parseInt(inp[1]); // 도착 노드 설정

		res = dajikstra(); // 다익스트라 알고리즘을 통한 최소 비용 계산
		find_path(); // 최소 비용 경로 찾기

		bw.write(res + "\n" + path.size() + "\n"); // 결과 및 경로 길이 출력
		for (int i = path.size() - 1; i >= 0; i--) // 경로 역순으로 출력
			bw.write(path.get(i) + " ");
		bw.flush();
		bw.close();
	}
}
