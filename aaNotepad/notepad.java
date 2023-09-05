package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {

			String res = "0\n";
			String s = br.readLine();
			int beg = 0;
			int end = s.length() - 1;
			int sbeg = -1;
			int send = -1;

			while (beg < end) {
				if (s.charAt(beg) != s.charAt(end)) {
					if (res.equals("0\n")) {
						if (s.charAt(beg + 1) == s.charAt(end) && s.charAt(beg) == s.charAt(end - 1)) {
							sbeg = beg;
							send = end;
							res = "1\n";
							beg++;
						} else if (s.charAt(beg + 1) == s.charAt(end)) {
							res = "1\n";
							beg++;
						} else if (s.charAt(beg) == s.charAt(end - 1)) {
							res = "1\n";
							end--;
						} else {
							res = "2\n";
							break;
						}
					} else {
						if (sbeg != -1) {
							beg = sbeg;
							end = send - 1;
							sbeg = -1;
						} else {
							res = "2\n";
							break;
						}
					}
				}
				beg++;
				end--;
			}

			bw.write(res);
		}

		bw.flush();
		bw.close();

	}
}
