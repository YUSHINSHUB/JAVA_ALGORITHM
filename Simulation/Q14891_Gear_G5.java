package Simulation;

/*
commented by ChatGPT
This Java code simulates a series of gears interacting with each other, where each gear's state is represented by an ArrayList of integers. 
The gears can be rotated either clockwise or counterclockwise. 
The program reads rotation commands and applies them to the specified gear, considering the impact on adjacent gears. 
The final state of the gears is evaluated to calculate a score based on the position of the first element of each gear's ArrayList.
이 Java 코드는 각각의 기어 상태가 정수의 ArrayList로 표현되는 일련의 기어들의 상호작용을 시뮬레이션합니다. 
기어는 시계 방향이나 반시계 방향으로 회전할 수 있습니다. 
프로그램은 회전 명령을 읽고 지정된 기어에 적용하며, 인접한 기어에 미치는 영향을 고려합니다. 
기어의 최종 상태는 각 기어의 ArrayList의 첫 번째 요소의 위치에 따라 점수를 계산하여 평가됩니다.
*/

import java.io.*;
import java.util.*;

public class Q14891_Gear_G5 {
	static ArrayList<Integer> d[] = new ArrayList[4]; // 기어의 상태를 나타내는 ArrayList 배열

// 시계 방향으로 기어를 회전시키는 함수
	static void clo(int gear) {
		for (int i = 0; i < 7; i++) {
			d[gear].add(d[gear].get(0)); // 첫 번째 요소를 마지막에 추가
			d[gear].remove(0); // 첫 번째 요소 제거
		}
	}

// 반시계 방향으로 기어를 회전시키는 함수
	static void rev(int gear) {
		for (int i = 0; i < 7; i++) {
			d[gear].add(0, d[gear].get(d[gear].size() - 1)); // 마지막 요소를 첫 번째에 추가
			d[gear].remove(d[gear].size() - 1); // 마지막 요소 제거
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int res = 0; // 최종 점수를 저장하는 변수
		int t1, t2, t3, t4, t5, t6; // 인접한 기어들의 치아 상태를 저장하는 변수들

		// 기어 상태 초기화 및 입력
		for (int i = 0; i < 4; i++) {
			d[i] = new ArrayList<>();
			String in = br.readLine();
			for (int j = 0; j < 8; j++)
				d[i].add(Integer.parseInt(in.charAt(j) + ""));
		}
		int K = Integer.parseInt(br.readLine()); // 회전 횟수 입력

		// 회전 명령 처리
		for (int cs = 0; cs < K; cs++) {
			String inp[] = br.readLine().split(" ");
			int a = Integer.parseInt(inp[0]); // 회전할 기어 번호
			int b = Integer.parseInt(inp[1]); // 회전 방향 (1: 시계 방향, -1: 반시계 방향)
			t1 = d[0].get(2);
			t2 = d[1].get(6);
			t3 = d[1].get(2);
			t4 = d[2].get(6);
			t5 = d[2].get(2);
			t6 = d[3].get(6);
			switch (a) {
			case 1: // 첫 번째 기어에 대한 처리
				if (b == 1) {
					clo(0);
					if (t1 != t2) {
						rev(1);
						if (t3 != t4) {
							clo(2);
							if (t5 != t6)
								rev(3);
						}
					}
				} else {
					rev(0);
					if (t1 != t2) {
						clo(1);
						if (t3 != t4) {
							rev(2);
							if (t5 != t6)
								clo(3);
						}
					}
				}
				break;
			case 2: // 두 번째 기어에 대한 처리
				if (b == 1) {
					clo(1);
					if (t2 != t1)
						rev(0);
					if (t3 != t4) {
						rev(2);
						if (t5 != t6)
							clo(3);
					}
				} else {
					rev(1);
					if (t2 != t1)
						clo(0);
					if (t3 != t4) {
						clo(2);
						if (t5 != t6)
							rev(3);
					}
				}
				break;
			case 3: // 세 번째 기어에 대한 처리
				if (b == 1) {
					clo(2);
					if (t4 != t3) {
						rev(1);
						if (t2 != t1)
							clo(0);
					}
					if (t5 != t6)
						rev(3);
				} else {
					rev(2);
					if (t4 != t3) {
						clo(1);
						if (t2 != t1)
							rev(0);
					}
					if (t5 != t6)
						clo(3);
				}
				break;
			case 4: // 네 번째 기어에 대한 처리
				if (b == 1) {
					clo(3);
					if (t6 != t5) {
						rev(2);
						if (t4 != t3) {
							clo(1);
							if (t2 != t1)
								rev(0);
						}
					}
				} else {
					rev(3);
					if (t6 != t5) {
						clo(2);
						if (t4 != t3) {
							rev(1);
							if (t2 != t1)
								clo(0);
						}
					}
				}
				break;
			}
		}

		// 최종 점수 계산
		if (d[0].get(0) == 1)
			res++;
		if (d[1].get(0) == 1)
			res += 2;
		if (d[2].get(0) == 1)
			res += 4;
		if (d[3].get(0) == 1)
			res += 8;

		bw.write(res + ""); // 최종 점수 출력
		bw.flush();
		bw.close();
	}
}