package Graph_Traversal;

/*
commented by ChatGPT
This Java code implements a dynamic programming approach to solve the problem of finding the longest increasing path in a matrix. 
Each cell in the matrix has a value, and the path can only move to adjacent cells with a higher value. 
The solution uses memoization to store the length of the longest path starting from each cell, thereby avoiding redundant calculations.
이 Java 코드는 행렬에서 가장 긴 증가 경로를 찾는 문제를 해결하기 위한 동적 프로그래밍 접근법을 구현합니다. 
행렬의 각 셀에는 값이 있으며, 경로는 더 높은 값을 가진 인접 셀로만 이동할 수 있습니다. 
이 솔루션은 각 셀에서 시작하는 가장 긴 경로의 길이를 저장하는 메모이제이션을 사용하여 중복 계산을 방지합니다.
*/

import java.io.*;
import java.util.*;

public class Q1937_Panda_G3 {

	static int mem[][]; // 메모이제이션을 위한 2차원 배열
	static int grp[][]; // 행렬의 값을 저장하는 2차원 배열
	static int ny[] = { -1, 1, 0, 1 }; // y축 이동 벡터 (상, 하, 좌, 우)
	static int nx[] = { 0, -1, 2, -1 }; // x축 이동 벡터 (상, 하, 좌, 우)
	static int N; // 행렬의 크기

	static int dp(int y, int x) {
		// 이미 계산된 셀의 경우 저장된 값을 반환
		if (mem[y][x] >= 0)
			return mem[y][x];
		else {
			mem[y][x] = 1; // 기본 경로 길이는 1
			int cy = y;
			int cx = x;
			for (int i = 0; i < 4; i++) {
				cy += ny[i]; // 다음 y 좌표 계산
				cx += nx[i]; // 다음 x 좌표 계산

				// 행렬 경계 및 값 검사
				if (cx < 0 || cy < 0 || cx >= N || cy >= N)
					continue; // 경계를 벗어나면 이동하지 않음
				else if (grp[cy][cx] <= grp[y][x])
					continue; // 현재 셀보다 값이 작거나 같으면 이동하지 않음
				mem[y][x] = Math.max(mem[y][x], dp(cy, cx) + 1); // 재귀적으로 dp 호출 및 최대 경로 길이 갱신
			}

			return mem[y][x]; // 계산된 최대 경로 길이 반환
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine()); // 행렬 크기 입력
		int res = 0; // 최종 결과(최대 경로 길이)
		grp = new int[N][N]; // 행렬 초기화
		mem = new int[N][N]; // 메모이제이션 배열 초기화

		// 행렬 값 입력 및 메모이제이션 배열 초기화
		for (int i = 0; i < N; i++) {
			Arrays.fill(mem[i], -1);
			String inp[] = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				grp[i][j] = Integer.parseInt(inp[j]);
			}
		}

		// 모든 셀에 대해 dp 호출하여 최대 경로 길이 계산
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				res = Math.max(res, dp(i, j));
			}
		}

		bw.write(res + ""); // 결과 출력

		bw.flush();
		bw.close();
	}
}