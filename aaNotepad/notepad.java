package aaNotepad;

import java.io.*;
import java.util.*;
import java.math.*;

public class notepad {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N, k;
		int low, mid, hig;
		int res = 0;

		N = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());

		low = 1;
		hig = k;
		mid = (low + hig) / 2;

		while (true) {

			if (low > hig)
				break;
			mid = (low + hig) / 2;

			int temp = 0;
			for (int i = 1; i <= N; i++) {
				temp += Math.min(mid / i, N);
				if (temp > k)
					break;
			}

			if (temp < k) {
				low = mid + 1;
			} else {
				res = mid;
				hig = mid - 1;
			}

		}

		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}