package Graph_Theory;

/*
commented by ChatGPT
This Java code simulates a color blindness check. It reads an n x n matrix of RGB colors and determines the number of color regions for both normal and color blind people. In the case of color blindness, 'R' (red) and 'G' (green) are considered as indistinguishable.

이 Java 코드는 색맹 검사를 시뮬레이션합니다. RGB 색상의 n x n 행렬을 읽어들여 일반인과 색맹인 모두에 대한 색상 영역의 수를 결정합니다. 색맹의 경우 'R'(빨강)과 'G'(녹색)은 구별할 수 없다고 간주됩니다.
*/

import java.io.*;
import java.math.*;
import java.util.*;

public class Q10026_Blindness_G5 {

	static int n;
	static char rgb[][];
	static int nres = 0;
	static int yres = 0;
	static Queue<Integer> yq = new LinkedList<>();
	static Queue<Integer> xq = new LinkedList<>();
	static int ypos[] = { 1, -1, -1, 1, }; // 방향성을 가진 y 좌표 (Directional y coordinates)
	static int xpos[] = { 0, 1, -1, -1, }; // 방향성을 가진 x 좌표 (Directional x coordinates)

// BFS 방식으로 같은 색상 영역을 찾는 함수 (Function to find the same color region using BFS method)
	static void bfs() {

		// yrgb 행렬은 색맹을 시뮬레이션하기 위한 행렬입니다. (yrgb matrix is for simulating color
		// blindness)
		char yrgb[][] = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				yrgb[i][j] = rgb[i][j];
		}

		// 일반 사람들에 대한 같은 색상 영역 찾기 (Finding the same color region for normal people)
		while (true) {

			char chk = ' '; // 현재 확인중인 색상 (Current color being checked)

			// 방문하지 않은 색상 영역 찾기 (Find unvisited color region)
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (rgb[i][j] != 'C') {
						chk = rgb[i][j];
						rgb[i][j] = 'C';
						yq.add(i);
						xq.add(j);
						break;
					}
				}
				if (chk != ' ')
					break;
			}

			// 모든 색상 영역을 확인했으면 종료 (Exit if all color regions are checked)
			if (chk == ' ')
				break;

			nres++; // 영역 수 증가 (Increase the region count)

			// 현재 색상 영역에 대해 BFS 수행 (Perform BFS for the current color region)
			while (!yq.isEmpty()) {

				int y = yq.poll();
				int x = xq.poll();

				// 모든 방향에 대해 확인 (Check for all directions)
				for (int i = 0; i < 4; i++) {
					y += ypos[i];
					x += xpos[i];

					if (y < 0 || y >= n || x < 0 || x >= n)
						continue;

					if (rgb[y][x] == chk) {
						yq.add(y);
						xq.add(x);
						rgb[y][x] = 'C';
					}
				}
			}
		}

		// 색맹 사람들에 대한 같은 색상 영역 찾기 (Finding the same color region for color blind people)
		while (true) {

			char chk = ' '; // 현재 확인중인 색상 (Current color being checked)

			// 방문하지 않은 색상 영역 찾기 (Find unvisited color region)
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (yrgb[i][j] != 'C') {
						chk = yrgb[i][j];
						yrgb[i][j] = 'C';
						yq.add(i);
						xq.add(j);
						break;
					}
				}
				if (chk != ' ')
					break;
			}

			// 모든 색상 영역을 확인했으면 종료 (Exit if all color regions are checked)
			if (chk == ' ')
				break;

			yres++; // 영역 수 증가 (Increase the region count)

			// 현재 색상 영역에 대해 BFS 수행 (Perform BFS for the current color region)
			while (!yq.isEmpty()) {

				int y = yq.poll();
				int x = xq.poll();

				// 모든 방향에 대해 확인 (Check for all directions)
				for (int i = 0; i < 4; i++) {
					y += ypos[i];
					x += xpos[i];

					if (y < 0 || y >= n || x < 0 || x >= n)
						continue;

					if (yrgb[y][x] == chk || (yrgb[y][x] == 'R' && chk == 'G') || (yrgb[y][x] == 'G' && chk == 'R')) {
						yq.add(y);
						xq.add(x);
						yrgb[y][x] = 'C';
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		rgb = new char[n][n];

		// 사용자로부터 n x n 행렬 입력 받기 (Receive the n x n matrix input from the user)
		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < n; j++) {
				rgb[i][j] = temp.charAt(j);
			}
		}

		// BFS 방식으로 색상 영역 찾기 (Find color regions using BFS method)
		bfs();

		// 결과 출력 (Output the results)
		bw.write(nres + " " + yres);
		bw.flush();
		bw.close();
	}
}