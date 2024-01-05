package Simulation;

/*
commented by ChatGPT
This Java code simulates an air purification system in a room represented by a 2D grid. 
The grid contains particles, two air purifiers (marked as -1), and empty spaces. 
The program executes a series of steps to purify the air: diffusion of particles, upward circulation of air through the first purifier, and downward circulation through the second. 
The diffusion process follows specific rules to spread particles into adjacent cells. 
The circulation functions move the air along predefined paths, ensuring that particles are filtered by the purifiers. 
The program calculates and returns the total number of particles remaining after a specified number of cycles.

이 Java 코드는 2D 그리드로 표현된 방에서 공기 정화 시스템을 시뮬레이션합니다. 
그리드에는 입자, 두 개의 공기 정화기(값이 -1로 표시됨), 그리고 빈 공간이 포함됩니다. 
이 프로그램은 공기를 정화하기 위한 일련의 단계를 실행합니다: 입자의 확산, 첫 번째 정화기를 통한 공기의 상향 순환, 그리고 두 번째 정화기를 통한 하향 순환입니다. 
확산 과정은 특정 규칙을 따라 인접한 셀로 입자를 퍼뜨립니다. 순환 함수는 정화기를 통해 입자가 걸러지도록 공기를 미리 정의된 경로로 이동시킵니다. 
이 프로그램은 지정된 사이클 수 후 남아 있는 입자의 총 개수를 계산하여 반환합니다.
*/

import java.io.*;
import java.util.*;

public class Q17144_Dust_G4 {

	static int R, C, T; // Room dimensions (R x C) and number of cycles (T)
	static int grid[][]; // 2D grid representing the room
	static int temp[][]; // Temporary grid for processing
	static int up = -1; // Row index of the upper air purifier
	static int down = -1; // Row index of the lower air purifier
	static int ny[] = { 1, -1, 0, -1 }; // Y-axis movement for diffusion
	static int nx[] = { 0, -1, 2, -1 }; // X-axis movement for diffusion

// Function to simulate the diffusion of particles
	static void diffusion() {
		for (int i = 0; i < R; i++)
			Arrays.fill(temp[i], 0); // Reset temporary grid
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (grid[i][j] >= 5) { // Only cells with 5 or more particles diffuse
					int y = i;
					int x = j;
					for (int k = 0; k < 4; k++) { // Spread to adjacent cells
						y += ny[k];
						x += nx[k];
						if (y < 0 || x < 0 || y >= R || x >= C)
							continue; // Skip invalid cells
						else if (grid[y][x] == -1)
							continue; // Skip air purifier cells
						temp[y][x] += grid[i][j] / 5; // Add particles to adjacent cell
						temp[i][j] -= grid[i][j] / 5; // Remove particles from original cell
					}
				}
			}
		}
		// Update grid with diffusion results
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				grid[i][j] += temp[i][j];
			}
		}
	}

// Function to simulate air circulation through the upper air purifier
	static void circ_up() {
		for (int i = 0; i < R; i++)
			Arrays.fill(temp[i], 0); // Reset temporary grid

		// Move air along the predefined path
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
		temp[up][0] = -1; // Preserve air purifier

		// Update grid with circulation results
		for (int i = 0; i < C; i++) {
			grid[0][i] = temp[0][i];
			grid[up][i] = temp[up][i];
		}
		for (int i = 0; i <= up; i++) {
			grid[i][0] = temp[i][0];
			grid[i][C - 1] = temp[i][C - 1];
		}
	}

// Function to simulate air circulation through the lower air purifier
	static void circ_down() {
		for (int i = 0; i < R; i++)
			Arrays.fill(temp[i], 0); // Reset temporary grid

		// Move air along the predefined path
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
		temp[down][0] = -1; // Preserve air purifier

		// Update grid with circulation results
		for (int i = 0; i < C; i++) {
			grid[R - 1][i] = temp[R - 1][i];
			grid[down][i] = temp[down][i];
		}
		for (int i = down; i < R; i++) {
			grid[i][0] = temp[i][0];
			grid[i][C - 1] = temp[i][C - 1];
		}
	}

// Function to execute the air purification process
	static int execute() {
		int res = 0; // Resultant total particles
		for (int i = 0; i < T; i++) {
			diffusion(); // Diffuse particles
			circ_up(); // Circulate air upward
			circ_down(); // Circulate air downward
		}
		// Calculate remaining particles
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (grid[i][j] > 0)
					res += grid[i][j];
			}
		}
		return res; // Return total particles
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read room dimensions and cycles
		String inp[] = br.readLine().split(" ");
		R = Integer.parseInt(inp[0]);
		C = Integer.parseInt(inp[1]);
		T = Integer.parseInt(inp[2]);
		grid = new int[R][C]; // Initialize grid
		temp = new int[R][C]; // Initialize temporary grid

		// Read grid and find air purifiers
		for (int i = 0; i < R; i++) {
			inp = br.readLine().split(" ");
			for (int j = 0; j < C; j++) {
				grid[i][j] = Integer.parseInt(inp[j]);
				if (grid[i][j] == -1 && up == -1)
					up = i; // Upper purifier
				else if (grid[i][j] == -1)
					down = i; // Lower purifier
			}
		}

		// Execute purification and write result
		bw.write(execute() + "");
		bw.flush();
		bw.close();
	}
}