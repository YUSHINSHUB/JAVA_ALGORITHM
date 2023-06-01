package String;

import java.io.*;
import java.util.*;

public class Q2596_Secret_Letter_B1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int idx = 0;
		StringBuilder out = new StringBuilder("");
		Boolean pass = false;
		Boolean wrong = false;

		String word[] = { "000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010" };

		for (int i = 0; i < n; i++) {
			wrong = false;
			pass = false;

			int cnt[] = new int[8];
			Arrays.fill(cnt, 0);
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 8; k++) {
					if (s.charAt(6 * i + j) != word[k].charAt(j)) {
						cnt[k]++;
					}
				}
			}
			for (int j = 0; j < 8; j++) {
				if (cnt[j] == 0) {
					pass = true;
					if (j == 0)
						out.append("A");
					else if (j == 1)
						out.append("B");
					else if (j == 2)
						out.append("C");
					else if (j == 3)
						out.append("D");
					else if (j == 4)
						out.append("E");
					else if (j == 5)
						out.append("F");
					else if (j == 6)
						out.append("G");
					else
						out.append("H");
					break;
				}
			}

			if (!pass) {
				for (int j = 0; j < 8; j++) {
					if (cnt[j] == 1) {
						if (pass == true) {
							out = new StringBuilder(i + 1 + "");
							break;
						} else {
							pass = true;
							idx = j;
						}
					}
				}
			} else
				continue;

			if (!pass) {
				out = new StringBuilder(i + 1 + "");
				break;
			} else {
				if (idx == 0)
					out.append("A");
				else if (idx == 1)
					out.append("B");
				else if (idx == 2)
					out.append("C");
				else if (idx == 3)
					out.append("D");
				else if (idx == 4)
					out.append("E");
				else if (idx == 5)
					out.append("F");
				else if (idx == 6)
					out.append("G");
				else
					out.append("H");
				continue;
			}

		}

		bw.write(out.toString());

		bw.flush();
		bw.close();
	}
}