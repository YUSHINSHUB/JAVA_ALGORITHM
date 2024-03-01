package Dynamic_Programming;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q11053_LIS_S2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String inp[] = br.readLine().split(" ");
		int nums[] = new int[n];
		int m = 0;

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(inp[i]);
			m = Math.max(m, nums[i]);
		}

		int dp[] = new int[m + 1];
		int cnt = 0;
		int res = 0;

		for (int i = n - 1; i >= 0; i--) {
			cnt = 0;
			for (int z = nums[i] + 1; z <= m; z++) {
				cnt = Math.max(cnt, dp[z]);
			}
			dp[nums[i]] = cnt + 1;
			res = Math.max(res, dp[nums[i]]);
		}

		bw.write(res + "");

		bw.flush();
		bw.close();
	}
}