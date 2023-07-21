package Bruteforcing;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q4134_Next_Prime_S4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		// �Ҽ��� �ƴ� ���� �Ҽ��� ����̴�. ���� n�� �Ҽ����θ� Ȯ���ϱ� ���� �ϳ��ϳ� ������ ���� ����� ���� ������
		// n-1���� ��� ������ �ʿ� ���� 2���� �Ҽ����� ���� n�� ������ ������ ������ ���Ƶ� �ȴ�.
		// �ִ��� 40���� �������� 63245.553...���� �̿��ؼ� �迭�� 63246 ������ ��� �Ҽ��� �����ؼ� �̿��Ѵ�.
		ArrayList<Integer> prime = new ArrayList<>();
		int pri[] = new int[63247];
		Arrays.fill(pri, 0);
		pri[1] = 1;
		prime.add(2);
		for (int i = 4; i < 63247; i += 2) {
			pri[i] = 1;
		}

		for (int i = 3; i < 63247; i += 2) {
			if (pri[i] == 0) {
				prime.add(i);
				for (int j = i * 2; j < 63247; j += i)
					pri[i] = 1;
			}
		}

		for (int i = 0; i < t; i++) {
			long n = Long.parseLong(br.readLine());
			if (n < 2)
				n = 2;
			for (int j = 0; j < prime.size(); j++) {
				if (prime.get(j) > Math.sqrt(n))
					break;
				if (n % prime.get(j) == 0) {
					j = -1;
					n++;
				}
			}
			bw.write(n + "\n");
		}
		bw.flush();
		bw.close();

	}
}