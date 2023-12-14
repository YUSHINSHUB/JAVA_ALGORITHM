package Backtracking;

/*
commented by ChatGPT
This Java code generates all non-decreasing sequences of length M from 1 to N using backtracking. The sequences are printed with each element separated by a space.
이 Java 코드는 백트래킹을 사용하여 1부터 N까지의 숫자로 만들 수 있는 모든 비감소하는 길이 M의 순열을 생성합니다. 각 요소는 공백으로 구분하여 출력됩니다.
*/

import java.io.*;
import java.util.*;

public class Q15652_NM_4_S3 {

	static int N; // The range of numbers to use for sequences
	static int M; // The length of each sequence
	static Deque<Integer> out = new LinkedList<>(); // A deque to store and manipulate the current sequence
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // For efficient output

	// Backtracking method to generate all non-decreasing sequences
	static void bt(int idx, int cur) throws IOException {
		if (idx == M) { // Base case: if the current sequence length is M
			for (int i = 1; i <= M; i++) { // Iterate through the sequence
				bw.write(out.getFirst() + " "); // Write the first element of the deque followed by a space
				out.addLast(out.pollFirst()); // Rotate the deque to access elements in correct order
			}
			bw.write("\n"); // After writing a sequence, insert a newline character
			return; // Return to explore other possibilities
		}

		for (int i = cur; i <= N; i++) { // Iterate from the current number to N
			out.addLast(i); // Add the current number to the end of the deque
			bt(idx + 1, i); // Recursively call bt() to add the next number, ensuring non-decreasing order
			out.pollLast(); // Remove the last element to backtrack
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // For efficient input

		String[] inp = br.readLine().split(" "); // Read input and split by space

		N = Integer.parseInt(inp[0]); // Parse N from input
		M = Integer.parseInt(inp[1]); // Parse M from input

		bt(0, 1); // Start the backtracking process with index 0 and current number 1

		bw.flush(); // Flush the buffer
		bw.close(); // Close the BufferedWriter

	}

}
