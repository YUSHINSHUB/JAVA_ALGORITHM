package Breadth_first_Search;

/*
commented by ChatGPT
This Java program implements a solution to navigate a grid using both knight's moves from chess and regular moves. 
Given a grid with obstacles, it calculates the minimum number of moves required to reach the bottom-right corner from the top-left, with a limited number of knight's moves allowed (specified by K). 
The solution employs a breadth-first search (BFS) algorithm and keeps track of the visited states with a 3D array to consider the number of knight moves used. 
It explores all possible moves from each position, prioritizing knight's moves until the limit is reached, then continuing with regular moves, and marks each visited position with the minimum number of moves required to get there. 
If the destination is reached, it returns the minimum number of moves; otherwise, it returns -1, indicating the destination is unreachable.
이 Java 프로그램은 체스의 나이트 이동과 일반 이동을 모두 사용하여 그리드를 탐색하는 솔루션을 구현합니다. 
장애물이 있는 그리드가 주어지고, 제한된 수의 나이트 이동(K로 지정)을 사용하여 좌측 상단에서 우측 하단까지 도달하는 데 필요한 최소 이동 횟수를 계산합니다. 
이 솔루션은 너비 우선 탐색(BFS) 알고리즘을 사용하며, 사용된 나이트 이동의 수를 고려하여 방문한 상태를 추적하기 위해 3차원 배열을 사용합니다. 
각 위치에서 가능한 모든 이동을 탐색하며, 나이트 이동의 한계에 도달할 때까지 나이트 이동을 우선시한 다음 일반 이동으로 계속 진행하고, 각 방문 위치를 거기에 도달하는 데 필요한 최소 이동 횟수로 표시합니다. 
목적지에 도달하면 최소 이동 횟수를 반환하고, 그렇지 않으면 목적지에 도달할 수 없음을 나타내는 -1을 반환합니다.
*/

import java.io.*;
import java.util.*;

public class Q1600_Horse_Monkey_G3 {

	static int K; // The maximum number of knight moves allowed.
	static int W, H; // Width and Height of the grid.
	static int[][] grid = new int[200][200]; // The grid itself, with 1s representing obstacles.
	static int[][][] visited = new int[200][200][31]; // 3D array to track the visited states: [y][x][knight moves
														// used].
	// Movement offsets for knight moves.
	static int[] nky = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] nkx = { -1, 1, -2, 2, -2, 2, -1, 1 };
	// Movement offsets for regular (up, down, left, right) moves.
	static int[] ny = { -1, 0, 0, 1 };
	static int[] nx = { 0, -1, 1, 0 };

	static int bfs() { // Breadth-first search function to find the minimum number of moves.

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++)
				Arrays.fill(visited[i][j], 50000); // Initialize visited array with a large number.
		}

		Queue<Integer> yq = new LinkedList<>(); // Queue for Y positions.
		Queue<Integer> xq = new LinkedList<>(); // Queue for X positions.
		Queue<Integer> cq = new LinkedList<>(); // Queue for knight moves count.
		yq.add(0);
		xq.add(0);
		cq.add(0);
		visited[0][0][0] = 0; // Starting position with 0 knight moves used.

		while (!yq.isEmpty()) {
			int y = yq.poll();
			int x = xq.poll();
			int c = cq.poll();
			if (y == H - 1 && x == W - 1) // If the destination is reached, return the number of moves.
				return visited[y][x][c];
			if (c < K) { // If more knight moves are allowed, try all knight moves.
				for (int i = 0; i < 8; i++) {
					int cy = y + nky[i];
					int cx = x + nkx[i];
					if (cy < 0 || cx < 0 || cy >= H || cx >= W || grid[cy][cx] == 1
							|| visited[cy][cx][c + 1] <= visited[y][x][c] + 1)
						continue; // Skip invalid or already better visited positions.

					visited[cy][cx][c + 1] = visited[y][x][c] + 1; // Update visited with new minimum moves.

					yq.add(cy);
					xq.add(cx);
					cq.add(c + 1); // Increment knight moves used.
				}
			}
			// Try all regular moves.
			for (int i = 0; i < 4; i++) {
				int cy = y + ny[i];
				int cx = x + nx[i];
				if (cy < 0 || cx < 0 || cy >= H || cx >= W || grid[cy][cx] == 1
						|| visited[cy][cx][c] <= visited[y][x][c] + 1)
					continue; // Skip invalid or already better visited positions.

				visited[cy][cx][c] = visited[y][x][c] + 1; // Update visited with new minimum moves.

				yq.add(cy);
				xq.add(cx);
				cq.add(c); // Keep knight moves used unchanged.
			}

		}

		return -1; // If destination is unreachable, return -1.
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[];

		K = Integer.parseInt(br.readLine()); // Reading the maximum number of knight moves allowed.
		inp = br.readLine().split(" ");
		W = Integer.parseInt(inp[0]); // Reading the width of the grid.
		H = Integer.parseInt(inp[1]); // Reading the height of the grid.

		for (int i = 0; i < H; i++) {
			inp = br.readLine().split(" ");
			for (int j = 0; j < W; j++)
				grid[i][j] = Integer.parseInt(inp[j]); // Filling the grid with obstacles and free spaces.
		}

		bw.write(bfs() + ""); // Writing the result of the BFS search to the output.
		bw.flush();
		bw.close();
	}
}
