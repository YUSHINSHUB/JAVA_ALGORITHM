package String;

import java.io.*;

public class Q10798_Vertical_Reading_B1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] in = new String[5];
		int max = 0;

		for (int i = 0; i < 5; i++) {
			in[i] = br.readLine();
			if (max < in[i].length()) {
				max = in[i].length();
			}
		}

		for (int i = 0; i < max; i++) {
			if (in[0].length() > i) {
				bw.write(in[0].charAt(i));
			}
			if (in[1].length() > i) {
				bw.write(in[1].charAt(i));
			}
			if (in[2].length() > i) {
				bw.write(in[2].charAt(i));
			}
			if (in[3].length() > i) {
				bw.write(in[3].charAt(i));
			}
			if (in[4].length() > i) {
				bw.write(in[4].charAt(i));
			}
		}

		bw.flush();
		bw.close();
	}
}