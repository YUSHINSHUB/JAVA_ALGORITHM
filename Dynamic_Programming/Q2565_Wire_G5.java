package Dynamic_Programming;

/*
commented by ChatGPT
This Java code is designed to find the longest increasing subsequence in a given sequence of pairs. 
It reads a series of pairs, stores the second element of each pair in an array, and then calculates the length of the longest increasing subsequence. 
Finally, it outputs the minimum number of elements that need to be removed to achieve this subsequence.
이 Java 코드는 주어진 쌍의 시퀀스에서 가장 긴 증가하는 부분 수열을 찾도록 설계되었습니다. 
일련의 쌍을 읽고 각 쌍의 두 번째 요소를 배열에 저장한 다음, 가장 긴 증가하는 부분 수열의 길이를 계산합니다. 
마지막으로, 이 부분 수열을 달성하기 위해 제거해야 하는 최소 요소 수를 출력합니다.
*/

import java.io.*;
import java.util.*;

public class Q2565_Wire_G5 {

	static int link[] = new int[501]; // Array to store the second elements of pairs (쌍의 두 번째 요소를 저장하는 배열)
	static ArrayList<Integer> list = new ArrayList<>(); // ArrayList to store valid second elements (유효한 두 번째 요소를 저장하는
														// ArrayList)
	static int mem[]; // Array for dynamic programming to store the length of the longest increasing
						// subsequence (가장 긴 증가하는 부분 수열의 길이를 저장하기 위한 동적 프로그래밍 배열)
	static int inc = 1; // Increment variable (증가 변수)

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Arrays.fill(link, 0); // Initialize the link array with zeros (link 배열을 0으로 초기화)
		int n = Integer.parseInt(br.readLine()); // Read the number of pairs (쌍의 수를 읽음)
		mem = new int[501]; // Initialize the memory array (메모리 배열 초기화)
		int res = 0; // Variable to store the result (결과를 저장할 변수)

		// Reading each pair and storing the second element in link array
		for (int i = 0; i < n; i++) {
			String inp[] = br.readLine().split(" ");
			link[Integer.parseInt(inp[0])] = Integer.parseInt(inp[1]);
		}

		// Adding valid second elements to the list
		for (int i = 1; i <= 500; i++) {
			if (link[i] > 0)
				list.add(link[i]);
		}

		// Calculating the length of the longest increasing subsequence
		for (int i = 0; i < n; i++) {
			int cur = list.get(i);
			for (int j = 0; j < cur; j++) {
				mem[cur] = Math.max(mem[j] + 1, mem[cur]); // Updating the length of the subsequence
			}
			res = Math.max(res, mem[cur]); // Storing the maximum length found
		}

		// Writing the minimum number of elements to be removed
		bw.write(n - res + ""); // Subtracting the length of the subsequence from the total number of pairs
		bw.flush();
		bw.close();
	}
}