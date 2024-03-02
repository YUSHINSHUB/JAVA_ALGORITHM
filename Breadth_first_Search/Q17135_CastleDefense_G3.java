package Breadth_first_Search;

/*
commented by ChatGPT
This Java code simulates a defense game where the player places three archers to defend against enemies advancing on a grid. 
The objective is to maximize the number of enemies defeated by the archers within a given range (D). 
The grid dimensions (N x M) and the archers' attack range (D) are provided by the user. 
The code uses backtracking to try all possible archer placements and BFS (Breadth-First Search) to simulate the attack phase for each configuration. 
The result is the maximum number of enemies that can be eliminated in a single turn, considering all possible placements of the archers.

이 Java 코드는 플레이어가 그리드를 진행하는 적을 방어하기 위해 세 명의 궁수를 배치하는 방어 게임을 시뮬레이션합니다. 
주어진 범위(D) 내에서 궁수들에 의해 쓰러진 적의 최대 수를 최대화하는 것이 목표입니다. 그리드 차원(N x M)과 궁수의 공격 범위(D)는 사용자에 의해 제공됩니다. 
코드는 모든 가능한 궁수 배치를 시도하기 위해 백트래킹을 사용하고 각 구성에 대한 공격 단계를 시뮬레이션하기 위해 BFS(너비 우선 검색)를 사용합니다. 
결과는 모든 가능한 궁수 배치를 고려할 때 단일 턴에서 제거할 수 있는 최대 적 수입니다.
*/

import java.io.*;
import java.util.*;
import java.math.*;

public class Q17135_CastleDefense_G3 {

	static int out = 0; // Maximum number of enemies eliminated
	static int N, M, D; // Grid dimensions and archers' attack range
	static int ny[] = { 0, -1, 0 }; // Y-axis movement for BFS (left, up, right)
	static int nx[] = { -1, 0, 1 }; // X-axis movement for BFS
	static int grid[][] = new int[16][15]; // Game grid
	static Boolean check[] = new Boolean[16]; // Check array for archer placements
	static int sel[] = new int[3]; // Selected positions for archers

	// Backtracking method to try all archer placements
	static void backtracking(int cur, int idx) {
		if (idx == 3) { // When 3 archers are placed
			bfs(); // Simulate the attack phase
			return;
		}

		for (int i = cur; i < M; i++) {
			if (check[i])
				continue; // Skip if already checked
			sel[idx] = i; // Select position for archer
			check[i] = true;
			backtracking(i + 1, idx + 1); // Recursive call
			check[i] = false; // Backtrack
		}
	}

	// BFS method to simulate archers' attack
	static void bfs() {
		Queue<Integer> yq = new LinkedList<>(); // Queue for Y-axis
		Queue<Integer> xq = new LinkedList<>(); // Queue for X-axis

		int res = 0; // Number of enemies eliminated in this configuration
		int remy[] = new int[3]; // Closest enemy's Y-axis position for each archer
		int remx[] = new int[3]; // Closest enemy's X-axis position for each archer
		int dis[][] = new int[16][15]; // Distance array for BFS
		int tgrid[][] = new int[16][15]; // Temporary grid for simulation
		// Copy the original grid to temporary grid
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tgrid[i][j] = grid[i][j];
			}
		}

		while (true) {
			Arrays.fill(remy, N);
			Arrays.fill(remx, 0);

			// For each archer, find the closest enemy using BFS
			for (int j = 0; j < 3; j++) {
				for (int i = 0; i <= N; i++)
					Arrays.fill(dis[i], 0);
				yq.add(N); // Start from the archer's position
				xq.add(sel[j]);
				while (!yq.isEmpty()) {
					int y = yq.poll();
					int x = xq.poll();
					if (dis[y][x] == D) { // Stop if maximum range reached
						remy[j] = N;
						remx[j] = 1;
						break;
					}
					for (int i = 0; i < 3; i++) {
						int cy = y + ny[i];
						int cx = x + nx[i];
						if (cy >= N || cx >= M || cy < 0 || cx < 0)
							continue;
						if (dis[cy][cx] > 0)
							continue;
						if (tgrid[cy][cx] == 1) { // Enemy found
							remy[j] = cy;
							remx[j] = cx;
							break;
						}
						yq.add(cy);
						xq.add(cx);
						dis[cy][cx] = dis[y][x] + 1;
					}
					if (remy[j] != N)
						break;
				}
				yq.clear();
				xq.clear();
			}

			// Eliminate the closest enemies and count them
			for (int i = 0; i < 3; i++) {
				if (tgrid[remy[i]][remx[i]] == 1) {
					tgrid[remy[i]][remx[i]] = 0;
					res++;
				}
			}

			// Move remaining enemies forward
			for (int i = 0; i < M; i++)
				tgrid[N - 1][i] = 0;
			int cnt = 0;
			for (int i = N - 2; i >= 0; i--) {
				for (int j = 0; j < M; j++) {
					if (tgrid[i][j] == 1) {
						tgrid[i][j] = 0;
						tgrid[i + 1][j] = 1;
						cnt++;
					}
				}
			}
			if (cnt == 0)
				break;
		}

		out = Math.max(out, res); // Update the maximum number of enemies eliminated
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]); // Grid height
		M = Integer.parseInt(inp[1]); // Grid width
		D = Integer.parseInt(inp[2]); // Archers' attack range

		for (int i = 0; i < N; i++) {
			inp = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(inp[j]); // Fill the grid with enemy positions
			}
		}

		Arrays.fill(check, false);
		backtracking(0, 0); // Start backtracking to find the best archer placements

		bw.write(out + ""); // Write the maximum number of enemies eliminated
		bw.flush();
		bw.close();
	}
}