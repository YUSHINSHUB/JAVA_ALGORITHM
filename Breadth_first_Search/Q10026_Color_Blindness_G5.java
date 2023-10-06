package Breadth_first_Search;

/*
commented by ChatGPT
This Java code simulates a color blindness check. It reads an n x n matrix of RGB colors and determines the number of color regions for both normal and color blind people. 
In the case of color blindness, 'R' (red) and 'G' (green) are considered as indistinguishable.

�� Java �ڵ�� ���� �˻縦 �ùķ��̼��մϴ�. RGB ������ n x n ����� �о�鿩 �Ϲ��ΰ� ������ ��ο� ���� ���� ������ ���� �����մϴ�. 
������ ��� 'R'(����)�� 'G'(���)�� ������ �� ���ٰ� ���ֵ˴ϴ�.
*/

import java.io.*;
import java.util.*;

public class Q10026_Color_Blindness_G5 {

	static int n;
	static char rgb[][];
	static int nres = 0;
	static int yres = 0;
	static Queue<Integer> yq = new LinkedList<>();
	static Queue<Integer> xq = new LinkedList<>();
	static int ypos[] = { 1, -1, -1, 1, }; // ���⼺�� ���� y ��ǥ (Directional y coordinates)
	static int xpos[] = { 0, 1, -1, -1, }; // ���⼺�� ���� x ��ǥ (Directional x coordinates)

// BFS ������� ���� ���� ������ ã�� �Լ� (Function to find the same color region using BFS method)
	static void bfs() {

		// yrgb ����� ������ �ùķ��̼��ϱ� ���� ����Դϴ�. (yrgb matrix is for simulating color
		// blindness)
		char yrgb[][] = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				yrgb[i][j] = rgb[i][j];
		}

		// �Ϲ� ����鿡 ���� ���� ���� ���� ã�� (Finding the same color region for normal people)
		while (true) {

			char chk = ' '; // ���� Ȯ������ ���� (Current color being checked)

			// �湮���� ���� ���� ���� ã�� (Find unvisited color region)
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

			// ��� ���� ������ Ȯ�������� ���� (Exit if all color regions are checked)
			if (chk == ' ')
				break;

			nres++; // ���� �� ���� (Increase the region count)

			// ���� ���� ������ ���� BFS ���� (Perform BFS for the current color region)
			while (!yq.isEmpty()) {

				int y = yq.poll();
				int x = xq.poll();

				// ��� ���⿡ ���� Ȯ�� (Check for all directions)
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

		// ���� ����鿡 ���� ���� ���� ���� ã�� (Finding the same color region for color blind people)
		while (true) {

			char chk = ' '; // ���� Ȯ������ ���� (Current color being checked)

			// �湮���� ���� ���� ���� ã�� (Find unvisited color region)
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

			// ��� ���� ������ Ȯ�������� ���� (Exit if all color regions are checked)
			if (chk == ' ')
				break;

			yres++; // ���� �� ���� (Increase the region count)

			// ���� ���� ������ ���� BFS ���� (Perform BFS for the current color region)
			while (!yq.isEmpty()) {

				int y = yq.poll();
				int x = xq.poll();

				// ��� ���⿡ ���� Ȯ�� (Check for all directions)
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

		// ����ڷκ��� n x n ��� �Է� �ޱ� (Receive the n x n matrix input from the user)
		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < n; j++) {
				rgb[i][j] = temp.charAt(j);
			}
		}

		// BFS ������� ���� ���� ã�� (Find color regions using BFS method)
		bfs();

		// ��� ��� (Output the results)
		bw.write(nres + " " + yres);
		bw.flush();
		bw.close();
	}
}