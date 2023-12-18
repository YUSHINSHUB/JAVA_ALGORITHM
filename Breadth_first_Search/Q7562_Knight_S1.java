package Breadth_first_Search;

/*
commented by ChatGPT
This Java code implements a Breadth-First Search (BFS) algorithm to solve the problem of finding the minimum number of moves for a knight to reach a destination on a chessboard. 
The chessboard size (l) and the knight's starting and destination positions are provided as input. 
The bfs function explores possible moves from the current position, marking each visited position with the number of moves taken to reach it. 
The search continues until the destination is reached. 
The program handles multiple test cases (T) and outputs the minimum number of moves for each case.
이 Java 코드는 체스판에서 나이트가 목적지에 도달하기 위한 최소 이동 횟수를 찾는 문제를 해결하기 위해 너비 우선 탐색(BFS) 알고리즘을 구현합니다. 
체스판의 크기(l) 및 나이트의 시작 위치와 목적지 위치가 입력으로 제공됩니다. 
bfs 함수는 현재 위치에서 가능한 이동을 탐색하며, 각 방문 위치에 도달하는 데 필요한 이동 횟수를 표시합니다. 
목적지에 도달할 때까지 탐색이 계속됩니다. 
프로그램은 여러 테스트 케이스(T)를 처리하고 각 경우에 대한 최소 이동 횟수를 출력합니다.
*/

import java.io.*;
import java.util.*;

public class Q7562_Knight_S1 {

	static int l; // Size of the chessboard (체스판의 크기)
	static int board[][]; // 2D array representing the chessboard (체스판을 나타내는 2D 배열)
	static int nexty[] = { -2, 0, 1, 0, 2, 0, 1, 0 }; // Y-axis movements for a knight (나이트의 Y축 이동)
	static int nextx[] = { -1, 2, -3, 4, -4, 4, -3, 2 }; // X-axis movements for a knight (나이트의 X축 이동)

// BFS function to find the minimum number of moves (최소 이동 횟수를 찾기 위한 BFS 함수)
	static int bfs(int sy, int sx, int dy, int dx) {
		Queue<Integer> yq = new LinkedList<Integer>(); // Queue for Y-axis positions (Y축 위치를 위한 큐)
		Queue<Integer> xq = new LinkedList<Integer>(); // Queue for X-axis positions (X축 위치를 위한 큐)
		yq.add(sy);
		xq.add(sx);
		int cury, curx, y, x;

		while (!yq.isEmpty()) {
			cury = yq.poll();
			curx = xq.poll();
			y = cury;
			x = curx;

			for (int i = 0; i < 8; i++) { // Explore all possible moves for a knight (나이트의 모든 가능한 이동 탐색)
				y += nexty[i];
				x += nextx[i];
				if (y < 0 || x < 0 || y >= l || x >= l) // Check boundary conditions (경계 조건 확인)
					continue;
				if (board[y][x] >= 0) // Skip if already visited (이미 방문한 경우 건너뛰기)
					continue;

				board[y][x] = board[cury][curx] + 1; // Mark the number of moves (이동 횟수 표시)
				if (y == dy && x == dx) // If destination is reached (목적지에 도달한 경우)
					break;
				yq.add(y); // Add new positions to the queues (큐에 새 위치 추가)
				xq.add(x);
			}
		}

		return board[dy][dx]; // Return the minimum number of moves (최소 이동 횟수 반환)
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T, sy, sx, dy, dx; // T: Number of test cases, sy, sx: Start coordinates, dy, dx: Destination
								// coordinates

		T = Integer.parseInt(br.readLine()); // Read the number of test cases (테스트 케이스 수 읽기)

		while (T > 0) {
			T--; // Decrement test case counter (테스트 케이스 카운터 감소)
			l = Integer.parseInt(br.readLine()); // Read the size of the chessboard (체스판의 크기 읽기)
			board = new int[l][l]; // Initialize the chessboard (체스판 초기화)
			for (int i = 0; i < l; i++) {
				Arrays.fill(board[i], -1); // Fill the chessboard with -1 (체스판을 -1로 채우기)
			}
			String inp[] = br.readLine().split(" "); // Read start coordinates (시작 좌표 읽기)
			sy = Integer.parseInt(inp[0]);
			sx = Integer.parseInt(inp[1]);
			board[sy][sx] = 0; // Mark the start position (시작 위치 표시)
			inp = br.readLine().split(" "); // Read destination coordinates (목적지 좌표 읽기)
			dy = Integer.parseInt(inp[0]);
			dx = Integer.parseInt(inp[1]);

			bw.write(bfs(sy, sx, dy, dx) + "\n"); // Write the minimum number of moves (최소 이동 횟수 작성)
		}
		bw.flush(); // Flush the BufferedWriter (BufferedWriter 플러시)
		bw.close(); // Close the BufferedWriter (BufferedWriter 닫기)
	}
}
