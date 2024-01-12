package Number_Theory;

import java.io.*;
import java.util.*;

public class Q6064_Calendar_S1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		int m, n, x, y;

		for (int i = 0; i < t; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			m = Integer.parseInt(stk.nextToken());
			n = Integer.parseInt(stk.nextToken());
			x = Integer.parseInt(stk.nextToken());
			y = Integer.parseInt(stk.nextToken());

			int hi = Math.max(m, n);
			int end = hi;
			while (end % m != 0 || end % n != 0) {
				end += hi;
			}

			int res = Math.min(x, y);
			int up = 0;
			if (res == x) {
				up = m;
			} else {
				up = n;
			}
			if (m == x) {
				x = 0;
			}
			if (n == y) {
				y = 0;
			}

			while (res <= end) {
				if (res % m == x && res % n == y) {
					break;
				} else {
					res += up;
					if (res == end) {
						if (x == 0)
							x += m;
						if (y == 0)
							y += n;
						if (res % x == 0 && res % y == 0)
							break;
					}
				}
			}

			if (res > end) {
				res = -1;
			}

			bw.write(String.valueOf(res) + "\n");

		}

		bw.flush();
		bw.close();

	}
}