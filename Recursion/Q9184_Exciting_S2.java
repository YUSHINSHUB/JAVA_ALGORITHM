package Recursion;

/*
commented by ChatGPT
This Java code implements a recursive function w(a, b, c) defined by a specific set of rules. 
It utilizes a 3D array mem[][][] for memoization to optimize the calculation of the function. 
The function defines various conditions for its arguments and computes a value based on these conditions. 
The main purpose of this code is to compute and display the value of w(a, b, c) for different inputs a, b, and c, stopping when all three inputs are -1.
이 Java 코드는 특정 규칙에 따라 정의된 재귀 함수 w(a, b, c)를 구현합니다. 
함수 계산을 최적화하기 위해 3차원 배열 mem[][][]을 메모이제이션에 사용합니다. 
이 함수는 그 인자들에 대해 다양한 조건을 정의하고 이러한 조건에 따라 값을 계산합니다. 
이 코드의 주 목적은 서로 다른 입력 a, b, c에 대해 w(a, b, c)의 값을 계산하여 표시하는 것이며, 세 입력 모두 -1일 때 중지합니다.
*/

import java.io.*;
import java.util.*;

public class Q9184_Exciting_S2 {

	static int mem[][][] = new int[21][21][21]; // 3D array for memoization (메모이제이션을 위한 3차원 배열)

	static int w(int a, int b, int c) { // Recursive function w (재귀 함수 w)

		if (a <= 0 || b <= 0 || c <= 0)
			return 1;
		else if (a > 20 || b > 20 || c > 20) {
			if (mem[20][20][20] < 0)
				mem[20][20][20] = w(20, 20, 20); // Memoize if not already done (아직 메모이제이션이 안 된 경우 메모이제이션 수행)
			return mem[20][20][20];
		} else if (a < b && b < c) {
			int res = 0;
			if (mem[a][b][c - 1] < 0)
				mem[a][b][c - 1] = w(a, b, c - 1); // Memoize if not already done (아직 메모이제이션이 안 된 경우 메모이제이션 수행)
			res = mem[a][b][c - 1];
			if (mem[a][b - 1][c - 1] < 0)
				mem[a][b - 1][c - 1] = w(a, b - 1, c - 1); // Memoize if not already done (아직 메모이제이션이 안 된 경우 메모이제이션 수행)
			res += mem[a][b - 1][c - 1];
			if (mem[a][b - 1][c] < 0)
				mem[a][b - 1][c] = w(a, b - 1, c); // Memoize if not already done (아직 메모이제이션이 안 된 경우 메모이제이션 수행)
			res -= mem[a][b - 1][c];
			return res;
		} else {
			int res = 0;
			if (mem[a - 1][b][c] < 0)
				mem[a - 1][b][c] = w(a - 1, b, c); // Memoize if not already done (아직 메모이제이션이 안 된 경우 메모이제이션 수행)
			res = mem[a - 1][b][c];
			if (mem[a - 1][b - 1][c] < 0)
				mem[a - 1][b - 1][c] = w(a - 1, b - 1, c); // Memoize if not already done (아직 메모이제이션이 안 된 경우 메모이제이션 수행)
			res += mem[a - 1][b - 1][c];
			if (mem[a - 1][b][c - 1] < 0)
				mem[a - 1][b][c - 1] = w(a - 1, b, c - 1); // Memoize if not already done (아직 메모이제이션이 안 된 경우 메모이제이션 수행)
			res += mem[a - 1][b][c - 1];
			if (mem[a - 1][b - 1][c - 1] < 0)
				mem[a - 1][b - 1][c - 1] = w(a - 1, b - 1, c - 1); // Memoize if not already done (아직 메모이제이션이 안 된 경우
																	// 메모이제이션 수행)
			res -= mem[a - 1][b - 1][c - 1];
			return res;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Initialize the memoization array with -1 (메모이제이션 배열을 -1로 초기화)
		for (int i = 0; i <= 20; i++) {
			for (int j = 0; j <= 20; j++) {
				Arrays.fill(mem[i][j], -1);
			}
		}

		while (true) { // Read inputs until -1, -1, -1 is encountered (입력이 -1, -1, -1일 때까지 반복 읽기)
			String inp[] = br.readLine().split(" ");
			int a = Integer.parseInt(inp[0]);
			int b = Integer.parseInt(inp[1]);
			int c = Integer.parseInt(inp[2]);

			if (a == -1 && b == -1 && c == -1) // Break the loop if all inputs are -1 (모든 입력이 -1이면 루프 종료)
				break;

			// Write the result of the function w (함수 w의 결과를 작성)
			bw.write("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c) + "\n");
		}

		bw.flush();
		bw.close();

	}
}