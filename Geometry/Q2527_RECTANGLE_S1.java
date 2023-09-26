package Geometry;

/*
commented by ChatGPT
�� �ڵ�� �� ���� �簢���� ��ǥ�� �������� �׵� ������ ���踦 �Ǵ��ϴ� Java �����Դϴ�.
*/

import java.io.*;

public class Q2527_RECTANGLE_S1 {

	public static void main(String[] args) throws IOException {

		// �ַܼκ��� �Է��� �ޱ� ���� BufferedReader �ʱ�ȭ
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// �ֿܼ� ����ϱ� ���� BufferedWriter �ʱ�ȭ
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 4���� �簢�� ��ǥ ��Ʈ�� �ݺ� ó��
		for (int i = 0; i < 4; i++) {
			// �Է¹��� ���� ���� �������� �и�
			String inp[] = br.readLine().split(" ");

			// ù ��° �簢���� ��ǥ ���� �Ľ�
			int x1 = Integer.parseInt(inp[0]);
			int y1 = Integer.parseInt(inp[1]);
			int p1 = Integer.parseInt(inp[2]);
			int q1 = Integer.parseInt(inp[3]);
			// �� ��° �簢���� ��ǥ ���� �Ľ�
			int x2 = Integer.parseInt(inp[4]);
			int y2 = Integer.parseInt(inp[5]);
			int p2 = Integer.parseInt(inp[6]);
			int q2 = Integer.parseInt(inp[7]);

			// �簢������ ���� ������ �ִ� ���
			if (x1 > p2 || y1 > q2 || p1 < x2 || q1 < y2)
				bw.write("d\n");
			// �簢������ ������ ������ ���
			else if ((x1 == p2 && y1 == q2) || (p1 == x2 && y1 == q2) || (x1 == p2 && q1 == y2)
					|| (p1 == x2 && q1 == y2))
				bw.write("c\n");
			// �簢������ ������ ������ ���
			else if ((x1 == p2) || (y1 == q2) || (p1 == x2) || (q1 == y2))
				bw.write("b\n");
			// �簢������ ���� ��ġ�� ���
			else
				bw.write("a\n");
		}

		// ��� ��Ʈ���� ���� ����
		bw.flush();
		bw.close();
	}
}
