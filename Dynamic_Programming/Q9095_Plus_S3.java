package Dynamic_Programming;

import java.io.*;
import java.util.*;

public class Q9095_Plus_S3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int dp[] = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i <= 10; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int temp = Integer.parseInt(br.readLine());
			bw.write(String.valueOf(dp[temp]) + "\n");
		}

		bw.flush();
		bw.close();

	}
}