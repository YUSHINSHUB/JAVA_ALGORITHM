package Dynamic_Programming;

/*
commented by ChatGPT
This Java code implements a dynamic programming solution for a board game problem. 
The game involves moving on a board of N x N cells where each cell contains a number that indicates the maximum number of cells one can move either right or down. 
The goal is to count the number of ways to reach the bottom-right corner from the top-left corner.
이 Java 코드는 보드 게임 문제를 위한 동적 프로그래밍 솔루션을 구현합니다. 
이 게임은 N x N 셀의 보드에서 각 셀에 있는 숫자가 오른쪽 또는 아래로 이동할 수 있는 최대 셀 수를 나타내는 방식으로 진행됩니다. 
목표는 왼쪽 상단 모서리에서 오른쪽 하단 모서리까지 도달하는 방법의 수를 세는 것입니다.
*/

import java.io.*;
import java.util.*;

public class Q1890_Jump_S1 {

	static int N; // Size of the board
	static int board[][]; // 2D array to represent the board
	static long mem[][]; // 2D array for memoization to store number of ways to reach each cell

// Recursive function for dynamic programming
	static long dp(int y, int x) {

		// If the value is already computed, return it
		if (mem[y][x] >= 0)
			return mem[y][x];
		// Base case: if current cell value is 0, no way to move forward
		else if (board[y][x] == 0) {
			mem[y][x] = 0;
			return 0;
		}
		// If moving right or down goes out of the board, set ways to 0
		else if (y + board[y][x] >= N && x + board[y][x] >= N)
			mem[y][x] = 0;
		// If moving down goes out of the board, only move right
		else if (y + board[y][x] >= N)
			mem[y][x] = dp(y, x + board[y][x]);
		// If moving right goes out of the board, only move down
		else if (x + board[y][x] >= N)
			mem[y][x] = dp(y + board[y][x], x);
		// Otherwise, sum up ways of moving right and down
		else
			mem[y][x] = dp(y, x + board[y][x]) + dp(y + board[y][x], x);

		return mem[y][x]; // Return the computed number of ways for the current cell
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine()); // Reading the size of the board
		board = new int[N][N]; // Initializing the board
		mem = new long[N][N]; // Initializing the memoization array
		for (int i = 0; i < N; i++) {
			Arrays.fill(mem[i], -1); // Filling memoization array with -1 to indicate uncomputed cells
			String inp[] = br.readLine().split(" ");
			for (int j = 0; j < N; j++)
				board[i][j] = Integer.parseInt(inp[j]); // Filling the board with input values
		}
		mem[N - 1][N - 1] = 1; // Base case: There is 1 way to be at the bottom-right cell

		bw.write(dp(0, 0) + ""); // Writing the total number of ways to reach bottom-right cell from top-left
		bw.flush(); // Flushing the BufferedWriter
		bw.close(); // Closing the BufferedWriter

	}
}