package Priority_Queue;

/*
commented by ChatGPT
This Java code implements a number streaming system where each new number is read and the median of all read numbers is printed after each insertion. 
The program utilizes two priority queues to maintain the lower half and upper half of the numbers. 
The 'max' priority queue holds the lower half and orders them in decreasing order, whereas the 'min' priority queue holds the upper half and orders them in increasing order. 
The program ensures that the two halves are either equal in size or differ by one element, allowing efficient computation of the median after each insertion. 
The approach of using two priority queues ensures that the median can be determined in O(log n) time for each new number, providing a time-efficient solution for streaming data.

이 Java 코드는 새로운 숫자를 읽을 때마다 모든 읽은 숫자의 중앙값을 출력하는 숫자 스트리밍 시스템을 구현합니다. 
프로그램은 두 개의 우선순위 큐를 사용하여 숫자의 하위 절반과 상위 절반을 유지합니다. 
'max' 우선순위 큐는 숫자의 하위 절반을 보관하며 내림차순으로 정렬하고, 'min' 우선순위 큐는 숫자의 상위 절반을 보관하며 오름차순으로 정렬합니다. 
프로그램은 두 절반의 크기가 동일하거나 하나의 요소로 차이가 나도록 보장하여 각 삽입 후 중앙값을 효율적으로 계산합니다. 
두 우선순위 큐를 사용하는 접근 방식은 각 새로운 숫자에 대해 O(log n) 시간 안에 중앙값을 결정할 수 있도록 하여 스트리밍 데이터에 대해 시간 효율적인 솔루션을 제공합니다.
*/

import java.io.*;
import java.util.*;

public class Q1655_Middle_G2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Priority queues to store the lower half and upper half of numbers
		PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder()); // Max-heap for lower half
		PriorityQueue<Integer> min = new PriorityQueue<>(); // Min-heap for upper half
		int N, in;

		N = Integer.parseInt(br.readLine()); // Total number of elements to read
		in = Integer.parseInt(br.readLine()); // First input element
		max.add(in); // Adding the first element to the max-heap
		bw.write(in + "\n"); // Writing the first median

		for (int i = 1; i < N; i++) {
			in = Integer.parseInt(br.readLine()); // Reading new element
			// Balancing the heaps based on the sizes and the new element
			if (max.size() == min.size()) {
				if (min.peek() < in) {
					max.add(min.poll());
					min.add(in);
				} else {
					max.add(in);
				}
				bw.write(max.peek() + "\n"); // Writing the median
			} else {
				if (in < max.peek()) {
					min.add(max.poll());
					max.add(in);
				} else {
					min.add(in);
				}
				// Choosing the median based on the top elements of the heaps
				if (max.peek() > min.peek()) {
					bw.write(min.peek() + "\n");
				} else {
					bw.write(max.peek() + "\n");
				}
			}
		}

		bw.flush();
		bw.close();
	}
}