package Dynamic_Programming;

/*
commented by ChatGPT
This Java program calculates the N-th number in a sequence where each number is the sum of the previous two numbers, modulo 15746. 
It employs dynamic programming and memoization to optimize the computation for large values of N. 
The program handles the base cases for N=1 and N=2 separately.
이 Java 프로그램은 각 숫자가 이전 두 숫자의 합인 수열의 N번째 숫자를 15746으로 나눈 나머지로 계산합니다. 
이 프로그램은 동적 프로그래밍과 메모이제이션을 사용하여 큰 N 값에 대한 계산을 최적화합니다. 
N=1과 N=2에 대한 기본 케이스를 별도로 처리합니다.
*/

import java.io.*;
import java.util.*;

public class Q1904_01Tile_S3 {

	static int mem[]; // Memoization array (메모이제이션 배열)

	// Recursive function to calculate the N-th number
	static int dp(int idx) {
		if (mem[idx] >= 0) { // If already computed, return the value (이미 계산된 경우 값을 반환)
			return mem[idx];
		}

		// Compute the value and store it in the memoization array (값을 계산하고 메모이제이션 배열에
		// 저장)
		mem[idx] = (dp(idx - 1) + dp(idx - 2)) % 15746;

		return mem[idx];
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N; // The N-th number to compute (계산할 N번째 숫자)

		N = Integer.parseInt(br.readLine());
		mem = new int[N + 1]; // Initialize memoization array (메모이제이션 배열 초기화)
		Arrays.fill(mem, -1); // Fill with -1 to indicate uncomputed values (미계산 값을 나타내기 위해 -1로 채움)
		mem[1] = 1; // Base case for N=1 (N=1에 대한 기본 사례)
		if (N >= 2)
			mem[2] = 2; // Base case for N=2 (N=2에 대한 기본 사례)

		bw.write(dp(N) + ""); // Output the result (결과 출력)

		bw.flush(); // Flush the buffer (버퍼 플러시)
		bw.close(); // Close the writer (쓰기 닫기)

	}
}
