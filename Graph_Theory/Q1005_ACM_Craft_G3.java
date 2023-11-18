package Graph_Theory;

/*
commented by ChatGPT
This Java code is designed to solve a dynamic programming problem where it calculates the maximum value of a node in a directed acyclic graph (DAG). 
The graph represents dependencies between tasks, with each task having a specific duration. 
The program uses a top-down dynamic programming approach (memoization) to find the maximum time required to reach a target task, considering the duration of preceding tasks.
이 Java 코드는 방향성 비순환 그래프(DAG) 내의 노드의 최대 값을 계산하는 동적 프로그래밍 문제를 해결하도록 설계되었습니다. 
그래프는 각각 특정 지속 시간을 가진 작업 간의 의존성을 나타냅니다. 
프로그램은 선행 작업의 지속 시간을 고려하여 목표 작업에 도달하기 위한 최대 시간을 찾기 위해 상향식 동적 프로그래밍 접근법(메모이제이션)을 사용합니다.
*/

import java.io.*;
import java.util.*;

public class Q1005_ACM_Craft_G3 {

	static int D[]; // 각 작업의 지속 시간을 저장하는 배열
	static int visited[]; // 메모이제이션을 위한 배열, 각 작업에 대한 최대 시간을 저장
	static Queue<Integer>[] grp = new Queue[1001]; // 작업 의존성을 나타내는 그래프

	static int dp(int idx) {
		// 이미 계산된 작업의 경우 저장된 값 반환
		if (visited[idx] >= 0) {
			return visited[idx];
		}

		// 현재 작업에 대한 모든 선행 작업 처리
		while (!grp[idx].isEmpty()) {
			visited[idx] = Math.max(dp(grp[idx].poll()) + D[idx], visited[idx]);
		}

		// 선행 작업이 없는 경우 현재 작업의 지속 시간으로 설정
		if (visited[idx] < 0)
			visited[idx] = D[idx];

		return visited[idx]; // 계산된 최대 시간 반환
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

		for (int cs = 0; cs < T; cs++) {
			String inp[] = br.readLine().split(" ");
			int N = Integer.parseInt(inp[0]); // 작업의 수
			D = new int[N + 1]; // 작업 지속 시간 배열 초기화
			visited = new int[N + 1]; // 메모이제이션 배열 초기화
			Arrays.fill(visited, -1); // 메모이제이션 배열을 -1로 설정
			int K = Integer.parseInt(inp[1]); // 작업 의존성의 수
			inp = br.readLine().split(" ");
			for (int i = 1; i <= N; i++) {
				D[i] = Integer.parseInt(inp[i - 1]); // 작업별 지속 시간 입력
				grp[i] = new LinkedList<>(); // 그래프 초기화
			}
			for (int i = 0; i < K; i++) {
				inp = br.readLine().split(" ");
				grp[Integer.parseInt(inp[1])].add(Integer.parseInt(inp[0])); // 의존성 추가
			}

			int W = Integer.parseInt(br.readLine()); // 목표 작업
			bw.write(dp(W) + "\n"); // 목표 작업까지의 최대 시간 계산 및 출력
		}
		bw.flush();
		bw.close();
	}
}
