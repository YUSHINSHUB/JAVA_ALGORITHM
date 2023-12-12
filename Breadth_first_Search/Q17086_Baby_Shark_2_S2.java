package Breadth_first_Search;

/*
commented by ChatGPT
This Java code implements a Breadth-First Search (BFS) algorithm to solve a problem on a 2D grid, represented by graph. 
The grid size is N x M. 
Each cell can have a value of 0 (unripe) or 1 (ripe). 
The task is to determine the minimum number of days required for all cells to become ripe, given that a cell becomes ripe if it is adjacent to a ripe cell. 
The algorithm uses a queue to process cells in a BFS manner, updating the grid and keeping track of the maximum number of days required for all cells to become ripe.
이 Java 코드는 2D 그리드 상의 문제를 해결하기 위해 너비 우선 탐색(BFS) 알고리즘을 구현합니다. 
그리드 크기는 N x M입니다. 
각 셀은 0(익지 않음) 또는 1(익음)의 값을 가질 수 있습니다. 
과제는 익은 셀에 인접한 셀이 익게 되는 조건에서 모든 셀이 익는 데 필요한 최소 일수를 결정하는 것입니다. 
알고리즘은 큐를 사용하여 BFS 방식으로 셀을 처리하고, 그리드를 업데이트하며 모든 셀이 익는 데 필요한 최대 일수를 추적합니다.
*/

import java.io.*;
import java.util.*;

public class Q17086_Baby_Shark_2_S2 {

	static int N, M; // Dimensions of the grid
	static int graph[][]; // 2D grid representing the cells
	static Queue<Integer> q = new LinkedList<>(); // Queue for BFS
	static int ymove[] = { -1, 0, 0, 1, 0, 1, 0, 0 }; // Y-axis movements
	static int xmove[] = { -1, 1, 1, -2, 2, -2, 1, 1 }; // X-axis movements

// BFS function to calculate the days required for all cells to become ripe
	static int bfs() {

		int res = 0; // Variable to store the result (maximum days required)
		int ypos, xpos; // Temporary variables for current position
		while (!q.isEmpty()) {
			int temp = q.poll(); // Current position
			int yidx = temp / M; // Y-coordinate
			int xidx = temp % M; // X-coordinate
			ypos = yidx;
			xpos = xidx;
			for (int i = 0; i < 8; i++) { // Check all 8 directions
				ypos += ymove[i];
				xpos += xmove[i];
				if (ypos < 0 || ypos >= N || xpos < 0 || xpos >= M) // Check for boundary conditions
					continue;
				else if (graph[ypos][xpos] != 0) // Skip if the cell is already ripe
					continue;
				graph[ypos][xpos] = graph[yidx][xidx] + 1; // Update the day count for the cell
				res = Math.max(res, graph[ypos][xpos]); // Update the maximum days required
				q.add(ypos * M + xpos); // Add the new position to the queue
			}
		}
		return res - 1; // Return the result (minus 1 because initial ripe cells are counted as day 1)
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Reading input for grid dimensions and initializing the grid
		String inp[] = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]);
		M = Integer.parseInt(inp[1]);
		graph = new int[N][M];

		// Filling the grid and adding ripe cells to the queue
		for (int i = 0; i < N; i++) {
			inp = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(inp[j]);
				if (graph[i][j] == 1) // Add ripe cells to the queue
					q.add(i * M + j);
			}
		}

		bw.write(bfs() + ""); // Write the result of the BFS function
		bw.flush(); // Flush the BufferedWriter
		bw.close(); // Close the BufferedWriter

	}
}