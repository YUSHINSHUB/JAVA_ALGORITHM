package Bruteforcing;

import java.io.*;

public class Q1543_Search_Documents_S4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String d1 = br.readLine();
		String d2 = br.readLine();
		int len = d2.length();
		char f = d2.charAt(0);
		int res = 0;

		for (int i = 0; i <= d1.length() - len; i++) {
			if (d1.charAt(i) == f) {
				if (d1.substring(i, i + len).equals(d2)) {
					res++;
					i += len - 1;
				}
			}
		}

		bw.write(res + "");
		bw.flush();
		bw.close();

	}
}