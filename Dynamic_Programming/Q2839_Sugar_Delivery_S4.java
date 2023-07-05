package Dynamic_Programming;

import java.io.*;

public class Q2839_Sugar_Delivery_S4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int out = n / 5;

		int res = n % 5;

		boolean chk = false;

		if (res % 3 == 0) {
			out += res / 3;
		} else {
			while (chk == false) {
				out--;
				if (out == -1) {
					break;
				}
				res = n - (out * 5);
				if (res % 3 == 0) {
					out += res / 3;
					chk = true;
				}
			}
		}

		bw.write(String.valueOf(out));

		bw.flush();
		bw.close();

	}

}