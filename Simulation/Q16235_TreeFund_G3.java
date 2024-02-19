package Simulation;

/*
commented by ChatGPT
This Java code simulates a forest growth cycle over a specified number of years. 
The simulation involves seeding, growing, and reproducing trees on a grid. 
Trees age and reproduce at specific intervals, and nutrients in each grid cell affect tree growth. 
The program calculates the total number of trees after a given number of years.
이 Java 코드는 지정된 연수 동안 숲의 성장 주기를 시뮬레이션합니다. 
이 시뮬레이션은 그리드에서 나무를 심고, 성장시키고, 번식시키는 과정을 포함합니다. 
나무는 특정 간격으로 나이를 먹고 번식하며, 각 그리드 셀의 영양분이 나무의 성장에 영향을 미칩니다. 
프로그램은 주어진 연수 후의 나무 총 수를 계산합니다.
*/

import java.io.*;
import java.util.*;

public class Q16235_TreeFund_G3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int ny[] = { -1, 0, 0, 1, 0, 1, 0, 0 }; // y축 이동 벡터 (상, 하, 좌, 우, 대각선)
		int nx[] = { -1, 1, 1, -2, 2, -2, 1, 1 }; // x축 이동 벡터 (상, 하, 좌, 우, 대각선)
		int res = 0; // 최종 결과(나무의 총 수)
		String inp[] = br.readLine().split(" ");

		int N = Integer.parseInt(inp[0]); // 그리드의 크기
		int M = Integer.parseInt(inp[1]); // 초기 나무 수
		int K = Integer.parseInt(inp[2]); // 시뮬레이션 연수

		int land[][] = new int[N + 1][N + 1]; // 각 셀의 영양분
		int A[][] = new int[N + 1][N + 1]; // 매년 추가되는 영양분
		Deque<Integer>[][] list = new LinkedList[N + 1][N + 1]; // 각 셀에 있는 나무의 나이를 저장하는 덱
		Queue<Integer> temp = new LinkedList<>(); // 임시 저장을 위한 큐

		// 초기화 과정
		for (int i = 1; i <= N; i++) {
			Arrays.fill(land[i], 5); // 모든 셀의 영양분을 5로 초기화
			for (int j = 1; j <= N; j++)
				list[i][j] = new LinkedList<>(); // 나무 나이 리스트 초기화
		}

		// 매년 추가되는 영양분 입력
		for (int i = 1; i <= N; i++) {
			inp = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(inp[j - 1]);
			}
		}

		// 초기 나무 정보 입력
		for (int i = 0; i < M; i++) {
			inp = br.readLine().split(" ");

			int x = Integer.parseInt(inp[0]);
			int y = Integer.parseInt(inp[1]);
			int age = Integer.parseInt(inp[2]);

			list[x][y].add(age); // 나무 나이 추가
		}

		// K년 동안 시뮬레이션 수행
		for (int year = 0; year < K; year++) {

			// 봄: 나무가 자라고, 영양분이 부족하면 죽음
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					if (!list[j][k].isEmpty()) {
						int addNutrient = 0;
						while (!list[j][k].isEmpty()) {
							int treeAge = list[j][k].poll();
							if (treeAge <= land[j][k]) {
								land[j][k] -= treeAge;
								temp.add(treeAge + 1); // 나무 나이 증가
							} else {
								addNutrient += treeAge / 2; // 죽은 나무가 영양분으로 변함
							}
						}
						while (!temp.isEmpty())
							list[j][k].addLast(temp.poll()); // 나이 증가한 나무를 다시 추가
						land[j][k] += addNutrient; // 영양분 추가
					}
				}
			}

			// 가을: 나무 번식
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					if (!list[j][k].isEmpty()) {
						while (!list[j][k].isEmpty()) {
							int treeAge = list[j][k].poll();
							temp.add(treeAge);
							if (treeAge % 5 == 0) { // 5의 배수 나이인 나무가 번식
								int ypos = j;
								int xpos = k;
								for (int m = 0; m < 8; m++) {
									ypos += ny[m];
									xpos += nx[m];
									if (ypos < 1 || ypos > N || xpos < 1 || xpos > N)
										continue;

									list[ypos][xpos].addFirst(1); // 새로운 나무 추가
								}
							}
						}
						while (!temp.isEmpty())
							list[j][k].add(temp.poll()); // 나무 나이 정보 복원
					}
				}
			}

			// 겨울: 영양분 추가
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					land[j][k] += A[j][k]; // 각 셀에 영양분 추가
				}
			}

		}

		// 나무의 총 수 계산
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				res += list[i][j].size();
			}
		}

		bw.write(res + ""); // 결과 출력

		bw.flush();
		bw.close();

	}
}