package Mathematics;

import java.io.*;

class Q15552_Fast_AplusB_B4 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int i = Integer.parseInt(br.readLine().trim());

		for (int a = 0; a < i; a++) {
			String s = br.readLine();
			int split = s.indexOf(" ");
			int res = Integer.parseInt(s.substring(0, split)) + Integer.parseInt(s.substring(split + 1, s.length()));
			bw.write(res + "\n");
		}
		br.close();
		bw.flush();
		bw.close();

	}

}