package Bruteforcing;

import java.io.*;

public class Q1182_Sum_of_Subsequence_S2 {

	static int n, s;
	static int len = 1;
	static int res = 0;
	static int seq[];
	static boolean visited[];

	static void bt(int idx, int cnt, int sum) {
		if (cnt == len) {
			if (sum == s)
				res++;
		} else {
			for (int i = idx; i < n; i++) {
				if (!visited[i]) {
					visited[i] = true;
					bt(i + 1, cnt + 1, sum + seq[i]);
					visited[i] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		n = Integer.parseInt(inp[0]);
		s = Integer.parseInt(inp[1]);
		seq = new int[n];
		visited = new boolean[n];

		inp = br.readLine().split(" ");
		for (int i = 0; i < n; i++)
			seq[i] = Integer.parseInt(inp[i]);

		while (len <= n) {
			bt(0, 0, 0);
			len++;
		}

		bw.write(res + "");

		bw.flush();
		bw.close();

	}
}