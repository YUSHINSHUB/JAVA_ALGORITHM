package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int res = 0;
		int bi[] = new int[n];
		int mem[][] = new int[n][2];
		int chk[] = new int[1001];
		Arrays.fill(chk, -1);
		chk[0] = 0;

		String inp[] = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			bi[i] = Integer.parseInt(inp[i]);

			for (int j = bi[i] - 1; j >= 0; j--) {
				if (chk[j] >= 0) {
					chk[bi[i]] = chk[j] + 1;
					mem[i][0] = chk[bi[i]];
					break;
				}
			}

			if (i == 0) {
				chk[bi[i]] = 1;
				mem[i][0] = 1;
			}

		}

		Arrays.fill(chk, -1);
		chk[0] = 0;

		for (int i = n - 1; i >= 0; i--) {

			for (int j = bi[i] - 1; j >= 0; j--) {
				if (chk[j] >= 0) {
					chk[bi[i]] = chk[j] + 1;
					mem[i][1] = chk[bi[i]];
					break;
				}
			}

			if (i == n - 1) {
				chk[bi[i]] = 1;
				mem[i][1] = 1;
			}

			if (mem[i][0] + mem[i][1] > res)
				res = mem[i][0] + mem[i][1] - 1;
		}

		bw.write(res + "");

		bw.flush();
		bw.close();

	}
}
