package Divide_and_Conquer;

/*
commented by ChatGPT
�� Java �ڵ�� ��� ���� ������ �ذ��մϴ�. �־��� ����� �Էµ� �� ��ŭ �����Ͽ� �� ����� ����ϴ� �ڵ��Դϴ�.
�̸� ���� ������ ǥ������ ����Ͽ� �Էµ� ���� �����ϰ�, �ش� ���ڸ�ŭ ����� �����մϴ�. �� ����� ���� ȿ�������� ��� ������ ����� �� �ֽ��ϴ�.

This Java code solves the matrix exponentiation problem. It exponentiates a given matrix by a provided number and outputs the result.
It utilizes binary representation to decompose the provided number and exponentiates the matrix accordingly. This approach allows for efficient matrix exponentiation.
*/

import java.io.*;
import java.math.*;
import java.util.*;

public class Q10830_Squaring_Matrix_G4 {

	static int res[][] = new int[6][6]; // ���� ��� ��� (Final result matrix)
	static int tr[][] = new int[6][6]; // �ӽ� ��� ��� (Temporary result matrix)

// �־��� �� ����� ���ϴ� �Լ� (Function to multiply two given matrices)
	public static void calc(int[][] mat, int[][] t, int n) {
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				temp = 0;
				for (int k = 0; k < n; k++) {
					temp += (t[i][k] * mat[k][j]) % 1000;
				}
				tr[i][j] = temp % 1000; // ����� 1000���� ���� ������ (Results are modulo 1000)
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

		int mat[][] = new int[n][n]; // �ʱ� ��� (Initial matrix)
		int t[][] = new int[n][n]; // �ӽ� ��� (Temporary matrix)
		int tt[][] = new int[n][n]; // �߰� �ӽ� ��� (Additional temporary matrix)

		// ��� �Է� (Matrix input)
		for (int i = 0; i < n; i++) {
			in = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				mat[i][j] = Integer.parseInt(in[j]);
				res[i][j] = mat[i][j];
				t[i][j] = mat[i][j];
				tt[i][j] = mat[i][j];
			}
		}

		// b�� 1�� ���, ���� ����� ��� (If b is 1, print the original matrix)
		if (b == 1) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					bw.write(mat[i][j] % 1000 + " ");
				bw.write("\n");
			}
		} else {
			// ���� ǥ���� ����� ��� ���� ��� (Matrix exponentiation using binary representation)
			int cnt = (int) (Math.log(b) / Math.log(2));
			b -= Math.pow(2, cnt);

			for (int i = 0; i < cnt; i++) {
				calc(t, tt, n); // ��� ���ϱ� (Matrix multiplication)
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

			// ��� ��� (Result output)
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