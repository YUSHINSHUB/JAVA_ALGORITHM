package Breadth_first_Search;

/*
commented by ChatGPT
This Java program constructs a parent array for a tree rooted at node 1. 
It uses a breadth-first search (BFS) approach to traverse the tree and assign parent nodes to each node. 
The result is then printed, showing the parent of each node in the tree.
이 Java 프로그램은 루트 노드가 1인 트리에 대한 부모 배열을 구성합니다. 
너비 우선 탐색 (BFS) 방식을 사용하여 트리를 탐색하고 각 노드에 부모 노드를 할당합니다. 
그 결과는 각 노드의 부모를 나타내며 출력됩니다.
*/

import java.io.*;
import java.util.*;

public class Q11725_Parents_of_Tree_S2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N;
		int a, b;
		int res[];
		ArrayList<Integer> list[];
		Queue<Integer> q = new LinkedList<>();

		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			list[i] = new ArrayList<>();
		res = new int[N + 1];
		Arrays.fill(res, 0);
		q.add(1);

		// Constructing the tree using input edges (입력된 간선을 사용하여 트리 구성)
		for (int i = 0; i < N - 1; i++) {
			String inp[] = br.readLine().split(" ");
			a = Integer.parseInt(inp[0]);
			b = Integer.parseInt(inp[1]);
			list[a].add(b);
			list[b].add(a);
		}

		// Performing BFS to assign parent nodes (부모 노드를 할당하기 위한 BFS 수행)
		while (!q.isEmpty()) {
			int idx = q.poll();
			for (int i = 0; i < list[idx].size(); i++) {
				if (res[list[idx].get(i)] == 0) {
					res[list[idx].get(i)] = idx;
					q.add(list[idx].get(i));
				}
			}
		}

		// Printing the result, showing the parent of each node (각 노드의 부모를 나타내는 결과 출력)
		for (int i = 2; i <= N; i++)
			bw.write(res[i] + "\n");

		bw.flush();
		bw.close();

	}

}
