package Dynamic_Programming;

/*
commented by ChatGPT
이 Java 코드는 3xN 크기의 벽을 2x1, 1x2 크기의 타일로 채우는 경우의 수를 계산합니다. 
동적 프로그래밍을 사용하여 효율적으로 문제를 해결합니다.
This Java code calculates the number of ways to fill a 3xN sized wall using 2x1 and 1x2 sized tiles. 
It efficiently solves the problem using dynamic programming.
*/

import java.io.*;

public class Q2133_TILE_G4 {

	static int dp[]; // 메모이제이션을 위한 배열 (Array for memoization)
	static boolean visited[]; // 해당 인덱스의 계산 여부를 확인하기 위한 배열 (Array to check if the calculation for an index is
								// done or not)

	static int recur(int idx) {

		// 이미 계산된 idx 값일 경우 바로 반환 (If the value for idx is already calculated, return
		// it)
		if (visited[idx])
			return dp[idx];
		else {
			visited[idx] = true;
			// 타일링 방법 계산 (Calculate tiling ways)
			dp[idx] = recur(idx - 2) * 3;
			for (int i = idx - 4; i >= 0; i -= 2) {
				dp[idx] += recur(i) * 2;
			}
			return dp[idx];
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];
		visited = new boolean[n + 1];
		dp[0] = 1; // 기본값 설정 (Set the base value)
		visited[0] = true;

		// n이 홀수일 경우 타일로 채울 수 없으므로 0 출력 (If n is odd, output 0 since it's not possible
		// to fill with tiles)
		if (n % 2 != 0)
			bw.write("0");
		else
			bw.write(recur(n) + ""); // 3xN 크기 벽을 타일로 채우는 방법의 수 출력 (Output the number of ways to fill the 3xN wall
										// with tiles)

		bw.flush();
		bw.close();
	}
}
