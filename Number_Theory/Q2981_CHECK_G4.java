package Number_Theory;

/*
commented by ChatGPT
�� Java �ڵ�� ������� ���� ������ �ذ��ϱ� ���� ���Դϴ�. �־��� N���� ���ڵ� �߿��� Ư���� ��Ģ�� �����ϴ� �� M�� ã�� �����Դϴ�. 
N���� ���ڵ��� M���� �������� �� �������� ��� ���� �Ǵ� M�� ã�ƾ� �մϴ�. M�� 1���� Ŀ�� �մϴ�.
*/

import java.io.*;
import java.util.*;

public class Q2981_CHECK_G4 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int cards[] = new int[n];
		int nums[] = new int[n - 1];

		// N���� ���ڸ� �Է� �޴´�. (Receive N numbers)
		for (int i = 0; i < n; i++) {
			cards[i] = Integer.parseInt(br.readLine());
		}

		// ���ڵ��� �����Ѵ�. (Sort the numbers)
		Arrays.sort(cards);

		// ���ӵ� ���ڵ� ������ ���̸� ����Ѵ�. (Calculate the difference between consecutive numbers)
		for (int i = 1; i < n; i++) {
			nums[i - 1] = cards[i] - cards[i - 1];
		}

		// ���̰����� �����Ѵ�. (Sort the difference values)
		Arrays.sort(nums);

		boolean out = true;
		int gdc = 0;

		// ������ M�� ���� �� �ִ������� ã�´�. (Finding the greatest common divisor among possible
		// values of M)
		for (int j = nums[0]; j >= 0; j--) {
			out = true;
			for (int i = 0; i < n - 1; i++) {
				if (nums[i] % j != 0) {
					out = false;
					break;
				}
			}
			if (out) {
				gdc = j;
				break;
			}
		}

		// �ִ������� ������� ã�� ����Ѵ�. (Finding and printing the divisors of the greatest
		// common divisor)
		for (int i = 2; i < Math.sqrt(gdc); i++) {
			if (gdc % i == 0)
				bw.write(i + " ");
		}

		for (int i = (int) Math.sqrt(gdc); i >= 1; i--) {
			if (gdc % i == 0)
				bw.write(gdc / i + " ");
		}

		bw.flush();
		bw.close();

	}
}
