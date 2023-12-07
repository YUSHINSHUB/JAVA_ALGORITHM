package Dynamic_Programming;

/*
commented by ChatGPT
This Java program calculates the maximum sum of an increasing subsequence in a given sequence of integers. 
It employs dynamic programming with memoization to optimize the computation. 
The program is designed to find the largest possible sum of a subsequence where each element is greater than all previous elements in the subsequence.
이 Java 프로그램은 주어진 정수 수열에서 증가하는 부분 수열의 최대 합을 계산합니다. 
동적 프로그래밍과 메모이제이션을 사용하여 계산을 최적화합니다. 
프로그램은 부분 수열의 각 요소가 부분 수열의 모든 이전 요소보다 큰 경우에 가능한 가장 큰 합을 찾도록 설계되었습니다.
*/

import java.io.*;
import java.util.*;

public class Q11055_Biggest_Increasing_Subsequence_S2 {

	static int sequence[]; // 주어진 수열을 저장할 배열
	static int mem[]; // 메모이제이션을 위한 배열
	static int N; // 수열의 길이

	// 동적 프로그래밍을 위한 함수 dp
	static int dp(int idx) {
		if (mem[idx] > 0) // 이미 계산된 값이 있는 경우 해당 값을 반환
			return mem[idx];

		mem[idx] = sequence[idx]; // 초기 값 설정
		for (int i = idx - 1; i >= 0; i--) { // 이전 요소들을 확인
			if (sequence[i] < sequence[idx]) { // 증가하는 부분 수열의 조건을 만족하는 경우
				mem[idx] = Math.max(dp(i) + sequence[idx], mem[idx]); // 최대 합 갱신
			}
		}

		return mem[idx]; // 계산된 최대 합 반환
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int res = 0; // 최대 합을 저장할 변수

		N = Integer.parseInt(br.readLine()); // 수열의 길이 입력
		mem = new int[N]; // 메모이제이션 배열 초기화
		Arrays.fill(mem, 0); // 배열의 모든 값을 0으로 설정
		sequence = new int[N]; // 수열을 저장할 배열 초기화
		String inp[] = br.readLine().split(" "); // 수열 입력
		for (int i = 0; i < N; i++)
			sequence[i] = Integer.parseInt(inp[i]); // 수열을 배열에 저장

		for (int i = N - 1; i >= 0; i--)
			res = Math.max(res, dp(i)); // 모든 요소에 대해 최대 합 계산

		bw.write(res + ""); // 결과 출력
		bw.flush();
		bw.close();

	}
}
