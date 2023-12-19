package Graph_Theory;

/*
commented by ChatGPT
This Java code is designed to find the shortest relationship path between two family members in a genealogical tree. 
The tree is represented using an adjacency list (fam) and an array (parent) to store direct parent-child relationships. 
The search function uses Breadth-First Search (BFS) to traverse the tree, starting from one family member (a) and seeking the shortest path to the other (b). 
The mem array tracks the minimum number of steps taken to reach each family member from a. 
The BFS algorithm updates mem for each node visited, and the function returns the number of steps to reach b if a path exists, or -1 if not.
이 Java 코드는 가계도에서 두 가족 구성원 간의 최단 관계 경로를 찾기 위해 설계되었습니다. 
가계도는 인접 리스트(fam)와 직접적인 부모-자식 관계를 저장하는 배열(parent)을 사용하여 표현됩니다. 
search 함수는 너비 우선 탐색(BFS)을 사용하여 한 가족 구성원(a)에서 시작하여 다른 가족 구성원(b)까지의 최단 경로를 찾습니다. 
mem 배열은 a에서 각 가족 구성원에 도달하기 위해 걸린 최소 단계 수를 추적합니다. 
BFS 알고리즘은 방문한 각 노드에 대해 mem을 업데이트하며, 경로가 존재하는 경우 b에 도달하기 위한 단계 수를 반환하거나, 존재하지 않는 경우 -1을 반환합니다.
*/

import java.io.*;
import java.util.*;

public class Q2644_Relatives_S2 {

	static int mem[]; // Array to keep track of the number of steps to each family member from 'a' (가족
						// 구성원 'a'로부터 각 가족 구성원까지의 단계 수를 추적하는 배열)
	static ArrayList<Integer> fam[]; // Adjacency list to represent the genealogical tree (가계도를 나타내는 인접 리스트)
	static int parent[]; // Array to store direct parent-child relationships (직접적인 부모-자식 관계를 저장하는 배열)
	static int a, b; // The two family members between whom the relationship path is sought (관계 경로를
						// 찾고자 하는 두 가족 구성원)

// Function to find the shortest path using BFS (BFS를 사용하여 최단 경로를 찾는 함수)
	static int search() {
		Queue<Integer> q = new LinkedList<>(); // Queue for BFS (BFS를 위한 큐)
		q.add(a);
		mem[a] = 0; // Starting point (시작점)

		while (!q.isEmpty()) {
			int cur = q.poll();
			// Check the parent (부모 확인)
			if (parent[cur] > 0 && mem[parent[cur]] < 0) {
				q.add(parent[cur]);
				mem[parent[cur]] = mem[cur] + 1;
				if (parent[cur] == b)
					break;
			}
			// Check other family members (다른 가족 구성원 확인)
			for (int i = 0; i < fam[cur].size(); i++) {
				if (mem[fam[cur].get(i)] >= 0)
					continue;
				q.add(fam[cur].get(i));
				mem[fam[cur].get(i)] = mem[cur] + 1;
				if (fam[cur].get(i) == b)
					break;
			}
		}

		return mem[b]; // Return the number of steps to 'b' (가족 구성원 'b'까지의 단계 수 반환)
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n, m; // Variables for the number of family members and relationships (가족 구성원 및 관계 수를
					// 위한 변수)

		n = Integer.parseInt(br.readLine()); // Read the number of family members (가족 구성원 수 읽기)
		String inp[] = br.readLine().split(" ");
		a = Integer.parseInt(inp[0]);
		b = Integer.parseInt(inp[1]);
		m = Integer.parseInt(br.readLine()); // Read the number of relationships (관계 수 읽기)
		fam = new ArrayList[n + 1];
		parent = new int[n + 1];
		mem = new int[n + 1];
		Arrays.fill(parent, 0);
		Arrays.fill(mem, -1);
		for (int i = 1; i <= n; i++)
			fam[i] = new ArrayList<Integer>();

		// Read and store relationships (관계 읽기 및 저장)
		for (int i = 0; i < m; i++) {
			inp = br.readLine().split(" ");
			int x, y;
			x = Integer.parseInt(inp[0]);
			y = Integer.parseInt(inp[1]);
			fam[x].add(y);
			parent[y] = x;
		}

		bw.write(search() + ""); // Write the shortest path length (최단 경로 길이 작성)
		bw.flush();
		bw.close();
	}
}