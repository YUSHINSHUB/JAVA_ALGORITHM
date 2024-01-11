package Tree;

/*
commented by ChatGPT
This Java code calculates the diameter of a tree (the longest path between any two nodes in the tree). 
The code uses a two-step DFS (Depth-First Search) process. 
In the first step, it finds the farthest node (referred to as edge) from a starting node. 
In the second step, it finds the farthest node from this edge node, calculating the tree's diameter. 
The node class represents each node with its children and the distances to these children. 
The visited array keeps track of visited nodes to prevent revisiting during DFS.

이 Java 코드는 트리의 지름(트리 내 임의의 두 노드 간 가장 긴 경로)을 계산합니다. 코드는 두 단계의 DFS(깊이 우선 탐색) 과정을 사용합니다. 
첫 번째 단계에서 시작 노드로부터 가장 먼 노드(edge로 지칭됨)를 찾습니다. 두 번째 단계에서 이 edge 노드로부터 가장 먼 노드를 찾아 트리의 지름을 계산합니다.
node 클래스는 각 노드를 그 자식들과 이들 자식까지의 거리와 함께 표현합니다. 
visited 배열은 DFS 동안 노드의 재방문을 방지하기 위해 방문한 노드를 추적합니다.
*/

import java.io.*;
import java.util.*;

public class Q1167_Diameter_G2 {

	static int n; // 트리의 노드 수
	static node nodes[]; // 노드 배열
	static Boolean visited[]; // 방문 여부를 추적하는 배열
	static int edge = 0; // 가장 먼 노드 인덱스
	static int res = 0; // 최대 거리 (트리의 지름)

// 노드 클래스: 자식 노드 및 각 자식까지의 거리를 저장하는 배열
	static class node {
		ArrayList<Integer> child = new ArrayList<>();
		ArrayList<Integer> dist = new ArrayList<>();

		node() {
		}
	}

// 깊이 우선 탐색을 통한 최대 거리 계산 함수
	static void dfs(int idx, int len) {
		// 현재 거리가 최대 거리보다 길면 갱신
		if (len > res) {
			res = len;
			edge = idx;
		}

		// 모든 자식 노드에 대해 탐색
		for (int i = 0; i < nodes[idx].child.size(); i++) {
			if (visited[nodes[idx].child.get(i)])
				continue;
			visited[nodes[idx].child.get(i)] = true;
			dfs(nodes[idx].child.get(i), len + nodes[idx].dist.get(i));
			visited[nodes[idx].child.get(i)] = false;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[];
		int in;

		n = Integer.parseInt(br.readLine());
		nodes = new node[n + 1];
		visited = new Boolean[n + 1];
		Arrays.fill(visited, false); // 방문 배열 초기화

		// 트리 구성
		for (int i = 1; i <= n; i++)
			nodes[i] = new node();
		for (int i = 0; i < n; i++) {
			inp = br.readLine().split(" ");
			in = Integer.parseInt(inp[0]);
			for (int j = 1; !inp[j].equals("-1"); j += 2) {
				nodes[in].child.add(Integer.parseInt(inp[j]));
				nodes[in].dist.add(Integer.parseInt(inp[j + 1]));

			}
		}

		// 첫 번째 DFS 실행
		visited[1] = true;
		dfs(1, 0);
		visited[1] = false;

		// 두 번째 DFS 실행
		visited[edge] = true;
		dfs(edge, 0);

		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}
