package Greedy;

import java.io.*;

public class Q5585_CHANGE_B2 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = 1000 - Integer.parseInt(br.readLine());
		int cnt = 0;

		while (n != 0) {
			if (n >= 500) {
				n -= 500;
				cnt++;
			} else if (n >= 100) {
				n -= 100;
				cnt++;
			} else if (n >= 50) {
				n -= 50;
				cnt++;
			} else if (n >= 10) {
				n -= 10;
				cnt++;
			} else if (n >= 5) {
				n -= 5;
				cnt++;
			} else {
				n--;
				cnt++;
			}
		}

		bw.write(String.valueOf(cnt));

		bw.flush();
		bw.close();

	}
}
