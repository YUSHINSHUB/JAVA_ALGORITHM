package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {

	static int N;
	static long mem1[] = new long[91];
	static long mem0[] = new long[91];

	static long dp(int idx, int cur) {

		if (cur == 1) {
			if (mem1[idx] > 0)
				return mem1[idx];
			mem1[idx] = dp(idx + 1, 0);
			return mem1[idx];
		} else {
			if (mem0[idx] > 0)
				return mem0[idx];
			mem0[idx] = dp(idx + 1, 1) + dp(idx + 1, 0);
			return mem0[idx];
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Arrays.fill(mem1, -1);
		Arrays.fill(mem0, -1);
		N = Integer.parseInt(br.readLine());
		mem1[N] = 1;
		mem0[N] = 1;

		dp(1, 1);

		bw.write(mem1[1] + "");

		bw.flush();
		bw.close();

	}

}
