package Greedy;

import java.io.*;

public class Q11501_STOCK_S2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int nums[] = new int[n];
			int hig = Integer.MIN_VALUE;
			long res = 0;
			String inp[] = br.readLine().split(" ");
			for (int j = 0; j < n; j++)
				nums[n - 1 - j] = Integer.parseInt(inp[j]);

			for (int j = 0; j < n; j++) {
				if (hig < nums[j])
					hig = nums[j];
				else
					res += hig - nums[j];
			}

			bw.write(res + "\n");
		}

		bw.flush();
		bw.close();

	}
}