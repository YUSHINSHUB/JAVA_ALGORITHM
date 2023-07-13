package Dynamic_Programming;

import java.io.*;

public class Q1699_Sum_of_Square_S2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int square[] = new int[n + 1];
		square[0] = 0;

		for (int i = 1; i <= n; i++) {
			square[i] = i;
			// 1�θ� ä�� ���
			for (int j = 1; j * j <= i; j++) {
				if (square[i] > (square[i - (j * j)] + 1))
					square[i] = square[i - (j * j)] + 1;
				// j * j �� �������̱� ������ �ּ����� �������� ����Ͽ� i�� ����� �����
				// ������ �Ѱ� (j*j) �� ���ϸ� i�� �Ǵ� �� (i-j*j) �߿� �ּ��� �������� ���� �� �ִ� ����
				// ã�� ���̴�.
			}
		}

		bw.write(square[n] + "");

		bw.flush();
		bw.close();

	}
}