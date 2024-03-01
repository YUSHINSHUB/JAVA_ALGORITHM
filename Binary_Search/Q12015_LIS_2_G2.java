package Binary_Search;

/*
commented by ChatGPT
This Java code implements an algorithm to find the length of the longest increasing subsequence (LIS) in a given sequence of integers. 
The input sequence is read from standard input, and the length of the LIS is written to standard output. 
The algorithm uses dynamic programming and binary search techniques to efficiently compute the LIS length. 
It maintains an array res to store the smallest possible tail for all increasing subsequences of all possible lengths.

이 Java 코드는 주어진 정수 시퀀스에서 가장 긴 증가하는 부분 수열(LIS)의 길이를 찾는 알고리즘을 구현합니다. 
입력 시퀀스는 표준 입력에서 읽고, LIS의 길이는 표준 출력으로 작성됩니다. 알고리즘은 LIS 길이를 효율적으로 계산하기 위해 동적 프로그래밍 및 이진 검색 기술을 사용합니다. 
모든 가능한 길이의 모든 증가하는 부분 수열에 대해 가능한 가장 작은 꼬리를 저장하기 위해 res 배열을 유지합니다.
*/

import java.io.*;
import java.util.*;
import java.math.*;

public class Q12015_LIS_2_G2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[];
		int N = Integer.parseInt(br.readLine()); // Reading the size of the sequence
		int sequence[] = new int[1000001]; // Array to store the sequence
		int res[] = new int[1000001]; // Array to store the ends of the longest increasing subsequences
		int idx = 1; // Index for the 'res' array

		Arrays.fill(sequence, 0); // Initializing the sequence array
		inp = br.readLine().split(" "); // Reading the sequence from input

		// Filling the sequence array
		for (int i = 0; i < N; i++)
			sequence[i] = Integer.parseInt(inp[i]);
		res[0] = sequence[0]; // Initializing the first element of 'res' array

		// Loop through the sequence to find LIS
		for (int i = 1; i < N; i++) {
			if (sequence[i] > res[idx - 1]) { // If current element extends the LIS
				res[idx] = sequence[i];
				idx++;
				continue;
			}
			// Binary search to find the position of the current element in 'res'
			int low = 0;
			int high = idx;
			int mid = high / 2;

			while (low < high) {
				if (res[mid] < sequence[i]) {
					low = mid + 1;
					mid = (low + high) / 2;
				} else {
					high = mid;
					mid = (low + high) / 2;
				}
			}
			res[low] = sequence[i]; // Update the 'res' array with the current element
		}

		bw.write(idx + ""); // Write the length of the LIS to the output
		bw.flush();
		bw.close();
	}
}