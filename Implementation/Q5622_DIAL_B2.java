package Implementation;

import java.io.*;

public class Q5622_DIAL_B2 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();

		int res = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'A' && s.charAt(i) <= 'C') {
				res += 3;
			} else if (s.charAt(i) >= 'D' && s.charAt(i) <= 'F') {
				res += 4;
			} else if (s.charAt(i) >= 'G' && s.charAt(i) <= 'I') {
				res += 5;
			} else if (s.charAt(i) >= 'J' && s.charAt(i) <= 'L') {
				res += 6;
			} else if (s.charAt(i) >= 'M' && s.charAt(i) <= 'O') {
				res += 7;
			} else if (s.charAt(i) >= 'P' && s.charAt(i) <= 'S') {
				res += 8;
			} else if (s.charAt(i) >= 'T' && s.charAt(i) <= 'V') {
				res += 9;
			} else if (s.charAt(i) >= 'W' && s.charAt(i) <= 'Z') {
				res += 10;
			}
		}

		bw.write(String.valueOf(res));
		bw.flush();
		bw.close();

	}
}
