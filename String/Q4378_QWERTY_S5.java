package String;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Q4378_QWERTY_S5 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = "";
		String change = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";
		StringBuilder sb = new StringBuilder("");

		while ((s = br.readLine()) != null) {
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == ' ') {
					sb.append(' ');
				} else {
					for (int j = 1; j < change.length(); j++) {
						if (s.charAt(i) == change.charAt(j)) {
							sb.append(change.charAt(j - 1));
							break;
						}
					}
				}
			}
			sb.append("\n");
		}

		bw.write(sb.toString());

		bw.flush();
		bw.close();
	}
}
