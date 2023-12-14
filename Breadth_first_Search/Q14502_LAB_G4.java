package Breadth_first_Search;

/*
commented by ChatGPT
이 Java 코드는 주어진 2차원 배열의 특정 지점에 장애물을 3개 설치하여 바이러스가 퍼지지 않는 영역의 최대 크기를 찾는 문제를 해결합니다.
바이러스는 상하좌우로 퍼질 수 있으며, 퍼지지 않는 영역을 찾기 위해 BFS(너비 우선 탐색) 알고리즘을 사용합니다.

This Java code solves a problem where obstacles are placed at specific points in a given 2D array to find the maximum size of the area where a virus does not spread.
The virus can spread up, down, left, and right. To find the non-infected area, the BFS (Breadth-First Search) algorithm is used.
*/

import java.io.*;
import java.util.*;

public class Q14502_Lab_G4 {

	static int n, m; // 행과 열의 크기 (Dimensions of the rows and columns)
	static int res = 0; // 최대 안전 영역의 크기 (Size of the maximum safe area)
	static int ypos[] = { -1, 1, 1, -1 }; // 세로 방향 이동 (Vertical movement)
	static int xpos[] = { 0, 1, -1, -1 }; // 가로 방향 이동 (Horizontal movement)
	static int grp[][]; // 입력 맵 (Input map)
	static Queue<Integer> xq = new LinkedList<>();
	static Queue<Integer> yq = new LinkedList<>();

// 바이러스를 퍼뜨리는 BFS 함수 (BFS function to spread the virus)
	static void bfs(int y, int x, int idx) {

		// 3개의 장애물이 설치된 경우 (When 3 obstacles are placed)
		if (idx == 3) {

			int temp = 0; // 임시 안전 영역 크기 (Temporary safe area size)
			int tgrp[][] = new int[n][m];

			for (int i = 0; i < n; i++)
				tgrp[i] = grp[i].clone();

			for (int j = 0; j < yq.size(); j++) {

				Queue<Integer> tyq = new LinkedList<>();
				Queue<Integer> txq = new LinkedList<>();

				tyq.add(yq.peek());
				txq.add(xq.peek());

				yq.add(yq.poll());
				xq.add(xq.poll());

				// 바이러스 퍼뜨리기 (Spreading the virus)
				while (!tyq.isEmpty()) {
					int ty = tyq.poll();
					int tx = txq.poll();

					for (int i = 0; i < 4; i++) {
						ty += ypos[i];
						tx += xpos[i];

						if (ty < 0 || ty >= n || tx < 0 || tx >= m)
							continue;
						else if (tgrp[ty][tx] == 0) {
							tyq.add(ty);
							txq.add(tx);
							tgrp[ty][tx] = 2;
						}
					}
				}
			}

			// 안전 영역 계산 (Calculate the safe area)
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (tgrp[i][j] == 0)
						temp++;
				}
			}

			res = Math.max(res, temp);

		} else {
			// 장애물 설치하기 (Placing obstacles)
			for (int i = y; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (j == 0 && i == y)
						j = x;
					if (j >= m)
						break;
					if (grp[i][j] == 0) {
						grp[i][j] = 1;
						bfs(i, j + 1, idx + 1);
						grp[i][j] = 0;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		n = Integer.parseInt(inp[0]);
		m = Integer.parseInt(inp[1]);
		grp = new int[n][m];

		// 맵 입력받기 (Receiving the map input)
		for (int i = 0; i < n; i++) {
			inp = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				grp[i][j] = Integer.parseInt(inp[j]);
				if (grp[i][j] == 2) {
					yq.add(i);
					xq.add(j);
				}
			}
		}

		bfs(0, 0, 0);
		bw.write(res + "");

		bw.flush();
		bw.close();
	}
}