package Dynamic_Programming;

/*
commented by ChatGPT
This Java code solves the problem of finding the minimum number of operations required to reduce a given number X to 1. 
The operations allowed are division by 3, division by 2, or subtraction by 1. 
It implements a depth-first search (DFS) strategy to explore all possible sequences of operations and uses dynamic programming to avoid recalculating the number of operations for the same number. 
The code also tracks the sequence of operations leading to the minimum number of steps.
이 Java 코드는 주어진 수 X를 1로 줄이기 위해 필요한 최소 연산 횟수를 찾는 문제를 해결합니다. 허용된 연산은 3으로 나누기, 2로 나누기 또는 1을 빼기입니다. 
코드는 모든 가능한 연산 시퀀스를 탐색하기 위해 깊이 우선 탐색(DFS) 전략을 구현하며, 동일한 숫자에 대한 연산 횟수를 재계산하지 않도록 동적 프로그래밍을 사용합니다. 
또한, 최소 단계로 이어지는 연산 시퀀스를 추적합니다.
*/

import java.io.*;
import java.util.*;
import java.math.*;

public class Q12852_1_2_S1 {

	static int visited[] = new int[1000001]; // Stores the minimum number of steps to reach each number
	static ArrayList<Integer> seq = new ArrayList<>(); // Tracks the sequence of numbers leading to 1
	static int X; // The initial number to be reduced to 1

	// Recursive function implementing the depth-first search (DFS) with dynamic
	// programming
	static void dp(int cur, int idx) {
		if (cur == 1) { // Base case: if current number is 1, record the step count
			visited[1] = idx;
			return;
		}
		// Pruning: skip if current path has more steps than already found or if already
		// visited with fewer steps
		if (visited[cur] <= idx || idx >= visited[1])
			return;

		// Record the number of steps for the current number
		visited[cur] = idx;
		// Recursively explore all possible operations
		if (cur % 6 == 0) { // If divisible by 6, try division by 3, division by 2, and subtraction by 1
			dp(cur / 3, idx + 1);
			dp(cur / 2, idx + 1);
			dp(cur - 1, idx + 1);
		} else if (cur % 3 == 0) { // If divisible by 3, try division by 3 and subtraction by 1
			dp(cur / 3, idx + 1);
			dp(cur - 1, idx + 1);
		} else if (cur % 2 == 0) { // If divisible by 2, try division by 2 and subtraction by 1
			dp(cur / 2, idx + 1);
			dp(cur - 1, idx + 1);
		} else { // Otherwise, only subtraction by 1 is possible
			dp(cur - 1, idx + 1);
		}
	}

	// Function to reconstruct the sequence of operations leading to 1
	static void find(int cur) {
		seq.add(cur); // Add the current number to the sequence
		if (cur == X) // If the sequence has reached the initial number, stop
			return;

		// Choose the next number based on the operation that leads to the current
		// number with minimum steps
		if (visited[cur + 1] == visited[cur] - 1)
			find(cur + 1);
		else if (visited[cur * 2] == visited[cur] - 1)
			find(cur * 2);
		else if (visited[cur * 3] == visited[cur] - 1)
			find(cur * 3);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Arrays.fill(visited, 1000001); // Initialize the visited array with a large number
		int res;

		X = Integer.parseInt(br.readLine()); // Read the initial number
		dp(X, 0); // Start the DFS from the initial number

		bw.write(visited[1] + "\n"); // Write the minimum number of steps to reach 1
		find(1); // Reconstruct the sequence of numbers
		for (int i = seq.size() - 1; i >= 0; i--) // Write the sequence in reverse order
			bw.write(seq.get(i) + " ");
		bw.flush();
		bw.close();
	}
}
