package Breadth_first_Search;

/*
commented by ChatGPT
This Java code implements a grid-based simulation in which an entity moves and consumes items. 
The entity increases its size after consuming a certain number of items smaller than itself. 
A breadth-first search (BFS) is used to navigate the grid and find the nearest consumable item. 
The process is repeated until no consumable items remain, and the total distance traveled is calculated.
이 Java 코드는 그리드 기반의 시뮬레이션을 구현합니다. 
여기서 한 객체가 이동하며 크기가 작은 아이템을 소비합니다. 
객체는 일정 수의 아이템을 소비한 후 크기가 증가하며, 너비 우선 탐색(BFS)을 사용하여 그리드를 탐색하고 가장 가까운 소비 가능한 아이템을 찾습니다. 
소비 가능한 아이템이 없을 때까지 이 과정이 반복되며, 이동한 총 거리가 계산됩니다.
*/

import java.io.*;
import java.util.*;

public class Q16236_Baby_Shark_G3 {
	static int N; // 그리드의 크기를 저장하는 변수
	static int area[][]; // 그리드의 각 셀에 저장된 아이템을 나타내는 2차원 배열
	static int dist[][]; // BFS 알고리즘 실행 중 각 셀까지의 거리를 저장하는 2차원 배열
	static Queue<Integer> yq = new LinkedList<>(); // BFS 수행을 위한 y 좌표 큐
	static Queue<Integer> xq = new LinkedList<>(); // BFS 수행을 위한 x 좌표 큐
	static int ny[] = { -1, 1, 0, 1 }; // y축 이동을 위한 벡터 (상, 하, 좌, 우)
	static int nx[] = { 0, -1, 2, -1 }; // x축 이동을 위한 벡터 (상, 하, 좌, 우)
	static int cnt = 0; // 현재까지 소비한 아이템 수
	static int size = 2; // 현재 객체의 크기
	static int res = 0; // 총 이동 거리

	static void search() {
		int curd = 1000; // 현재까지 발견된 최단 거리
		int cury = 0; // 현재 목표 아이템의 y 좌표
		int curx = 0; // 현재 목표 아이템의 x 좌표

		while (!yq.isEmpty()) {
			int y = yq.poll(); // 현재 y 좌표
			int x = xq.poll(); // 현재 x 좌표

			int nexty = y; // 다음 이동할 y 좌표의 초기값 설정
			int nextx = x; // 다음 이동할 x 좌표의 초기값 설정

			for (int i = 0; i < 4; i++) {
				nexty += ny[i]; // 다음 이동할 y 좌표 계산
				nextx += nx[i]; // 다음 이동할 x 좌표 계산

				// 그리드 경계 검사
				if (nexty < 0 || nexty >= N || nextx < 0 || nextx >= N)
					continue; // 경계를 벗어나면 무시

				// 소비할 수 있는 아이템을 찾음
				if (area[nexty][nextx] < size && area[nexty][nextx] > 0) {
					dist[nexty][nextx] = dist[y][x] + 1; // 다음 셀까지의 거리 계산
					if (dist[nexty][nextx] < curd) {
						curd = dist[nexty][nextx]; // 최단 거리 업데이트
						cury = nexty; // 목표 y 좌표 업데이트
						curx = nextx; // 목표 x 좌표 업데이트
					} else if (dist[nexty][nextx] == curd && (cury > nexty || (cury == nexty && curx > nextx))) {
						cury = nexty; // 위쪽 또는 왼쪽에 있는 셀을 우선적으로 선택
						curx = nextx;
					}
				} else if ((area[nexty][nextx] == 0 || area[nexty][nextx] == size) && dist[nexty][nextx] == 0) {
					dist[nexty][nextx] = dist[y][x] + 1; // 이동 가능한 셀까지의 거리 계산
					yq.add(nexty); // 다음 이동할 y 좌표 큐에 추가
					xq.add(nextx); // 다음 이동할 x 좌표 큐에 추가
				}
			}

			// 목표 아이템을 찾고 소비한 후 처리
			if (yq.isEmpty() && curd < 1000) {
				area[cury][curx] = 0; // 목표 아이템 소비 처리
				cnt++; // 소비한 아이템 수 증가
				if (cnt == size) { // 크기 증가 조건 충족 시
					cnt = 0;
					size++; // 크기 증가
				}
				// BFS 초기화 및 재시작 준비
				yq.add(cury);
				xq.add(curx);
				res += curd; // 이동한 거리 누적
				for (int j = 0; j < N; j++)
					Arrays.fill(dist[j], 0); // 거리 배열 초기화
				curd = 1000; // 최단 거리 초기화
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine()); // 그리드 크기 입력 받음
		area = new int[N][N]; // 그리드 배열 초기화
		dist = new int[N][N]; // 거리 배열 초기화

		// 그리드 상태 입력 및 초기 위치 설정
		for (int i = 0; i < N; i++) {
			String inp[] = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				area[i][j] = Integer.parseInt(inp[j]);
				if (area[i][j] == 9) { // 시작 위치 발견 시
					yq.add(i); // 시작 y 좌표 큐에 추가
					xq.add(j); // 시작 x 좌표 큐에 추가
					area[i][j] = 0; // 시작 위치 초기화
				}
			}
		}

		search(); // BFS 탐색 및 처리 실행

		bw.write(res + ""); // 결과 출력
		bw.flush();
		bw.close();
	}
}
