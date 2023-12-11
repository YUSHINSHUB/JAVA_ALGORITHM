package Data_Structures;

/*
commented by ChatGPT
This Java code implements a solution for finding the N-th largest element in a NxN matrix. 
The matrix's elements are read from standard input. 
It uses a max priority queue (a binary heap) to keep track of the largest elements seen so far. 
After inserting all elements into the queue, the first N-1 largest elements are removed, leaving the N-th largest element at the top of the queue.
이 Java 코드는 NxN 행렬에서 N번째로 큰 요소를 찾는 해결책을 구현합니다. 
행렬의 요소들은 표준 입력에서 읽어집니다. 
이 코드는 지금까지 본 가장 큰 요소들을 추적하기 위해 최대 우선순위 큐(이진 힙)를 사용합니다. 
모든 요소들을 큐에 삽입한 후, 첫 번째 N-1 개의 가장 큰 요소들을 제거하고, N번째로 큰 요소가 큐의 상단에 남습니다.
*/

import java.io.*;
import java.util.*;

public class Q2075_Nth_S2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N; // Size of the matrix
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // Max priority queue

		N = Integer.parseInt(br.readLine()); // Read the size of the matrix

		// Reading matrix elements and adding them to the priority queue
		for (int i = 0; i < N; i++) {
			String inp[] = br.readLine().split(" ");
			for (int j = 0; j < N; j++)
				pq.add(Integer.parseInt(inp[j])); // Add each element to the queue
		}

		// Polling the first N-1 largest elements from the queue
		for (int i = 0; i < N - 1; i++) {
			pq.poll(); // Remove the largest element
		}

		bw.write(pq.poll() + ""); // The next element in the queue is the N-th largest
		bw.flush(); // Flush the BufferedWriter
		bw.close(); // Close the BufferedWriter

	}
}