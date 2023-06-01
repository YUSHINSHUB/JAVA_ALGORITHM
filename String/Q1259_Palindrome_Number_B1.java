package String;

import java.io.*;

public class Q1259_Palindrome_Number_B1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String in;
		boolean chk = true;

		while (true) {
			in = br.readLine();
			chk = true;
			if (in.equals("0")) {
				break;
			}

			for (int i = 0; i < in.length(); i++) {
				if (in.charAt(i) != in.charAt(in.length() - 1 - i)) {
					chk = false;
					break;
				}
			}

			if (chk == true) {
				bw.write("yes" + "\n");
			} else {
				bw.write("no" + "\n");
			}

		}

		bw.flush();
		bw.close();

	}
}
