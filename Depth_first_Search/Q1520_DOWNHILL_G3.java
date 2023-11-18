package Depth_first_Search;

/*
commented by ChatGPT
This Java code implements a Depth-First Search (DFS) algorithm to find the number of paths from the top-left corner to the bottom-right corner in a grid. 
Each cell in the grid has a value, and a path can only continue to a cell with a lower value. 
The code uses memoization to avoid recalculating paths for previously visited cells.
이 Java 코드는 그리드에서 왼쪽 상단 모서리에서 오른쪽 하단 모서리로 가는 경로의 수를 찾기 위해 깊이 우선 탐색(DFS) 알고리즘을 구현합니다. 
그리드의 각 셀에는 값이 있으며, 경로는 더 낮은 값을 가진 셀로만 계속될 수 있습니다. 
코드는 이전에 방문한 셀에 대한 경로를 다시 계산하지 않기 위해 메모이제이션을 사용합니다.
*/

import java.io.*;
import java.util.*;

public class Q1520_DOWNHILL_G3 {

	static int M, N; // 그리드의 행과 열 크기
	static int grp[][]; // 그리드의 각 셀 값을 저장하는 2차원 배열
	static int ny[] = { -1, 1, 0, 1 }; // y축 이동 벡터 (상, 하, 좌, 우)
	static int nx[] = { 0, -1, 2, -1 }; // x축 이동 벡터 (상, 하, 좌, 우)
	static int visited[][]; // 방문 여부 및 경로 수를 저장하는 2차원 배열
	static int res = 0; // 최종 결과(경로의 수)

	static int dfs(int y, int x) {
		// 이미 방문한 셀인 경우 저장된 경로 수 반환
		if (visited[y][x] != -1)
			return visited[y][x];
		else
			visited[y][x] = 0; // 초기 방문의 경우 경로 수를 0으로 설정

		int oy = y;
		int ox = x;
		for (int i = 0; i < 4; i++) {
			oy += ny[i]; // 다음 y 좌표 계산
			ox += nx[i]; // 다음 x 좌표 계산

			// 그리드 경계 및 값 검사
			if (oy < 0 || ox < 0 || oy >= M || ox >= N)
				continue; // 경계를 벗어나면 이동하지 않음
			else if (grp[oy][ox] >= grp[y][x])
				continue; // 현재 셀보다 값이 크거나 같으면 이동하지 않음
			else
				visited[y][x] += dfs(oy, ox); // 재귀적으로 DFS 수행 및 경로 수 추가
		}

		return visited[y][x]; // 계산된 경로 수 반환
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		M = Integer.parseInt(inp[0]); // 행 크기 입력
		N = Integer.parseInt(inp[1]); // 열 크기 입력

		grp = new int[M][N]; // 그리드 초기화
		visited = new int[M][N]; // 방문 배열 초기화

		// 그리드 값 입력 및 방문 배열 초기화
		for (int i = 0; i < M; i++) {
			Arrays.fill(visited[i], -1);
			inp = br.readLine().split(" ");
			for (int j = 0; j < N; j++)
				grp[i][j] = Integer.parseInt(inp[j]);
		}

		visited[M - 1][N - 1] = 1; // 목적지에 도달한 경우의 경로 수는 1
		bw.write(dfs(0, 0) + ""); // DFS를 사용하여 경로의 수 계산 및 출력

		bw.flush();
		bw.close();
	}
}