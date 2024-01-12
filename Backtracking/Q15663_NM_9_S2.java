package Backtracking;

/*
commented by ChatGPT
This Java code is designed to generate all unique combinations of M elements from an array of N integers using backtracking. 
It avoids duplicates by skipping over elements that are the same as the previous element. 
The bt() function constructs combinations recursively. 
When a combination reaches the desired length (M), it is appended to the StringBuilder sb. 
The visited array is used to track which elements have been included in the current combination. 
The input array list is sorted to ensure that duplicates are adjacent and can be skipped efficiently.

이 Java 코드는 백트래킹을 사용하여 N개의 정수 배열에서 M개의 요소로 이루어진 모든 고유한 조합을 생성하기 위해 설계되었습니다. 
이전 요소와 같은 요소를 건너뛰어 중복을 피합니다. bt() 함수는 조합을 재귀적으로 구성합니다. 
조합이 원하는 길이(M)에 도달하면 StringBuilder sb에 추가됩니다. visited 배열은 현재 조합에 포함된 요소를 추적하는 데 사용됩니다. 
입력 배열 list는 중복이 인접하고 효율적으로 건너뛸 수 있도록 정렬됩니다.
*/

import java.io.*;
import java.util.*;

public class Q15663_NM_9_S2 {
	static StringBuilder sb = new StringBuilder(""); // 출력을 저장할 StringBuilder
	static ArrayList<Integer> out = new ArrayList<>(); // 현재 조합을 저장하는 ArrayList
	static int list[]; // 입력 배열
	static Boolean visited[]; // 방문 여부를 추적하는 배열
	static int N, M; // N: 배열의 크기, M: 조합의 크기

	// 백트래킹을 이용한 조합 생성 함수
	static void bt() {
		if (out.size() == M) {
			// 조합 크기가 M과 같으면 StringBuilder에 추가
			for (int i = 0; i < M; i++)
				sb.append(out.get(i)).append(" ");
			sb.append("\n");
		} else {
			// 재귀적으로 조합 구성
			for (int i = 0; i < N; i++) {
				if (visited[i])
					continue;
				visited[i] = true;
				out.add(list[i]);
				bt();
				visited[i] = false;
				out.remove(out.size() - 1); // 백트래킹
				if (i == N - 1)
					break;
				while (list[i + 1] == list[i]) { // 중복 건너뛰기
					i++;
					if (i == N - 1)
						break;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력 처리
		String inp[] = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]);
		M = Integer.parseInt(inp[1]);
		list = new int[N];
		visited = new Boolean[N];
		Arrays.fill(visited, false);
		inp = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(inp[i]);
		}
		Arrays.sort(list); // 입력 배열 정렬

		bt(); // 백트래킹 시작
		bw.write(sb.toString()); // 결과 출력
		bw.flush();
		bw.close();
	}
}