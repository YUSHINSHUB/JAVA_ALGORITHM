package String;

import java.io.*;

public class Q1439_Reverse_S5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String in = br.readLine();
		int zc = 0;
		int oc = 0;

		for (int i = 1; i < in.length(); i++) {
			if (in.charAt(i) != in.charAt(i - 1)) {
				if (in.charAt(i) == '1')
					zc++;
				else
					oc++;
			}
			if (i == in.length() - 1) {
				if (in.charAt(i) == '1')
					oc++;
				else
					zc++;
			}
		}

		bw.write(Math.min(zc, oc) + "");

		bw.flush();
		bw.close();

	}
}
