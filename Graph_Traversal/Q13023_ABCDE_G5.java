package Graph_Traversal;

/*
commented by ChatGPT
This Java code implements a depth-first search (DFS) algorithm to solve a problem related to finding a specific relationship pattern among a set of people. 
The goal is to determine if there exists a sequence of five people where each person is directly connected to the next. 
The dfs function recursively explores connections starting from each person, incrementing the count (idx) each time a connected person is found. 
The search stops if the count reaches 5 or all possibilities are exhausted. 
A boolean array (mem) is used to track which people have been visited during the search to avoid revisiting them.
이 Java 코드는 사람들의 집합 중 특정 관계 패턴을 찾기 위해 깊이 우선 탐색(DFS) 알고리즘을 구현합니다. 
목표는 각 사람이 다음 사람과 직접 연결된 5명의 사람의 시퀀스가 존재하는지 여부를 결정하는 것입니다. 
dfs 함수는 각 사람에서 시작하여 연결을 재귀적으로 탐색하며, 연결된 사람이 발견될 때마다 카운트(idx)를 증가시킵니다. 
카운트가 5에 도달하거나 모든 가능성이 소진될 때까지 탐색이 중단됩니다. 
불리언 배열(mem)은 탐색 중에 방문한 사람들을 추적하여 재방문하지 않도록 사용됩니다.
*/

import java.io.*;
import java.util.*;

public class Q13023_ABCDE_G5 {

	static ArrayList<Integer> peo[]; // Array of ArrayLists to store connections between people (사람들 간의 연결을 저장하는
										// ArrayList의 배열)
	static Boolean mem[]; // Boolean array to track visited people (방문한 사람들을 추적하는 불리언 배열)
	static Boolean res = false; // Boolean flag to indicate if the required pattern is found (필요한 패턴이 발견되었는지
								// 나타내는 불리언 플래그)

// Depth-first search function to explore connections (연결을 탐색하는 깊이 우선 탐색 함수)
	static void dfs(int cur, int idx) {
		if (idx == 5) { // If a sequence of 5 connected people is found (5명의 연결된 사람의 시퀀스가 발견되면)
			res = true; // Set the result flag to true (결과 플래그를 true로 설정)
			return;
		}

		for (int i = 0; i < peo[cur].size(); i++) { // Iterate over all connections of the current person (현재 사람의 모든 연결을
													// 반복)
			if (mem[peo[cur].get(i)]) { // If the connected person is not yet visited (연결된 사람이 아직 방문되지 않았다면)
				mem[peo[cur].get(i)] = false; // Mark the person as visited (사람을 방문한 것으로 표시)
				dfs(peo[cur].get(i), idx + 1); // Recursively call dfs for the connected person (연결된 사람에 대해 dfs를 재귀적으로
												// 호출)
				mem[peo[cur].get(i)] = true; // Reset the visited status (방문 상태를 재설정)
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N, M; // N: Number of people, M: Number of connections (N: 사람 수, M: 연결 수)
		int a, b; // Variables to store connections (연결을 저장하는 변수)

		String inp[] = br.readLine().split(" "); // Read the input for N and M (N과 M에 대한 입력 읽기)
		N = Integer.parseInt(inp[0]);
		M = Integer.parseInt(inp[1]);
		peo = new ArrayList[N]; // Initialize the array of ArrayLists (ArrayList의 배열 초기화)
		mem = new Boolean[N]; // Initialize the visited array (방문 배열 초기화)

		for (int i = 0; i < N; i++)
			peo[i] = new ArrayList<>(); // Initialize each ArrayList in the array (배열의 각 ArrayList 초기화)
		for (int i = 0; i < M; i++) {
			inp = br.readLine().split(" "); // Read each connection (각 연결 읽기)
			a = Integer.parseInt(inp[0]);
			b = Integer.parseInt(inp[1]);
			peo[a].add(b); // Add the connection to the ArrayLists (ArrayList에 연결 추가)
			peo[b].add(a); // Connections are bidirectional (연결은 양방향임)
		}
		Arrays.fill(mem, true); // Initially, all people are unvisited (초기에 모든 사람은 미방문 상태임)

		for (int i = 0; i < N; i++) { // Start dfs from each person (각 사람에서 dfs 시작)
			mem[i] = false; // Mark the current person as visited (현재 사람을 방문한 것으로 표시)
			dfs(i, 1); // Call dfs function (dfs 함수 호출)
			mem[i] = true; // Reset the visited status (방문 상태 재설정)
			if (res) // If the required pattern is found (필요한 패턴이 발견되면)
				break; // Break the loop (루프 중단)
		}

		// Write the result (결과 작성)
		if (res)
			bw.write("1");
		else
			bw.write("0");
		bw.flush(); // Flush the BufferedWriter (BufferedWriter 플러시)
		bw.close(); // Close the BufferedWriter (BufferedWriter 닫기)
	}
}