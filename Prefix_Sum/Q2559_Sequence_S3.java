package Prefix_Sum;

/*
commented by ChatGPT
This Java program finds the maximum sum of consecutive K elements in a given sequence. It uses a sliding window approach to efficiently compute the sum as it moves through the sequence, avoiding redundant calculations.
이 Java 프로그램은 주어진 수열에서 연속하는 K개 요소의 최대 합을 찾습니다. 슬라이딩 윈도우 방식을 사용하여 수열을 효율적으로 탐색하면서 합을 계산하며, 중복 계산을 피합니다.
*/

import java.io.*;
import java.util.*;

public class Q2559_Sequence_S3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		int N, K;
		int cur = 0;
		int front = 0;
		int res = 0;

		N = Integer.parseInt(inp[0]);
		K = Integer.parseInt(inp[1]);
		inp = br.readLine().split(" ");

		for (int i = 0; i < K; i++) {
			cur += Integer.parseInt(inp[i]);
			res = cur; // Initialize result with the sum of the first K elements
		}

		for (int i = K; i < N; i++) {
			cur -= Integer.parseInt(inp[front]);
			cur += Integer.parseInt(inp[i]);
			front++;
			res = Math.max(res, cur); // Update result with the maximum sum encountered
		}

		bw.write(res + ""); // Output the final result
		bw.flush();
		bw.close();

	}

}
