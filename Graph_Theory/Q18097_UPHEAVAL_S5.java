package Graph_Theory;

import java.io.*;

public class Q18097_UPHEAVAL_S5 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		if (n == 2)
			bw.write("1");
		else
			bw.write(n + "");
		// n���� ��带 n-1���� ������ �ִ��� ���ټ��� �����ϸ� ��� �����ϴ� ����� �ϳ��� ��忡 ��� ��带 �����ϴ�
		// ���̴�. �׷��Ƿ� ����� ���� ����� ������ ����.

		bw.flush();
		bw.close();

	}
}
