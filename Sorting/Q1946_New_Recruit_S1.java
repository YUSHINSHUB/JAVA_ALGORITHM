package Sorting;

/*
commented by ChatGPT
This Java code is designed to solve a problem where it filters a set of pairs based on a specific condition.
It reads multiple test cases. Each test case contains a list of pairs, and the goal is to count how many pairs meet the condition that both elements in a pair are not greater than the minimum elements seen so far in each dimension.
이 Java 코드는 특정 조건에 따라 쌍의 집합을 필터링하는 문제를 해결하기 위해 설계되었습니다.
여러 테스트 케이스를 읽고, 각 테스트 케이스는 쌍의 목록을 포함합니다. 목표는 각 차원에서 지금까지 본 최소 요소보다 크지 않은 쌍을 세는 것입니다.
*/

import java.io.*;
import java.util.*;

public class Q1946_New_Recruit_S1 {

	static class comm {
		int g1, g2;

		// Constructor for comm class, initializing two integer values g1 and g2
		comm(int g1, int g2) {
			this.g1 = g1;
			this.g2 = g2;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T, N; // Variables for number of test cases (T) and number of pairs (N)
		int res; // Variable to store the result for each test case
		ArrayList<comm> list = new ArrayList<>(); // List to store pairs

		T = Integer.parseInt(br.readLine()); // Reading number of test cases

		for (int tc = 0; tc < T; tc++) { // Loop through each test case
			list.clear(); // Clearing the list for the new test case
			N = Integer.parseInt(br.readLine()); // Reading number of pairs for current test case
			res = N; // Initializing result with the total number of pairs

			for (int i = 0; i < N; i++) { // Loop to read each pair
				String inp[] = br.readLine().split(" ");
				list.add(new comm(Integer.parseInt(inp[0]), Integer.parseInt(inp[1]))); // Adding new pair to list
			}

			// Sorting the list of pairs based on the first element of the pair
			Collections.sort(list, new Comparator<comm>() {
				public int compare(comm o1, comm o2) {
					return o1.g1 - o2.g1;
				}
			});

			int low = list.get(0).g2; // Variable to keep track of the minimum second element seen so far

			for (int i = 1; i < N; i++) { // Loop to filter pairs based on the condition
				if (low < list.get(i).g2) { // If current pair's second element is greater than 'low', decrement result
					res--;
				} else { // Otherwise, update 'low' with the current pair's second element
					low = list.get(i).g2;
				}
			}

			bw.write(res + "\n"); // Writing the result for the current test case

		}

		bw.flush(); // Flushing the BufferedWriter
		bw.close(); // Closing the BufferedWriter

	}
}