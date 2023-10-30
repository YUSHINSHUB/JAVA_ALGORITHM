package Geometry;

/*
commented by ChatGPT
This Java code simulates the grouping of circles based on their touching positions. 
The main objective is to determine the number of separate groups of touching circles.
이 Java 코드는 원들이 서로 닿는 위치를 기반으로 그룹화하는 시뮬레이션을 합니다. 
주요 목표는 서로 닿는 원들의 별도 그룹 수를 결정하는 것입니다.
*/

import java.io.*;
import java.math.*;
import java.util.*;

class circle {
	int x; // Circle's center x-coordinate (원의 중심 x좌표)
	int y; // Circle's center y-coordinate (원의 중심 y좌표)
	int r; // Circle's radius (원의 반지름)

	circle(int x, int y, int r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}

	// Check for object equality based on circle's center position (원의 중심 위치를 기반으로
	// 객체 동일성 확인)
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		circle position = (circle) o;
		return x == position.x && y == position.y;
	}

	// Generate hash code based on circle's center position (원의 중심 위치를 기반으로 해시 코드
	// 생성)
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
}

public class Q10216_Count_Circle_Groups_G4 {

	static int group[]; // Array to indicate the group to which each circle belongs (각 원이 속한 그룹을 표시하는
						// 배열)
	static Queue<Integer> q[]; // Array of queues for BFS traversal (BFS 순회를 위한 큐 배열)
	static int N; // Number of circles (원의 수)
	static int res = 0; // Result variable to store number of distinct groups (별도의 그룹 수를 저장하는 결과 변수)

	// DFS function to traverse connected circles and mark them as visited (연결된 원들을
	// 순회하고 방문했다고 표시하는 DFS 함수)
	static void dfs(int idx) {
		while (!q[idx].isEmpty()) {
			int t = q[idx].poll();
			if (group[t] == 0) {
				group[t] = 1;
				dfs(t);
			}
		}
	}

	// Function to identify distinct groups of touching circles (닿는 원들의 별도 그룹을 식별하는
	// 함수)
	static void search() {
		for (int i = 0; i < N; i++) {
			if (group[i] == 0) { // If circle is not visited yet (원이 아직 방문되지 않았다면)
				group[i] = 1; // Mark the circle as visited (원을 방문했다고 표시)
				dfs(i); // Call DFS for the circle (원에 대해 DFS 호출)
				res++; // Increment the number of groups (그룹 수 증가)
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine()); // Number of test cases (테스트 케이스의 수)

		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine()); // Read the number of circles for current test case (현재 테스트 케이스의 원의 수
													// 읽기)
			res = 0; // Reset the result for each test case (각 테스트 케이스마다 결과 초기화)
			circle p[] = new circle[N]; // Array to store circle objects (원 객체를 저장하는 배열)
			group = new int[N]; // Array to indicate the group to which each circle belongs (각 원이 속한 그룹을 표시하는
								// 배열)
			Arrays.fill(group, 0); // Initialize all circles as not visited (모든 원을 방문하지 않았다고 초기화)
			q = new LinkedList[N]; // Initialize queue array for BFS (BFS를 위한 큐 배열 초기화)

			// Read circle details for current test case (현재 테스트 케이스의 원의 세부 정보 읽기)
			for (int j = 0; j < N; j++) {
				String inp[] = br.readLine().split(" ");
				p[j] = new circle(Integer.parseInt(inp[0]), Integer.parseInt(inp[1]), Integer.parseInt(inp[2]));
				q[j] = new LinkedList<>();
			}

			// Identify touching circles and add them to the respective queues (닿는 원들을 식별하고
			// 해당 큐에 추가)
			for (int j = 0; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {
					if (Math.pow(Math.abs(p[j].x - p[k].x), 2) + Math.pow(Math.abs(p[j].y - p[k].y), 2) <= Math
							.pow(p[j].r + p[k].r, 2)) {
						q[j].add(k);
						q[k].add(j);
					}
				}
			}

			search(); // Call function to identify distinct groups of touching circles (닿는 원들의 별도 그룹을
						// 식별하는 함수 호출)

			bw.write(res + "\n"); // Write the result for current test case (현재 테스트 케이스의 결과 작성)

		}

		bw.flush(); // Flush the buffered writer (버퍼된 작성자 플러시)
		bw.close(); // Close the buffered writer (버퍼된 작성자 닫기)
		br.close(); // Close the buffered reader (버퍼된 리더 닫기)

	}
}
