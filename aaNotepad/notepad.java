package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	static long combination(int n, int r) {

		long out = 1;
		for (long i = n - r + 1; i <= n; i++) {
			out *= i;
		}

		for (int i = 2; i <= r; i++) {
			out /= i;
		}

		return out;

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");

		int N = Integer.parseInt(inp[0]);
		int M = Integer.parseInt(inp[1]);
		int sum = 0;
		long res = 0;

		int cnt[] = new int[M];
		Arrays.fill(cnt, 0);

		inp = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			sum = (sum + Integer.parseInt(inp[i])) % M;
			cnt[sum]++;
		}

		res += cnt[0];
		for (int i = 0; i < M; i++) {
			res += combination(cnt[i], 2);
		}

		bw.write(res + "");

		bw.flush();
		bw.close();

	}

}
