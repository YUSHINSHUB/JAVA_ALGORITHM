package Breadth_first_Search;

/*
commented by ChatGPT
This Java code is designed to find the shortest path from point N to K using Breadth-First Search (BFS). 
It uses an array mem to keep track of the minimum number of steps required to reach each position. 
The BFS algorithm explores all possible moves from each position: moving one step forward or backward, or teleporting to twice the current position. 
The find function reconstructs the path from K back to N, using the mem array to trace the steps in reverse order. 
The final path is stored in the list and printed in reverse, displaying the sequence of moves to go from N to K in the minimum number of steps.

이 Java 코드는 너비 우선 탐색(BFS)을 사용하여 N 지점에서 K 지점까지의 최단 경로를 찾도록 설계되었습니다. 각 위치에 도달하기까지 필요한 최소 단계 수를 추적하기 위해 mem 배열을 사용합니다. 
BFS 알고리즘은 각 위치에서 가능한 모든 이동을 탐색합니다: 한 걸음 앞으로 또는 뒤로 이동하거나 현재 위치의 두 배로 순간 이동하기. find 함수는 mem 배열을 사용하여 역순으로 단계를 추적하며 K에서 N으로 되돌아가는 경로를 재구성합니다. 
최종 경로는 list에 저장되어, N에서 K까지 최소 단계로 이동하는 순서를 역순으로 출력합니다.
*/

import java.io.*;
import java.util.*;
import java.math.*;

public class Q13913_Seek_4_G4 {
	static int mem[] = new int[110000]; // Array to keep track of minimum steps to each position
	static ArrayList<Integer> list = new ArrayList<>(); // List to store the path

// BFS to find the minimum steps from N to K
	static void bfs(int N, int K) {
		Arrays.fill(mem, -1); // Initialize all positions as unvisited
		mem[N] = 0; // Starting position
		Queue<Integer> q = new LinkedList<>();
		q.add(N);

		// Explore all possible moves
		while (!q.isEmpty()) {
			int cur = q.poll(); // Current position
			int next;

			// Move forward
			next = cur + 1;
			if (next < 110000 && next >= 0 && mem[next] < 0) {
				q.add(next);
				mem[next] = mem[cur] + 1;
			}

			// Move backward
			next = cur - 1;
			if (next < 110000 && next >= 0 && mem[next] < 0) {
				q.add(next);
				mem[next] = mem[cur] + 1;
			}

			// Teleport
			next = cur * 2;
			if (next < 110000 && next >= 0 && mem[next] < 0) {
				q.add(next);
				mem[next] = mem[cur] + 1;
			}
		}
	}

// Function to find the path from K to N
	static void find(int cur) {
		list.add(cur);
		if (mem[cur] == 0)
			return;

		int next;

		// Trace the path in reverse order
		next = cur + 1;
		if (next < 110000 && next >= 0 && mem[next] == mem[cur] - 1) {
			find(next);
			return;
		}

		next = cur - 1;
		if (next < 110000 && next >= 0 && mem[next] == mem[cur] - 1) {
			find(next);
			return;
		}

		next = cur / 2;
		if (next < 110000 && next >= 0 && mem[next] == mem[cur] - 1) {
			find(next);
			return;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N, K; // Starting position N and target position K
		String inp[];

		inp = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]);
		K = Integer.parseInt(inp[1]);

		bfs(N, K); // Perform BFS to find the minimum steps
		find(K); // Find the path

		// Output the minimum steps and the path
		bw.write(mem[K] + "\n");
		for (int i = mem[K]; i >= 0; i--)
			bw.write(list.get(i) + " ");
		bw.flush();
		bw.close();
	}
}