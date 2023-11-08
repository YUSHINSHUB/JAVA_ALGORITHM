package Prefix_Sum;

/*
commented by ChatGPT
This Java code calculates the number of subarrays in an array that sum to a multiple of M. 
It reads N (the size of the array) and M from the input, and then the array elements. 
The algorithm involves finding the sum of elements modulo M and using a combination formula to count subarrays that have a cumulative sum that is divisible by M.
이 Java 코드는 배열 내에서 합이 M의 배수인 서브 배열의 수를 계산합니다. 
입력으로부터 N(배열의 크기)과 M을 읽은 다음, 배열 요소들을 읽습니다. 
알고리즘은 요소들의 합을 M으로 나눈 나머지를 찾고, 누적 합이 M으로 나누어 떨어지는 서브 배열을 계산하기 위해 조합 공식을 사용합니다.
*/

import java.io.*;
import java.util.*;

public class Q10986_Modulo_Sum_G3 {

	// Function to calculate nCr (조합을 계산하는 함수)
	static long combination(int n, int r) {
		long out = 1;
		// Calculate n! / (n-r)! part (n! / (n-r)! 부분을 계산)
		for (long i = n - r + 1; i <= n; i++) {
			out *= i;
		}
		// Divide by r! (r!로 나누기)
		for (int i = 2; i <= r; i++) {
			out /= i;
		}
		return out;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read the values for N and M (N과 M의 값을 읽기)
		String inp[] = br.readLine().split(" ");
		int N = Integer.parseInt(inp[0]); // Array size (배열 크기)
		int M = Integer.parseInt(inp[1]); // Modulo value (모듈로 값)
		int sum = 0; // Sum of elements modulo M (요소들의 합의 모듈로 M)
		long res = 0; // Number of subarrays with sum divisible by M (합이 M으로 나누어 떨어지는 서브 배열의 수)

		// Array to keep track of modulo counts (모듈로 카운트를 추적하는 배열)
		int cnt[] = new int[M];
		Arrays.fill(cnt, 0);

		// Read array elements (배열 요소 읽기)
		inp = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			// Update sum modulo M and count (합 모듈로 M과 카운트 업데이트)
			sum = (sum + Integer.parseInt(inp[i])) % M;
			cnt[sum]++;
		}

		// Add the number of subarrays starting at the beginning (시작점에서 서브 배열의 수 추가)
		res += cnt[0];
		for (int i = 0; i < M; i++) {
			// Add combinations of counts (카운트의 조합 추가)
			if (cnt[i] > 1) {
				res += combination(cnt[i], 2);
			}
		}

		// Write the result (결과 쓰기)
		bw.write(res + "");

		bw.flush();
		bw.close();
	}
}
