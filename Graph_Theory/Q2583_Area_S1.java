package Graph_Theory;

/*
commented by ChatGPT
This Java code solves a problem of finding and counting distinct rectangular regions not covered by given rectangles on a grid. 
It uses Breadth-First Search (BFS) to explore each region. 
The grid (board) is initialized with zeros, and the given rectangles are marked as covered (1). 
The bfs function is called for each unvisited cell (0) and calculates the size of the region. 
It uses a queue to explore adjacent cells, incrementing the size for each unvisited cell and marking it as visited. 
Finally, the code sorts and outputs the sizes of all regions found, along with their count.
이 Java 코드는 그리드 상에 주어진 직사각형들에 의해 덮이지 않은 별개의 직사각형 영역들을 찾고 세는 문제를 해결합니다. 
너비 우선 탐색(BFS)을 사용하여 각 영역을 탐색합니다. 
그리드(board)는 0으로 초기화되며, 주어진 직사각형들은 덮힌 것으로 표시됩니다(1). 
bfs 함수는 방문하지 않은 각 셀(0)에 대해 호출되며 영역의 크기를 계산합니다. 
큐를 사용하여 인접한 셀을 탐색하며, 방문하지 않은 각 셀마다 크기를 증가시키고 방문한 것으로 표시합니다. 
마지막으로, 코드는 모든 영역의 크기를 정렬하여 출력하고, 그 개수를 세어 출력합니다.
*/

import java.io.*;
import java.util.*;

public class Q2583_Area_S1 {

	static int M, N, K; // M: Rows, N: Columns, K: Number of rectangles (M: 행 수, N: 열 수, K: 직사각형 수)
	static int board[][]; // 2D array representing the grid (그리드를 나타내는 2D 배열)
	static ArrayList<Integer> list = new ArrayList<>(); // List to store the size of each region (각 영역의 크기를 저장하는 리스트)
	static int nexty[] = { 1, -1, 0, -1 }; // Y-axis movements for BFS (BFS를 위한 Y축 이동)
	static int nextx[] = { 0, -1, 2, -1 }; // X-axis movements for BFS (BFS를 위한 X축 이동)

// BFS function to explore and count each region (각 영역을 탐색하고 세는 BFS 함수)
	static void bfs(int y, int x) {
		int idx = 1; // Counter for the size of the region (영역 크기를 세는 카운터)
		Queue<Integer> yq = new LinkedList<>(); // Queue for Y-axis positions (Y축 위치를 위한 큐)
		Queue<Integer> xq = new LinkedList<>(); // Queue for X-axis positions (X축 위치를 위한 큐)
		yq.add(y);
		xq.add(x);
		board[y][x] = 1; // Mark the cell as visited (셀을 방문한 것으로 표시)

		while (!yq.isEmpty()) {
			int cury = yq.poll();
			int curx = xq.poll();
			for (int i = 0; i < 4; i++) { // Explore adjacent cells (인접한 셀 탐색)
				cury += nexty[i];
				curx += nextx[i];
				if (cury >= M || curx >= N || cury < 0 || curx < 0) // Check boundary conditions (경계 조건 확인)
					continue;
				if (board[cury][curx] == 1) // Skip if already visited (이미 방문한 경우 건너뛰기)
					continue;
				board[cury][curx] = 1; // Mark the cell as visited (셀을 방문한 것으로 표시)
				idx++; // Increment the size of the region (영역 크기 증가)
				yq.add(cury); // Add new positions to the queues (큐에 새 위치 추가)
				xq.add(curx);
			}
		}

		list.add(idx); // Add the size of the region to the list (영역 크기를 리스트에 추가)
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int dx, dy, ux, uy; // Variables for rectangle coordinates (직사각형 좌표를 위한 변수)
		int cnt = 0; // Counter for the number of regions (영역 수를 세는 카운터)

		String inp[] = br.readLine().split(" "); // Read grid dimensions and number of rectangles (그리드 크기와 직사각형 수 읽기)
		M = Integer.parseInt(inp[0]);
		N = Integer.parseInt(inp[1]);
		K = Integer.parseInt(inp[2]);
		board = new int[M][N]; // Initialize the grid (그리드 초기화)
		for (int i = 0; i < M; i++) {
			Arrays.fill(board[i], 0); // Fill the grid with zeros (그리드를 0으로 채우기)
		}
		for (int i = 0; i < K; i++) { // Mark the given rectangles on the grid (그리드에 주어진 직사각형 표시)
			inp = br.readLine().split(" ");
			dx = Integer.parseInt(inp[0]);
			dy = Integer.parseInt(inp[1]);
			ux = Integer.parseInt(inp[2]) - 1;
			uy = Integer.parseInt(inp[3]) - 1;
			for (int j = dy; j <= uy; j++) {
				for (int k = dx; k <= ux; k++)
					board[j][k] = 1;
			}
		}

		for (int i = 0; i < M; i++) { // Explore the grid for unvisited regions (방문하지 않은 영역 탐색)
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 0) { // If an unvisited region is found (방문하지 않은 영역 발견 시)
					cnt++; // Increment the region counter (영역 카운터 증가)
					bfs(i, j); // Perform BFS for the region (영역에 대해 BFS 수행)
				}
			}
		}

		Collections.sort(list); // Sort the sizes of the regions (영역 크기 정렬)
		bw.write(cnt + "\n"); // Write the number of regions (영역 수 작성)
		for (int i = 0; i < list.size(); i++) // Write the sizes of the regions (영역 크기 작성)
			bw.write(list.get(i) + " ");

		bw.flush(); // Flush the BufferedWriter (BufferedWriter 플러시)
		bw.close(); // Close the BufferedWriter (BufferedWriter 닫기)
	}
}