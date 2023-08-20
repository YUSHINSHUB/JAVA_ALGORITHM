package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	static int mem[] = new int[1001];

	static int dp(int a) {
		if (mem[a] > 0)
			return mem[a];
		else {
			mem[a] = ( dp(a - 1) + (dp(a - 2) * 2) ) % 10007;
			return mem[a];
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		mem[0] = 1;
		mem[1] = 1;

		bw.write(dp(n) + "");

		bw.flush();
		bw.close();

	}
}
