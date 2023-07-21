package Number_Theory;

import java.io.*;
import java.math.*;

public class Q13909_Close_Windows_S5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// �������� �ƴ� â������ ����� ���� �̷�� ������ ��� ������.
		// ����: 6�� ����� 1 - 6, 2 - 3
		// �׷��Ƿ� ���� �� ������ ���� �������� ����� ������ Ȧ���� �Ǿ ���� ���°� �ȴ�.

		// �Է¹��� ���� n�� �о�ɴϴ�.
		int n = Integer.parseInt(br.readLine());
		int idx = 1;

		// n�� idx�� �������� ���� ������ idx ���� ������ŵ�ϴ�.
		// ��, idx�� n�� ������ ������ ���� ū ������ ã�� �����Դϴ�.
		while (Math.pow(idx, 2) < n) {
			idx++;
		}

		// ���� while loop���� idx�� n�� ������ �̻��� ���� ���� �� �����Ƿ�,
		// n�� idx�� ������ �ƴ� ��� idx�� �ϳ� ���ҽ�ŵ�ϴ�.
		if ((int) Math.pow(idx, 2) != n)
			idx--;

		// n�� ������ ������ ���� ū ������ idx�� ����մϴ�.
		bw.write(idx + "");

		bw.flush();
		bw.close();

	}
}