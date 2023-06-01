package Mathematics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1356_Equidigital_Number_B1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int a = (int) Math.pow(10, (int) Math.log10(n)) * 10;
		int b = 10;

		String out = "NO";

		int r1 = (n % a) / (a / 10);
		int r2 = (n % b) / (b / 10);

		a /= 10;
		b *= 10;

		if (n >= 1000000000) {
			r1 = n / 1000000000;
			a = 1000000000;
		}

		while (true) {

			if (a == 1) {
				break;
			}

			if (a < b) {
				if (r1 == r2) {
					out = "YES";
				}
				break;
			}

			if (r1 > r2) {
				r2 *= (n % b) / (b / 10);
				b *= 10;
			} else {
				r1 *= (n % a) / (a / 10);
				a /= 10;
			}

		}

		String chk = String.valueOf(n);
		int cnt = 0;
		for (int i = 0; i < chk.length(); i++) {
			if (chk.charAt(i) == '0') {
				cnt++;
			}
			if (cnt == 2) {
				out = "YES";
				break;
			}
		}

		bw.write(out);

		bw.flush();
		bw.close();
	}
}
