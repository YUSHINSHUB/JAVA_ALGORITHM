package Greedy;

/*
commented by ChatGPT
This Java code is designed to calculate the minimum cost required to merge all given numbers into one by always summing the two smallest numbers. 
The merging cost for each step is the sum of the two numbers being merged, and the goal is to minimize the total merging cost. 
The main logic uses a priority queue to always select the two smallest numbers for the merging process.
이 Java 코드는 주어진 숫자들을 항상 두 개의 가장 작은 숫자를 합하여 하나로 병합하는데 필요한 최소 비용을 계산하기 위해 설계되었습니다. 
각 단계에서의 병합 비용은 병합되는 두 숫자의 합이며, 전체 병합 비용을 최소화하는 것이 목표입니다. 
주요 로직은 병합 과정에서 항상 두 개의 가장 작은 숫자를 선택하기 위해 우선순위 큐를 사용합니다.
*/

import java.io.*;
import java.util.*;

public class Q1715_Sort_Cards_G4 {

	public static void main(String[] args) throws IOException {

		// Setting up I/O tools for console-based input and output
		// 콘솔 기반의 입력 및 출력을 위한 I/O 도구 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Reading the number of integers to be merged
		// 병합할 정수의 개수를 읽어옵니다.
		int N = Integer.parseInt(br.readLine());
		int res = 0; // Variable to store the total merging cost (전체 병합 비용을 저장하기 위한 변수)

		// Priority Queue to always get the smallest numbers in O(logN) time
		// O(logN) 시간 내에 항상 가장 작은 숫자를 얻기 위한 우선순위 큐
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		// Populating the Priority Queue with the numbers
		// 우선순위 큐에 숫자들을 넣습니다.
		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}

		// Keep merging the two smallest numbers until only one number is left in the
		// queue
		// 큐에 하나의 숫자만 남을 때까지 두 개의 가장 작은 숫자를 계속 병합합니다.
		while (pq.size() > 1) {
			int a = pq.poll(); // Extracting the smallest number (가장 작은 숫자 추출)
			int b = pq.poll(); // Extracting the second smallest number (두 번째로 작은 숫자 추출)

			a += b; // Merging the two numbers (두 숫자 병합)
			res += a; // Adding the merging cost to the total cost (병합 비용을 전체 비용에 추가)
			pq.add(a); // Inserting the merged number back into the queue (병합된 숫자를 큐에 다시 삽입)

		}

		// Outputting the total merging cost
		// 전체 병합 비용을 출력합니다.
		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}