package Recursion;

import java.io.*;
import java.util.*;

public class Q4779_Cantor_S3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder cnt[] = new StringBuilder[13];

		for (int i = 0; i <= 12; i++)
			cnt[i] = new StringBuilder("");

		cnt[0].append("-");

		for (int i = 1; i <= 12; i++) {
			int bl = cnt[i - 1].length();
			for (int j = 0; j < bl; j++) {
				cnt[i].append(cnt[i - 1].charAt(j));
			}
			for (int j = 0; j < bl; j++) {
				cnt[i].append(" ");
			}
			for (int j = 0; j < bl; j++) {
				cnt[i].append(cnt[i - 1].charAt(j));
			}
		}

		String inp = "";
		while ((inp = br.readLine()) != null) {
			bw.write(cnt[Integer.parseInt(inp)] + "\n");
		}

		bw.flush();
		bw.close();
	}
}