package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	static int dp[];
	static boolean visited[];

	static int recur(int idx) {

		if (visited[idx])
			return dp[idx];
		else {
			visited[idx] = true;
			dp[idx] = recur(idx - 2) * 3;
			for (int i = idx - 4; i >= 0; i -= 2) {
				dp[idx] += recur(i) * 2;
			}
			return dp[idx];
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];
		visited = new boolean[n + 1];
		dp[0] = 1;
		visited[0] = true;

		if (n % 2 != 0)
			bw.write("0");
		else
			bw.write(recur(n) + "");

		bw.flush();
		bw.close();

	}
}
