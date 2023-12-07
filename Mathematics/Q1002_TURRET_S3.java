package Mathematics;

import java.io.*;
import java.math.*;

public class Q1002_TURRET_S3 {

	public static void main(String[] args) throws IOException {
		// �� ��ǥ�� �������� ���� �������� r1, r2�� ���� �ִ� �����Ͽ� ������ ã�´�.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			String inp[] = br.readLine().split(" ");
			int x1 = Integer.parseInt(inp[0]);
			int y1 = Integer.parseInt(inp[1]);
			int r1 = Integer.parseInt(inp[2]);
			int x2 = Integer.parseInt(inp[3]);
			int y2 = Integer.parseInt(inp[4]);
			int r2 = Integer.parseInt(inp[5]);

			if (x1 == x2 && y1 == y2 && r1 == r2) {
				// �� ���� ��ġ (������ ����)
				bw.write("-1\n");
			} else {

				if (r2 > r1) {
					int temp = x1;
					x1 = x2;
					x2 = temp;

					temp = y1;
					y1 = y2;
					y2 = temp;

					temp = r1;
					r1 = r2;
					r2 = temp;
				}

				int dis = (int) (Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
				// �� ��ǥ���� �Ÿ��� �ش� ���� �������� ���ؾ� ������ sqrt�� ����ϸ� �Ǽ����� ������ �߻��� �� �ֱ� ������
				// �������� ������ �ʰ� �״�� ����Ѵ�.

				if (dis < Math.pow(r1 - r2, 2)) {
					// ���� ���� ū �� �ȿ� ����ְ� ������ ����.
					bw.write("0\n");
				} else if (dis == Math.pow(r1 - r2, 2)) {
					// �� ���� ������.
					bw.write("1\n");
				} else if (Math.pow(r2 + r1, 2) > dis) {
					// �� ���� ��ħ
					bw.write("2\n");
				} else if (Math.pow(r2 + r1, 2) < dis) {
					// �� ���� ���� ����������
					bw.write("0\n");
				} else {
					// �� ���� ������
					bw.write("1\n");
				}
			}

		}

		bw.flush();
		bw.close();

	}
}