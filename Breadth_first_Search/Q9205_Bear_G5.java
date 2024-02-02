package Breadth_first_Search;

/*
commented by ChatGPT
This Java code is designed to solve a problem where a person must consume beer at specific distances to continue their journey. 
The goal is to determine whether the person can reach the final destination, given the constraint that they can only travel 1000 meters on a single beer. 
It employs Breadth-First Search (BFS) to explore all reachable points from the starting position, considering the distance constraint. 
If the final destination is reachable within the constraints, the output is "happy"; otherwise, it's "sad".
이 Java 코드는 특정 거리마다 맥주를 마셔야 하는 문제를 해결하기 위해 설계되었습니다. 
한 병의 맥주로 1000미터만 이동할 수 있는 제약 조건을 고려하여, 최종 목적지에 도달할 수 있는지를 결정하는 것이 목표입니다. 
너비 우선 탐색(BFS)을 사용하여 시작 위치에서부터 도달할 수 있는 모든 지점을 탐색하며, 거리 제약을 고려합니다. 
최종 목적지에 제약 조건 내에서 도달할 수 있으면 "happy"를, 그렇지 않으면 "sad"를 출력합니다.
*/

import java.io.*;
import java.util.*;

public class Q9205_Bear_G5 {

	static ArrayList<Integer> ylist = new ArrayList<>(); // Stores the y-coordinates of all points
	static ArrayList<Integer> xlist = new ArrayList<>(); // Stores the x-coordinates of all points
	static Boolean visited[]; // Tracks which points have been visited
	static int n; // Number of convenience stores plus the festival location

	// Performs Breadth-First Search to find if the destination is reachable
	static Boolean bfs(int y, int x) {
		Queue<Integer> yq = new LinkedList<>(); // Queue for y-coordinates
		Queue<Integer> xq = new LinkedList<>(); // Queue for x-coordinates
		yq.add(y); // Starting y-coordinate
		xq.add(x); // Starting x-coordinate

		// While there are points to explore
		while (!yq.isEmpty()) {
			int cy = yq.poll(); // Current y-coordinate
			int cx = xq.poll(); // Current x-coordinate

			// Explore all points
			for (int i = 0; i <= n; i++) {
				// Skip if already visited
				if (visited[i])
					continue;
				// Check if the point is within 1000 meters
				if ((Math.abs(cy - ylist.get(i)) + Math.abs(cx - xlist.get(i))) <= 1000) {
					visited[i] = true; // Mark as visited
					yq.add(ylist.get(i)); // Add y-coordinate to queue
					xq.add(xlist.get(i)); // Add x-coordinate to queue
				}
			}
		}

		// Return true if the festival location is reachable
		return visited[n];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t, y, x; // Number of test cases, starting y-coordinate, starting x-coordinate
		String inp[];

		t = Integer.parseInt(br.readLine()); // Read number of test cases

		// Process each test case
		for (int i = 0; i < t; i++) {
			ylist.clear(); // Clear previous data
			xlist.clear(); // Clear previous data
			n = Integer.parseInt(br.readLine()); // Number of points (convenience stores + festival)
			visited = new Boolean[n + 1]; // Initialize visited array
			Arrays.fill(visited, false); // Mark all points as unvisited
			inp = br.readLine().split(" "); // Read starting point
			y = Integer.parseInt(inp[0]); // Starting y-coordinate
			x = Integer.parseInt(inp[1]); // Starting x-coordinate

			// Read and store all points
			for (int j = 0; j <= n; j++) {
				inp = br.readLine().split(" ");
				ylist.add(Integer.parseInt(inp[0])); // Store y-coordinate
				xlist.add(Integer.parseInt(inp[1])); // Store x-coordinate
			}

			// Perform BFS and write the result
			if (bfs(y, x))
				bw.write("happy\n"); // Reachable
			else
				bw.write("sad\n"); // Not reachable
		}

		bw.flush();
		bw.close();
	}
}