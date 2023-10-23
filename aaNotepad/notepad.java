package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String inp[] = new String[N];
		int res = 0;
		int cnt[] = new int[26];
		int conv[] = new int[26];
		int idx = 9;
		Arrays.fill(cnt, 0);

		for (int i = 0; i < N; i++) {
			inp[i] = br.readLine();
			for (int j = 0; j < inp[i].length(); j++) {
				cnt[inp[i].charAt(j) - 'A'] += Math.pow(10, inp[i].length() - j);
			}
		}

		while (true) {
			int hig = 0;
			int hidx = -1;
			for (int i = 0; i < 26; i++) {
				if (cnt[i] > hig) {
					hig = cnt[i];
					hidx = i;
				}
			}
			if (hig == 0)
				break;
			conv[hidx] = idx;
			cnt[hidx] = 0;
			idx--;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < inp[i].length(); j++) {
				res += Math.pow(10, inp[i].length() - j-1) * conv[inp[i].charAt(j) - 'A'];
			}
		}

		bw.write(res + "");
		bw.flush();
		bw.close();

	}

}
