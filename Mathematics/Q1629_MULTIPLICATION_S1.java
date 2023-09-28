//�� �ڵ�� a, b, c�� �Է¹޾� �Լ� recur�� ȣ���ϴ� main �Լ���, ��������� a^b�� ����ϴ� recur �Լ��� �̷���� �ֽ��ϴ�. 
//recur �Լ��� b�� 0�� ��� 1�� ��ȯ�ϰ�, b�� ¦���� ��� a^(b/2)�� ���� ����Ͽ� �� ����� �����ϰ�, 
//b�� Ȧ���� ��� a^(b/2)�� ���� ����Ͽ� �� ����� ������ �� �ٽ� a�� ���մϴ�. 
//��� �߰� ����� c�� ���� �������� ����Ͽ� �����÷ο츦 �����մϴ�.
package Mathematics;

import java.io.*;

public class Q1629_MULTIPLICATION_S1 {

	static long recur(long a, long b, long c) { // a^b�� ����ϵ�, �߰� ��� ����� c�� ���� �������� ���
		if (b == 0) { // ������ 0�̸� 1�� ��ȯ
			return 1;
		} else if (b % 2 == 0) { // ������ ¦���̸�, a^(b/2)�� ���� ����Ͽ� �� ����� ����
			long re = recur(a, b / 2, c) % c;
			return (re * re) % c;
		} else { // ������ Ȧ���̸�, a^(b/2)�� ���� ����Ͽ� �� ����� ������ ���� a�� ����
			long re = recur(a, b / 2, c) % c;
			return (re * (((re) * (a % c)) % c)) % c;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] inp = br.readLine().split(" "); // �Է��� �޾Ƽ�

		long a = Long.parseLong(inp[0]);
		long b = Long.parseLong(inp[1]);
		long c = Long.parseLong(inp[2]); // a, b, c�� �Ľ�

		bw.write(String.valueOf(recur(a, b, c))); // recur �Լ��� ȣ���Ͽ� ����� ���

		bw.flush();
		bw.close();

	}
}