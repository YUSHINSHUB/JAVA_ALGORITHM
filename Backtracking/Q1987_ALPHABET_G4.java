package Backtracking;

/*
commented by ChatGPT
This Java code performs a Depth-First Search (DFS) on a grid to determine the maximum number of distinct characters a person can visit without revisiting any character. 
The person starts at the top-left corner and can move to four possible directions.
이 Java 코드는 그리드에서 깊이 우선 탐색(DFS)을 수행하여 한 사람이 문자를 재방문하지 않고 방문할 수 있는 고유 문자의 최대 수를 결정합니다. 
사람은 왼쪽 상단 모서리에서 시작하여 네 가지 가능한 방향으로 이동할 수 있습니다.
*/

import java.io.*;
import java.util.*;

public class Q1987_ALPHABET_G4 {

// 2D array to represent the grid
// 그리드를 나타내는 2D 배열
	static char[][] grp;

// 2D array to track visited cells during DFS
// DFS 동안 방문한 셀을 추적하기 위한 2D 배열
	static boolean visited[][];

// Boolean array to check if a character has been visited
// 문자가 방문되었는지 확인하기 위한 불리언 배열
	static boolean alp[] = new boolean[26];

// To store the result of maximum distinct characters
// 고유 문자의 최대 수를 저장하기 위한 변수
	static int res = 0;

// Arrays to help in moving to adjacent cells in the grid
// 그리드의 인접한 셀로 이동을 돕기 위한 배열
	static int yt[] = { 1, -1, -1, 1 };
	static int xt[] = { 0, 1, -1, -1 };

	static int R, C;

// Depth-First Search function
// 깊이 우선 탐색 함수
	static void bt(int y, int x, int cur) {

		// Mark the current cell as visited
		// 현재 셀을 방문했음으로 표시
		visited[y][x] = true;

		// Mark the character in the current cell as visited
		// 현재 셀의 문자를 방문했음으로 표시
		alp[grp[y][x] - 'A'] = true;
		cur++;
		res = Math.max(res, cur);

		for (int i = 0; i < 4; i++) {
			y += yt[i];
			x += xt[i];

			// Check for out-of-bounds or if cell/character is already visited
			// 경계를 벗어나거나 셀/문자가 이미 방문된 경우 확인
			if (y < 0 || y >= R || x < 0 || x >= C)
				continue;
			else if (visited[y][x] || alp[grp[y][x] - 'A'])
				continue;

			// Recursive DFS call for the next cell
			// 다음 셀에 대한 재귀 DFS 호출
			bt(y, x, cur);

			// Backtrack: Mark the cell and character as not visited
			// 백트래킹: 셀과 문자를 방문하지 않은 상태로 표시
			visited[y][x] = false;
			alp[grp[y][x] - 'A'] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Reading dimensions of the grid
		// 그리드의 차원 읽기
		String inp[] = br.readLine().split(" ");
		R = Integer.parseInt(inp[0]);
		C = Integer.parseInt(inp[1]);

		// Initialize arrays
		// 배열 초기화
		Arrays.fill(alp, false);
		visited = new boolean[R][C];
		grp = new char[R][C];

		// Reading the grid
		// 그리드 읽기
		for (int i = 0; i < R; i++) {
			String in = br.readLine();
			Arrays.fill(visited[i], false);
			for (int j = 0; j < C; j++) {
				grp[i][j] = in.charAt(j);
			}
		}

		// Starting DFS from the top-left corner
		// 왼쪽 상단 모서리에서 DFS 시작
		bt(0, 0, 0);

		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}