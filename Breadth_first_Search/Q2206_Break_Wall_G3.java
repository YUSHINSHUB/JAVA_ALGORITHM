package Breadth_first_Search;

/*
commented by ChatGPT
This Java code is designed to find the shortest path in an N×M grid where '0' represents a traversable cell and '1' represents an impassable wall. 
The goal is to travel from the top-left corner (1, 1) to the bottom-right corner (N, M) using the shortest possible path, which includes breaking up to one wall if it provides a shorter route. 
The program uses Breadth-First Search (BFS) to explore paths, and a two-dimensional array 'visited' to track the minimum number of steps taken to reach each cell.
이 Java 코드는 N×M 그리드에서 최단 경로를 찾는 것을 목표로 합니다. 여기서 '0'은 이동할 수 있는 칸을, '1'은 벽으로 지나갈 수 없는 칸을 나타냅니다. 
목표는 왼쪽 상단 모서리 (1, 1)에서 오른쪽 하단 모서리 (N, M)까지 가능한 가장 짧은 경로를 사용하여 이동하는 것이며, 이는 더 짧은 경로를 제공하는 경우 한 개의 벽을 부수는 것을 포함합니다. 
프로그램은 너비 우선 탐색(BFS)을 사용하여 경로를 탐색하고, 2차원 배열 'visited'를 사용하여 각 칸에 도달하기까지 걸린 최소 이동 횟수를 추적합니다.
*/

import java.io.*;
import java.util.*;

public class Q2206_Break_Wall_G3 {
	static int N, M; // 그리드의 행과 열 크기
	static int[][] grp; // 그리드의 상태를 나타내는 배열 (0: 이동 가능, 1: 벽)
	static int[][] visited; // 각 칸에 도달하기까지의 이동 횟수를 저장하는 배열
	static int[] ny = { -1, 1, 0, 0 }; // y축 이동 벡터 (상, 하)
	static int[] nx = { 0, 0, -1, 1 }; // x축 이동 벡터 (좌, 우)

	static void search() {
		Queue<Integer> yq = new LinkedList<>(); // y 좌표 큐
		Queue<Integer> xq = new LinkedList<>(); // x 좌표 큐
		Queue<Integer> wyq = new LinkedList<>(); // 벽을 부수고 갈 수 있는 y 좌표 큐
		Queue<Integer> wxq = new LinkedList<>(); // 벽을 부수고 갈 수 있는 x 좌표 큐
		yq.add(0);
		xq.add(0);

		// 기본 BFS 수행
		while (!yq.isEmpty()) {
			int cy = yq.poll(); // 현재 y 좌표
			int cx = xq.poll(); // 현재 x 좌표

			for (int i = 0; i < 4; i++) {
				int y = cy + ny[i];
				int x = cx + nx[i];
				if (y < 0 || x < 0 || y >= N || x >= M)
					continue;
				if (visited[y][x] >= 0)
					continue;
				if (grp[y][x] == 1) {
					visited[y][x] = visited[cy][cx] + 1;
					wyq.add(y);
					wxq.add(x);
					continue;
				}

				visited[y][x] = visited[cy][cx] + 1;
				yq.add(y);
				xq.add(x);
			}
		}

		// 벽을 부수고 이동하는 경우에 대한 BFS 수행
		while (!wyq.isEmpty()) {
			yq.add(wyq.poll());
			xq.add(wxq.poll());

			while (!yq.isEmpty()) {
				int cy = yq.poll();
				int cx = xq.poll();

				for (int i = 0; i < 4; i++) {
					int y = cy + ny[i];
					int x = cx + nx[i];
					if (y < 0 || y >= N || x < 0 || x >= M)
						continue;
					if (grp[y][x] == 1)
						continue;
					if (visited[y][x] >= 0 && visited[y][x] <= visited[cy][cx] + 1)
						continue;

					visited[y][x] = visited[cy][cx] + 1;
					yq.add(y);
					xq.add(x);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] inp = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]);
		M = Integer.parseInt(inp[1]);
		grp = new int[N][M];
		visited = new int[N][M];

		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			Arrays.fill(visited[i], -1);
			for (int j = 0; j < M; j++)
				grp[i][j] = Integer.parseInt(Character.toString(temp.charAt(j)));
		}

		visited[N - 1][M - 1] = -2; // 목적지를 특별한 값으로 초기화
		visited[0][0] = 0; // 시작점 초기화
		search(); // 최단 경로 탐색

		bw.write(visited[N - 1][M - 1] + 1 + ""); // 최단 경로 길이 출력

		bw.flush();
		bw.close();
	}
}