//�� ���α׷��� ����ڷκ��� �Է¹��� ���� ���� ���丮��(factorial)�� ����մϴ�. 
//���丮���� �־��� ������ 1������ ��� ������ ���� ���� �ǹ��մϴ�. 
//���� ���, 5�� ���丮���� 5 * 4 * 3 * 2 * 1 = 120 �Դϴ�. 
//�� ���α׷������� for���� ����Ͽ� �� ������ �����ϰ� ����� ����մϴ�.

package Implementation;

import java.io.*;

public class Q10872_FACTORIAL_B5 {
	public static void main(String[] args) throws IOException {
		// BufferedReader�� BufferedWriter ��ü�� �����մϴ�.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// ����ڷκ��� �Է��� �޾Ƽ� int�� ��ȯ�մϴ�.
		int n = Integer.parseInt(br.readLine());

		// ���丮�� ������ ���� �ʱⰪ 1�� ������ ������ �����մϴ�.
		int res = 1;

		// for���� ����Ͽ� 1���� n������ ���ڸ� ��� ���մϴ�.
		for (int i = 1; i <= n; i++) {
			res *= i;
		}

		// ���� ���丮�� ���� ���ڿ��� ��ȯ�Ͽ� ����մϴ�.
		bw.write(String.valueOf(res));

		// BufferedWriter�� flush�Ͽ� ���ۿ� �����ִ� �����͸� ��� ����ϰ�, BufferedWriter�� �ݽ��ϴ�.
		bw.flush();
		bw.close();
	}
}