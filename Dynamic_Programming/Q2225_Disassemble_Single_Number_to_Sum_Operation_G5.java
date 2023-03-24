package Dynamic_Programming;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q2225_Disassemble_Single_Number_to_Sum_Operation_G5 {

	static long dp[][] = new long[201][201];
	static boolean chk[][] = new boolean[201][201];

	// A개의 정수로 B를 만드는 경우의 수는 X 0->B일 때 A-1개로 X를 만드는 경우의 수의 합과 같다.

	public static long recur(int a, int b) {
		if (chk[a][b] != true) {
			dp[a][b] = 0;
			for (int i = 0; i <= b; i++) {
				if (chk[a - 1][i] == true) {
					dp[a][b] += dp[a - 1][i];
				} else {
					dp[a][b] += recur(a - 1, i);
				}
				if (dp[a][b] >= 1000000000)
					dp[a][b] %= 1000000000;
			}
			chk[a][b] = true;
		} else {
			return dp[a][b];
		}

		return dp[a][b];
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int k = Integer.parseInt(inp[1]);

		for (int i = 0; i <= n; i++) {
			dp[1][i] = 1;
			chk[1][i] = true;
		}

		long res = recur(k, n);

		bw.write(res + "");
		bw.flush();
		bw.close();

	}
}
