package Breadth_first_Search;

/*
commented by ChatGPT
이 Java 코드는 2D 배열로 표현된 빙산이 주어질 때, 빙산이 몇 년 만에 분리되는지를 계산합니다.
This Java code calculates the number of years it takes for a given iceberg, represented in a 2D array, to break apart.

키워드: 빙산 (Keywords: Iceberg)
*/

import java.io.*;
import java.math.*;
import java.util.*;

public class Q2573_ICEBERG_G4 {

	static int idx = 0; // 빙산이 분리되기까지의 시간을 계산하기 위한 변수 (Variable to calculate the time taken for the
						// iceberg to break apart)
	static int n, m;
	static int sea[][]; // 빙산의 현재 상태를 저장하는 2D 배열 (2D array to store the current state of the iceberg)
	static int by[] = { 1, -1, -1, 1 };
	static int bx[] = { 0, 1, -1, -1 };
	static boolean visited[][]; // 해당 위치를 방문했는지 체크하기 위한 변수 (Variable to check if the given position was visited)

// 현재 빙산이 몇 개의 덩어리로 이루어져있는지 확인하는 함수 (Function to check how many chunks the iceberg is currently made of)
	static int chk() {

		visited = new boolean[n][m];
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (sea[i][j] > 0 && !visited[i][j]) {
					dfs(i, j);
					cnt++;
				}
			}
		}

		return cnt;
	}

// DFS를 사용하여 빙산의 덩어리를 찾는 함수 (Function to find the chunks of the iceberg using DFS)
	static void dfs(int y, int x) {
		visited[y][x] = true;
		for (int i = 0; i < 4; i++) {
			y += by[i];
			x += bx[i];
			if (y < 0 || x < 0 || y >= n || x >= m)
				continue;
			if (sea[y][x] > 0 && !visited[y][x])
				dfs(y, x);
		}
	}

// BFS를 사용하여 빙산 주변의 바다에 의해 빙산이 얼마나 녹는지 계산하는 함수 (Function to calculate how much the iceberg melts due to the sea around it using BFS)
	static void bfs() {

		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (sea[i][j] == 0 && !visited[i][j]) {
					int y = i;
					int x = j;
					for (int k = 0; k < 4; k++) {
						y += by[k];
						x += bx[k];
						if (y < 0 || x < 0 || y >= n || x >= m)
							continue;
						else if (sea[y][x] > 0) {
							sea[y][x]--;
							visited[y][x] = true;
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 사용자로부터 빙산의 크기와 상태를 입력받습니다.
		// Reads the size and state of the iceberg from the user.
		String inp[] = br.readLine().split(" ");
		n = Integer.parseInt(inp[0]);
		m = Integer.parseInt(inp[1]);
		sea = new int[n][m];

		for (int i = 0; i < n; i++) {
			inp = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				sea[i][j] = Integer.parseInt(inp[j]);
			}
		}

		// 빙산이 분리될 때까지 빙산의 상태를 업데이트하며 시간을 계산합니다.
		// Updates the state of the iceberg and calculates the time until the iceberg
		// breaks apart.
		while (true) {

			int chk = chk();

			if (chk == 0) {
				idx = 0;
				break;
			} else if (chk >= 2)
				break;

			idx++;
			bfs();
		}

		bw.write(idx + "");
		bw.flush();
		bw.close();
	}
}