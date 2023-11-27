package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {

	public static int kmp(String s) {

		int idx = 0;
		int out = 0;
		int pi[] = new int[s.length()];
		Arrays.fill(pi, 0);

		for (int i = 1; i < s.length(); i++) {
			while (idx > 0 && s.charAt(idx) != s.charAt(i)) {
				idx = pi[idx-1];
			}
			
			if( s.charAt(idx) == s.charAt(i)) {
				idx++;
				pi[i] = idx;
				out = Math.max(out, idx);
			}
		}

		return out;

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String in = br.readLine();
		int res = 0;

		for (int i = 0; i < in.length() - 1; i++) {
			String sub = in.substring(i, in.length());
			res = Math.max(res, kmp(sub));
		}

		bw.write(res + "");

		bw.flush();
		bw.close();

	}

}
