package Number_Theory;

import java.io.*;

public class Q1978_PRIME_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		String temp[] = br.readLine().split(" ");
		int nums[] = new int[n];
		int res = 0;

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(temp[i]);
		}

		boolean pri[] = new boolean[1001];

		pri[0] = true;
		pri[1] = true;

		for (int i = 2; i < 1001; i++) {
			if (pri[i] != true) {
				int z = i * 2;
				while (z <= 1000) {
					pri[z] = true;
					z += i;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			if (pri[nums[i]] != true) {
				res++;
			}
		}

		bw.write(String.valueOf(res));

		bw.flush();
		bw.close();

	}

}