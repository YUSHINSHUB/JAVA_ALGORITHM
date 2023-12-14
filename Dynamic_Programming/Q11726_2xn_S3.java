package Dynamic_Programming;

import java.io.*;
import java.util.*;

public class Q11726_2xn_S3 {

	static int dp[] = new int[1001];

	static int recur(int n) {

		if (dp[n] == 0) {
			dp[n] = recur(n - 1) + recur(n - 2);
		}

		return dp[n] % 10007;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		dp[1] = 1;
		dp[2] = 2;

		int n = Integer.parseInt(br.readLine());

		bw.write(recur(n) + "");

		bw.flush();
		bw.close();

	}
}
