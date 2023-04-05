package Implementation;

import java.io.*;

public class Q1159_Basketball_Game_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String temp;
		int cnt[] = new int[27];
		boolean chk = true;

		for (int i = 0; i < n; i++) {
			temp = br.readLine();
			cnt[(int) (temp.charAt(0) - 97)]++;
		}

		for (int i = 0; i < 26; i++) {
			if (cnt[i] >= 5) {
				chk = false;
				bw.write((char) (i + 97));
			}
		}

		if (chk == true) {
			bw.write("PREDAJA");
		}

		bw.flush();
		bw.close();
	}
}