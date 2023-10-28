package Binary_Search;

/*
commented by ChatGPT
This Java code aims to find the number of integers in an array that can be represented as the sum of two distinct integers from the same array. 
이 Java 코드는 배열 내의 정수 중 두 개의 다른 정수의 합으로 표현될 수 있는 정수의 개수를 찾는 것을 목적으로 합니다.
*/

import java.io.*;
import java.util.*;

public class Q1253_GOOD_G4 {

	public static void main(String[] args) throws IOException {

		// Initialization of buffered readers and writers for I/O operations (입출력 작업을 위한
		// 버퍼리더 및 버퍼라이터 초기화)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine()); // Number of integers in the array (배열 내의 정수 개수)
		int nums[] = new int[N]; // Array to store integers (정수를 저장할 배열)
		int res = 0; // Result variable to count the valid numbers (유효한 숫자를 계산하기 위한 결과 변수)

		// Reading the array of integers (정수 배열 읽기)
		String inp[] = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(inp[i]);
		}

		Arrays.sort(nums); // Sorting the array for efficient processing (효율적인 처리를 위해 배열 정렬)

		// Checking each integer in the array (배열 내의 각 정수 확인)
		for (int i = 0; i < N; i++) {
			int s = 0; // Start index for searching (검색을 위한 시작 인덱스)
			int e = N - 1; // End index for searching (검색을 위한 끝 인덱스)
			while (true) {
				// Skipping the current index to avoid using the same number twice (동일한 숫자를 두 번
				// 사용하지 않도록 현재 인덱스 건너뛰기)
				if (s == i)
					s++;
				if (e == i)
					e--;

				// Exit loop if start index exceeds or equals the end index (시작 인덱스가 끝 인덱스를
				// 초과하거나 같으면 루프 종료)
				if (s >= e)
					break;

				// If a valid pair is found, increment the result and exit loop (유효한 쌍이 발견되면 결과
				// 증가시키고 루프 종료)
				if (nums[s] + nums[e] == nums[i]) {
					res++;
					break;
				}
				// Adjusting start or end index based on the sum comparison (합 비교에 기초하여 시작 또는 끝
				// 인덱스 조정)
				else if (nums[s] + nums[e] < nums[i])
					s++;
				else
					e--;
			}
		}

		// Writing the final result to the output (최종 결과를 출력에 작성)
		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}
