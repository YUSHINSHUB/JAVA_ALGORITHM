package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {

	static int sequence[];
	static int mem[];
	static int N;

	static int dp(int idx) {

		if (mem[idx] > 0)
			return mem[idx];

		mem[idx] = sequence[idx];
		for (int i = idx - 1; i >= 0; i--) {
			if (sequence[i] < sequence[idx]) {
				mem[idx] = Math.max(dp(i) + sequence[idx], mem[idx]);
			}
		}

		return mem[idx];
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int res = 0;

		N = Integer.parseInt(br.readLine());
		mem = new int[N];
		Arrays.fill(mem, 0);
		sequence = new int[N];
		String inp[] = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			sequence[i] = Integer.parseInt(inp[i]);

		for (int i = N - 1; i >= 0; i--)
			res = Math.max(res, dp(i));

		bw.write(res + "");
		bw.flush();
		bw.close();

	}

}
