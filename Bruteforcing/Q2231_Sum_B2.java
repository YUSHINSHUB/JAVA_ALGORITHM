package Bruteforcing;

import java.io.*;

public class Q2231_Sum_B2 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int res = 0;

		for (int i = n - 100; i < n; i++) {
			int temp = i + (i / 100000) + (i % 100000 / 10000) + (i % 10000 / 1000) + (i % 1000 / 100) + (i % 100 / 10)
					+ (i % 10);
			if (temp == n) {
				res = i;
				break;
			}
		}

		bw.write(String.valueOf(res));

		bw.flush();
		bw.close();

	}
}