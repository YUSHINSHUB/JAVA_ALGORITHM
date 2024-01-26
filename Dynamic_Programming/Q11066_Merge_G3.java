package Dynamic_Programming;

/*
commented by ChatGPT
This Java code is designed to solve the problem of finding the minimum cost to concatenate several chapters into one book. 
It uses dynamic programming to achieve this. The chapters are represented as an array chapter, and the mem array is used for memoization. 
The goal is to find the minimum cost of concatenation, where the cost is defined as the sum of the pages of the chapters being concatenated each time.

이 Java 코드는 여러 챕터를 하나의 책으로 합치는 최소 비용을 찾는 문제를 해결하기 위해 설계되었습니다. 이를 위해 동적 프로그래밍을 사용합니다. 
챕터는 chapter 배열로 표현되며, mem 배열은 메모이제이션을 위해 사용됩니다. 목표는 합치는 비용을 최소화하는 것이며, 여기서 비용은 매번 합쳐지는 챕터의 페이지 수의 합으로 정의됩니다.
*/

import java.io.*;
import java.util.*;

public class Q11066_Merge_G3 {

	static int chapter[] = new int[500]; // Array to store the number of pages in each chapter
	static long mem[][] = new long[500][500]; // 2D array for memoization

// Function to compute the minimum cost of concatenating chapters from 'start' to 'end'
	static long dp(int start, int end) {
		// Check if the value is already computed
		if (mem[start][end] < Long.MAX_VALUE)
			return mem[start][end];

		// Calculate total pages from 'start' to 'end'
		long val = 0;
		for (int i = start; i <= end; i++)
			val += chapter[i];

		// Calculate the minimum cost of concatenation
		for (int i = start; i < end; i++) {
			mem[start][end] = Math.min(mem[start][end], dp(start, i) + dp(i + 1, end) + val);
		}

		return mem[start][end];
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T, N; // Number of test cases (T) and number of chapters (N)
		String inp[];

		T = Integer.parseInt(br.readLine());

		for (int cs = 0; cs < T; cs++) {

			N = Integer.parseInt(br.readLine());
			inp = br.readLine().split(" ");

			// Input chapter pages and initialize memoization array
			for (int i = 0; i < N; i++) {
				chapter[i] = Integer.parseInt(inp[i]);
				Arrays.fill(mem[i], Long.MAX_VALUE);
			}

			// Initialize base cases for memoization
			for (int i = 0; i < N; i++) {
				mem[i][i] = 0;
				if (i > 0)
					mem[i - 1][i] = chapter[i - 1] + chapter[i];
			}
			bw.write(dp(0, N - 1) + "\n");

		}

		bw.flush();
		bw.close();
	}
}