package Backtracking;

/*
commented by ChatGPT
This Java code implements a recursive backtracking algorithm to generate all possible sequences of length M from N given numbers, ensuring that each number is used at most once in each sequence. 
The bt function recursively constructs sequences, adding a new number at each step and ensuring that the same number is not reused within the same sequence. 
Once a sequence of length M is formed, it is written to the output. 
The nums array stores the given numbers, and mem keeps track of which numbers have been used in the current sequence. 
The program reads N and M, the numbers to be used, and outputs all possible sequences in sorted order.
이 Java 코드는 주어진 N개의 숫자에서 길이 M의 모든 가능한 시퀀스를 생성하기 위해 재귀적 백트래킹 알고리즘을 구현합니다. 
각 시퀀스에서 각 숫자는 최대 한 번만 사용됩니다. 
bt 함수는 재귀적으로 시퀀스를 구성하며, 각 단계에서 새로운 숫자를 추가하고 동일한 숫자가 같은 시퀀스 내에서 재사용되지 않도록 합니다. 
길이 M의 시퀀스가 형성되면 출력으로 작성됩니다. nums 배열은 주어진 숫자를 저장하며, mem은 현재 시퀀스에서 사용된 숫자를 추적합니다. 
프로그램은 N과 M, 사용할 숫자를 읽고 모든 가능한 시퀀스를 정렬된 순서로 출력합니다.
*/

import java.io.*;
import java.util.*;

public class Q15654_NM_5_S3 {

	static int N, M; // N: Total numbers, M: Length of each sequence (N: 전체 숫자 수, M: 각 시퀀스의 길이)
	static int nums[]; // Array to store the given numbers (주어진 숫자를 저장하는 배열)
	static boolean mem[]; // Array to keep track of used numbers in the current sequence (현재 시퀀스에서 사용된 숫자를
							// 추적하는 배열)
	static ArrayList<Integer> out = new ArrayList<>(); // List to construct each sequence (각 시퀀스를 구성하는 리스트)
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // BufferedWriter for output (출력을
																						// 위한 BufferedWriter)

// Recursive backtracking function to generate sequences (시퀀스를 생성하기 위한 재귀적 백트래킹 함수)
	static void bt(int idx) throws IOException {
		if (idx == M) { // If the sequence reaches the desired length (시퀀스가 원하는 길이에 도달하면)
			for (int i = 0; i < M; i++) { // Write the sequence to output (시퀀스를 출력으로 작성)
				bw.write(out.get(i) + " ");
			}
			bw.write("\n");
			return;
		}

		for (int i = 0; i < N; i++) { // Iterate over all numbers (모든 숫자에 대해 반복)
			if (mem[i]) // Skip if the number is already used in the current sequence (현재 시퀀스에서 이미 사용된
						// 경우 건너뛰기)
				continue;
			mem[i] = true; // Mark the number as used (숫자를 사용한 것으로 표시)
			out.add(nums[i]); // Add the number to the sequence (시퀀스에 숫자 추가)
			bt(idx + 1); // Recursive call to extend the sequence (시퀀스를 확장하기 위한 재귀 호출)
			out.remove(out.size() - 1); // Remove the last number to backtrack (백트래킹을 위해 마지막 숫자 제거)
			mem[i] = false; // Reset the used status (사용 상태 재설정)
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader for input (입력을 위한
																					// BufferedReader)

		String inp[] = br.readLine().split(" "); // Read N and M (N과 M 읽기)
		N = Integer.parseInt(inp[0]);
		M = Integer.parseInt(inp[1]);
		nums = new int[N]; // Initialize the array for numbers (숫자 배열 초기화)
		mem = new boolean[N]; // Initialize the used status array (사용 상태 배열 초기화)

		inp = br.readLine().split(" "); // Read the given numbers (주어진 숫자 읽기)
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(inp[i]);
		}
		Arrays.fill(mem, false); // Initially, no numbers are used (초기에는 아무 숫자도 사용되지 않음)
		Arrays.sort(nums); // Sort the numbers (숫자 정렬)
		bt(0); // Start backtracking (백트래킹 시작)
		bw.flush(); // Flush the BufferedWriter (BufferedWriter 플러시)
		bw.close(); // Close the BufferedWriter (BufferedWriter 닫기)
	}
}