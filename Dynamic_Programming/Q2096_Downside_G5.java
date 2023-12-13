package Dynamic_Programming;

/*
commented by ChatGPT
This Java code employs recursive dynamic programming to find the maximum and minimum scores that can be achieved on a path through a grid. 
The grid has N rows and 3 columns, representing possible paths. 
Two separate recursive functions (recur and recur2) calculate the maximum and minimum scores, respectively. 
The functions consider three possible moves from each position (left, middle, right) while avoiding invalid transitions. 
The mem and lmem arrays are used to store intermediate results for the maximum and minimum scores, respectively.
이 Java 코드는 그리드를 통한 경로에서 달성할 수 있는 최대 점수와 최소 점수를 찾기 위해 재귀적 동적 프로그래밍을 사용합니다. 
그리드는 N행 3열로 가능한 경로를 나타냅니다. 
두 개의 별도의 재귀 함수(recur 및 recur2)는 각각 최대 점수와 최소 점수를 계산합니다. 
이 함수들은 각 위치에서 세 가지 가능한 이동(왼쪽, 중간, 오른쪽)을 고려하면서 유효하지 않은 전환을 피합니다. 
mem 및 lmem 배열은 각각 최대 점수와 최소 점수에 대한 중간 결과를 저장하는 데 사용됩니다.
*/

import java.io.*;
import java.util.*;

public class Q2096_Downside_G5 {

	static int N; // Number of rows in the grid (그리드의 행 수)
	static int road[][]; // 2D array representing the grid (그리드를 나타내는 2D 배열)
	static int mem[][]; // Array for memoization to store maximum scores (최대 점수를 저장하기 위한 메모이제이션 배열)
	static int lmem[][]; // Array for memoization to store minimum scores (최소 점수를 저장하기 위한 메모이제이션 배열)

// Recursive function to calculate the maximum score
	static int recur(int y, int x) {

		if (y == N) // Base case: if the last row is reached (기본 사례: 마지막 행에 도달한 경우)
			return road[y][x];

		if (mem[y][x] >= 0) // Check if the value is already computed (값이 이미 계산되었는지 확인)
			return mem[y][x];

		// Compute the maximum score for the current position (현재 위치에 대한 최대 점수 계산)
		if (x == 1) {
			mem[y][x] = Math.max(mem[y][x], recur(y + 1, 0) + road[y][x]);
			mem[y][x] = Math.max(mem[y][x], recur(y + 1, 1) + road[y][x]);
			mem[y][x] = Math.max(mem[y][x], recur(y + 1, 2) + road[y][x]);
		} else if (x == 0) {
			mem[y][x] = Math.max(mem[y][x], recur(y + 1, 0) + road[y][x]);
			mem[y][x] = Math.max(mem[y][x], recur(y + 1, 1) + road[y][x]);
		} else {
			mem[y][x] = Math.max(mem[y][x], recur(y + 1, 1) + road[y][x]);
			mem[y][x] = Math.max(mem[y][x], recur(y + 1, 2) + road[y][x]);
		}

		return mem[y][x]; // Return the maximum score (최대 점수 반환)
	}

// Recursive function to calculate the minimum score
	static int recur2(int y, int x) {

		if (y == N) // Base case: if the last row is reached (기본 사례: 마지막 행에 도달한 경우)
			return road[y][x];

		if (lmem[y][x] < 1000000) // Check if the value is already computed (값이 이미 계산되었는지 확인)
			return lmem[y][x];

		// Compute the minimum score for the current position (현재 위치에 대한 최소 점수 계산)
		if (x == 1) {
			lmem[y][x] = Math.min(lmem[y][x], recur2(y + 1, 0) + road[y][x]);
			lmem[y][x] = Math.min(lmem[y][x], recur2(y + 1, 1) + road[y][x]);
			lmem[y][x] = Math.min(lmem[y][x], recur2(y + 1, 2) + road[y][x]);
		} else if (x == 0) {
			lmem[y][x] = Math.min(lmem[y][x], recur2(y + 1, 0) + road[y][x]);
			lmem[y][x] = Math.min(lmem[y][x], recur2(y + 1, 1) + road[y][x]);
		} else {
			lmem[y][x] = Math.min(lmem[y][x], recur2(y + 1, 1) + road[y][x]);
			lmem[y][x] = Math.min(lmem[y][x], recur2(y + 1, 2) + road[y][x]);
		}

		return lmem[y][x]; // Return the minimum score (최소 점수 반환)
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine()); // Read the number of rows (행 수 읽기)
		road = new int[N + 1][3]; // Initialize the grid (그리드 초기화)
		mem = new int[N + 1][3]; // Initialize the memoization array for maximum scores (최대 점수를 위한 메모이제이션 배열 초기화)
		lmem = new int[N + 1][3]; // Initialize the memoization array for minimum scores (최소 점수를 위한 메모이제이션 배열 초기화)
		for (int i = 0; i < N; i++) {
			Arrays.fill(mem[i], -1); // Fill the memory array for maximum scores with -1 (최대 점수 메모리 배열을 -1로 채우기)
			Arrays.fill(lmem[i], Integer.MAX_VALUE); // Fill the memory array for minimum scores with maximum integer
														// value (최소 점수 메모리 배열을 최대 정수 값으로 채우기)
			String inp[] = br.readLine().split(" ");
			road[i + 1][0] = Integer.parseInt(inp[0]); // Fill the grid with input values (그리드를 입력 값으로 채우기)
			road[i + 1][1] = Integer.parseInt(inp[1]);
			road[i + 1][2] = Integer.parseInt(inp[2]);
		}
		mem[0][1] = -1; // Initialize the starting point for maximum score calculation (최대 점수 계산을 위한 시작점
						// 초기화)
		lmem[0][1] = Integer.MAX_VALUE; // Initialize the starting point for minimum score calculation (최소 점수 계산을 위한 시작점
										// 초기화)

		bw.write(recur(0, 1) + " " + recur2(0, 1)); // Write the maximum and minimum scores
		bw.flush(); // Flush the BufferedWriter
		bw.close(); // Close the BufferedWriter

	}
}