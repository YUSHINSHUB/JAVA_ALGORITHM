package Backtracking;

/*
commented by ChatGPT
This Java code is designed to generate all combinations of M elements from a given array of N integers. 
It uses backtracking to efficiently explore all possible combinations and a StringBuilder to accumulate the output for efficient printing. 
The combinations are generated in sorted order as the input array is sorted before the backtracking process begins.
이 Java 코드는 주어진 N개의 정수 배열에서 M개의 요소로 이루어진 모든 조합을 생성하기 위해 설계되었습니다. 
백트래킹을 사용하여 가능한 모든 조합을 효율적으로 탐색하고, StringBuilder를 사용하여 출력을 효율적으로 누적합니다. 
입력 배열이 백트래킹 프로세스가 시작되기 전에 정렬되기 때문에 조합은 정렬된 순서로 생성됩니다.
*/

import java.io.*;
import java.util.*;

public class Q15657_NM_8_S3 {
	static StringBuilder sb = new StringBuilder(""); // StringBuilder 객체를 생성하여 출력을 누적
	static ArrayList<Integer> out = new ArrayList<>(); // 현재 조합을 저장하는 ArrayList
	static int list[]; // 입력 배열
	static int N, M; // N: 배열의 크기, M: 조합의 크기

// 백트래킹을 이용한 조합 생성 함수
	static void bt(int idx) {
		if (out.size() == M) {
			// 조합 크기가 M과 같으면 StringBuilder에 추가
			for (int i = 0; i < M; i++)
				sb.append(out.get(i)).append(" ");
			sb.append("\n");
		} else {
			// 재귀적으로 조합 구성
			for (int i = idx; i < N; i++) {
				out.add(list[i]);
				bt(i);
				out.remove(out.size() - 1); // 백트래킹
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
		inp = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(inp[i]);
		}
		Arrays.sort(list); // 입력 배열 정렬

		bt(0); // 백트래킹 시작
		bw.write(sb.toString()); // 결과 출력
		bw.flush();
		bw.close();
	}
}