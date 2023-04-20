package Greedy;

import java.io.*;
import java.math.*;
import java.util.*;
// append �ڿ� string �迭�� �����ؼ� �ֱ�

public class Q2873_RollerCoaster_P3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String nums[] = br.readLine().split(" ");
		int r = Integer.parseInt(nums[0]); // ���ι�ȣ (�������� ����)
		int c = Integer.parseInt(nums[1]); // ���ι�ȣ (�������� ����)
		String temp[] = new String[c];
		StringBuffer b1 = new StringBuffer();
		// �ǳʶ� ĭ�� ���Ե� y��ǥ �������� ���
		StringBuffer b2 = new StringBuffer();
		// �ǳʶ� ĭ�� y��ǥ ������ ��� ���������� �ԷµǱ� ������ �������)

		int line[][] = new int[r][c];

		for (int i = 0; i < r; i++) {
			temp = br.readLine().split(" ");
			for (int z = 0; z < c; z++) {
				line[i][z] = Integer.parseInt(temp[z]);
			}
		}

		// ������ Ȥ�� �������� ������ Ȧ���� ��� ���ĭ�� �� ���� �� �ִ�.
		if (r % 2 == 1) {

			for (int i = 0; i < r; i++) {
				for (int z = 0; z < c - 1; z++) {
					b1.append("R");
				}
				i++;
				if (i >= r)
					break;
				else {
					b1.append("D");
				}
				for (int z = 0; z < c - 1; z++) {
					b1.append("L");
				}
				b1.append("D");
			}

		} else if (c % 2 == 1) {

			for (int i = 0; i < c; i++) {
				for (int z = 0; z < r - 1; z++) {
					b1.append("D");
				}
				i++;
				if (i == c)
					break;
				else {
					b1.append("R");
				}
				for (int z = 0; z < r - 1; z++) {
					b1.append("U");
				}
				b1.append("R");
			}

			// ������, ������ ������ ��� ¦���� ���
		} else {
			int mi = 1001;
			int xpos = 0;
			int ypos = 0;
			int ra = 0;
			int rb = r - 1;
			int ct = 0;

			// �������� ���ٴ����� ����� �ǳʶ� ĭ�� ����(b1), ����(b2)�� ������ �Է��Ѵ�.
			for (int i = 0; i < r; i += 2) {
				for (int z = 1; z < c; z += 2) {
					mi = Math.min(mi, line[i][z]);
					if (line[i][z] == Math.min(mi, line[i][z])) {
						ypos = i;
						xpos = z;
					}
				}
			}

			for (int i = 1; i < r; i += 2) {
				for (int z = 0; z < c; z += 2) {
					mi = Math.min(mi, line[i][z]);
					if (line[i][z] == Math.min(mi, line[i][z])) {
						ypos = i;
						xpos = z;
					}
				}
			}

			// ĭ�� ��ġ�� �� �� �� ��� �ǳʶ� ĭ�� ������ ���ĭ �߿� �ֱ� ������ ���� ���� ������� �ǳʶ� ������ �����Ѵ�.
			// �� ��

			while (ra / 2 < ypos / 2 || rb / 2 > ypos / 2) {
				if (ra / 2 < ypos / 2) {
					for (int i = 0; i < c - 1; i++)
						b1.append("R");
					b1.append("D");
					for (int i = 0; i < c - 1; i++)
						b1.append("L");
					b1.append("D");
					ra += 2;
				}

				if (rb / 2 > ypos / 2) {
					for (int i = 0; i < c - 1; i++)
						b2.append("R");
					b2.append("D");
					for (int i = 0; i < c - 1; i++)
						b2.append("L");
					b2.append("D");
					rb -= 2;
				}
			}

			while (ct / 2 < xpos / 2) {
				b1.append("DRUR");
				ct += 2;
			}

			// 1 2 �� ��쿡 3�� �ǳʶٴ� ���
			// 3 4
			if (xpos % 2 == 0) {
				b1.append("RD");
			} else { // 1 2 �� ��쿡 2�� �ǳʶٴ� ���
						// 3 4
				b1.append("DR");
			}
			ct += 1;

			while (ct < c - 1) {
				b1.append("RURD");
				ct += 2;
			}

		}

		bw.write(b1.toString());
		bw.write(b2.reverse().toString());

		bw.flush();
		bw.close();

	}
}