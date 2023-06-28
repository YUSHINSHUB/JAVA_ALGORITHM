package String;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q2941_Croatian_Alphabet_S5 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String in = br.readLine();
		int cnt = 0;

		for (int i = 0; i < in.length(); i++) {
			if (in.charAt(i) == 'c' && i < in.length() - 1) {
				if (in.charAt(i + 1) == '=') {
					i++;
					cnt++;
				} else if (in.charAt(i) == '-') {
					i++;
					cnt++;
				} else
					cnt++;
			} else if (in.charAt(i) == 'd' && i < in.length() - 2) {
				if (in.charAt(i + 1) == 'z' && in.charAt(i + 2) == '=') {
					i += 2;
					cnt++;
				} else if (in.charAt(i + 1) == '-') {
					i++;
					cnt++;
				} else
					cnt++;
			} else if (in.charAt(i) == 'd' && i < in.length() - 1) {
				if (in.charAt(i + 1) == '-') {
					i++;
					cnt++;
				} else
					cnt++;
			} else if (in.charAt(i) == 'l' && i < in.length() - 1) {
				if (in.charAt(i + 1) == 'j') {
					i++;
					cnt++;
				} else
					cnt++;
			} else if (in.charAt(i) == 'n' && i < in.length() - 1) {
				if (in.charAt(i + 1) == 'j') {
					i++;
					cnt++;
				} else
					cnt++;
			} else if (in.charAt(i) == 's' && i < in.length() - 1) {
				if (in.charAt(i + 1) == '=') {
					i++;
					cnt++;
				} else
					cnt++;
			} else if (in.charAt(i) == 'z' && i < in.length() - 1) {
				if (in.charAt(i + 1) == '=') {
					i++;
					cnt++;
				} else
					cnt++;
			} else if (in.charAt(i) >= 97 && in.charAt(i) <= 122)
				cnt++;
		}

		bw.write(cnt + "");
		bw.flush();
		bw.close();

	}
}
