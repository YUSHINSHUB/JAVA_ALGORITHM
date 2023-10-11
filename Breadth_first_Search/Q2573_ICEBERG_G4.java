package Breadth_first_Search;

/*
commented by ChatGPT
�� Java �ڵ�� 2D �迭�� ǥ���� ������ �־��� ��, ������ �� �� ���� �и��Ǵ����� ����մϴ�.
This Java code calculates the number of years it takes for a given iceberg, represented in a 2D array, to break apart.

Ű����: ���� (Keywords: Iceberg)
*/

import java.io.*;
import java.math.*;
import java.util.*;

public class Q2573_ICEBERG_G4 {

	static int idx = 0; // ������ �и��Ǳ������ �ð��� ����ϱ� ���� ���� (Variable to calculate the time taken for the
						// iceberg to break apart)
	static int n, m;
	static int sea[][]; // ������ ���� ���¸� �����ϴ� 2D �迭 (2D array to store the current state of the iceberg)
	static int by[] = { 1, -1, -1, 1 };
	static int bx[] = { 0, 1, -1, -1 };
	static boolean visited[][]; // �ش� ��ġ�� �湮�ߴ��� üũ�ϱ� ���� ���� (Variable to check if the given position was visited)

// ���� ������ �� ���� ����� �̷�����ִ��� Ȯ���ϴ� �Լ� (Function to check how many chunks the iceberg is currently made of)
	static int chk() {

		visited = new boolean[n][m];
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (sea[i][j] > 0 && !visited[i][j]) {
					dfs(i, j);
					cnt++;
				}
			}
		}

		return cnt;
	}

// DFS�� ����Ͽ� ������ ����� ã�� �Լ� (Function to find the chunks of the iceberg using DFS)
	static void dfs(int y, int x) {
		visited[y][x] = true;
		for (int i = 0; i < 4; i++) {
			y += by[i];
			x += bx[i];
			if (y < 0 || x < 0 || y >= n || x >= m)
				continue;
			if (sea[y][x] > 0 && !visited[y][x])
				dfs(y, x);
		}
	}

// BFS�� ����Ͽ� ���� �ֺ��� �ٴٿ� ���� ������ �󸶳� ����� ����ϴ� �Լ� (Function to calculate how much the iceberg melts due to the sea around it using BFS)
	static void bfs() {

		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (sea[i][j] == 0 && !visited[i][j]) {
					int y = i;
					int x = j;
					for (int k = 0; k < 4; k++) {
						y += by[k];
						x += bx[k];
						if (y < 0 || x < 0 || y >= n || x >= m)
							continue;
						else if (sea[y][x] > 0) {
							sea[y][x]--;
							visited[y][x] = true;
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// ����ڷκ��� ������ ũ��� ���¸� �Է¹޽��ϴ�.
		// Reads the size and state of the iceberg from the user.
		String inp[] = br.readLine().split(" ");
		n = Integer.parseInt(inp[0]);
		m = Integer.parseInt(inp[1]);
		sea = new int[n][m];

		for (int i = 0; i < n; i++) {
			inp = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				sea[i][j] = Integer.parseInt(inp[j]);
			}
		}

		// ������ �и��� ������ ������ ���¸� ������Ʈ�ϸ� �ð��� ����մϴ�.
		// Updates the state of the iceberg and calculates the time until the iceberg
		// breaks apart.
		while (true) {

			int chk = chk();

			if (chk == 0) {
				idx = 0;
				break;
			} else if (chk >= 2)
				break;

			idx++;
			bfs();
		}

		bw.write(idx + "");
		bw.flush();
		bw.close();
	}
}