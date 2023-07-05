package Dynamic_Programming;

import java.io.*;
import java.math.*;

public class Q2491_SEQUENCE_S4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String in[] = br.readLine().split(" ");
		int cnt = 0;
		boolean chk[] = new boolean[n];
		chk[0] = true;
		int scr[] = new int[n];
		scr[0] = 1;
		int cur = 0;
		int res = 0;

		for (int i = 1; i < n; i++) {
			if (Integer.parseInt(in[i]) == Integer.parseInt(in[i - 1])) {
				scr[cnt]++;
			} else {
				cnt++;
				scr[cnt] = 1;
				if (Integer.parseInt(in[i - scr[cnt]]) < Integer.parseInt(in[i])) {
					chk[cnt] = true;
				} else {
					chk[cnt] = false;
				}
			}
		}

		cur = scr[0];

		for (int i = 1; i <= cnt; i++) {
			if (chk[i] != chk[i - 1]) {
				res = Math.max(res, cur);
				cur = scr[i] + scr[i - 1];
			} else {
				cur += scr[i];
			}
		}

		res = Math.max(res, cur);
		bw.write(res + "");

		bw.flush();
		bw.close();

	}
}