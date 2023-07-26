//���� Ž���� ����Ͽ� ������ ���̺� ���̸� ã���ϴ�. 
//���̺��� ���̰� �߰����� �� �ʿ��� ���̺��� ���� �����ϴٸ� ���̸� ���̰�, �׷��� �ʴٸ� ���̸� �ø��ϴ�. 
//�� ������ �ݺ��Ͽ� ������ ���̺� ���̸� ã�� ����մϴ�.
package Binary_Search;

import java.io.*;

public class Q1654_Cut_Lan_S2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // ����ڷκ��� �Է��� �ޱ� ���� BufferedReader ����
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // ����� ����ϱ� ���� BufferedWriter ����

		int k, n;
		long cnt, mid;
		long low = 0, hig = 0; // ���� Ž���� ���� low, hig �ʱ�ȭ

		String in[] = br.readLine().split(" "); // �Է¹��� �� ���� �������� ������ �迭�� ����
		k = Integer.parseInt(in[0]); // ���̺��� ����
		n = Integer.parseInt(in[1]); // �ʿ��� ���̺��� ����

		int lans[] = new int[k]; // ���̺� ���̸� ������ �迭

		for (int i = 0; i < k; i++) { // ���̺��� ������ŭ �ݺ�
			lans[i] = Integer.parseInt(br.readLine()); // �� ���̺��� ���̸� �迭�� ����
			if (hig < lans[i])
				hig = lans[i]; // ���� �� ���̺� ���̸� hig�� ����
		}
		hig++; // �ִ� ���̺� ���̺��� �ϳ� ū ������ �ʱ�ȭ

		while (low < hig) { // ���� Ž�� ����
			cnt = 0; // �� �ݺ����� ���� �� �ִ� ���̺��� ���� �����ϴ� ����
			mid = (low + hig) / 2; // �߰����� ����
			for (int i = 0; i < k; i++) {
				cnt += lans[i] / mid; // �� ���̺��� ���� �� �ִ� ���̺��� ���� ����
			}

			if (cnt < n) { // �ʿ��� ���̺��� ������ ���ٸ�, ���̺��� ���̸� ����
				hig = mid;
			} else { // �ʿ��� ���̺��� ������ ���ٸ�, ���̺��� ���̸� �ø�
				low = mid + 1;
			}
		}

		bw.write((low - 1) + ""); // ������ ���̺� ���̸� ���. low�� hig���� 1��ŭ ũ�Ƿ� 1�� ���ش�.

		bw.flush(); // BufferedWriter�� ���۸� ����, �����ִ� �����͸� ��� ���
		bw.close(); // BufferedWriter�� ����
	}
}