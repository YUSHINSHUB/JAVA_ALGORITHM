package aaNotepad;

import java.io.*;
import java.util.*;
import java.math.*;

public class notepad {
	static int mem[] = new int[110000]; // Array to keep track of minimum steps to each position
	static Boolean visited[] = new Boolean[110000];
	static int res = 0;

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

		if (mem[cur] == 0) {
			res++;
			return;
		}
		if (visited[cur])
			return;

		visited[cur] = true;
		int next;

		// Trace the path in reverse order
		next = cur + 1;
		if (next < 110000 && next >= 0 && mem[next] == mem[cur] - 1) {
			find(next);
		}

		next = cur - 1;
		if (next < 110000 && next >= 0 && mem[next] == mem[cur] - 1) {
			find(next);
		}

		if (cur % 2 == 0) {
			next = cur / 2;
			if (next < 110000 && next >= 0 && mem[next] == mem[cur] - 1) {
				find(next);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N, K; // Starting position N and target position K
		String inp[];
		Arrays.fill(visited, false);

		inp = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]);
		K = Integer.parseInt(inp[1]);

		bfs(N, K); // Perform BFS to find the minimum steps
		find(K); // Find the path

		// Output the minimum steps and the path
		bw.write(mem[K] + "\n" + res);
		bw.flush();
		bw.close();
	}
}