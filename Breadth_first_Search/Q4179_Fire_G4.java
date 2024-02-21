package Breadth_first_Search;

/*
commented by ChatGPT
This Java code simulates a scenario where a character ('J') tries to escape a grid filled with obstacles ('#') and spreading fire ('F'). 
The grid is represented by a 2D array, and the simulation uses Breadth-First Search (BFS) to calculate the minimum number of moves needed for the escape. 
If an escape is impossible, it returns "IMPOSSIBLE". The program processes the character's and fire's movements separately within each BFS cycle to ensure accurate simulation of the scenario.
이 Java 코드는 장애물('#')과 확산되는 불('F')로 가득 찬 격자에서 캐릭터('J')가 탈출을 시도하는 시나리오를 시뮬레이션합니다.
2D 배열로 표현된 격자에서, 이 시뮬레이션은 BFS(너비 우선 검색)를 사용하여 탈출에 필요한 최소 이동 횟수를 계산합니다.
탈출이 불가능한 경우 "IMPOSSIBLE"을 반환합니다. 프로그램은 각 BFS 사이클 내에서 캐릭터와 불의 움직임을 별도로 처리하여 시나리오를 정확하게 시뮬레이션합니다.
*/

import java.io.*;
import java.util.*;
import java.math.*;

public class Q4179_Fire_G4 {

	static Queue<Integer> jy = new LinkedList<>(); // 캐릭터의 y좌표를 저장하는 큐
	static Queue<Integer> jx = new LinkedList<>(); // 캐릭터의 x좌표를 저장하는 큐
	static Queue<Integer> fy = new LinkedList<>(); // 불의 y좌표를 저장하는 큐
	static Queue<Integer> fx = new LinkedList<>(); // 불의 x좌표를 저장하는 큐
	static int ny[] = { 1, 0, 0, -1 }; // y좌표 이동 방향
	static int nx[] = { 0, -1, 1, 0 }; // x좌표 이동 방향
	static int R, C; // 격자의 행(R)과 열(C)
	static Boolean visited[][] = new Boolean[1000][1000]; // 방문 여부를 추적하는 배열
	static int grid[][] = new int[1000][1000]; // 격자의 상태를 저장하는 배열

	static int bfs() {

		while (!jy.isEmpty()) {
			int s = jy.size();
			for (int i = 0; i < s; i++) {

				int y = jy.poll();
				int x = jx.poll();
				if (grid[y][x] == -1) // 불이 있는 위치에 도달한 경우 무시
					continue;

				for (int j = 0; j < 4; j++) {
					int cy = y + ny[j];
					int cx = x + nx[j];
					if (cy >= R || cx >= C || cy < 0 || cx < 0) // 격자 밖으로 탈출하는 경우
						return grid[y][x] + 1;
					if (grid[cy][cx] == -1) // 다음 위치에 불이 있는 경우 무시
						continue;
					if (visited[cy][cx]) // 이미 방문한 위치인 경우 무시
						continue;
					jy.add(cy);
					jx.add(cx);
					grid[cy][cx] = grid[y][x] + 1;
					visited[cy][cx] = true;
				}
			}

			s = fy.size();

			for (int i = 0; i < s; i++) {
				int y = fy.poll();
				int x = fx.poll();
				for (int j = 0; j < 4; j++) {
					int cy = y + ny[j];
					int cx = x + nx[j];
					if (cy < 0 || cx < 0 || cy >= R || cx >= C) // 격자 밖인 경우 무시
						continue;
					if (grid[cy][cx] == -1) // 이미 불이 있는 위치인 경우 무시
						continue;
					fy.add(cy);
					fx.add(cx);
					grid[cy][cx] = -1; // 위치에 불 표시
				}
			}
		}

		return -1; // 탈출 불가능한 경우
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[];

		inp = br.readLine().split(" ");
		R = Integer.parseInt(inp[0]);
		C = Integer.parseInt(inp[1]);

		for (int i = 0; i < R; i++) {
			Arrays.fill(visited[i], false); // 방문 배열 초기화
			String in = br.readLine();
			for (int j = 0; j < C; j++) {
				grid[i][j] = 0; // 격자 초기화
				if (in.charAt(j) == '#')
					grid[i][j] = -1; // 장애물 표시
				else if (in.charAt(j) == 'J') { // 캐릭터 위치
					visited[i][j] = true;
					jy.add(i);
					jx.add(j);
				} else if (in.charAt(j) == 'F') { // 불 위치
					grid[i][j] = -1;
					fy.add(i);
					fx.add(j);
				}
			}
		}

		int res = bfs(); // BFS 실행
		if (res < 0)
			bw.write("IMPOSSIBLE");
		else
			bw.write(res + "");

		bw.flush();
		bw.close();
	}
}
