package String;

import java.io.*;

public class Q1152_Number_of_Words_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str[] = br.readLine().split(" ");
		int out = str.length;
		if (out >= 1) {
			if (str[0].contentEquals("")) {
				out--;
			}
		}

		bw.write(String.valueOf(out));

		bw.flush();
		bw.close();
	}
}