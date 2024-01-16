package Prefix_Sum;

/*
commented by ChatGPT
This Java code solves a problem where it finds the smallest length of a contiguous subarray in an array of N integers whose sum is greater than or equal to a given number S. 
It uses a sliding window approach to efficiently find the subarray. 
The code iterates through the array, continuously adding elements to the sum and expanding the window. 
When the sum becomes greater than or equal to S, it contracts the window from the left side to find the smallest possible subarray that meets the condition. 
The length of this subarray is stored as the result (res). If no such subarray is found, the code outputs 0.

이 Java 코드는 N개의 정수 배열에서 주어진 수 S 이상의 합을 갖는 연속된 부분 배열의 최소 길이를 찾는 문제를 해결합니다. 
효율적으로 부분 배열을 찾기 위해 슬라이딩 윈도우 방식을 사용합니다. 코드는 배열을 순회하며 요소를 지속적으로 합에 더하고 윈도우를 확장합니다. 
합이 S 이상이 되면 왼쪽에서부터 윈도우를 축소하여 조건을 만족하는 가능한 가장 작은 부분 배열을 찾습니다. 이 부분 배열의 길이는 결과(res)로 저장됩니다. 
이러한 부분 배열이 없으면 코드는 0을 출력합니다.
*/

import java.io.*;
import java.util.*;

public class Q1806_Partial_G4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[];
		int N, S;
		int sum = 0;
		int idx = 0;
		int st = 0;
		int res = 100001; // 초기 결과 값을 큰 수로 설정
		int list[];

		inp = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]); // 배열의 크기
		S = Integer.parseInt(inp[1]); // 목표 합
		list = new int[N];

		inp = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(inp[i]);
			sum += list[i];
			idx++;
			if (sum >= S) {
				while (sum >= S) {
					sum -= list[st];
					st++;
					idx--;
				}
				st--;
				sum += list[st];
				idx++;
				if (res > idx) // 최소 길이 갱신
					res = idx;
			}
		}

		if (res > 100000) // 조건을 만족하는 부분 배열이 없는 경우
			bw.write("0");
		else
			bw.write(res + "");
		bw.flush();
		bw.close();
	}
}