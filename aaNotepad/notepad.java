package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		int len = s.length();
		int y = 0, n = 0;
		int res = 0;
		boolean pass = false;

		if (s.charAt(0) == '0')
			bw.write("0");
		else if (len == 1)
			bw.write("1");
		else {
			int temp = Integer.parseInt(s.substring(0, 2));

			if (temp % 10 == 0 && temp >= 30) {
				pass = true;
				res = 0;
			}

			if (!pass) {
				if (temp <= 26) {
					res = 2;
					y = 1;
					n = 1;
					if (temp == 10 || temp == 20) {
						res = 1;
						y = 1;
						n = 0;
					}
				}else {
					res = 1;
					y = 0;
					n = 1;
				}
				
				for (int i = 1; i < s.length() - 1; i++) {
					temp = Integer.parseInt(s.substring(i, i + 2));

					if ((temp % 10 == 0 && temp >= 30) || temp == 0) {
						pass = true;
						res = 0;
						break;
					}

					if (temp <= 26 && temp >= 10) {
						if (temp == 10 || temp == 20) {
							res = ((res + 1000000) - y) % 1000000;
							y = res;
							n = 0;
						} else {
							y = n;
							n = res;
							res = (y + n) % 1000000;
						}
					} else {
						y = 0;
						n = res;
					}
				}
			}
			if (res == 0 && !pass)
				res = 1;

			temp = Integer.parseInt(s.substring(s.length() - 2, s.length()));

			bw.write(res + "");
		}

		bw.flush();
		bw.close();

	}
}
