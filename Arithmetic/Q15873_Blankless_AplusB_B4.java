package Arithmetic;

import java.io.*;

public class Q15873_Blankless_AplusB_B4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String ab = br.readLine();
		int res = 0;

		switch (ab.length()) {
		case 4:
			res = 20;
			break;
		case 3:
			if (ab.charAt(1) == '0') {
				res = 10 + (ab.charAt(2) - 48);
			} else {
				res = 10 + (ab.charAt(0) - 48);
			}
			break;
		case 2:
			res = (ab.charAt(0) - 48) + (ab.charAt(1) - 48);

		}

		bw.write(String.valueOf(res));

		bw.flush();
		bw.close();

	}

}