package Backtracking;

/*
commented by ChatGPT
This Java code is a classic example of generating combinations using backtracking. 
It reads two integers, N and M, and an array of N integers. 
The goal is to print all possible combinations of M numbers from the given array. 
The bt() function is a recursive backtracking function that constructs combinations. 
If the size of the current combination (out.size()) equals M, it adds the combination to the StringBuilder. 
Otherwise, it iteratively adds each number from list to out, recursively calls bt(), and then removes the last number to backtrack. 
The list array is sorted to ensure combinations are generated in sorted order.

이 Java 코드는 백트래킹을 사용하여 조합을 생성하는 전형적인 예입니다. 
두 개의 정수 N과 M과 N개의 정수 배열을 읽습니다. 
목표는 주어진 배열에서 M개의 숫자의 모든 가능한 조합을 출력하는 것입니다. 
bt() 함수는 조합을 구성하는 재귀적인 백트래킹 함수입니다. 
현재 조합의 크기(out.size())가 M과 같으면 조합을 StringBuilder에 추가합니다. 
그렇지 않으면 list의 각 숫자를 순차적으로 out에 추가하고, 재귀적으로 bt()를 호출한 다음, 마지막 숫자를 제거하여 백트래킹합니다. 
list 배열은 조합이 정렬된 순서로 생성되도록 정렬됩니다.
*/

import java.io.*;
import java.util.*;

public class Q15656_NM_7_S3 {
	static StringBuilder sb = new StringBuilder(""); // StringBuilder to build output
	static ArrayList<Integer> out = new ArrayList<>(); // List to store current combination
	static int list[]; // Input array
	static int N, M; // N: Size of the array, M: Size of the combination

	static void bt() {
		if (out.size() == M) {
			// When the combination size equals M, add it to StringBuilder
			for (int i = 0; i < M; i++)
				sb.append(out.get(i)).append(" ");
			sb.append("\n");
		} else {
			// Recursively construct combinations
			for (int i = 0; i < N; i++) {
				out.add(list[i]);
				bt();
				out.remove(out.size() - 1); // Backtrack
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]);
		M = Integer.parseInt(inp[1]);
		list = new int[N];
		inp = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(inp[i]);
		}
		Arrays.sort(list); // Sort the input array

		bt(); // Start backtracking
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}