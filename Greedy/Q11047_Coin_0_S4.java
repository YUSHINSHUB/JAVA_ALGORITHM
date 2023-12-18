package Greedy;

import java.io.*;
import java.util.*;

public class Q11047_Coin_0_S4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");

		int n = Integer.parseInt(inp[0]);
		int k = Integer.parseInt(inp[1]);
		int coin[] = new int[n];
		int out = 0;
		int sum = 0;

		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		for (int i = n - 1; i >= 0; i--) {
			out += k / coin[i];
			k %= coin[i];
		}

		bw.write(out + "");

		bw.flush();
		bw.close();

	}
}
