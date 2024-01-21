package aaNotepad;

import java.io.*;
import java.util.*;
import java.math.*;

public class notepad {

	static char str[][] = new char[2][1000];
	static int mem[][] = new int[1000][1000];

	static int dp(int idx1, int idx2) {

		if (mem[idx1][idx2] >= 0)
			return mem[idx1][idx2];

		if (str[0][idx1] == str[1][idx2])
			if (idx1 == 0 || idx2 == 0)
				mem[idx1][idx2] = 1;
			else
				mem[idx1][idx2] = dp(idx1 - 1, idx2 - 1) + 1;
		else {
			if (idx1 == 0 && idx2 == 0)
				mem[idx1][idx2] = 0;
			else if (idx1 == 0)
				mem[idx1][idx2] = dp(idx1, idx2 - 1);
			else if (idx2 == 0)
				mem[idx1][idx2] = dp(idx1 - 1, idx2);
			else
				mem[idx1][idx2] = Math.max(dp(idx1 - 1, idx2), dp(idx1, idx2 - 1));
		}

		return mem[idx1][idx2];

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String in;
		StringBuilder sb = new StringBuilder("");
		int alen, blen;

		in = br.readLine();
		alen = in.length() - 1;

		for (int i = 0; i <= alen; i++)
			str[0][i] = in.charAt(i);

		in = br.readLine();
		blen = in.length() - 1;

		for (int i = 0; i <= blen; i++)
			str[1][i] = in.charAt(i);

		for (int i = 0; i < 1000; i++) {
			Arrays.fill(mem[i], -1);
		}
		if (alen == -1 || blen == -1)
			bw.write("0");
		else {
			int len = dp(alen, blen);
			while (len > 0) {
				for (int i = alen; i >= 0; i--) {
					if (mem[i][blen] == len && str[0][i] == str[1][blen]) {
						sb.append(str[1][blen]);
						alen = i-1;
						len--;
						break;
					}
				}
				blen--;
			}
			bw.write(sb.toString().length() + "\n" + sb.reverse().toString());
		}
		bw.flush();
		bw.close();
	}
}