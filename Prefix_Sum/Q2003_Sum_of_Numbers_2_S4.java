package Prefix_Sum;

import java.io.*;

public class Q2003_Sum_of_Numbers_2_S4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int m = Integer.parseInt(inp[1]);
		int num[] = new int[n];
		inp = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(inp[i]);
		}

		int idx = 0;
		int sum = 0;
		int res = 0;

		for (int i = 0; i < n; i++) {
			sum += num[i];
			if (sum == m)
				res++;
			else if (sum > m) {
				while (sum > m) {
					sum -= num[idx];
					idx++;
				}
				if (sum == m)
					res++;
			}
		}

		bw.write(res + "");

		bw.flush();
		bw.close();

	}
}