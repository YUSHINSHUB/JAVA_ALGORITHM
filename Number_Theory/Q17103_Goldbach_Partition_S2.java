package Number_Theory;

import java.io.*;

public class Q17103_Goldbach_Partition_S2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// �Ҽ����� �ƴ����� �Ǻ��� �迭, n[i]�� true�̸� i�� �Ҽ��� �ƴϰ� false�̸� �Ҽ�
		boolean n[] = new boolean[1000001];

		// 0�� 1�� �Ҽ��� �ƴϹǷ� true�� ����
		n[0] = true;
		n[1] = true;

		// �����佺�׳׽��� ü�� �̿��Ͽ� �Ҽ��� ����
		for (int i = 2; i < 1000001; i++) {
			if (n[i] == false) {
				for (int z = i * 2; z < 1000001; z += i) {
					n[z] = true;
				}
			}
		}

		// �׽�Ʈ ���̽��� ���� �Է¹���
		int t = Integer.parseInt(br.readLine());

		// �� �׽�Ʈ ���̽��� �ش��ϴ� ���� ������ �迭�� �� ���� �� �Ҽ��� ������ ��Ÿ�� �� �ִ� ����� ���� ������ �迭
		int num[] = new int[t];
		int gold[] = new int[t];

		for (int i = 0; i < t; i++) {
			// �� �׽�Ʈ ���̽��� �ش��ϴ� ���� �Է¹���
			num[i] = Integer.parseInt(br.readLine());

			// �ʱ⿡ �� ���� �� �Ҽ��� ������ ��Ÿ�� �� �ִ� ����� ���� 0���� ����
			gold[i] = 0;

			// �� ���� �� �Ҽ��� ������ ��Ÿ�� �� �ִ� ����� ���� ����
			for (int z = 2; z <= num[i] / 2; z++) {
				if (n[z] == false && n[num[i] - z] == false) {
					gold[i]++;
				}
			}

			// �� ���� �� �Ҽ��� ������ ��Ÿ�� �� �ִ� ����� ���� ���
			bw.write(String.valueOf(gold[i]) + "\n");
		}

		bw.flush();
		bw.close();
	}
}