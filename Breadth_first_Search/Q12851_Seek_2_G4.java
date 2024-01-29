package Breadth_first_Search;

/*
commented by ChatGPT
This Java code is designed to calculate the minimum number of steps needed for a character to move from position N to position K, considering forward, backward, and teleportation moves. 
The code employs a Breadth-First Search (BFS) approach to explore all possible moves and record the minimum steps needed to reach each position. 
Additionally, it tracks the possible paths from K to N, counting the unique routes. 
The program reads the starting position N and the target position K as input, performs BFS to find the minimum steps, then traces back the paths to calculate the total number of unique routes from K to N.

이 Java 코드는 캐릭터가 N 위치에서 K 위치로 이동하는 데 필요한 최소 단계 수를 계산하기 위해 설계되었습니다. 
코드는 앞으로 이동, 뒤로 이동, 순간 이동을 고려하여 BFS(너비 우선 탐색) 접근 방식을 사용하여 모든 가능한 이동을 탐색하고 각 위치에 도달하기 위해 필요한 최소 단계를 기록합니다. 
또한, K에서 N으로의 가능한 경로를 추적하여 K에서 N으로의 고유한 경로 수를 계산합니다. 
프로그램은 시작 위치 N과 목표 위치 K를 입력으로 읽고 BFS를 수행하여 최소 단계를 찾은 다음 K에서 N으로의 경로를 추적하여 K에서 N까지의 고유한 경로 수를 계산합니다.
*/

import java.io.*;
import java.util.*;
import java.math.*;

public class Q12851_Seek_2_G4 {
	static int mem[] = new int[110000]; // 각 위치까지의 최소 단계 수를 추적하는 배열
	static int res = 0; // 고유한 경로 수를 저장하는 변수

// N에서 K까지의 최소 단계를 찾는 BFS 함수
	static void bfs(int N, int K) {
		Arrays.fill(mem, -1); // 모든 위치를 방문하지 않은 상태로 초기화
		mem[N] = 0; // 시작 위치
		Queue<Integer> q = new LinkedList<>();
		q.add(N);

		// 모든 가능한 이동을 탐색
		while (!q.isEmpty()) {
			int cur = q.poll(); // 현재 위치
			int next;

			// 앞으로 이동
			next = cur + 1;
			if (next < 110000 && next >= 0 && mem[next] < 0) {
				q.add(next);
				mem[next] = mem[cur] + 1;
			}

			// 뒤로 이동
			next = cur - 1;
			if (next < 110000 && next >= 0 && mem[next] < 0) {
				q.add(next);
				mem[next] = mem[cur] + 1;
			}

			// 순간 이동
			next = cur * 2;
			if (next < 110000 && next >= 0 && mem[next] < 0) {
				q.add(next);
				mem[next] = mem[cur] + 1;
			}
		}
	}

// K에서 N까지의 경로를 찾는 함수
	static void find(int cur) {

		if (mem[cur] == 0) { // 시작점에 도달하면 경로 수 증가
			res++;
			return;
		}
		int next;

		// 역순으로 경로 추적
		next = cur + 1;
		if (next < 110000 && next >= 0 && mem[next] == mem[cur] - 1) {
			find(next);
		}

		next = cur - 1;
		if (next < 110000 && next >= 0 && mem[next] == mem[cur] - 1) {
			find(next);
		}

		if (cur % 2 == 0) { // 순간 이동이 가능한 경우
			next = cur / 2;
			if (next < 110000 && next >= 0 && mem[next] == mem[cur] - 1) {
				find(next);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N, K; // 시작 위치 N과 목표 위치 K
		String inp[];

		inp = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]);
		K = Integer.parseInt(inp[1]);

		bfs(N, K); // BFS를 수행하여 최소 단계를 찾음
		find(K); // 경로를 찾음

		// 최소 단계와 경로 출력
		bw.write(mem[K] + "\n" + res);
		bw.flush();
		bw.close();
	}
}