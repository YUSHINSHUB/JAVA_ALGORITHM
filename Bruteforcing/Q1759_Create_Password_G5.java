package Bruteforcing;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q1759_Create_Password_G5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");

		int l = Integer.parseInt(inp[0]);
		int c = Integer.parseInt(inp[1]);

		String ialp[] = br.readLine().split(" ");
		char alp[] = new char[c];
		int cnt[] = new int[l];

		for (int i = 0; i < c; i++) {
			alp[i] = ialp[i].charAt(0);
		}

		for (int i = 0; i < l; i++) {
			cnt[i] = i;
		}

		Arrays.sort(alp);
		Boolean end = false;

		char chk[] = { 'a', 'e', 'i', 'o', 'u' };
		Boolean pass = true;

		int c1 = 0, c2 = 0;

		while (true) {
			c1 = 0;
			c2 = 0;
			for (int i = 0; i < l; i++) {
				if (alp[cnt[i]] == 'a' || alp[cnt[i]] == 'e' || alp[cnt[i]] == 'i' || alp[cnt[i]] == 'o'
						|| alp[cnt[i]] == 'u') {
					c1++;
				} else {
					c2++;
				}
				if (c1 >= 1 && c2 >= 2) {
					pass = false;
					break;
				}
			}
			if (pass == false) {
				for (int i = 0; i < l; i++) {
					bw.write(Character.toString(alp[cnt[i]]));

				}
				bw.write("\n");
			}

			pass = true;
			cnt[l - 1]++;
			if (cnt[l - 1] >= c) {
				cnt[l - 1]--;
				int temp = l - 2;
				while (cnt[temp] == cnt[temp + 1] - 1) {
					temp--;
					if (temp == -1) {
						end = true;
						break;
					}
				}
				if (end == false) {
					cnt[temp]++;
					for (int i = temp + 1; i < l; i++)
						cnt[i] = cnt[i - 1] + 1;
				} else {
					break;
				}
			}
		}

		bw.flush();
		bw.close();
	}
}
