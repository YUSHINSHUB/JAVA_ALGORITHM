package Backtracking;
/*
commented by ChatGPT
This Java code simulates an optimization problem where surveillance cameras of different types are placed in a grid to minimize blind spots. Each camera type has a specific coverage pattern, and the goal is to find the optimal orientation for each camera to cover the maximum area. The code employs backtracking to explore different combinations and orientations of cameras and calculates the minimum number of grid spaces that remain uncovered (blind spots).
이 Java 코드는 서로 다른 종류의 감시 카메라들이 그리드 안에 배치되어 사각지대를 최소화하는 최적화 문제를 시뮬레이션합니다. 각 카메라 유형은 특정한 커버리지 패턴을 가지고 있으며, 최대 영역을 커버하기 위한 각 카메라의 최적 방향을 찾는 것이 목표입니다. 이 코드는 백트래킹을 사용하여 카메라들의 다양한 조합 및 방향을 탐색하고, 커버되지 않은 최소한의 그리드 공간(사각지대)을 계산합니다.
*/

import java.io.*;
import java.util.*;

public class Q15683_CCTV_G4 {
	static int N, M; // 그리드의 세로(N) 및 가로(M) 크기를 저장하는 변수
	static int res = 65; // 최소 사각지대 개수를 저장하는 변수, 초기값은 65로 설정
	static int grid[][]; // 그리드를 나타내는 2차원 배열
	static ArrayList<Integer> ylist = new ArrayList<>(); // 카메라의 y좌표를 저장하는 ArrayList
	static ArrayList<Integer> xlist = new ArrayList<>(); // 카메라의 x좌표를 저장하는 ArrayList

// 카메라가 위쪽 방향으로 감시할 때 감시 범위를 증가시키는 함수
	static void up(int yt, int xt) {
		for (int i = yt + 1; i < N; i++) {
			if (grid[i][xt] == 6) // 벽을 만나면 반복 중단
				break;
			else if (grid[i][xt] < 10) // 카메라 또는 벽이 아니면 계속 진행
				continue;
			grid[i][xt]++; // 감시 범위 내 칸의 값을 증가
		}
	}

// 카메라가 아래쪽 방향으로 감시할 때 감시 범위를 증가시키는 함수
	static void dp(int yt, int xt) {
		for (int i = yt - 1; i >= 0; i--) {
			if (grid[i][xt] == 6)
				break;
			else if (grid[i][xt] < 10)
				continue;
			grid[i][xt]++;
		}
	}

// 카메라가 왼쪽 방향으로 감시할 때 감시 범위를 증가시키는 함수
	static void lp(int yt, int xt) {
		for (int i = xt - 1; i >= 0; i--) {
			if (grid[yt][i] == 6)
				break;
			else if (grid[yt][i] < 10)
				continue;
			grid[yt][i]++;
		}
	}

// 카메라가 오른쪽 방향으로 감시할 때 감시 범위를 증가시키는 함수
	static void rp(int yt, int xt) {
		for (int i = xt + 1; i < M; i++) {
			if (grid[yt][i] == 6)
				break;
			else if (grid[yt][i] < 10)
				continue;
			grid[yt][i]++;
		}
	}

// 카메라가 위쪽 방향으로 감시 범위를 줄이는 함수
	static void um(int yt, int xt) {
		for (int i = yt + 1; i < N; i++) {
			if (grid[i][xt] == 6)
				break;
			else if (grid[i][xt] < 10)
				continue;
			grid[i][xt]--;
		}
	}

// 카메라가 아래쪽 방향으로 감시 범위를 줄이는 함수
	static void dm(int yt, int xt) {
		for (int i = yt - 1; i >= 0; i--) {
			if (grid[i][xt] == 6)
				break;
			else if (grid[i][xt] < 10)
				continue;
			grid[i][xt]--;
		}
	}

// 카메라가 왼쪽 방향으로 감시 범위를 줄이는 함수
	static void lm(int yt, int xt) {
		for (int i = xt - 1; i >= 0; i--) {
			if (grid[yt][i] == 6)
				break;
			else if (grid[yt][i] < 10)
				continue;
			grid[yt][i]--;
		}
	}

// 카메라가 오른쪽 방향으로 감시 범위를 줄이는 함수
	static void rm(int yt, int xt) {
		for (int i = xt + 1; i < M; i++) {
			if (grid[yt][i] == 6)
				break;
			else if (grid[yt][i] < 10)
				continue;
			grid[yt][i]--;
		}
	}

// 백트래킹을 통해 카메라의 모든 방향 조합을 시도하고 사각지대의 최소 개수를 찾는 함수
	static void bt(int idx) {
		if (idx == ylist.size()) { // 모든 카메라를 배치했을 경우
			int r = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (grid[i][j] == 10) // 사각지대 카운트
						r++;
				}
			}
			res = Math.min(res, r); // 최소 사각지대 개수 갱신
			return;
		} else {
			int yt = ylist.get(idx); // 현재 카메라의 y좌표
			int xt = xlist.get(idx); // 현재 카메라의 x좌표

			switch (grid[yt][xt]) {
			case 1: // 카메라 유형 1의 로직
				up(yt, xt);
				bt(idx + 1);
				um(yt, xt);
				dp(yt, xt);
				bt(idx + 1);
				dm(yt, xt);
				lp(yt, xt);
				bt(idx + 1);
				lm(yt, xt);
				rp(yt, xt);
				bt(idx + 1);
				rm(yt, xt);
				break;
			case 2: // 카메라 유형 2의 로직
				up(yt, xt);
				dp(yt, xt);
				bt(idx + 1);
				um(yt, xt);
				dm(yt, xt);
				lp(yt, xt);
				rp(yt, xt);
				bt(idx + 1);
				lm(yt, xt);
				rm(yt, xt);
				break;
			case 3: // 카메라 유형 3의 로직
				up(yt, xt);
				rp(yt, xt);
				bt(idx + 1);
				um(yt, xt);
				rm(yt, xt);
				rp(yt, xt);
				dp(yt, xt);
				bt(idx + 1);
				rm(yt, xt);
				dm(yt, xt);
				dp(yt, xt);
				lp(yt, xt);
				bt(idx + 1);
				dm(yt, xt);
				lm(yt, xt);
				up(yt, xt);
				lp(yt, xt);
				bt(idx + 1);
				um(yt, xt);
				lm(yt, xt);
				break;
			case 4: // 카메라 유형 4의 로직
				up(yt, xt);
				lp(yt, xt);
				rp(yt, xt);
				bt(idx + 1);
				um(yt, xt);
				lm(yt, xt);
				rm(yt, xt);
				rp(yt, xt);
				up(yt, xt);
				dp(yt, xt);
				bt(idx + 1);
				rm(yt, xt);
				um(yt, xt);
				dm(yt, xt);
				dp(yt, xt);
				lp(yt, xt);
				rp(yt, xt);
				bt(idx + 1);
				dm(yt, xt);
				lm(yt, xt);
				rm(yt, xt);
				lp(yt, xt);
				up(yt, xt);
				dp(yt, xt);
				bt(idx + 1);
				lm(yt, xt);
				um(yt, xt);
				dm(yt, xt);
				break;
			}
		}
	}

// 프로그램의 메인 함수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]); // 그리드의 세로 크기 입력
		M = Integer.parseInt(inp[1]); // 그리드의 가로 크기 입력
		grid = new int[N][M]; // 그리드 초기화

		// 그리드 상태 입력 및 카메라 위치 저장
		for (int i = 0; i < N; i++) {
			inp = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(inp[j]);
				if (grid[i][j] >= 1 && grid[i][j] <= 5) {
					ylist.add(i);
					xlist.add(j);
				} else if (grid[i][j] == 0)
					grid[i][j] = 10; // 빈 공간은 사각지대로 설정
			}
		}

		// 유형 5 카메라 처리: 모든 방향으로 감시
		for (int i = 0; i < ylist.size(); i++) {
			if (grid[ylist.get(i)][xlist.get(i)] == 5) {
				int yt = ylist.get(i);
				int xt = xlist.get(i);
				up(yt, xt);
				dp(yt, xt);
				lp(yt, xt);
				rp(yt, xt);
				ylist.remove(i);
				xlist.remove(i);
				i--;
			}
		}

		bt(0); // 백트래킹 시작
		bw.write(res + ""); // 결과 출력
		bw.flush();
		bw.close();
	}
}