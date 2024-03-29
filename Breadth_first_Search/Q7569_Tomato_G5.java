package Breadth_first_Search;

/*
commented by ChatGPT
This Java code simulates the ripening of tomatoes in a 3D grid using Breadth-First Search. If any tomato cannot ripen, it outputs 0; otherwise, it outputs the minimum days for all tomatoes to ripen.
이 Java 코드는 3D 그리드 내에서 토마토의 익는 과정을 너비 우선 탐색을 사용하여 시뮬레이션 합니다. 만약 모든 토마토가 익지 않는 경우에는 0을 출력하며, 그렇지 않은 경우에는 모든 토마토가 익는데 필요한 최소 일수를 출력합니다.
*/

import java.io.*;
import java.util.*;

public class Q7569_Tomato_G5 {

	static int m, n, h; // Dimensions for the 3D grid (3D 그리드의 크기)
	static int[][][] tom; // 3D array to store tomato states (토마토 상태를 저장하는 3D 배열)
	static int res = 0; // Result to store minimum days required (모든 토마토가 익는데 필요한 최소 일수)
	static Queue<Integer> yq = new LinkedList<>();
	static Queue<Integer> xq = new LinkedList<>();
	static Queue<Integer> hq = new LinkedList<>();
	static int[] ypos = { 1, -1, -1, 1, 0, 0 };
	static int[] xpos = { 0, 1, -1, -1, 1, 0 };
	static int[] hpos = { 0, 0, 0, 0, 1, -2 };

	static void bfs() { // Breadth-first search function to ripen tomatoes (토마토를 익히기 위한 너비 우선 탐색 함수)

		while (true) {
			Queue<Integer> ytq = new LinkedList<>();
			Queue<Integer> xtq = new LinkedList<>();
			Queue<Integer> htq = new LinkedList<>();

			// Transfering tomatoes from main queues to temp queues (메인 큐에서 임시 큐로 토마토 이동)
			while (!yq.isEmpty()) {
				ytq.add(yq.poll());
				xtq.add(xq.poll());
				htq.add(hq.poll());
			}

			if (ytq.isEmpty()) // If temp queues are empty, break out of loop (임시 큐가 비어있으면 루프 탈출)
				break;

			res++; // Increase days as we go to next level in BFS (BFS의 다음 레벨로 넘어갈 때 일수 증가)

			while (!ytq.isEmpty()) { // Process each tomato in current level (현재 레벨의 각 토마토 처리)

				int y = ytq.poll();
				int x = xtq.poll();
				int z = htq.poll();

				for (int i = 0; i < 6; i++) { // Check all 6 directions for each tomato (각 토마토에 대해 6개의 방향 확인)
					y += ypos[i];
					x += xpos[i];
					z += hpos[i];

					if (y < 0 || y >= m || x < 0 || x >= n || z < 0 || z >= h) // Boundary condition (경계 조건)
						continue;

					// If neighboring position is unripe tomato, then ripen it and add to queue (이웃한
					// 위치가 익지 않은 토마토라면 익히고 큐에 추가)
					if (tom[y][x][z] == 0) {
						yq.add(y);
						xq.add(x);
						hq.add(z);
						tom[y][x][z] = 1;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] inp = br.readLine().split(" ");
		m = Integer.parseInt(inp[0]);
		n = Integer.parseInt(inp[1]);
		h = Integer.parseInt(inp[2]);

		tom = new int[m][n][h];

		// Reading initial tomato states and adding ripe tomatoes to queue (토마토의 초기 상태
		// 읽기 및 익은 토마토를 큐에 추가)
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				inp = br.readLine().split(" ");
				for (int k = 0; k < m; k++) {
					tom[k][j][i] = Integer.parseInt(inp[k]);
					if (tom[k][j][i] == 1) {
						yq.add(k);
						xq.add(j);
						hq.add(i);
					}
				}
			}
		}

		bfs(); // Calling BFS function to ripen all tomatoes (BFS 함수 호출하여 모든 토마토 익히기)

		// Check if any tomato is still unripe after BFS (BFS 후에도 익지 않은 토마토가 있는지 확인)
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (tom[k][j][i] == 0) {
						res = 0;
					}
				}
			}
		}

		bw.write(res - 1 + ""); // Subtracting 1 from result because the initial state is considered a day (결과에서
								// 1을 빼는 이유는 초기 상태도 하루로 간주되기 때문)
		bw.flush();
		bw.close();
	}
}
