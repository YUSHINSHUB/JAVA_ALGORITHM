package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	static int dp[];
	static int w[];

	static int recur(int n) {

		if (dp[n] < 0) {
			dp[n] = Math.max(Math.max(recur(n - 3) + w[n - 1] + w[n], recur(n - 2) + w[n]), recur(n - 1));
		}

		return dp[n];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];
		w = new int[n + 1];

		Arrays.fill(dp, -1);

		for (int i = 1; i <= n; i++) {
			w[i] = Integer.parseInt(br.readLine());
		}
		w[0] = 0;
		dp[0] = 0;

		if (n >= 2) {
			dp[2] = w[1] + w[2];
			dp[1] = w[1];
		} else if (n == 1)
			dp[1] = w[1];

		int res = recur(n);

		bw.write(res + "");
		bw.flush();
		bw.close();

	}
}