package Sorting;

/*
commented by ChatGPT
This Java code solves the problem of determining the minimum number of water tape needed to water all plants in a line. 
Given N plants positioned along a line at specific points and a water tape of length L, the program calculates the minimum number of tapes required to cover all the positions of the plants. 
It uses a PriorityQueue to sort the plants based on their positions. 
For each plant, it places a tape covering up to L-1 positions ahead of the current plant's position and then removes all plants covered by this tape. 
The process repeats until all plants are covered. The final count of tapes used is outputted.
이 Java 코드는 한 줄에 배열된 N개의 식물을 특정 길이 L의 물 호스를 사용하여 모든 식물에 물을 주기 위해 필요한 최소 호스 수를 결정하는 문제를 해결합니다. 
식물들의 위치에 따라 정렬하기 위해 PriorityQueue를 사용합니다. 각 식물에 대해, 현재 식물의 위치로부터 L-1 위치까지 커버하는 호스를 배치하고 이 호스에 의해 커버된 모든 식물을 제거합니다. 
이 과정은 모든 식물이 커버될 때까지 반복됩니다. 사용된 호스의 최종 수를 출력합니다.
*/

import java.io.*;
import java.util.*;

public class Q1449_Engineer_S3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		PriorityQueue<Integer> pq = new PriorityQueue<>(); // PriorityQueue to hold plant positions in ascending order.
		int N, L, cur, res = 0; // N: Number of plants, L: Length of the water tape, cur: Current position, res:
								// Result (number of tapes needed).
		String inp[];

		inp = br.readLine().split(" "); // Reading input for N and L.
		N = Integer.parseInt(inp[0]); // Number of plants.
		L = Integer.parseInt(inp[1]); // Length of the water tape.

		inp = br.readLine().split(" "); // Reading positions of all plants.
		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(inp[i])); // Adding each plant's position to the PriorityQueue.
		}

		while (!pq.isEmpty()) { // Loop until all plants are covered.
			cur = pq.poll() + L - 1; // Current position plus length of the tape minus one.
			res++; // Incrementing the number of tapes used.
			if (pq.isEmpty()) // If no more plants need to be covered, break out of the loop.
				break;
			while (!pq.isEmpty() && pq.peek() <= cur) { // Remove all plants covered by the current tape.
				pq.poll(); // Removing the covered plant's position from the PriorityQueue.
			}
		}

		bw.write(res + ""); // Writing the result to the output.
		bw.flush(); // Flushing the BufferedWriter.
		bw.close(); // Closing the BufferedWriter.
	}
}
