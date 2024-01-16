package Shortest_Path;

/*
commented by ChatGPT
This Java code implements a Dijkstra's algorithm-based approach to find the minimum number of wall destructions required to reach from the top-left corner to the bottom-right corner of a grid. 
The grid consists of walls (1s) and empty spaces (0s). 
The dajikstra() function uses a priority queue to find the shortest path with the least number of wall destructions. 
The pos class represents a position in the grid with y and x coordinates. 
The mem array keeps track of the minimum number of wall destructions required to reach each cell, and the visited array tracks whether a cell has been processed.

이 Java 코드는 그리드의 좌상단 모서리에서 우하단 모서리로 가는 데 필요한 최소 벽 파괴 횟수를 찾기 위해 Dijkstra 알고리즘 기반 접근 방식을 구현합니다. 
그리드는 벽(1)과 빈 공간(0)으로 구성됩니다. dajikstra() 함수는 우선순위 큐를 사용하여 벽 파괴 횟수가 가장 적은 최단 경로를 찾습니다. 
pos 클래스는 그리드 내의 위치를 y와 x 좌표로 나타냅니다. 
mem 배열은 각 셀에 도달하기 위해 필요한 최소 벽 파괴 횟수를 추적하며, visited 배열은 셀이 처리되었는지 여부를 추적합니다.
*/

import java.io.*;
import java.util.*;

public class Q1261_Algospot_G4 {

	static int grid[][] = new int[100][100]; // 그리드 배열
	static int mem[][] = new int[100][100]; // 메모이제이션 배열
	static Boolean visited[][] = new Boolean[100][100]; // 방문 여부 배열
	static int N, M; // N: 열의 수, M: 행의 수
	static int ny[] = { 1, -1, 0, -1 }; // 상하좌우 이동을 위한 y축 변화량
	static int nx[] = { 0, -1, 2, -1 }; // 상하좌우 이동을 위한 x축 변화량

// 그리드 내의 위치를 나타내는 pos 클래스
	static class pos {
		int y;
		int x;

		pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

// Dijkstra 알고리즘을 이용한 최소 벽 파괴 횟수 계산 함수
	static void dajikstra() {
		PriorityQueue<pos> pq = new PriorityQueue<>((o1, o2) -> {
			if (mem[o1.y][o1.x] > mem[o2.y][o2.x])
				return 1;
			else
				return -1;
		});

		pq.add(new pos(0, 0));

		while (!pq.isEmpty()) {
			pos p = pq.poll();
			int y = p.y;
			int x = p.x;
			if (visited[y][x])
				continue;
			visited[y][x] = true;
			int cy = y;
			int cx = x;
			for (int i = 0; i < 4; i++) {
				cy += ny[i];
				cx += nx[i];
				if (cy < 0 || cx < 0 || cy >= M || cx >= N)
					continue;

				if (grid[cy][cx] == 1)
					mem[cy][cx] = Math.min(mem[cy][cx], mem[y][x] + 1);
				else
					mem[cy][cx] = Math.min(mem[y][x], mem[cy][cx]);

				if (!visited[cy][cx])
					pq.add(new pos(cy, cx));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[];

		inp = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]);
		M = Integer.parseInt(inp[1]);

		for (int i = 0; i < M; i++) {
			Arrays.fill(mem[i], 10001);
			Arrays.fill(visited[i], false);
			String in = br.readLine();
			for (int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(in.charAt(j) + "");
			}
		}

		mem[0][0] = 0;

		dajikstra();

		bw.write(mem[M - 1][N - 1] + "");

		bw.flush();
		bw.close();
	}
}

/*
 * This Java code is a classic implementation of Dijkstra's algorithm for
 * finding the shortest path in a grid-like environment. The grid contains cells
 * that can either be passable (0) or walls (1). The goal is to find the path
 * from the top-left corner (0, 0) to the bottom-right corner (M-1, N-1) with
 * the minimum number of wall destructions.
 * 
 * The dajikstra() function uses a priority queue to process cells in order of
 * increasing path cost. It updates the mem array, which stores the minimum
 * number of walls that must be destroyed to reach each cell. The visited array
 * ensures that each cell is processed only once.
 * 
 * The main function reads the grid dimensions and the grid itself, initializes
 * arrays, and calls the dajikstra() function. Finally, it outputs the minimum
 * number of wall destructions required to reach the bottom-right corner. If no
 * path is found, the output will be 10001, as this is the initial value set for
 * unreachable cells.
 */