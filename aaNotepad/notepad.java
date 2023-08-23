package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	static int item[][] = new int[100][2];
	static int mem[][] = new int[100001][100];
	static int n, k;
	static int res = 0;

	static int dp(int w, int idx) {

		if (mem[w][idx] >= 0) {
			return mem[w][idx];
		}

		if (item[idx][0] <= w)
			mem[w][idx] = Math.max(item[idx][1] + dp(w - item[idx][0], idx - 1), dp(w, idx - 1));
		else
			mem[w][idx] = dp(w, idx - 1);

		return mem[w][idx];
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		n = Integer.parseInt(inp[0]);
		k = Integer.parseInt(inp[1]);

		for (int i = 0; i < n; i++) {
			inp = br.readLine().split(" ");
			item[i][0] = Integer.parseInt(inp[0]);
			item[i][1] = Integer.parseInt(inp[1]);
		}

		for (int i = 1; i <= k; i++) {
			Arrays.fill(mem[i], -1);
			if (i >= item[0][0])
				mem[i][0] = item[0][1];
			else
				mem[i][0] = 0;
		}

		Arrays.fill(mem[0], 0);

		bw.write(dp(k, n - 1) + "");

		bw.flush();
		bw.close();

	}
}
