package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String inp[] = br.readLine().split(" ");
		int arr[] = new int[n];
		int dp[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(inp[i]);
		}

		dp[0] = arr[0];
		int res = arr[0];

		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
			if (dp[i] > res)
				res = dp[i];
		}

		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}
