package Binary_Search;

/*
commented by ChatGPT
This Java code implements a binary search algorithm to find the kth smallest number in an N×N multiplication table. 
The algorithm starts with a range defined by low (1) and hig (k) and repeatedly narrows down this range based on the position of mid in the sorted list of numbers in the multiplication table. 
For each mid, it calculates the number of elements less than or equal to mid and adjusts the search range accordingly. 
If the count is less than k, it means mid is too small, so it moves low up. 
If the count is greater than or equal to k, it means mid could be the answer, so it moves hig down while keeping res as the current mid. 
The process repeats until the correct value is found.
이 Java 코드는 N×N 곱셈 테이블에서 k번째로 작은 숫자를 찾기 위해 이진 탐색 알고리즘을 구현합니다. 
알고리즘은 low (1)와 hig (k)로 정의된 범위에서 시작하여, 곱셈 테이블의 정렬된 숫자 목록에서 mid의 위치에 따라 이 범위를 반복적으로 좁혀갑니다. 
각 mid에 대해 mid 이하의 원소 개수를 계산하고 검색 범위를 그에 맞게 조정합니다. 개수가 k보다 작으면 mid가 너무 작다는 의미이므로 low를 올립니다. 
개수가 k 이상이면 mid가 정답일 수 있으므로 hig를 내리면서 res를 현재 mid로 유지합니다. 정확한 값이 찾아질 때까지 이 과정을 반복합니다.
*/

import java.io.*;
import java.util.*;
import java.math.*;

public class Q1300_Kth_G1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N, k; // N: 곱셈 테이블의 크기, k: 찾고자 하는 숫자의 순서
		int low, mid, hig; // 이진 탐색을 위한 변수: low, mid, hig
		int res = 0; // 결과값을 저장할 변수

		N = Integer.parseInt(br.readLine()); // N 입력 받기
		k = Integer.parseInt(br.readLine()); // k 입력 받기

		low = 1;
		hig = k;
		mid = (low + hig) / 2;

		while (true) {
			if (low > hig)
				break;
			mid = (low + hig) / 2;

			int temp = 0; // mid 이하의 숫자 개수를 저장할 변수
			for (int i = 1; i <= N; i++) {
				temp += Math.min(mid / i, N);
				if (temp > k)
					break;
			}

			// 이진 탐색 범위 조정
			if (temp < k) {
				low = mid + 1;
			} else {
				res = mid;
				hig = mid - 1;
			}
		}

		bw.write(res + ""); // 결과 출력

		bw.flush();
		bw.close();
	}
}