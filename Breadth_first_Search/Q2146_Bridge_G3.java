package Breadth_first_Search;

/*
commented by ChatGPT
This Java code is for solving the problem of finding the shortest bridge between islands on a grid. 
It first identifies distinct islands and assigns each a unique identifier. 
Then, it calculates the minimum bridge length needed to connect any two islands. 
The process involves two primary functions: find_island() to identify and label the islands, and bridge() to calculate the shortest bridge length from each island grid cell to any cell of a different island. 
The main function reads the grid dimensions (N) and the grid itself, where '1' represents land and '0' represents water. 
find_island() marks each island with a unique number starting from 2. 
The bridge() function then uses BFS to find the shortest distance from the cells of one island to another, ensuring not to revisit the same cell or cross the same island. 
The shortest bridge length is determined by iterating over each cell of each island.

이 Java 코드는 격자판에서 섬 사이의 가장 짧은 다리를 찾는 문제를 해결하기 위한 것입니다. 코드는 먼저 서로 다른 섬을 식별하고 각각에 고유한 식별자를 할당합니다. 
그런 다음, 두 섬을 연결하는데 필요한 최소 다리 길이를 계산합니다. 
이 과정에는 주요 함수 두 개가 포함되어 있습니다: find_island()는 섬을 식별하고 레이블을 붙이는 기능을 하며, bridge()는 각 섬 격자 칸에서 다른 섬의 어떤 칸으로의 최단 다리 길이를 계산합니다. 
메인 함수는 격자 크기(N)와 격자 자체를 읽습니다. 여기서 '1'은 땅을 나타내고 '0'은 물을 나타냅니다. find_island()는 각 섬에 2부터 시작하는 고유 번호를 표시합니다. 
bridge() 함수는 BFS를 사용하여 한 섬의 칸에서 다른 섬으로의 최단 거리를 찾되, 같은 칸을 재방문하거나 같은 섬을 가로지르지 않도록 합니다. 
각 섬의 각 칸에 대해 반복하여 최단 다리 길이를 결정합니다.
*/

import java.io.*;
import java.util.*;
import java.math.*;

public class Q2146_Bridge_G3 {

	static int ny[] = { -1, 0, 0, 1 }; // Y-axis movement (상, 하, 좌, 우로 이동을 위한 Y축 변화량)
	static int nx[] = { 0, -1, 1, 0 }; // X-axis movement (상, 하, 좌, 우로 이동을 위한 X축 변화량)
	static int grid[][] = new int[100][100]; // Grid representing the map (지도를 나타내는 격자)
	static Boolean visited[][] = new Boolean[100][100]; // Tracking visited cells (방문한 셀 추적)
	static int N; // Size of the grid (격자의 크기)
	static int res = 0; // Result variable to store the shortest bridge length (가장 짧은 다리 길이를 저장하는 결과 변수)

// Function to identify and mark islands with unique identifiers
	static void find_island() {

		Queue<Integer> yq = new LinkedList<>();
		Queue<Integer> xq = new LinkedList<>();
		int idx = 2; // Starting index for islands

		// Iterate over the grid to find islands
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j] == 1) { // Island found
					yq.add(i);
					xq.add(j);
					grid[i][j] = idx; // Mark island with unique identifier

					// BFS to mark the entire island
					while (!yq.isEmpty()) {

						int cy = yq.poll();
						int cx = xq.poll();

						// Check adjacent cells
						for (int k = 0; k < 4; k++) {
							int ynext = cy + ny[k];
							int xnext = cx + nx[k];
							if (ynext < 0 || xnext < 0 || ynext >= N || xnext >= N)
								continue;
							if (grid[ynext][xnext] == 0 || grid[ynext][xnext] == idx)
								continue;

							grid[ynext][xnext] = idx; // Mark adjacent cells as part of the island
							yq.add(ynext);
							xq.add(xnext);
						}

					}
					idx++; // Increment identifier for the next island
				}
			}
		}

	}

// Function to calculate the shortest bridge length from an island
	static int bridge(int y, int x, int idx) {

		// Reset visited grid
		for (int i = 0; i < N; i++)
			Arrays.fill(visited[i], false);

		Queue<Integer> yq = new LinkedList<>();
		Queue<Integer> xq = new LinkedList<>();
		Queue<Integer> b = new LinkedList<>(); // Queue to store bridge length
		yq.add(y);
		xq.add(x);
		b.add(0);

		// BFS to find shortest bridge
		while (!yq.isEmpty()) {

			int cy = yq.poll();
			int cx = xq.poll();
			int cb = b.poll(); // Current bridge length

			// Check adjacent cells
			for (int i = 0; i < 4; i++) {
				int ynext = cy + ny[i];
				int xnext = cx + nx[i];
				if (ynext < 0 || xnext < 0 || ynext >= N || xnext >= N)
					continue;
				if (visited[ynext][xnext])
					continue;
				if (grid[ynext][xnext] == idx)
					continue;
				if (grid[ynext][xnext] > 0 && grid[ynext][xnext] != idx)
					return cb; // Reached another island

				yq.add(ynext);
				xq.add(xnext);
				b.add(cb + 1); // Increase bridge length
				visited[ynext][xnext] = true;
			}

		}

		return Integer.MAX_VALUE; // Return maximum value if no bridge is found
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int res = Integer.MAX_VALUE; // Initialize result to maximum value

		N = Integer.parseInt(br.readLine()); // Read grid size

		// Read grid data
		for (int i = 0; i < N; i++) {
			String inp[] = br.readLine().split(" ");
			for (int j = 0; j < N; j++)
				grid[i][j] = Integer.parseInt(inp[j]);
		}

		find_island(); // Identify and mark islands

		// Find the shortest bridge for each island
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j] > 1) {
					res = Math.min(res, bridge(i, j, grid[i][j]));
				}
			}
		}

		bw.write(res + ""); // Write the result
		bw.flush();
		bw.close();
	}
}