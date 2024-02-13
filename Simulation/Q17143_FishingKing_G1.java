package Simulation;

/*
commented by ChatGPT
This Java code models a scenario where sharks with varying speeds, directions, and sizes move around a grid representing an ocean, with a fisherman capturing them over multiple rounds. 
Each round, the fisherman captures the closest shark in his current column, and the sharks move based on their attributes. 
Sharks change direction upon reaching the grid's boundaries and can eliminate each other based on size if they end up in the same cell, simulating a dynamic ecosystem. 
The program tracks the total size of captured sharks as the outcome. This simulation demonstrates complex interactions within a grid environment, utilizing object-oriented principles for managing the state and behavior of each shark and employing a hashmap for efficient tracking and updates.
이 Java 코드는 서로 다른 속도, 방향, 크기를 가진 상어들이 바다를 나타내는 격자에서 움직이며, 어부가 여러 라운드에 걸쳐 이들을 포획하는 시나리오를 모델링합니다. 
각 라운드마다, 어부는 현재 열에서 가장 가까운 상어를 포획하고, 상어들은 그들의 속성에 따라 움직입니다. 
상어들은 격자의 경계에 도달하면 방향을 바꾸고, 같은 셀에 도착하면 크기에 따라 서로를 제거할 수 있어, 동적인 생태계를 시뮬레이션합니다. 프로그램은 포획된 상어들의 총 크기를 결과로 추적합니다. 
이 시뮬레이션은 격자 환경 내에서 복잡한 상호작용을 보여주며, 각 상어의 상태와 행동을 관리하기 위한 객체 지향 원리를 사용하고, 효율적인 추적 및 업데이트를 위해 해시맵을 사용합니다.
*/

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.math.*;

public class Q17143_FishingKing_G1 {

	static int R, C, M; // R and C represent the dimensions of the grid, and M is the number of sharks.
	static int res = 0; // Accumulates the total size of captured sharks.
	static int grid[][] = new int[101][101]; // Represents the ocean grid, storing shark IDs.
	static Boolean visited[][] = new Boolean[101][101]; // Tracks whether a cell has been visited during the current
														// round.
	static HashMap<Integer, shark> hm = new HashMap<>(); // Maps shark IDs to shark objects for easy access and
															// manipulation.

	static class shark {
		int r, c; // Current position of the shark in the grid.
		int idx; // Unique identifier for each shark.
		int speed; // Speed of the shark, determining how many cells it moves per round.
		int dir; // Current direction of the shark's movement (1: up, 2: down, 3: right, 4:
					// left).
		int size; // Size of the shark, used to determine outcomes when sharks meet.

		shark(int idx, int r, int c, int speed, int dir, int size) {
			this.r = r;
			this.c = c;
			this.idx = idx;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}

		void move() { // Moves the shark according to its speed and direction.
			switch (dir) {
			case 1:
				r--;
				break; // Move up
			case 2:
				r++;
				break; // Move down
			case 3:
				c++;
				break; // Move right
			case 4:
				c--;
				break; // Move left
			}
		}

		void revdir() { // Reverses the shark's direction when it hits the grid boundary.
			switch (dir) {
			case 1:
				dir = 2;
				break; // Up to down
			case 2:
				dir = 1;
				break; // Down to up
			case 3:
				dir = 4;
				break; // Right to left
			case 4:
				dir = 3;
				break; // Left to right
			}
		}
	}

	static void sim() { // Simulates the movement of sharks and the fisherman's actions.
		Queue<Integer> rem = new LinkedList<>(); // Queue to track sharks that need to be removed from the hashmap.

		for (int i = 1; i <= C; i++) { // For each column, representing the fisherman's position.

			for (int j = 1; j <= R; j++)
				Arrays.fill(visited[j], false); // Reset visited flags for each round.

			for (int j = 1; j <= R; j++) { // Check for a shark to capture in the current column.
				if (grid[j][i] > 0) {
					res += hm.get(grid[j][i]).size; // Add size to total.
					hm.remove(grid[j][i]); // Remove captured shark.
					grid[j][i] = 0; // Clear cell.
					break; // Only capture the first shark encountered.
				}
			}

			for (Entry<Integer, shark> en : hm.entrySet()) { // Move remaining sharks.
				shark s = en.getValue();
				if (!visited[s.r][s.c])
					grid[s.r][s.c] = 0; // Clear cell if shark is moving from it.
				for (int j = 0; j < s.speed; j++) { // Move shark based on its speed.
					if ((s.dir == 1 && s.r == 1) || (s.dir == 2 && s.r == R) || (s.dir == 3 && s.c == C)
							|| (s.dir == 4 && s.c == 1))
						s.revdir(); // Reverse direction at grid edges.
					s.move(); // Move shark.
				}
				if (visited[s.r][s.c]) { // If cell is already occupied by another shark.
					shark s2 = hm.get(grid[s.r][s.c]);
					if (s2.size < s.size) { // If the current shark is larger.
						rem.add(s2.idx); // Mark smaller shark for removal.
						hm.put(s.idx, s); // Update cell with current shark.
						grid[s.r][s.c] = s.idx;
					} else {
						rem.add(s.idx); // Mark current shark for removal if smaller.
					}
				} else {
					visited[s.r][s.c] = true; // Mark cell as visited.
					hm.put(s.idx, s); // Update hashmap with shark's new position.
					grid[s.r][s.c] = s.idx; // Update grid with shark's new position.
				}
			}
			while (!rem.isEmpty())
				hm.remove(rem.poll()); // Remove marked sharks from the hashmap.
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[]; // To store split input strings.
		int r, c, s, d, z; // Temporary variables for shark attributes.

		inp = br.readLine().split(" ");
		R = Integer.parseInt(inp[0]); // Number of rows.
		C = Integer.parseInt(inp[1]); // Number of columns.
		M = Integer.parseInt(inp[2]); // Number of sharks.

		for (int i = 1; i <= R; i++)
			Arrays.fill(grid[i], 0); // Initialize grid.

		for (int i = 1; i <= M; i++) { // Read shark attributes and initialize sharks.
			inp = br.readLine().split(" ");
			r = Integer.parseInt(inp[0]);
			c = Integer.parseInt(inp[1]);
			s = Integer.parseInt(inp[2]);
			d = Integer.parseInt(inp[3]);
			z = Integer.parseInt(inp[4]);
			if (d <= 2) {
				s %= (R - 1) * 2;
			} else {
				s %= (C - 1) * 2;
			}
			hm.put(i, new shark(i, r, c, s, d, z)); // Create and store shark object.
			grid[r][c] = i; // Mark shark's initial position on the grid.
		}

		sim(); // Start simulation.

		bw.write(res + ""); // Write total size of captured sharks.
		bw.flush();
		bw.close();
	}
}
