package Simulation;

/*
commented by ChatGPT
This Java code simulates the rolling of a dice on a 2D grid. 
The dice is represented as an array where each index corresponds to a face of the dice. 
The grid, its dimensions, and the dice's movements are inputted by the user. 
When the dice rolls, its orientation changes, affecting the top and bottom values. 
If the dice lands on a cell with a non-zero value, that value moves to the bottom of the dice, and the cell becomes zero. 
Otherwise, the bottom of the dice is copied to the cell. The top value of the dice is printed after each move.
이 Java 코드는 2D 그리드 상에서 주사위를 굴리는 것을 시뮬레이션합니다. 
주사위는 각 인덱스가 주사위의 한 면에 해당하는 배열로 표현됩니다. 
그리드, 그것의 차원, 그리고 주사위의 움직임은 사용자에 의해 입력됩니다. 
주사위가 굴러갈 때, 그 방향이 바뀌며 상단과 하단의 값에 영향을 미칩니다. 
주사위가 0이 아닌 값을 가진 셀 위에 도착하면, 그 값은 주사위의 바닥으로 이동하고 셀은 0이 됩니다. 
그렇지 않으면 주사위의 바닥 값이 셀로 복사됩니다. 
각 이동 후 주사위의 상단 값이 출력됩니다.
*/

import java.io.*;
import java.util.*;

public class Q14499_Dice_G4 {
	static int dice[] = new int[7]; // 주사위의 각 면을 나타내는 배열

// 주사위를 북쪽으로 굴릴 때 주사위 면의 변화를 처리하는 함수
	static void mn() {
		int d1 = dice[1];
		int d3 = dice[3];
		int d5 = dice[5];
		int d6 = dice[6];

		dice[1] = d6; // 바닥면이 상단면이 됨
		dice[3] = d1; // 상단면이 앞면이 됨
		dice[5] = d3; // 앞면이 바닥면이 됨
		dice[6] = d5; // 뒷면이 상단면이 됨
	}

// 주사위를 남쪽으로 굴릴 때 주사위 면의 변화를 처리하는 함수
	static void ms() {
		int d1 = dice[1];
		int d3 = dice[3];
		int d5 = dice[5];
		int d6 = dice[6];

		dice[1] = d3; // 앞면이 상단면이 됨
		dice[3] = d5; // 뒷면이 앞면이 됨
		dice[5] = d6; // 바닥면이 뒷면이 됨
		dice[6] = d1; // 상단면이 바닥면이 됨
	}

// 주사위를 동쪽으로 굴릴 때 주사위 면의 변화를 처리하는 함수
	static void me() {
		int d2 = dice[2];
		int d3 = dice[3];
		int d4 = dice[4];
		int d6 = dice[6];

		dice[2] = d3; // 앞면이 오른쪽 면이 됨
		dice[3] = d4; // 오른쪽 면이 바닥면이 됨
		dice[4] = d6; // 바닥면이 왼쪽 면이 됨
		dice[6] = d2; // 왼쪽 면이 상단면이 됨
	}

// 주사위를 서쪽으로 굴릴 때 주사위 면의 변화를 처리하는 함수
	static void mw() {
		int d2 = dice[2];
		int d3 = dice[3];
		int d4 = dice[4];
		int d6 = dice[6];

		dice[2] = d6; // 바닥면이 오른쪽 면이 됨
		dice[3] = d2; // 왼쪽 면이 앞면이 됨
		dice[4] = d3; // 앞면이 왼쪽 면이 됨
		dice[6] = d4; // 오른쪽 면이 바닥면이 됨
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N, M, y, x, K; // 그리드의 크기와 주사위의 초기 위치, 명령의 수
		Arrays.fill(dice, 0); // 주사위 배열 초기화
		int grid[][]; // 그리드 배열

		// 그리드의 크기와 주사위의 초기 위치, 명령의 수 입력
		String inp[] = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]);
		M = Integer.parseInt(inp[1]);
		y = Integer.parseInt(inp[2]);
		x = Integer.parseInt(inp[3]);
		K = Integer.parseInt(inp[4]);
		grid = new int[N][M];

		// 그리드 상태 입력
		for (int i = 0; i < N; i++) {
			inp = br.readLine().split(" ");
			for (int j = 0; j < M; j++)
				grid[i][j] = Integer.parseInt(inp[j]);
		}

		// 명령 처리
		inp = br.readLine().split(" ");
		for (int cs = 0; cs < K; cs++) {
			switch (Integer.parseInt(inp[cs])) {
			case 1: // 동쪽으로 굴림
				if (x + 1 >= M)
					break; // 경계 체크
				x++;
				me();
				if (grid[y][x] == 0) {
					grid[y][x] = dice[6];
				} else {
					dice[6] = grid[y][x];
					grid[y][x] = 0;
				}
				bw.write(dice[3] + "\n");
				break;
			case 2: // 서쪽으로 굴림
				if (x - 1 < 0)
					break;
				x--;
				mw();
				if (grid[y][x] == 0) {
					grid[y][x] = dice[6];
				} else {
					dice[6] = grid[y][x];
					grid[y][x] = 0;
				}
				bw.write(dice[3] + "\n");
				break;
			case 3: // 북쪽으로 굴림
				if (y - 1 < 0)
					break;
				y--;
				mn();
				if (grid[y][x] == 0) {
					grid[y][x] = dice[6];
				} else {
					dice[6] = grid[y][x];
					grid[y][x] = 0;
				}
				bw.write(dice[3] + "\n");
				break;
			case 4: // 남쪽으로 굴림
				if (y + 1 >= N)
					break;
				y++;
				ms();
				if (grid[y][x] == 0) {
					grid[y][x] = dice[6];
				} else {
					dice[6] = grid[y][x];
					grid[y][x] = 0;
				}
				bw.write(dice[3] + "\n");
				break;
			}
		}

		bw.flush();
		bw.close();

	}
}