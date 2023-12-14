package Backtracking;

/*
commented by ChatGPT
This Java code generates and prints all possible combinations of m-length numbers from a given range [1, n] without repetition. 
It uses backtracking to generate combinations with a certain order. This variation of the code also ensures combinations are generated in increasing order.
이 Java 코드는 주어진 범위 [1, n]에서 중복 없이 m-길이의 조합을 생성하고 출력합니다.
코드는 백트래킹을 사용하여 일정한 순서로 조합을 생성합니다. 이 코드의 변형은 조합이 증가하는 순서로 생성되도록 보장합니다.
*/

import java.io.*;
import java.util.*;

public class Q15650_NM_2_S3 {

	static int n, m; // Declaring variables for the range and length of combinations
						// 범위와 조합의 길이를 위한 변수 선언
	static boolean visited[] = new boolean[9]; // Array to keep track of the visited numbers
												// 방문한 숫자를 추적하기 위한 배열
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Deque<Integer> dq = new LinkedList<>(); // Use Deque to store the current combination
													// 현재 조합을 저장하기 위해 Deque 사용

	static void bt(int idx) throws IOException {
		// Backtracking function to generate combinations
		// 조합을 생성하기 위한 백트래킹 함수

		if (dq.size() == m) { // If the current combination has the required length
								// 현재 조합이 필요한 길이를 가지면
			for (int i = 0; i < dq.size(); i++) {
				int t = dq.pollFirst(); // Get and remove the first element from the deque
										// deque에서 첫 번째 요소를 가져와 제거
				bw.write(t + " ");
				dq.addLast(t); // Add the element back to the end
								// 요소를 다시 끝에 추가
			}
			bw.write("\n");
		} else {
			for (int i = idx + 1; i <= n; i++) {

				if (visited[i]) // If the number is already in the combination, skip it
								// 숫자가 이미 조합에 있다면 건너뜀
					continue;

				dq.addLast(i); // Add the number to the current combination
								// 숫자를 현재 조합에 추가
				visited[i] = true; // Mark the number as visited
									// 숫자를 방문했음으로 표시
				bt(i); // Recursive call with incremented index to ensure increasing order
						// 증가하는 순서를 보장하기 위해 증가된 인덱스로 재귀 호출
				dq.pollLast(); // Remove the last added number to backtrack
								// 백트래킹을 위해 마지막에 추가한 숫자 제거
				visited[i] = false; // Mark the number as unvisited for the next iteration
									// 다음 반복을 위해 숫자를 방문하지 않았음으로 표시
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Arrays.fill(visited, false); // Initialize the visited array with false values
										// 방문 배열을 false 값으로 초기화
		String inp[] = br.readLine().split(" ");
		n = Integer.parseInt(inp[0]);
		m = Integer.parseInt(inp[1]);

		bt(0); // Start the backtracking process with initial index 0

		bw.flush();
		bw.close();
	}
}
