package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int k = Integer.parseInt(inp[1]);

		int coin[] = new int[n];
		int dp[] = new int[10001];
		Arrays.fill(dp, 0);
		dp[0] = 1;

		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		for (int j = 0; j < n; j++) {
			for (int i = 1; i <= k; i++) {
				if (coin[j] <= i) {
					dp[i] += dp[i - coin[j]];
				}
			}
		}

		bw.write(dp[k] + "");

		bw.flush();
		bw.close();

	}
}
