package String;

import java.io.*;

public class Q2864_Difference_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] inp = br.readLine().split(" ");

		StringBuilder a = new StringBuilder(inp[0]);
		StringBuilder b = new StringBuilder(inp[1]);

		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == '6') {
				a.setCharAt(i, '5');
			}
		}

		for (int i = 0; i < b.length(); i++) {
			if (b.charAt(i) == '6') {
				b.setCharAt(i, '5');
			}
		}

		int res1 = Integer.parseInt(a.toString()) + Integer.parseInt(b.toString());

		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == '5') {
				a.setCharAt(i, '6');
			}
		}

		for (int i = 0; i < b.length(); i++) {
			if (b.charAt(i) == '5') {
				b.setCharAt(i, '6');
			}
		}

		int res2 = Integer.parseInt(a.toString()) + Integer.parseInt(b.toString());

		bw.write(String.valueOf(res1) + " " + String.valueOf(res2));

		bw.flush();
		bw.close();
	}
}
