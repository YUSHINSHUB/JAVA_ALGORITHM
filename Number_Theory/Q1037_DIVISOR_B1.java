package Number_Theory;

import java.io.*;

public class Q1037_DIVISOR_B1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int nums[] = new int[n];
		boolean chk = true;
		String t[] = br.readLine().split(" ");

		int res = 0;

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(t[i]);
		}

		int max = nums[0];
		int min = nums[0];

		for (int i = 0; i < n; i++) {
			if (max < nums[i]) {
				max = nums[i];
			}
			if (min > nums[i]) {
				min = nums[i];
			}
		}

		bw.write(String.valueOf(max * min));
		// ��� ����� �Է¹ޱ� ������ �ּڰ�, �ִ��� ���ϸ� ���� �� �ִ�.

		bw.flush();
		bw.close();

	}
}