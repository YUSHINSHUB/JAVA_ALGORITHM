package Dynamic_Programming;

/*
commented by ChatGPT
This Java code is designed to find the longest increasing subsequence in an array and print both its length and the subsequence itself. 
It uses dynamic programming to calculate the lengths of the longest subsequences ending at each element and then backtracks to construct the actual subsequence.
이 Java 코드는 배열에서 가장 긴 증가하는 부분 수열을 찾고 그 길이와 수열 자체를 출력하기 위해 설계되었습니다. 
각 요소에서 끝나는 가장 긴 부분 수열의 길이를 계산하기 위해 동적 프로그래밍을 사용하고, 실제 수열을 구성하기 위해 백트래킹을 수행합니다.
*/

import java.io.*;
import java.util.*;

public class Q14002_LIS_4_G4 {
	public static void main(String[] args) throws IOException {
// Setting up input and output tools
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Variable declarations
		int N; // Size of the array
		int A[]; // Array to store the input sequence
		int mem[]; // Array to store the length of the longest subsequence ending at each index
		int hig = 1; // Variable to track the length of the longest increasing subsequence
		int end = 0; // Variable to track the end index of the longest increasing subsequence
		ArrayList<Integer> list = new ArrayList<>(); // List to store the longest increasing subsequence

		// Reading the size of the array
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		mem = new int[N];
		Arrays.fill(mem, 1); // Initializing the mem array to 1 as the minimum subsequence length is 1

		// Reading and processing the input sequence
		String inp[] = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(inp[i]);
			for (int j = 0; j < i; j++) {
				if (A[j] < A[i])
					mem[i] = Math.max(mem[i], mem[j] + 1); // Updating the mem array to reflect the longest subsequence
															// length
			}
			if (mem[i] > hig) { // Updating hig and end if a longer subsequence is found
				hig = mem[i];
				end = i;
			}
		}

		// Writing the length of the longest increasing subsequence
		bw.write(hig + "\n");

		// Backtracking to find the elements of the longest increasing subsequence
		list.add(A[end]);
		for (int i = end; i >= 0; i--) {
			if (mem[i] == hig - 1) {
				list.add(A[i]);
				hig--;
			}
		}

		// Writing the elements of the longest increasing subsequence in reverse order
		for (int i = list.size() - 1; i >= 0; i--)
			bw.write(list.get(i) + " ");

		// Flushing and closing the BufferedWriter
		bw.flush();
		bw.close();
	}
}