package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int idx = 0;

		String s = br.readLine();
		String b = br.readLine();
		char c = b.charAt(b.length() - 1);
		StringBuilder sb = new StringBuilder("");

		while (idx < s.length()) {

			if (sb.length() < b.length()) {
				while (sb.length() != b.length()) {
					sb.append(s.charAt(idx));
					idx++;
				}
			} else {
				sb.append(s.charAt(idx));
				idx++;
			}

			if (sb.charAt(sb.length() - 1) == c
					&& sb.toString().substring(sb.length() - b.length(), sb.length()).equals(b)) {
				sb.delete(sb.length() - b.length(), sb.length());
			}

		}

		if (sb.isEmpty())
			bw.write("FRULA");
		else
			bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
}
