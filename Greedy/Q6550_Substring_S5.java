package Greedy;

import java.io.*;

public class Q6550_Substring_S5 {

	static boolean get(int idx, String s, String t) {

		int cnt = 1;
		for (int i = idx + 1; i < t.length(); i++) {
			if (cnt >= s.length()) {
				break;
			}
			if (t.charAt(i) == s.charAt(cnt)) {
				cnt++;
			}
		}

		if (cnt >= s.length())
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp;

		while ((inp = br.readLine()) != null) {

			String temp[] = inp.split(" ");
			boolean res = false;
			String s = temp[0];
			String t = temp[1];

			for (int i = 0; i < t.length(); i++) {
				if (t.charAt(i) == s.charAt(0)) {
					if (get(i, s, t)) {
						res = true;
						break;
					}
				}
			}

			if (res)
				bw.write("Yes\n");
			else
				bw.write("No\n");

		}

		bw.flush();
		bw.close();

	}

}
