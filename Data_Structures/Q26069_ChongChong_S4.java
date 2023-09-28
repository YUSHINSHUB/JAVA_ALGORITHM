//�� �ڵ�� �̸��� ����� �׷��� ���� ã�� ������ �ذ��ϴ� �ڹ� ���α׷��Դϴ�. 
//���⼭ "ChongChong"�� �׻� ù��° �׷쿡 ���Ѵٰ� �����մϴ�.

package Data_Structures;

import java.io.*;
import java.util.*;

public class Q26069_ChongChong_S4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// ����ڷκ��� ���� ���� n�� �Է¹���
		int n = Integer.parseInt(br.readLine());

		// ���� ����� �����ϴ� ����
		int res = 0;

		// �̸��� ���� ���θ� �����ϴ� �ؽ��� (����Ǿ� ������ 1, �ƴϸ� 0)
		HashMap<String, Integer> hm = new HashMap<>();
		String a, b;

		// ChongChong�� �׻� ����� �׷쿡 ���ԵǹǷ� 1�� ����
		hm.put("ChongChong", 1);

		// n ���� ���� �Է¹���
		for (int i = 0; i < n; i++) {
			String inp[] = br.readLine().split(" ");
			a = inp[0];
			b = inp[1];

			// a �Ǵ� b�� �ؽ��ʿ� ������ �߰��ϰ� �ʱⰪ�� 0���� ����
			if (!hm.containsKey(a)) {
				hm.put(a, 0);
			}
			if (!hm.containsKey(b)) {
				hm.put(b, 0);
			}

			// a�� ����� �׷쿡 ���ϸ�, b�� �׷쿡 �߰�
			if (hm.get(a) == 1)
				hm.put(b, 1);
			// �ݴ��� ��쵵 ��������
			else if (hm.get(b) == 1)
				hm.put(a, 1);

		}

		// ��� ��Ʈ���� ���� ����� �׸��� ���� ī��Ʈ
		for (Map.Entry<String, Integer> en : hm.entrySet()) {
			if (en.getValue() == 1)
				res++;
		}

		// ����� ���
		bw.write(res + "");

		bw.flush();
		bw.close();

	}
}