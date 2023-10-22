package Sorting;

/*
commented by ChatGPT
This Java code calculates the result by considering two primary operations on a series of integers: addition and multiplication. 
The numbers are polled from priority queues and certain conditions determine whether numbers should be multiplied, added, or retained for further operations. 
By making optimal choices based on these conditions, the code tries to obtain the best possible result from the given input numbers.
이 Java 코드는 일련의 정수에 대해 덧셈과 곱셈이라는 두 가지 주요 연산을 고려하여 결과를 계산합니다. 
숫자는 우선순위 큐에서 추출되며 특정 조건에 따라 숫자를 곱하거나 더하거나 추가 연산을 위해 유지할지 결정됩니다. 
이러한 조건을 기반으로 최적의 선택을 하여 주어진 입력 숫자로부터 최선의 결과를 얻으려고 합니다.
*/

import java.io.*;
import java.math.*;
import java.util.*;

public class Q1744_Grouping_Numbers_G4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read the total number of integers.
		int N = Integer.parseInt(br.readLine());
		int res = 0;
		// Initialize a priority queue with reverse order to get the maximum number
		// first.
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		// Populate the priority queue with input numbers.
		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}

		// Main logic to decide whether to add or multiply numbers.
		while (!pq.isEmpty()) {
			int a, b;
			a = pq.poll(); // Get the maximum number.

			if (pq.isEmpty()) {
				res += a; // If only one number left, simply add it to the result.
				break;
			}

			b = pq.poll(); // Get the next maximum number.

			// If both numbers are greater than 1, their product would be larger than their
			// sum.
			if (a > 1 && b > 1) {
				res += a * b;
			} else {
				// Handle various other conditions that dictate how numbers should be processed.
				if (a >= 1 && b < 1) {
					res += a;
					pq.add(b); // Retain the number for further operations.
					break;
				} else if (b == 1) {
					res += a;
					res += b; // If any number is 1, adding it would yield a larger result than multiplying.
				} else if (a < 1) {
					pq.add(a); // Retain both numbers for further operations.
					pq.add(b);
					break;
				}
			}
		}

		// Process remaining numbers.
		if (!pq.isEmpty()) {
			PriorityQueue<Integer> pq2 = new PriorityQueue<>();
			while (!pq.isEmpty())
				pq2.add(pq.poll());

			// Multiply the numbers in ascending order.
			while (!pq2.isEmpty()) {
				int a, b;
				a = pq2.poll();

				if (pq2.isEmpty()) {
					res += a;
					break;
				}

				b = pq2.poll();
				res += a * b; // Multiply and add to result.
			}
		}

		// Write the final result.
		bw.write(res + "");

		bw.flush();
		bw.close();
	}
}