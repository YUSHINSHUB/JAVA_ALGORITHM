package Breadth_first_Search;

/*
commented by ChatGPT
This Java code implements a BFS (Breadth-First Search) algorithm to solve a maze-like problem. 
The task is to find the minimum number of steps needed to reach the end of the array (maze) from the start, given that each element in the array represents the maximum jump length from that position. 
The code initializes a queue for the BFS process and an array 'mem' to keep track of the minimum steps required to reach each index. 
The BFS function explores all possible moves from the current position and updates 'mem' accordingly. 
If reaching the end of the array is impossible, the function will return -1.
이 Java 코드는 BFS (너비 우선 탐색) 알고리즘을 사용하여 미로와 같은 문제를 해결합니다. 
각 배열 요소가 해당 위치에서의 최대 점프 길이를 나타내는 배열(미로)의 시작 부분에서 끝까지 도달하는 데 필요한 최소 단계 수를 찾는 것이 과제입니다. 
코드는 BFS 프로세스를 위한 큐와 각 인덱스에 도달하는 데 필요한 최소 단계를 추적하기 위한 'mem' 배열을 초기화합니다. 
BFS 함수는 현재 위치에서 가능한 모든 움직임을 탐색하고 'mem'을 그에 따라 업데이트합니다. 
배열 끝에 도달하는 것이 불가능한 경우, 함수는 -1을 반환합니다.
*/

import java.io.*;
import java.util.*;

public class Q11060_Jump_Jump_S2 {

	static int N; // Size of the maze
	static int mem[]; // Array to store the minimum number of steps to reach each index
	static int maze[]; // Array representing the maze with maximum jump lengths

// Function to perform BFS and find the minimum number of steps
	static int bfs() {

		Queue<Integer> q = new LinkedList<>(); // Queue for BFS
		q.add(0); // Start from the first index
		mem[0] = 0; // Starting point has 0 steps

		while (!q.isEmpty()) {
			int idx = q.poll(); // Current index
			for (int i = idx; i <= idx + maze[idx]; i++) {
				if (i >= N) // If the index is beyond the maze, break the loop
					break;
				if (mem[i] < 0) { // If this index is not visited yet
					mem[i] = mem[idx] + 1; // Update the number of steps
					q.add(i); // Add this index to the queue
				}
			}
		}

		return mem[N - 1]; // Return the minimum number of steps to reach the end
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine()); // Read the size of the maze
		maze = new int[N]; // Initialize the maze array
		mem = new int[N]; // Initialize the memory array
		String inp[] = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			maze[i] = Integer.parseInt(inp[i]); // Fill the maze array
		}
		Arrays.fill(mem, -1); // Fill the memory array with -1 (unvisited)

		bw.write(bfs() + ""); // Write the result of the BFS function
		bw.flush(); // Flush the BufferedWriter
		bw.close(); // Close the BufferedWriter
	}
}
