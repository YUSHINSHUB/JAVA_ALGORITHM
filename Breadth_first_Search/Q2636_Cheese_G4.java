package Breadth_first_Search;

/*
commented by ChatGPT
This Java code simulates a process using a Breadth-First Search (BFS) algorithm on a grid. 
The grid is represented by a 2D integer array 'grid', and a corresponding 2D Boolean array 'visited' tracks whether each cell has been visited. 
The BFS algorithm explores the grid, modifying cell values and counting specific cell types. 
The main function reads grid dimensions and values, then repeatedly calls the BFS function until a certain condition is met, recording the number of iterations and the count of a specific cell type during the last iteration.
이 Java 코드는 격자에서 너비 우선 탐색(BFS) 알고리즘을 사용하는 프로세스를 시뮬레이션합니다. 
격자는 2차원 정수 배열 'grid'로 표현되며, 각 셀이 방문되었는지를 추적하는 2차원 불리언 배열 'visited'가 있습니다. 
BFS 알고리즘은 격자를 탐색하면서 셀 값을 수정하고 특정 셀 유형을 계산합니다. 
메인 함수는 격자의 크기와 값을 읽은 후 특정 조건이 충족될 때까지 반복적으로 BFS 함수를 호출하며, 마지막 반복 동안 특정 셀 유형의 수와 반복 횟수를 기록합니다.
*/

import java.io.*;
import java.util.*;

public class Q2636_Cheese_G4 {

	static int grid[][] = new int[100][100];
	static Boolean visited[][] = new Boolean[100][100];
	static int r, c;
	static int ny[] = { 1, -1, 0, -1 };
	static int nx[] = { 0, -1, 2, -1 };

	static int bfs() {
		int cnt = 0;

		Queue<Integer> yq = new LinkedList<>();
		Queue<Integer> xq = new LinkedList<>();
		yq.add(0);
		xq.add(0);
		for (int i = 0; i < r; i++) {
			Arrays.fill(visited[i], false);
			for (int j = 0; j < c; j++) {
				if (grid[i][j] == 1)
					cnt++;
			}
		}

		while (!yq.isEmpty()) {
			int cy = yq.poll();
			int cx = xq.poll();
			if (grid[cy][cx] == 1) {
				grid[cy][cx] = 0;
				continue;
			}
			for (int i = 0; i < 4; i++) {
				cy += ny[i];
				cx += nx[i];
				if (cy < 0 || cx < 0 || cy >= r || cx >= c)
					continue;
				else if (visited[cy][cx])
					continue;

				visited[cy][cx] = true;
				yq.add(cy);
				xq.add(cx);
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[];
		int idx = 0;
		int cnt = 0;

		inp = br.readLine().split(" ");
		r = Integer.parseInt(inp[0]);
		c = Integer.parseInt(inp[1]);

		for (int i = 0; i < r; i++) {
			inp = br.readLine().split(" ");
			for (int j = 0; j < c; j++)
				grid[i][j] = Integer.parseInt(inp[j]);
		}

		while (true) {
			int temp = bfs();
			if (temp == 0)
				break;
			cnt = temp;
			idx++;
		}

		bw.write(idx + "\n" + cnt);
		bw.flush();
		bw.close();
	}
}