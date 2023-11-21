package Breadth_first_Search;

/*
commented by ChatGPT
This Java code implements a binary search algorithm combined with Breadth-First Search (BFS) to solve a pathfinding problem in a graph. 
Each edge in the graph has a limitation value, and the goal is to find the maximum limitation value for a path between two specified nodes. 
The binary search narrows down the range of limitation values to find the highest value that still allows a path to exist.
이 Java 코드는 그래프 내에서 경로 찾기 문제를 해결하기 위해 이진 탐색 알고리즘과 너비 우선 탐색(BFS)을 결합하여 구현합니다. 
그래프의 각 간선에는 제한 값이 있으며, 두 지정된 노드 간의 경로에 대한 최대 제한 값을 찾는 것이 목표입니다. 
이진 탐색은 여전히 경로가 존재할 수 있는 가장 높은 제한 값을 찾기 위해 제한 값의 범위를 좁혀 나갑니다.
*/

import java.io.*;
import java.util.*;

class route {
	int to, lim; // 간선의 목적지 노드와 제한 값

	route(int to, int lim) {
		this.to = to;
		this.lim = lim;
	}
}

public class Q1939_Weight_Limit_G3 {

	static int N, M; // 노드 수와 간선 수
	static boolean visited[]; // 방문 여부를 확인하는 배열
	static int f1, f2; // 시작 노드와 목적지 노드
	static int hig = Integer.MIN_VALUE; // 가능한 제한 값의 최대값
	static int low = Integer.MAX_VALUE; // 가능한 제한 값의 최소값
	static int mid = 0; // 이진 탐색을 위한 중간 값
	static ArrayList<route>[] list; // 그래프를 나타내는 인접 리스트

	static boolean search(int idx) {
		// BFS를 사용하여 idx 제한 값으로 f1에서 f2로 이동 가능한지 확인
		Arrays.fill(visited, false);
		visited[f1] = true;
		Queue<Integer> q = new LinkedList<>();
		q.add(f1);
		while (!q.isEmpty()) {
			int t = q.poll();
			if (t == f2) {
				return true;
			}
			for (route r : list[t]) {
				if (r.lim >= idx && !visited[r.to]) {
					q.add(r.to);
					visited[r.to] = true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int res = 0; // 결과값 (최대 제한 값)
		String inp[] = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]);
		M = Integer.parseInt(inp[1]);
		visited = new boolean[N + 1];
		list = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			inp = br.readLine().split(" ");
			int A = Integer.parseInt(inp[0]);
			int B = Integer.parseInt(inp[1]);
			int C = Integer.parseInt(inp[2]);

			list[A].add(new route(B, C));
			list[B].add(new route(A, C));

			hig = Math.max(hig, C);
			low = Math.min(low, C);
		}

		inp = br.readLine().split(" ");
		f1 = Integer.parseInt(inp[0]);
		f2 = Integer.parseInt(inp[1]);

		// 이진 탐색으로 최대 제한 값 탐색
		while (low <= hig) {
			mid = (low + hig) / 2;
			if (search(mid)) {
				low = mid + 1;
				res = mid;
			} else {
				hig = mid - 1;
			}
		}

		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}
