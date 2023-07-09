package String;

import java.io.*;
import java.util.*;

public class Q1213_Make_Palindrome_S3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		int cnt[] = new int[26];
		int dcnt = 0;
		String res = "";
		Arrays.fill(cnt, 0);

		for (int i = 0; i < s.length(); i++) {
			cnt[s.charAt(i) - 'A']++;
			if (cnt[s.charAt(i) - 'A'] % 2 == 1)
				dcnt++;
			else
				dcnt--;
		}

		if (s.length() % 2 == 1) {
			if (dcnt != 1)
				bw.write("I'm Sorry Hansoo");
			else {
				for (int i = 0; i < 26; i++) {
					while (cnt[i] > 1) {
						res += (char) (i + 'A');
						cnt[i] -= 2;
					}
				}
				for (int i = 0; i < 26; i++) {
					if (cnt[i] == 1) {
						res += (char) (i + 'A');
						break;
					}
				}
				res += new StringBuilder(res.substring(0, res.length() - 1)).reverse();
				bw.write(res);
			}
		} else {
			if (dcnt != 0)
				bw.write("I'm Sorry Hansoo");
			else {
				for (int i = 0; i < 26; i++) {
					while (cnt[i] > 1) {
						res += (char) (i + 'A');
						cnt[i] -= 2;
					}
				}
				res += new StringBuilder(res.substring(0, res.length())).reverse();
				bw.write(res);
			}
		}

		bw.flush();
		bw.close();

	}
}