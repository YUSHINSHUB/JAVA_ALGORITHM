package Breadth_first_Search;

/*
commented by ChatGPT
This Java code implements a Breadth-First Search (BFS) algorithm to solve a problem where each element in an array represents a stepping stone with a specific jumping distance. 
The algorithm finds the minimum number of jumps needed to reach from a start position 's' to an end position 'e' in the array. 
The BFS explores possible jumps from each position in both forward and backward directions based on the jumping distance at each stone.
이 Java 코드는 배열의 각 요소가 특정 점프 거리를 가진 디딤돌을 나타내는 문제를 해결하기 위해 너비 우선 탐색(BFS) 알고리즘을 구현합니다. 
알고리즘은 시작 위치 's'에서 배열의 끝 위치 'e'까지 도달하는 데 필요한 최소 점프 횟수를 찾습니다. 
BFS는 각 돌에서의 점프 거리에 기반하여 각 위치에서 앞쪽과 뒤쪽 방향으로 가능한 점프를 탐색합니다.
*/

import java.io.*;
import java.util.*;

public class Q1326_Stepping_Stones_S2 {

	static int stone[]; // Array to store the jump distance for each stone (각 돌의 점프 거리를 저장하는 배열)
	static int mem[]; // Array to store the minimum number of jumps to reach each stone (각 돌에 도달하는 데
						// 필요한 최소 점프 수를 저장하는 배열)

// Function to perform BFS and calculate the minimum number of jumps
	static int bfs(int N, int s, int e) {

		Queue<Integer> q = new LinkedList<>(); // Queue for BFS (BFS에 사용되는 큐)
		q.add(s); // Start BFS from the starting stone (시작 돌에서 BFS 시작)
		while (!q.isEmpty()) {
			int idx = q.poll(); // Current stone (현재 돌)
			// Forward jump (앞쪽 점프)
			for (int i = idx + stone[idx]; i <= N; i += stone[idx]) {
				if (mem[i] < 0) { // If the stone is not visited yet (돌이 아직 방문되지 않았다면)
					mem[i] = mem[idx] + 1; // Update the number of jumps (점프 수 업데이트)
					q.add(i); // Add the stone to the queue (큐에 돌 추가)
				}
			}

			// Backward jump (뒤쪽 점프)
			for (int i = idx - stone[idx]; i >= 1; i -= stone[idx]) {
				if (mem[i] < 0) { // If the stone is not visited yet (돌이 아직 방문되지 않았다면)
					mem[i] = mem[idx] + 1; // Update the number of jumps (점프 수 업데이트)
					q.add(i); // Add the stone to the queue (큐에 돌 추가)
				}
			}
		}

		return mem[e]; // Return the number of jumps to reach the end stone (끝 돌에 도달하는 데 필요한 점프 수 반환)
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N, s, e; // Variables for number of stones (N), start stone (s), and end stone (e)
		N = Integer.parseInt(br.readLine()); // Read the number of stones
		stone = new int[N + 1]; // Initialize the stone array
		mem = new int[N + 1]; // Initialize the memory array
		Arrays.fill(mem, -1); // Fill memory array with -1 (unvisited)
		String inp[] = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			stone[i] = Integer.parseInt(inp[i - 1]); // Fill the stone array with jump distances
		}
		inp = br.readLine().split(" ");
		s = Integer.parseInt(inp[0]); // Starting stone
		e = Integer.parseInt(inp[1]); // Ending stone
		mem[s] = 0; // Starting stone has 0 jumps

		bw.write(bfs(N, s, e) + ""); // Perform BFS and write the result
		bw.flush(); // Flush the BufferedWriter
		bw.close(); // Close the BufferedWriter

	}
}
