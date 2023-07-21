//�� �ڵ�� �־��� ���� n�� ���� nP2�� ����ϰ� �� ����� ����մϴ�. nP2�� n���� ���� �ٸ� ���ҿ��� 2���� �����Ͽ� �Ϸķ� �����ϴ� 
//����� ���� ��Ÿ���ϴ�. �� ����� nPr �Լ��� ���� ����Ǹ�, �������� n - r + 1�� ���ǰ�, �� ������ n������ ��� ���ڸ� ���Ͽ� 
//����� ����ϴ�.

package Mathematics;

import java.io.*;
import java.util.*;

public class Q15439_FASHION_B4 {

	// nPr�� ����ϴ� �Լ��Դϴ�.
	// nPr�� n���� ���� �ٸ� ���ҿ��� r���� �����Ͽ� �Ϸķ� �����ϴ� ����� ���� ��Ÿ���ϴ�.
	static long npr(int n, int r) {

		int t = n - r + 1; // nPr�� ����� ������ �������� �����մϴ�.
		long res = 1; // ������� ������ �����Դϴ�.

		// ���������� n������ ��� ���ڸ� ���մϴ�. �̰��� nPr�� ���ǿ� ���� ��� ����Դϴ�.
		for (int i = t; i <= n; i++) {
			res *= i;
		}
		return res; // ����� ��ȯ�մϴ�.

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// �Է��� �޾ƿ� n�� �����մϴ�.
		int n = Integer.parseInt(br.readLine());

		// nP2�� ����ϰ�, ����� ���ڿ��� ��ȯ�Ͽ� ����մϴ�.
		bw.write(npr(n, 2) + "");

		bw.flush();
		bw.close();
	}
}