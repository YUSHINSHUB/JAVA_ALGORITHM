package Simulation;

/*
commented by ChatGPT
This Java code is designed to create dragon curves on a grid. 
It uses a recursive approach to draw these fractal patterns, which are created by rotating and extending a line segment. 
The main goal of the code is to calculate the number of squares formed by the dragon curves. 
The program reads several inputs to generate different dragon curves on a grid, each with its own starting point, direction, and number of generations. 
After generating all the curves, the code counts the number of 1x1 squares formed by these curves.

이 Java 코드는 그리드 위에 용곡선을 생성하기 위해 설계되었습니다. 이 프로그램은 선분을 회전시키고 확장하여 프랙탈 패턴을 만드는 재귀적 접근 방식을 사용합니다. 
코드의 주요 목표는 용곡선으로 형성된 정사각형의 수를 계산하는 것입니다. 프로그램은 다양한 용곡선을 그리드에 생성하기 위해 여러 입력(시작점, 방향, 세대 수)을 읽습니다. 
모든 곡선을 생성한 후, 이 곡선들에 의해 형성된 1x1 정사각형의 수를 세는 코드입니다.
*/

import java.io.*;
import java.util.*;
import java.math.*;

public class Q15685_Curve_G3 {

	static Boolean grid[][] = new Boolean[101][101]; // 101x101 크기의 그리드를 나타내는 이차원 배열
	static ArrayList<Integer> full = new ArrayList<>(); // 용곡선의 전체 방향을 저장하는 배열
	static int gen; // 용곡선을 생성할 세대 수

// 용곡선을 생성하는 재귀 함수
	static void curve(int cur, int y, int x, ArrayList<Integer> dir) {

		if (cur > gen) // 현재 세대가 설정된 세대를 초과하면 재귀 종료
			return;

		ArrayList<Integer> next = new ArrayList<Integer>(); // 다음 세대의 방향을 저장할 배열

		for (int i = 0; i < dir.size(); i++) {
			full.add(dir.get(i)); // 현재 세대의 방향을 전체 배열에 추가
			switch (dir.get(i)) { // 방향에 따라 x, y 좌표를 업데이트
			case 0: // 오른쪽
				x++;
				break;
			case 1: // 위쪽
				y--;
				break;
			case 2: // 왼쪽
				x--;
				break;
			case 3: // 아래쪽
				y++;
				break;
			}
			grid[y][x] = true; // 해당 좌표를 true로 설정하여 곡선 표시
		}

		// 다음 세대의 방향을 계산
		for (int i = full.size() - 1; i >= 0; i--) {
			switch (full.get(i)) { // 현재 방향을 기준으로 다음 방향을 결정
			case 0: // 오른쪽에서 위쪽으로
				next.add(1);
				break;
			case 1: // 위쪽에서 왼쪽으로
				next.add(2);
				break;
			case 2: // 왼쪽에서 아래쪽으로
				next.add(3);
				break;
			case 3: // 아래쪽에서 오른쪽으로
				next.add(0);
				break;
			}
		}

		curve(cur + 1, y, x, next); // 다음 세대에 대한 재귀 호출
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int res = 0; // 결과를 저장할 변수 (정사각형의 수)
		int N, dir, y, x; // 용곡선의 수, 시작 방향, 시작 y 좌표, 시작 x 좌표
		String inp[];

		// 그리드 초기화
		for (int i = 0; i <= 100; i++) {
			Arrays.fill(grid[i], false);
		}
		N = Integer.parseInt(br.readLine()); // 용곡선의 수 입력
		for (int i = 0; i < N; i++) {
			full.clear(); // 각 용곡선에 대한 전체 방향 배열 초기화
			ArrayList<Integer> list = new ArrayList<>(); // 현재 세대의 방향을 저장할 배열
			inp = br.readLine().split(" ");
			x = Integer.parseInt(inp[0]);
			y = Integer.parseInt(inp[1]);
			dir = Integer.parseInt(inp[2]);
			gen = Integer.parseInt(inp[3]);
			grid[y][x] = true; // 시작점을 true로 설정
			list.add(dir); // 시작 방향 추가
			curve(0, y, x, list); // 용곡선 생성 함수 호출
		}

		// 정사각형의 수 계산
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (grid[i][j] && grid[i + 1][j] && grid[i][j + 1] && grid[i + 1][j + 1])
					res++; // 네 꼭지점 모두 true인 경우 정사각형 카운트
			}
		}

		bw.write(res + ""); // 결과 출력
		bw.flush();
		bw.close();
	}
}
