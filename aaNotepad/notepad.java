package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		HashMap<Integer, Integer> hm = new HashMap<>();

		for (int i = 0; i <= 9; i++) {
			hm.put(i, 1);
		}

		String inp[] = new String[10];
		if( m > 0 ) inp = br.readLine().split(" ");

		for (int i = 0; i < m; i++) {
			hm.put(Integer.parseInt(inp[i]), 0);
		}

		int res;

		if (n > 100)
			res = n - 100;
		else
			res = 100 - n;

		for (int i = 0; i <= 1000000; i++) {
			String t = i + "";
			for (int j = 0; j < t.length(); j++) {
				if (hm.get(Integer.parseInt(Character.toString(t.charAt(j)))) != 1) {
					break;
				}
				if (j == t.length() - 1) {
					res = Math.min(res, t.length() + Math.abs(n - i));
				}
			}
		}

		bw.write(res + "");

		bw.flush();
		bw.close();

	}
}
