package Graph_Theory;

/*
commented by ChatGPT
This Java code implements a Breadth-First Search (BFS) algorithm to count the number of islands in a given sea map. 
The map is represented as a 2D array (sea), where 1 indicates land and 0 indicates water. 
The bfs function explores each piece of land and marks it as visited (by setting it to 0). 
The search function iterates over the map, invoking bfs for each unvisited land piece, incrementing the island count. 
The program repeatedly reads dimensions of the sea and the sea map until a termination condition (both dimensions being 0) is met, outputting the number of islands for each map.
이 Java 코드는 주어진 바다 지도에서 섬의 수를 세기 위해 너비 우선 탐색(BFS) 알고리즘을 구현합니다. 
지도는 2D 배열(sea)로 표현되며, 1은 땅을 나타내고 0은 물을 나타냅니다. 
bfs 함수는 각 땅 조각을 탐색하고 방문한 것으로 표시합니다(0으로 설정). 
search 함수는 지도를 반복하여 방문하지 않은 땅 조각마다 bfs를 호출하고 섬의 수를 증가시킵니다. 
프로그램은 바다의 크기와 바다 지도를 반복적으로 읽고, 종료 조건(두 차원 모두 0인 경우)이 충족될 때까지 각 지도에 대한 섬의 수를 출력합니다.
*/

import java.io.*;
import java.util.*;

public class Q4963_Island_S2 {

	static int sea[][]; // 2D array representing the sea map (바다 지도를 나타내는 2D 배열)
	static int nexty[] = { 1, 0, 0, -1, 0, -1, 0, 0 }; // Y-axis movements for BFS (BFS를 위한 Y축 이동)
	static int nextx[] = { -1, 1, 1, -2, 2, -2, 1, 1 }; // X-axis movements for BFS (BFS를 위한 X축 이동)

// BFS function to explore each island (각 섬을 탐색하는 BFS 함수)
	static void bfs(int w, int h, int y, int x) {
		Queue<Integer> yq = new LinkedList<>(); // Queue for Y-axis positions (Y축 위치를 위한 큐)
		Queue<Integer> xq = new LinkedList<>(); // Queue for X-axis positions (X축 위치를 위한 큐)
		yq.add(y);
		xq.add(x);

		while (!yq.isEmpty()) {
			int cury = yq.poll();
			int curx = xq.poll();
			for (int i = 0; i < 8; i++) {
				cury += nexty[i];
				curx += nextx[i];
				if (cury < 0 || curx < 0 || cury >= h || curx >= w) // Check boundary conditions (경계 조건 확인)
					continue;
				if (sea[cury][curx] == 0) // Skip if water (물인 경우 건너뛰기)
					continue;
				sea[cury][curx] = 0; // Mark land as visited (방문한 땅으로 표시)
				yq.add(cury); // Add new positions to the queues (큐에 새 위치 추가)
				xq.add(curx);
			}
		}
	}

// Function to search for islands (섬을 찾기 위한 함수)
	static int search(int w, int h) {
		int res = 0; // Counter for the number of islands (섬의 수를 세는 카운터)
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (sea[i][j] == 1) { // If land is found (땅이 발견되면)
					res++; // Increment island count (섬 수 증가)
					sea[i][j] = 0; // Mark land as visited (방문한 땅으로 표시)
					bfs(w, h, i, j); // Perform BFS to mark the entire island (전체 섬을 표시하기 위해 BFS 수행)
				}
			}
		}
		return res; // Return the total number of islands (총 섬의 수 반환)
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int w, h; // Variables for width and height of the sea (바다의 너비와 높이를 위한 변수)

		while (true) {
			String inp[] = br.readLine().split(" "); // Read width and height (너비와 높이 읽기)
			w = Integer.parseInt(inp[0]);
			h = Integer.parseInt(inp[1]);
			if (w + h == 0) // Check for termination condition (종료 조건 확인)
				break;
			sea = new int[h][w]; // Initialize the sea map (바다 지도 초기화)

			for (int i = 0; i < h; i++) {
				inp = br.readLine().split(" ");
				for (int j = 0; j < w; j++) {
					sea[i][j] = Integer.parseInt(inp[j]); // Populate the sea map (바다 지도 채우기)
				}
			}

			bw.write(search(w, h) + "\n"); // Write the number of islands found (찾은 섬의 수 작성)
		}

		bw.flush(); // Flush the BufferedWriter (BufferedWriter 플러시)
		bw.close(); // Close the BufferedWriter (BufferedWriter 닫기)
	}
}
