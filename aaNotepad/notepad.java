package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {

	static int R, C, T;
	static int grid[][];
	static int temp[][];
	static int up = -1;
	static int down = -1;
	static int ny[] = { 1, -1, 0, -1 };
	static int nx[] = { 0, -1, 2, -1 };

	static void diffusion() {

		for (int i = 0; i < R; i++)
			Arrays.fill(temp[i], 0);
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (grid[i][j] >= 5) {
					int y = i;
					int x = j;
					for (int k = 0; k < 4; k++) {
						y += ny[k];
						x += nx[k];
						if (y < 0 || x < 0 || y >= R || x >= C)
							continue;
						else if (grid[y][x] == -1)
							continue;
						temp[y][x] += grid[i][j] / 5;
						temp[i][j] -= grid[i][j] / 5;
					}
				}
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				grid[i][j] += temp[i][j];
			}
		}

	}

	static void circ_up() {
		for (int i = 0; i < R; i++)
			Arrays.fill(temp[i], 0);

		for (int i = 2; i < C; i++) {
			temp[up][i] = grid[up][i - 1];
		}

		for (int i = up - 1; i >= 0; i--) {
			temp[i][C - 1] = grid[i + 1][C - 1];
		}

		for (int i = C - 2; i >= 0; i--) {
			temp[0][i] = grid[0][i + 1];
		}

		for (int i = 1; i < up; i++) {
			temp[i][0] = grid[i - 1][0];
		}

		temp[up][0] = -1;

		for( int i = 0 ; i < C ; i++ ) {
			grid[0][i] = temp[0][i];
			grid[up][i] = temp[up][i];
		}
		
		for( int i = 0 ; i <= up ; i++ ) {
			grid[i][0] = temp[i][0];
			grid[i][C-1] = temp[i][C-1];
		}

	}

	static void circ_down() {
		for (int i = 0; i < R; i++)
			Arrays.fill(temp[i], 0);

		for (int i = 2; i < C; i++) {
			temp[down][i] = grid[down][i - 1];
		}

		for (int i = down + 1; i < R; i++) {
			temp[i][C - 1] = grid[i - 1][C - 1];
		}

		for (int i = C - 2; i >= 0; i--) {
			temp[R - 1][i] = grid[R - 1][i + 1];
		}

		for (int i = R - 2; i > down; i--) {
			temp[i][0] = grid[i + 1][0];
		}

		temp[down][0] = -1;
		
		for( int i = 0 ; i < C ; i++ ) {
			grid[R-1][i] = temp[R-1][i];
			grid[down][i] = temp[down][i];
		}
		
		for( int i = down ; i < R ; i++ ) {
			grid[i][0] = temp[i][0];
			grid[i][C-1] = temp[i][C-1];
		}

	}

	static int execute() {

		int res = 0;

		for (int i = 0; i < T; i++) {
			diffusion();
			circ_up();
			circ_down();
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (grid[i][j] > 0)
					res += grid[i][j];
			}
		}

		return res;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		R = Integer.parseInt(inp[0]);
		C = Integer.parseInt(inp[1]);
		T = Integer.parseInt(inp[2]);
		grid = new int[R][C];
		temp = new int[R][C];

		for (int i = 0; i < R; i++) {
			inp = br.readLine().split(" ");
			for (int j = 0; j < C; j++) {
				grid[i][j] = Integer.parseInt(inp[j]);
				if (grid[i][j] == -1 && up == -1)
					up = i;
				else if (grid[i][j] == -1)
					down = i;
			}
		}

		bw.write(execute() + "");
		bw.flush();
		bw.close();

	}

}
