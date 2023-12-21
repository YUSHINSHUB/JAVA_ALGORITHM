package Breadth_first_Search;

/*
commented by ChatGPT
This Java code simulates the process of countries' population exchange based on their differences in populations. 
It uses a BFS algorithm to find and equalize the populations of adjacent countries if their population difference falls within a specified range (L to R). 
The program outputs the number of days required for no more exchanges to be possible.
이 Java 코드는 인접한 국가들 간의 인구 차이가 특정 범위(L에서 R 사이)에 있을 때 인구 교환 과정을 시뮬레이션합니다. 
BFS 알고리즘을 사용하여 인접 국가들의 인구를 찾고 평준화하며, 더 이상 교환할 수 없을 때까지 필요한 일수를 출력합니다.
*/

import java.io.*;
import java.util.*;

public class Q16234_Population_G4 {

	static int ny[] = { -1, 1, 0, 1 }; // Array to move vertically in the grid (그리드에서 수직으로 이동하기 위한 배열)
	static int nx[] = { 0, -1, 2, -1 }; // Array to move horizontally in the grid (그리드에서 수평으로 이동하기 위한 배열)
	static int N, L, R; // N: grid size, L and R: population difference limits (N: 그리드 크기, L과 R: 인구 차이
						// 한계)
	static int grid[][]; // 2D array to represent each country's population (각 국가의 인구를 나타내는 2D 배열)
	static Boolean visited[][]; // Boolean 2D array to keep track of visited countries (방문한 국가를 추적하기 위한 Boolean
								// 2D 배열)

	static void bfs(int y, int x) { // BFS function to perform population exchange (인구 교환을 수행하는 BFS 함수)

		int sum = grid[y][x]; // Sum of populations for averaging (평균을 내기 위한 인구 합계)
		int size = 1; // Number of countries involved in exchange (교환에 참여하는 국가 수)
		Queue<Integer> ay = new LinkedList<>(); // Queue to store y-coordinates for averaging (평균을 내기 위한 y좌표 저장 큐)
		Queue<Integer> ax = new LinkedList<>(); // Queue to store x-coordinates for averaging (평균을 내기 위한 x좌표 저장 큐)
		Queue<Integer> yq = new LinkedList<>(); // BFS queue for y-coordinates (BFS를 위한 y좌표 큐)
		Queue<Integer> xq = new LinkedList<>(); // BFS queue for x-coordinates (BFS를 위한 x좌표 큐)
		yq.add(y);
		xq.add(x);
		ay.add(y);
		ax.add(x);

		while (!yq.isEmpty()) { // Continue BFS until queue is empty (큐가 빌 때까지 BFS 계속)

			int cy = yq.poll(); // Current y-coordinate (현재 y좌표)
			int cx = xq.poll(); // Current x-coordinate (현재 x좌표)
			int ly = cy;
			int lx = cx;

			for (int i = 0; i < 4; i++) { // Check all 4 adjacent positions (4개의 인접 위치 확인)
				ly += ny[i];
				lx += nx[i];
				if (ly >= N || lx >= N || ly < 0 || lx < 0 || visited[ly][lx]) // Boundary and visited check (경계 및 방문 여부
																				// 확인)
					continue;

				// Check if population difference is within the limits L and R (인구 차이가 L과 R 한계
				// 내인지 확인)
				if (Math.abs(grid[ly][lx] - grid[cy][cx]) >= L && Math.abs(grid[ly][lx] - grid[cy][cx]) <= R) {
					visited[ly][lx] = true; // Mark as visited (방문으로 표시)
					yq.add(ly);
					xq.add(lx);
					ay.add(ly);
					ax.add(lx);
					sum += grid[ly][lx]; // Add to sum for averaging (평균을 위해 합계에 추가)
					size++; // Increase size (크기 증가)
				}
			}
		}

		// Average the population (인구 평균화)
		sum /= size;
		while (!ay.isEmpty()) {
			int ly = ay.poll();
			int lx = ax.poll();
			grid[ly][lx] = sum; // Update population (인구 업데이트)
		}
	}

	static int search() { // Function to start the population exchange process (인구 교환 과정을 시작하는 함수)

		int res = 0; // Days count for exchanges (교환을 위한 일수 카운트)

		while (true) {
			for (int i = 0; i < N; i++) // Reset visited countries for each day (각 날마다 방문한 국가 초기화)
				Arrays.fill(visited[i], false);

			Boolean pass = false; // Flag to check if any exchange occurred (교환 발생 여부를 확인하는 플래그)
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j]) // Skip if already visited (이미 방문한 경우 건너뛰기)
						continue;
					int y = i;
					int x = j;
					// Check all adjacent countries for possible exchange (인접한 국가를 확인하여 가능한 교환 확인)
					for (int k = 0; k < 4; k++) {
						y += ny[k];
						x += nx[k];
						if (y >= N || x >= N || y < 0 || x < 0 || visited[y][x])
							continue;

						// If exchange is possible, perform BFS (교환이 가능하면 BFS 수행)
						if (Math.abs(grid[i][j] - grid[y][x]) >= L && Math.abs(grid[i][j] - grid[y][x]) <= R) {
							pass = true;
							visited[i][j] = true;
							bfs(i, j);
							break;
						}
					}
				}
			}

			if (!pass) // If no exchange occurred, break (교환이 발생하지 않으면 종료)
				break;
			else
				res++; // Increase day count (일수 카운트 증가)
		}

		return res; // Return the total number of days (총 일수 반환)
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read input and initialize variables (입력 읽기 및 변수 초기화)
		String inp[] = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]);
		L = Integer.parseInt(inp[1]);
		R = Integer.parseInt(inp[2]);
		grid = new int[N][N];
		visited = new Boolean[N][N];

		// Read and set initial population of each country (각 국가의 초기 인구 설정)
		for (int i = 0; i < N; i++) {
			inp = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(inp[j]);
			}
		}

		// Write and flush the result (결과 작성 및 출력)
		bw.write(search() + "");
		bw.flush();
		bw.close();
	}
}