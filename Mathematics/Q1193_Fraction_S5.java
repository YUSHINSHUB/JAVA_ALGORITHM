package Mathematics;

import java.io.*;

public class Q1193_Fraction_S5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int cnt = Integer.parseInt(br.readLine());
		int temp = 2;
		int r = 1;
		String res = "";
		boolean b = true;

		while (true) {
			cnt--;
			if (cnt == 0) {
				break;
			}

			if (b == false) {
				r++;
				if (r == temp) {
					b = true;
					temp++;
				}
			} else {
				r--;
				if (r == 0) {
					r = 1;
					temp++;
					b = false;
				}
			}

		}
		res = String.valueOf(r) + "/" + String.valueOf(temp - r);
		bw.write(res);

		bw.flush();
		bw.close();

	}
}