package Implementation;

import java.io.*;

public class Q5598_CaesarCipher_B2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String pas = br.readLine();
		String res = "";

		for (int i = 0; i < pas.length(); i++) {
			char c = (char) ((int) (pas.charAt(i)) - 3);
			if (c < 'A')
				c = (char) ('Z' + (c - 'A') + 1);
			res += c;
		}

		bw.write(res);

		bw.flush();
		bw.close();

	}

}
