package Number_Theory;

import java.io.*;

public class Q2004_Number_of_Zero_S2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] nm = br.readLine().split(" ");

		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		int nmm = n - m;

		// ���� nCm�� (n!) / m!(n-m)! �� ���� �� �ִ�.

		int fcnt = 0;
		int tcnt = 0;

		while (n >= 5) {
			fcnt += n / 5;
			n /= 5;
		}
		// �ش� ������ n�� ���丮���� ���μ����� ���� �� Ư�� �μ��� �¼�(������ Ƚ��)�� �����ش�.
		// n�� 25�� �� fcnt�� 5 + 1 = 6�� �ǹǷ� 25!�� ���μ� �����ϸ� 5^6 * ... �� ���¸� ���´�.

		while (m >= 5) {
			fcnt -= m / 5;
			m /= 5;
		}

		while (nmm >= 5) {
			fcnt -= nmm / 5;
			nmm /= 5;
		}

		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);
		nmm = n - m;

		while (n >= 2) {
			tcnt += n / 2;
			n /= 2;
		}

		while (m >= 2) {
			tcnt -= m / 2;
			m /= 2;
		}

		while (nmm >= 2) {
			tcnt -= nmm / 2;
			nmm /= 2;
		}

		// ������� ���ڸ��� 0�̶�� ���� ���μ� ���ظ� ������ 2 * 5�� 0�� ������ŭ ������ �����Ѵٴ� ���̴�.
		// ������� ...00�� ��� ���μ� ���� �ϸ� ... * 2^2 * 5*2�� �ȴ�.
		// �׷��Ƿ� n!�� ���μ����� �Ͽ��� �� 5�� �¼����� m!, (n-m)!�� 5�� �¼��� ���ְ�
		// 2�� �¼��ε� �Ȱ��� ���� �� ���� ���� ���� ���ϸ� ������ ������ 2�� 5�� ������� �� �� ������ �̴� 0�� ������ �ȴ�.

		bw.write(String.valueOf(Math.min(fcnt, tcnt)));

		bw.flush();
		bw.close();

	}

}