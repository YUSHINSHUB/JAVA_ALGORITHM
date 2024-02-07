package Breadth_first_Search;

/*
commented by ChatGPT
This Java code models a process that spreads over a grid, incrementing the value of certain cells and resetting others based on specific conditions. 
The grid represents a 2D space where each cell's value can increase or reset to simulate a spreading effect. 
The program reads the grid's dimensions and initial states from input, then performs breadth-first search (BFS) to spread the effect across the grid. 
After each BFS cycle, the grid's state is updated according to rules defined in the BFS method. 
The goal is to determine how many cycles are needed until no cell's value can increase further.
이 Java 코드는 특정 조건에 따라 특정 셀의 값을 증가시키고 다른 셀을 리셋하는 그리드 상의 과정을 모델링합니다. 
그리드는 2D 공간을 나타내며, 각 셀의 값은 퍼져나가는 효과를 시뮬레이션하기 위해 증가하거나 리셋될 수 있습니다. 
프로그램은 입력에서 그리드의 차원과 초기 상태를 읽은 다음, 너비 우선 탐색(BFS)을 수행하여 그리드 전체에 효과를 퍼뜨립니다. 
BFS 사이클마다 그리드의 상태는 BFS 메소드에서 정의된 규칙에 따라 업데이트됩니다. 목표는 더 이상 셀의 값이 증가할 수 없을 때까지 필요한 사이클 수를 결정하는 것입니다.
*/

import java.io.*;
import java.util.*;
import java.math.*;

public class Q2638_Cheese_G3 {

	static int N, M; // N: 그리드의 세로 크기, M: 그리드의 가로 크기
	static int grid[][] = new int[100][100]; // 그리드의 상태를 저장하는 2차원 배열
	static int ny[] = { 1, 0, 0, -1 }; // y 이동 방향 (상, 좌, 우, 하)
	static int nx[] = { 0, -1, 1, 0 }; // x 이동 방향 (상, 좌, 우, 하)

	static void bfs() { // 너비 우선 탐색(BFS)을 수행하는 메소드

		Queue<Integer> yq = new LinkedList<>(); // y 좌표를 저장하는 큐
		Queue<Integer> xq = new LinkedList<>(); // x 좌표를 저장하는 큐
		Boolean visited[][] = new Boolean[100][100]; // 방문 여부를 체크하는 배열

		yq.add(0); // 시작점 추가
		xq.add(0); // 시작점 추가

		for (int i = 0; i < N; i++)
			Arrays.fill(visited[i], false); // 방문 배열 초기화

		while (!yq.isEmpty()) { // 큐가 비어있지 않은 동안

			int cy = yq.poll(); // 현재 y 좌표
			int cx = xq.poll(); // 현재 x 좌표

			for (int i = 0; i < 4; i++) { // 4방향 탐색
				int y = cy + ny[i]; // 다음 y 좌표
				int x = cx + nx[i]; // 다음 x 좌표
				if (y < 0 || x < 0 || y >= N || x >= M) // 그리드 범위를 벗어나면 스킵
					continue;
				if (visited[y][x]) // 이미 방문한 셀이면 스킵
					continue;
				if (grid[y][x] > 0) { // 해당 셀의 값이 0보다 크면 값 증가
					grid[y][x]++;
					continue;
				}
				visited[y][x] = true; // 방문 표시
				yq.add(y); // 다음 위치 큐에 추가
				xq.add(x); // 다음 위치 큐에 추가
			}

		}

		for (int i = 0; i < N; i++) { // 그리드 상태 업데이트
			for (int j = 0; j < M; j++) {
				if (grid[i][j] > 2) // 값이 2보다 크면 0으로 리셋
					grid[i][j] = 0;
				else if (grid[i][j] == 2) // 값이 2이면 1로 설정
					grid[i][j] = 1;
			}
		}

	}

	static Boolean check() { // 모든 셀의 값이 0인지 확인하는 메소드
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (grid[i][j] > 0) // 셀의 값이 0보다 크면 false 반환
					return false;
			}
		}
		return true; // 모든 셀의 값이 0이면 true 반환
	}

	public static void main(String[] args) throws IOException { // 메인 메소드

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int res = 0; // 결과값 저장 변수 (필요한 사이클 수)
		String inp[];

		inp = br.readLine().split(" "); // 입력 받기 (N, M)
		N = Integer.parseInt(inp[0]); // N 할당
		M = Integer.parseInt(inp[1]); // M 할당

		for (int i = 0; i < N; i++) { // 그리드 상태 입력 받기
			inp = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(inp[j]); // 그리드 상태 할당
			}
		}

		while (true) { // 종료 조건까지 반복
			if (check()) // 모든 셀의 값이 0이면 반복 종료
				break;
			res++; // 사이클 수 증가
			bfs(); // BFS 수행
		}

		bw.write(res + ""); // 결과 출력
		bw.flush();
		bw.close();
	}
}
