package Recursion;

import java.io.*;
import java.util.*;

public class Q25501_Talented_B2 {

	static int cnt;

	protected static int recursion(String s, int l, int r) {
		cnt++;
		if (l >= r)
			return 1;
		else if (s.charAt(l) != s.charAt(r))
			return 0;
		else
			return recursion(s, l + 1, r - 1);
	}

	protected static int isPalindrome(String s) {
		return recursion(s, 0, s.length() - 1);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String inp;

		for (int i = 0; i < n; i++) {
			inp = br.readLine();
			cnt = 0;
			bw.write(isPalindrome(inp) + " " + cnt + "\n");
		}

		bw.flush();
		bw.close();

	}
}