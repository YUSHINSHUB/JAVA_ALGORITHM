package Bruteforcing;

import java.io.*;

public class Q1436_Movie_Director_S5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int res = 665;
		int cnt = 0;

		while (true) {
			res++;
			String temp = String.valueOf(res);
			for (int i = 2; i < temp.length(); i++) {
				if (temp.charAt(i) == '6' && temp.charAt(i - 1) == '6' && temp.charAt(i - 2) == '6') {
					cnt++;
					break;
				}
			}
			if (cnt == n)
				break;
		}

		bw.write(res + "");

		bw.flush();
		bw.close();
	}
}