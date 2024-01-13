package Backtracking;
/*
commented by ChatGPT
This Java code, designed for the "Q15666_NM_12_S2" problem, generates all combinations of M elements out of an N-element array, allowing repeated elements but ensuring combinations are in non-decreasing order. 
The program uses backtracking to efficiently generate these combinations. 
The bt() function recursively builds combinations, and when a combination reaches the required length (M), it is added to the StringBuilder sb. 
The input array list is sorted to facilitate the generation of non-decreasing combinations. 
The code avoids generating duplicate combinations by skipping over repeated elements in the sorted array.

이 Java 코드는 "Q15666_NM_12_S2" 문제를 위해 설계되었으며, N개 요소 배열에서 M개 요소를 선택하여 비감소 순서의 조합을 생성합니다. 
이 프로그램은 백트래킹을 사용하여 이러한 조합을 효율적으로 생성합니다. 
bt() 함수는 조합을 재귀적으로 구성하며, 조합이 필요한 길이(M)에 도달하면 StringBuilder sb에 추가됩니다. 입력 배열 list는 비감소 조합 생성을 용이하게 하기 위해 정렬됩니다. 
코드는 정렬된 배열에서 반복되는 요소를 건너뛰어 중복 조합을 생성하지 않습니다.
*/

import java.io.*;
import java.util.*;

public class Q15666_NM_12_S2 {
	static StringBuilder sb = new StringBuilder(""); // 출력을 저장할 StringBuilder
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