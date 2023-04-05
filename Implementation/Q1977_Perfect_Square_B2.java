package Implementation;

import java.io.*;

public class Q1977_Perfect_Square_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int res1 = 0;
		int res2 = 0;

		for (int i = n; i <= m; i++) {
			String temp = String.valueOf(Math.sqrt(i));
			if (Math.sqrt(i) == (int) Math.sqrt(i)) {
				if (res2 == 0) {
					res2 = i;
				}
				res1 += i;
			}
		}

		if (res1 == 0) {
			bw.write("-1");
		} else {
			bw.write(String.valueOf(res1) + "\n" + String.valueOf(res2));
		}

		bw.flush();
		bw.close();

	}

}
