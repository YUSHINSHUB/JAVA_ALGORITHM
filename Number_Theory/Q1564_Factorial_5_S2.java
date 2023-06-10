package Number_Theory;

import java.io.*;

public class Q1564_Factorial_5_S2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		long res = 1;
		long mod = 100000;
		mod *= 100000;

		for (int i = 2; i <= n; i++) {
			res *= i;

			while (res % 10 == 0) {
				res /= 10;
			}

			res %= mod;

		}

		res %= 100000;
		String out = res + "";

		while (out.length() < 5)
			out = "0" + out;

		bw.write(out);
		bw.flush();
		bw.close();
	}
}
