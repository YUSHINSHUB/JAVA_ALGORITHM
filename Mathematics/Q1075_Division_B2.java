package Mathematics;

import java.io.*;

public class Q1075_Division_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int a = Integer.parseInt(br.readLine());
		int m = n % 100;
		int res = 0;

		for (int i = n - m;; i++) {
			if (i % a == 0) {
				res = i % 100;
				break;
			}
		}

		if (res < 10) {
			bw.write("0" + String.valueOf(res));
		} else {
			bw.write(String.valueOf(res));
		}

		bw.flush();
		bw.close();
	}

}