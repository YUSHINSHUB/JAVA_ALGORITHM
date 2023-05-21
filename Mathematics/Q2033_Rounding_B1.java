package Mathematics;

import java.io.*;

public class Q2033_Rounding_B1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int idx = 10;

		while (n > idx) {
			n = (n + (idx / 10 * 5)) / idx * idx; // ������� 10�� �ڸ����� �ݿø��Ұ�� 5�� ���ϸ� �ø��� ���ڴ� ���ڸ��� �ٲ�� �ȴ�.
			idx *= 10;
		}

		bw.write(n + "");

		bw.flush();
		bw.close();
	}
}
