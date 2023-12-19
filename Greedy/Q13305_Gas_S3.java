package Greedy;

import java.io.*;
import java.math.*;

public class Q13305_Gas_S3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		String inp[] = br.readLine().split(" ");

		int prc[] = new int[n];
		int dis[] = new int[n - 1];

		int cheap = Integer.MAX_VALUE;

		for (int i = 0; i < n - 1; i++) {
			dis[i] = Integer.parseInt(inp[i]);
		}

		inp = br.readLine().split(" ");
		long res = 0;

		for (int i = 0; i < n - 1; i++) {
			prc[i] = Integer.parseInt(inp[i]);
			if (prc[i] > cheap)
				prc[i] = cheap;
			else
				cheap = prc[i];

			res += (long) dis[i] * (long) prc[i];
		}

		bw.write(res + "");

		bw.flush();
		bw.close();
	}
}
