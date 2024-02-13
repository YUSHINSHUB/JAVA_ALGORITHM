package Dynamic_Programming;

/*
commented by ChatGPT
This Java code implements an algorithm to find the largest square of 1s in a binary matrix. 
It reads the matrix dimensions (N and M), then the matrix itself, and uses dynamic programming to calculate the area of the largest square that can be formed by 1s. 
The algorithm maintains a cumulative sum matrix to efficiently compute the sum of 1s in any submatrix, which helps to check if a square of a given size is entirely made up of 1s. 
The final result is the area of the largest such square.
이 Java 코드는 이진 행렬에서 1로 구성된 가장 큰 정사각형을 찾는 알고리즘을 구현합니다. 
행렬의 차원(N과 M)과 행렬 자체를 읽은 다음, 동적 프로그래밍을 사용하여 1로 구성된 가장 큰 정사각형의 면적을 계산합니다. 
알고리즘은 주어진 크기의 정사각형이 전적으로 1로 구성되어 있는지 확인하는 데 도움이 되는, 임의의 부분 행렬 내의 1의 합을 효율적으로 계산하기 위해 누적 합 행렬을 유지합니다. 
최종 결과는 이러한 가장 큰 정사각형의 면적입니다.
*/

import java.io.*;
import java.util.*;

public class Q1915_Square_G4 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N, M; // 행렬의 세로(N)와 가로(M) 크기를 저장하는 변수
		int sum[][] = new int[1001][1001]; // 각 지점까지의 1의 누적 합을 저장하는 2차원 배열
		int grid[][] = new int[1001][1001]; // 입력받은 행렬을 저장하는 2차원 배열

		int res = 0; // 가장 큰 정사각형의 한 변의 길이를 저장하는 변수
		String inp[];

		// 행렬의 크기를 입력받음
		inp = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]);
		M = Integer.parseInt(inp[1]);

		// 행렬의 0행과 0열을 0으로 초기화
		Arrays.fill(grid[0], 0);
		Arrays.fill(sum[0], 0);
		for (int i = 1; i <= N; i++) {
			Arrays.fill(grid[i], 0); // 각 행을 0으로 초기화, 실제 사용에는 불필요한 단계
			Arrays.fill(sum[i], 0); // 누적 합 배열의 각 행을 0으로 초기화, 이후 불필요하게 -1로 다시 초기화하는 부분이 있음
			String in = br.readLine();
			Arrays.fill(sum[i], -1); // 이 부분은 오류로 보임, 누적 합 계산에 영향을 줄 수 있음
			for (int j = 1; j <= M; j++) {
				grid[i][j] = Integer.parseInt(in.charAt(j - 1) + ""); // 행렬 데이터 입력
			}
		}

		// 누적 합 계산
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + grid[i][j];
			}
		}

		// 가장 큰 정사각형 찾기
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (grid[i][j] == 1) { // 현재 위치가 1인 경우
					int idx = 1; // 정사각형의 시작 크기
					while (i + idx <= N && j + idx <= M) { // 정사각형을 확장할 수 있는지 확인
						if (sum[i + idx][j + idx] - sum[i - 1][j + idx] - sum[i + idx][j - 1]
								+ sum[i - 1][j - 1] == (idx + 1) * (idx + 1)) {
							idx++; // 정사각형의 크기 증가
						} else
							break; // 확장 불가능한 경우 반복 종료
					}
					res = Math.max(res, idx); // 가장 큰 정사각형의 크기 갱신
				}
			}
		}

		bw.write((res * res) + ""); // 가장 큰 정사각형의 면적 출력
		bw.flush();
		bw.close();
	}
}