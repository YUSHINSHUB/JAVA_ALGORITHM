package Tree;

/*
commented by ChatGPT
This Java code implements a tree-based algorithm to find the maximum path length between any two nodes in an undirected tree. 
Each node of the tree can have multiple children, and each edge has an associated distance. 
The main algorithm involves using Depth-First Search (DFS) to calculate the maximum distance from each node to its descendants. 
The code calculates the two longest paths from each node and then combines them to find the overall longest path in the tree.

이 Java 코드는 무방향 트리에서 임의의 두 노드 간의 최대 경로 길이를 찾는 트리 기반 알고리즘을 구현합니다. 
트리의 각 노드는 여러 자식을 가질 수 있으며, 각 간선에는 연관된 거리가 있습니다. 
주요 알고리즘은 각 노드에서 그 자손들로의 최대 거리를 계산하기 위해 깊이 우선 탐색(DFS)을 사용합니다. 
이 코드는 각 노드에서 두 가장 긴 경로를 계산한 다음 이들을 결합하여 트리 전체에서 가장 긴 경로를 찾습니다.
*/

import java.io.*;
import java.util.*;

public class Q1967_Diameter_G4 {

	static int n; // 트리의 노드 수
	static node nodes[]; // 노드 배열
	static int mem[]; // 메모이제이션을 위한 배열

// 노드 클래스: 자식 노드 및 각 자식까지의 거리를 저장하는 배열
	static class node {
		ArrayList<Integer> child = new ArrayList<>();
		ArrayList<Integer> dist = new ArrayList<>();

		node() {
		}
	}

// 깊이 우선 탐색을 통한 최대 거리 계산 함수
	static int dfs(int idx) {
		// 이미 계산된 값이 있으면 반환
		if (mem[idx] >= 0)
			return mem[idx];

		// 모든 자식 노드에 대해 최대 거리 계산
		for (int i = 0; i < nodes[idx].child.size(); i++) {
			mem[idx] = Math.max(mem[idx], dfs(nodes[idx].child.get(i)) + nodes[idx].dist.get(i));
		}

		// 자식 노드가 없는 경우 0으로 설정
		if (mem[idx] < 0)
			mem[idx] = 0;
		return mem[idx];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[];
		int in1, in2, in3;
		int f, s, temp;
		int res = 0; // 최대 경로 길이

		n = Integer.parseInt(br.readLine());
		nodes = new node[n + 1];
		mem = new int[n + 1];
		Arrays.fill(mem, -1); // 메모이제이션 배열 초기화

		// 트리 구성
		for (int i = 1; i <= n; i++)
			nodes[i] = new node();
		for (int i = 0; i < n - 1; i++) {
			inp = br.readLine().split(" ");
			in1 = Integer.parseInt(inp[0]);
			in2 = Integer.parseInt(inp[1]);
			in3 = Integer.parseInt(inp[2]);
			nodes[in1].child.add(in2);
			nodes[in1].dist.add(in3);
		}

		// 각 노드에서 두 가장 긴 경로를 찾아 합산
		for (int i = 1; i <= n; i++) {
			f = 0; // 첫 번째로 긴 경로
			s = 0; // 두 번째로 긴 경로
			for (int j = 0; j < nodes[i].child.size(); j++) {
				temp = nodes[i].dist.get(j) + dfs(nodes[i].child.get(j));
				if (f < temp) {
					s = f;
					f = temp;
				} else if (s < temp)
					s = temp;
			}
			res = Math.max(res, f + s); // 두 경로를 합산하여 최대값 갱신
		}

		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}