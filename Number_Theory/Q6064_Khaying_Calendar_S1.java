package Number_Theory;

import java.io.*;
import java.util.*;

public class Q6064_Khaying_Calendar_S1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine()); // Number of test cases
		int m, n, x, y;

		for (int i = 0; i < t; i++) { // Loop through each test case
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			m = Integer.parseInt(stk.nextToken());
			n = Integer.parseInt(stk.nextToken());
			x = Integer.parseInt(stk.nextToken());
			y = Integer.parseInt(stk.nextToken());

			int hi = Math.max(m, n); // Find the maximum of m and n
			int end = hi;

			// Loop until we find a common multiple of m and n
			while (end % m != 0 || end % n != 0) {
				end += hi;
			}

			int res = Math.min(x, y);
			int up = (res == x) ? m : n; // Determine the step size for res

			// Set x and y to 0 if they are equal to m or n respectively
			if (m == x)
				x = 0;
			if (n == y)
				y = 0;

			// Loop until we find a number that meets the conditions or we exceed the common
			// multiple of m and n
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

			if (res > end) { // If we didn't find a suitable number, set res to -1
				res = -1;
			}

			bw.write(String.valueOf(res) + "\n"); // Write the result
		}

		bw.flush();
		bw.close();
	}
}