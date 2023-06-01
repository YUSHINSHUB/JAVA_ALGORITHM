package String;

import java.io.*;

public class Q4659_Pronounce_PW_S5 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String pass = "";
		String vowel = "aeiou";

		while (true) {

			pass = br.readLine();
			if (pass.equals("end"))
				break;

			boolean b1 = false, b2 = true, b3 = true;

			if (pass.length() == 1) {
				if (vowel.contains(pass.charAt(0) + ""))
					b1 = true;
			} else if (pass.length() == 2) {
				if (vowel.contains(pass.charAt(0) + "") || vowel.contains(pass.charAt(1) + ""))
					b1 = true;
				if (pass.charAt(0) == pass.charAt(1) && pass.charAt(0) != 'e' && pass.charAt(0) != 'o') {
					b3 = false;
				}
			} else {
				if (vowel.contains(pass.charAt(0) + "") || vowel.contains(pass.charAt(1) + ""))
					b1 = true;
				if (pass.charAt(0) == pass.charAt(1) && pass.charAt(0) != 'e' && pass.charAt(0) != 'o') {
					b3 = false;
				}

				if (b3) {
					for (int i = 2; i < pass.length(); i++) {

						if (vowel.contains(pass.charAt(i) + ""))
							b1 = true;

						if (vowel.contains(pass.charAt(i) + "") && vowel.contains(pass.charAt(i - 1) + "")
								&& vowel.contains(pass.charAt(i - 2) + "")) {
							b2 = false;
							break;
						} else if (!vowel.contains(pass.charAt(i) + "") && !vowel.contains(pass.charAt(i - 1) + "")
								&& !vowel.contains(pass.charAt(i - 2) + "")) {
							b2 = false;
							break;
						}

						if (pass.charAt(i) == pass.charAt(i - 1) && pass.charAt(i) != 'e' && pass.charAt(i) != 'o') {
							b3 = false;
							break;
						}

					}
				}
			}

			if (b1 && b2 && b3)
				bw.write("<" + pass + "> is acceptable.\n");
			else
				bw.write("<" + pass + "> is not acceptable.\n");

		}

		bw.flush();
		bw.close();
	}
}
