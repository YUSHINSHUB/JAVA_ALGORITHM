package String;

import java.io.*;
import java.math.*;

public class Q5525_IOIOI_S1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int res = 0;
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;

		n *= 2;
		n++;

		int m = Integer.parseInt(br.readLine());

		String s = br.readLine();

		for (int i = 0; i < m; i++) {
			if (cnt % 2 == 0 && s.charAt(i) == 'I') {
				cnt++;
				if (cnt == n) {
					res++;
					cnt -= 2;
				}
			} else if (cnt % 2 == 1 && s.charAt(i) == 'O')
				cnt++;
			else if (s.charAt(i) == 'I')
				cnt = 1;
			else
				cnt = 0;
		}

		bw.write(res + "");

		bw.flush();
		bw.close();

	}
}
