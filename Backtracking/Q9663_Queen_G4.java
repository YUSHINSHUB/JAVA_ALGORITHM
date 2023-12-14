package Backtracking;

/*
commented by ChatGPT
This Java code implements the N-Queens problem. 
The N-Queens puzzle is the problem of placing N chess queens on an N×N chessboard so that no two queens threaten each other. 
The program uses backtracking to solve the problem, and outputs the number of valid configurations possible.
이 Java 코드는 N-Queens 문제를 구현합니다. 
N-Queens 퍼즐은 N×N 체스판에 N개의 체스 퀸을 서로 위협하지 않도록 배치하는 문제입니다. 
프로그램은 문제를 해결하기 위해 백트래킹을 사용하며, 가능한 유효한 구성의 수를 출력합니다.
*/

import java.io.*;

public class Q9663_Queen_G4 {

	static int board[][]; // 2D array to represent the chess board (체스판을 나타내는 2D 배열)
	static int N; // Size of the board (체스판의 크기)
	static int res = 0; // Resultant count of valid configurations (유효한 구성의 결과적인 수)

// Backtracking function to place queens on board (체스판에 퀸을 배치하기 위한 백트래킹 함수)
	static void bt(int idx) {
		boolean pass = false;

		// If all queens are placed successfully (모든 퀸이 성공적으로 배치된 경우)
		if (idx == N) {
			res++;
			return;
		}

		// Try placing queen in each column (각 열에 퀸을 배치해 보기)
		for (int j = 0; j < N; j++) {
			pass = false;

			// Check for any queen placed in left of current position (현재 위치의 왼쪽에 배치된 퀸 확인)
			for (int k = j - 1; k >= 0; k--) {
				if (board[idx][k] == 1) {
					pass = true;
					break;
				}
			}

			// If there's a queen on the left, move to the next column (왼쪽에 퀸이 있다면 다음 열로 이동)
			if (pass)
				continue;

			// Check for any queen placed above the current position (현재 위치 위에 배치된 퀸 확인)
			for (int k = idx - 1; k >= 0; k--) {
				if (board[k][j] == 1) {
					pass = true;
					break;
				}
			}

			// If there's a queen above, move to the next column (위에 퀸이 있다면 다음 열로 이동)
			if (pass)
				continue;

			// Check for queens on the top-left diagonal (왼쪽 대각선 위에 퀸 확인)
			int yt = idx - 1;
			int xt = j - 1;
			while (yt >= 0 && xt >= 0) {
				if (board[yt][xt] == 1) {
					pass = true;
					break;
				}
				yt--;
				xt--;
			}

			// If there's a queen on the top-left diagonal, move to the next column (왼쪽 대각선
			// 위에 퀸이 있다면 다음 열로 이동)
			if (pass)
				continue;

			// Check for queens on the top-right diagonal (오른쪽 대각선 위에 퀸 확인)
			yt = idx - 1;
			xt = j + 1;
			while (yt >= 0 && xt < N) {
				if (board[yt][xt] == 1) {
					pass = true;
					break;
				}
				yt--;
				xt++;
			}

			// If there's a queen on the top-right diagonal, move to the next column (오른쪽
			// 대각선 위에 퀸이 있다면 다음 열로 이동)
			if (pass)
				continue;

			// Place the queen if all checks are passed (모든 검사를 통과하면 퀸을 배치)
			board[idx][j] = 1;
			bt(idx + 1);
			board[idx][j] = 0; // Remove the queen for backtracking (백트래킹을 위해 퀸 제거)
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine()); // Read size of board (체스판의 크기 읽기)
		board = new int[N][N];

		bt(0); // Start backtracking from first row (첫 번째 행에서 백트래킹 시작)

		bw.write(res + ""); // Write resultant count to output (결과 수를 출력에 작성)

		bw.flush();
		bw.close();

	}
}