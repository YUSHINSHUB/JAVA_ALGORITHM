package Backtracking;

/*
commented by ChatGPT
This Java code implements a Sudoku solver using backtracking. 
It fills in a 9x9 Sudoku board such that each column, each row, and each of the nine 3x3 subgrids contain all of the digits from 1 to 9.
이 Java 코드는 백트래킹을 사용하여 스도쿠 퍼즐을 해결하는 알고리즘을 구현합니다. 
이 코드는 각 열, 각 행, 그리고 아홉 개의 3x3 부분 그리드가 1부터 9까지의 모든 숫자를 포함하도록 9x9 스도쿠 보드를 채웁니다.
*/

import java.io.*;
import java.util.*;

public class Q2580_Sudoku_G4 {

	static int board[][] = new int[9][9]; // The Sudoku board
	static int cnt = 0; // The number of cells to fill
	static int y[][] = new int[9][10]; // Used to check if a number can be placed in a row
	static int x[][] = new int[9][10]; // Used to check if a number can be placed in a column
	static int area[][][] = new int[3][3][10]; // Used to check if a number can be placed in a 3x3 subgrid
	static boolean end = false; // Flag to indicate when the solution is found
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// Backtracking function to solve the Sudoku
	static void bt(int yidx, int idx) throws IOException {

		if (idx == cnt) { // If all cells are filled, print the board and stop
			end = true;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					bw.write(board[i][j] + " ");
				}
				bw.write("\n");
			}
			return;
		}

		// Try to fill in each cell starting from the given row index
		for (int i = yidx; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == 0) { // If the cell is empty
					// Try placing each number from 1 to 9
					for (int k = 1; k <= 9; k++) {
						// Check if the number can be placed
						if (y[i][k] == 0 && x[j][k] == 0 && area[i / 3][j / 3][k] == 0) {
							// Place the number and mark the row, column, and subgrid as occupied
							board[i][j] = k;
							y[i][k] = 1;
							x[j][k] = 1;
							area[i / 3][j / 3][k] = 1;
							// Continue with the next cell
							bt(i, idx + 1);
							if (end)
								return; // If the end is reached, stop further recursion
							// Backtrack if not ended: unmark and empty the cell
							y[i][k] = 0;
							x[j][k] = 0;
							area[i / 3][j / 3][k] = 0;
							board[i][j] = 0;
						}
					}
					return; // Return to try the next number or to backtrack further
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Initialize the check arrays to 0
		for (int i = 0; i < 9; i++) {
			Arrays.fill(y[i], 0);
			Arrays.fill(x[i], 0);
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				Arrays.fill(area[i][j], 0);
		}

		// Read the initial board state from the input and set up the check arrays
		for (int i = 0; i < 9; i++) {
			String inp[] = br.readLine().split(" ");
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(inp[j]);
				if (board[i][j] == 0)
					cnt++; // Increase the count of cells to fill
				// Mark the filled numbers in the check arrays
				y[i][board[i][j]] = 1;
				x[j][board[i][j]] = 1;
				area[i / 3][j / 3][board[i][j]] = 1;
			}
		}

		bt(0, 0); // Start the backtracking process

		bw.flush();
		bw.close();

	}

}
