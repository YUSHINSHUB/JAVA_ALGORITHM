package Breadth_first_Search;

/*
commented by ChatGPT
This Java code implements a Breadth-First Search (BFS) algorithm to solve a building navigation problem. 
Given a building with a certain number of floors (F), the task is to find the minimum number of button presses required to get from the start floor (S) to the goal floor (G) using an elevator that can move up (U) and down (D) a specific number of floors per press. 
If reaching the goal floor is impossible, the program outputs "use the stairs".
이 Java 코드는 건물 탐색 문제를 해결하기 위한 너비 우선 탐색(BFS) 알고리즘을 구현합니다. 
일정한 층 수(F)를 가진 건물에서 시작 층(S)에서 목표 층(G)까지 가는 데 필요한 최소 버튼 누름 횟수를 찾는 것이 과제입니다. 
이때 엘리베이터는 한 번에 특정 층수(U, D)만큼 위로 혹은 아래로 이동할 수 있습니다. 목표 층에 도달할 수 없는 경우 프로그램은 "use the stairs"를 출력합니다.
*/

import java.io.*;
import java.util.*;

public class Q5014_Startlink_S1 {

	static int floor[]; // Array to keep track of the number of button presses required to reach each
						// floor

// BFS function to calculate the number of button presses
	static void bfs(int F, int S, int U, int D) {

		Queue<Integer> q = new LinkedList<>(); // Queue for BFS
		q.add(S); // Start from the starting floor

		while (!q.isEmpty()) {
			int cur = q.poll(); // Current floor

			// If moving up is possible
			if (cur + U <= F && cur + U > 0 && U != 0) {
				int temp = cur + U; // Floor reached after moving up
				// If this floor is not visited yet
				if (floor[temp] == 0) {
					floor[temp] = floor[cur] + 1; // Update the number of button presses
					q.add(temp); // Add this floor to the queue
				}
			}

			// If moving down is possible
			if (cur - D <= F && cur - D > 0 && D != 0) {
				int temp = cur - D; // Floor reached after moving down
				// If this floor is not visited yet
				if (floor[temp] == 0) {
					floor[temp] = floor[cur] + 1; // Update the number of button presses
					q.add(temp); // Add this floor to the queue
				}
			}

		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int F, S, G, U, D; // Variables for the number of floors (F), start floor (S), goal floor (G), up
							// (U) and down (D) steps

		// Reading input
		String inp[] = br.readLine().split(" ");
		F = Integer.parseInt(inp[0]);
		S = Integer.parseInt(inp[1]);
		G = Integer.parseInt(inp[2]);
		U = Integer.parseInt(inp[3]);
		D = Integer.parseInt(inp[4]);
		floor = new int[F + 1]; // Initializing the array
		Arrays.fill(floor, 0); // Setting initial values to 0 (unvisited)

		bfs(F, S, U, D); // Start BFS

		// Outputting the result
		if (S == G)
			bw.write("0"); // If start floor is the goal floor
		else if (floor[G] > 0)
			bw.write(floor[G] + ""); // If goal floor is reachable
		else
			bw.write("use the stairs"); // If goal floor is not reachable
		bw.flush(); // Flush the BufferedWriter
		bw.close(); // Close the BufferedWriter

	}
}