package Divide_and_Conquer;

/*
commented by ChatGPT
이 Java 코드는 행렬 제곱 문제를 해결합니다. 주어진 행렬을 입력된 수 만큼 제곱하여 그 결과를 출력하는 코드입니다.
이를 위해 이진수 표현법을 사용하여 입력된 수를 분해하고, 해당 숫자만큼 행렬을 제곱합니다. 이 방식을 통해 효율적으로 행렬 제곱을 계산할 수 있습니다.

This Java code solves the matrix exponentiation problem. It exponentiates a given matrix by a provided number and outputs the result.
It utilizes binary representation to decompose the provided number and exponentiates the matrix accordingly. This approach allows for efficient matrix exponentiation.
*/

import java.io.*;
import java.math.*;
import java.util.*;

public class Q10830_Squaring_Matrix_G4 {

	static int res[][] = new int[6][6]; // 최종 결과 행렬 (Final result matrix)
	static int tr[][] = new int[6][6]; // 임시 결과 행렬 (Temporary result matrix)

// 주어진 두 행렬을 곱하는 함수 (Function to multiply two given matrices)
	public static void calc(int[][] mat, int[][] t, int n) {
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				temp = 0;
				for (int k = 0; k < n; k++) {
					temp += (t[i][k] * mat[k][j]) % 1000;
				}
				tr[i][j] = temp % 1000; // 결과는 1000으로 나눈 나머지 (Results are modulo 1000)
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n;
		long b;

		String in[] = br.readLine().split(" ");

		n = Integer.parseInt(in[0]);
		b = Long.parseLong(in[1]);

		int mat[][] = new int[n][n]; // 초기 행렬 (Initial matrix)
		int t[][] = new int[n][n]; // 임시 행렬 (Temporary matrix)
		int tt[][] = new int[n][n]; // 추가 임시 행렬 (Additional temporary matrix)

		// 행렬 입력 (Matrix input)
		for (int i = 0; i < n; i++) {
			in = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				mat[i][j] = Integer.parseInt(in[j]);
				res[i][j] = mat[i][j];
				t[i][j] = mat[i][j];
				tt[i][j] = mat[i][j];
			}
		}

		// b가 1인 경우, 원래 행렬을 출력 (If b is 1, print the original matrix)
		if (b == 1) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					bw.write(mat[i][j] % 1000 + " ");
				bw.write("\n");
			}
		} else {
			// 이진 표현을 사용한 행렬 제곱 계산 (Matrix exponentiation using binary representation)
			int cnt = (int) (Math.log(b) / Math.log(2));
			b -= Math.pow(2, cnt);

			for (int i = 0; i < cnt; i++) {
				calc(t, tt, n); // 행렬 곱하기 (Matrix multiplication)
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < n; k++) {
						t[j][k] = tr[j][k];
						tt[j][k] = tr[j][k];
					}
				}
			}

			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					res[j][k] = tr[j][k];
				}
			}

			while (b > 1) {
				cnt = (int) (Math.log(b) / Math.log(2));
				b -= Math.pow(2, cnt);

				for (int j = 0; j < n; j++) {
					for (int k = 0; k < n; k++) {
						t[j][k] = mat[j][k];
						tt[j][k] = mat[j][k];
					}
				}

				for (int i = 0; i < cnt; i++) {
					calc(t, tt, n);
					for (int j = 0; j < n; j++) {
						for (int k = 0; k < n; k++) {
							t[j][k] = tr[j][k];
							tt[j][k] = tr[j][k];
						}
					}
				}

				calc(t, res, n);

				for (int j = 0; j < n; j++) {
					for (int k = 0; k < n; k++) {
						res[j][k] = tr[j][k];
					}
				}
			}

			if (b == 1) {
				calc(mat, res, n);
			}

			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					res[j][k] = tr[j][k];
				}
			}

			// 결과 출력 (Result output)
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					bw.write(res[i][j] % 1000 + " ");
				bw.write("\n");
			}
		}

		bw.flush();
		bw.close();
	}
}