package Data_Structures;

/*
commented by ChatGPT
This Java code implements Segment Trees to efficiently find minimum and maximum values in a given range of an array. 
Segment Trees are a data structure that stores information about array segments, allowing for faster queries. 
The code constructs two Segment Trees: one for finding the minimum (mintree) and one for finding the maximum (maxtree) in a range. 
It supports updating the range and querying the minimum and maximum values within any given range with less computational complexity compared to linear search methods.
이 Java 코드는 배열의 주어진 범위 내에서 최소값과 최대값을 효율적으로 찾기 위해 세그먼트 트리를 구현합니다. 
세그먼트 트리는 배열 세그먼트에 대한 정보를 저장하는 데이터 구조로, 더 빠른 쿼리를 가능하게 합니다. 
코드는 범위 내에서 최소값(min tree)과 최대값(max tree)을 찾기 위한 두 개의 세그먼트 트리를 구성합니다. 
선형 검색 방법에 비해 더 적은 계산 복잡성으로 범위를 업데이트하고 주어진 범위 내에서 최소값과 최대값을 쿼리하는 것을 지원합니다.
*/

import java.io.*;
import java.util.*;
import java.math.*;

public class Q2357_MinMax_G1 {

	static int N, M; // N is the number of elements in the array, M is the number of queries
	static int arr[]; // Array to store the actual values
	static int mintree[]; // Segment tree for minimum values
	static int maxtree[]; // Segment tree for maximum values
	static int a, b; // Variables to store the range for the query

// Function to create the segment tree for minimum values
	static int create_min(int node, int s, int e) {
		if (s == e) { // Base case: If the segment is a single element
			mintree[node] = arr[s];
			return arr[s];
		}
		int m = (s + e) / 2;
		// Recursively build the left and right parts of the segment tree and store the
		// minimum
		mintree[node] = Math.min(create_min(node * 2, s, m), create_min((node * 2) + 1, m + 1, e));
		return mintree[node];
	}

// Function to create the segment tree for maximum values
	static int create_max(int node, int s, int e) {
		if (s == e) {
			maxtree[node] = arr[s];
			return arr[s];
		}
		int m = (s + e) / 2;
		// Recursively build the left and right parts of the segment tree and store the
		// maximum
		maxtree[node] = Math.max(create_max(node * 2, s, m), create_max((node * 2) + 1, m + 1, e));
		return maxtree[node];
	}

// Function to query the minimum value in a given range
	static int get_min(int node, int s, int e) {
		if (a > e || b < s) // If the queried range is outside the current segment
			return Integer.MAX_VALUE;
		if (a <= s && b >= e) // If the current segment is completely within the queried range
			return mintree[node];
		int m = (s + e) / 2;
		// Recursively query the left and right parts of the segment tree and return the
		// minimum
		return Math.min(get_min(node * 2, s, m), get_min((node * 2) + 1, m + 1, e));
	}

// Function to query the maximum value in a given range
	static int get_max(int node, int s, int e) {
		if (a > e || b < s)
			return Integer.MIN_VALUE;
		if (a <= s && b >= e)
			return maxtree[node];
		int m = (s + e) / 2;
		return Math.max(get_max(node * 2, s, m), get_max((node * 2) + 1, m + 1, e));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[];
		inp = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]);
		M = Integer.parseInt(inp[1]);

		arr = new int[N + 1];
		mintree = new int[4 * N]; // Allocating size based on the heuristic for segment tree size
		maxtree = new int[4 * N];

		// Reading the values into the array
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// Building the segment trees for minimum and maximum queries
		create_min(1, 1, N);
		create_max(1, 1, N);

		// Processing each query
		for (int i = 0; i < M; i++) {
			inp = br.readLine().split(" ");
			a = Integer.parseInt(inp[0]);
			b = Integer.parseInt(inp[1]);
			// Writing the result of minimum and maximum queries to the output
			bw.write(get_min(1, 1, N) + " " + get_max(1, 1, N) + "\n");
		}

		bw.flush();
		bw.close();
	}
}
