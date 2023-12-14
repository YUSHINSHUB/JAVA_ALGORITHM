package Backtracking;

/*
commented by ChatGPT
This Java code generates all possible sequences of length M from 1 to N using backtracking. The sequences are printed with each element separated by a space.
이 Java 코드는 백트래킹을 사용하여 1부터 N까지의 숫자로 만들 수 있는 모든 길이 M의 순열을 생성합니다. 각 요소는 공백으로 구분하여 출력됩니다.
*/

import java.io.*;
import java.util.*;

public class Q15651_NM_3_S3 {

	static int N; // The range of numbers to use for sequences
	static int M; // The length of each sequence
	static Deque<Integer> out = new LinkedList<>(); // A deque to store and manipulate the current sequence
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // For efficient output

	// Backtracking method to generate all sequences
	static void bt(int idx) throws IOException {
		if (idx == M) { // Base case: if the current sequence length is M
			for (int i = 1; i <= M; i++) { // Iterate through the sequence
				bw.write(out.getFirst() + " "); // Write the first element to the buffer
				out.addLast(out.pollFirst()); // Rotate the deque to get the next element
			}
			bw.write("\n"); // After printing a sequence, write a newline character
			return; // Return to explore other possibilities
		}

		for (int i = 1; i <= N; i++) { // Iterate from 1 to N
			out.addLast(i); // Add the current number to the end of the deque
			bt(idx + 1); // Recursively call bt() to add the next number
			out.pollLast(); // Remove the last element to backtrack
		}

	}

	// Main method
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // For efficient input

		String inp[] = br.readLine().split(" "); // Read the input line and split by space

		N = Integer.parseInt(inp[0]); // Parse the first part of input to N
		M = Integer.parseInt(inp[1]); // Parse the second part of input to M

		bt(0); // Call the backtracking method starting with index 0

		bw.flush(); // Flush the buffer to ensure all output is written
		bw.close(); // Close the BufferedWriter

	}

}
