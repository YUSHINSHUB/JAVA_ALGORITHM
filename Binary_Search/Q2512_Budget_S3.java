package Binary_Search;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q2512_Budget_S3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int low = Integer.MAX_VALUE;
		int hig = Integer.MIN_VALUE;

		int cur[] = new int[n];
		int sum = 0;
		int mid = 0;

		String inp[] = br.readLine().split(" ");
		int dep = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			cur[i] = Integer.parseInt(inp[i]);
			sum += cur[i];
			low = Math.min(low, cur[i]);
			hig = Math.max(hig, cur[i]);
		}

		if (sum > dep) {
			while (mid != low) {
				mid = (low + hig) / 2;
				sum = 0;
				for (int i = 0; i < n; i++) {
					if (cur[i] > mid)
						sum += mid;
					else
						sum += cur[i];
				}

				if (sum > dep) {
					hig = mid;
				} else if (sum < dep) {
					low = mid + 1;
				}

			}
			while (true) {
				sum = 0;
				for (int i = 0; i < n; i++) {
					if (cur[i] > mid)
						sum += mid;
					else
						sum += cur[i];
				}
				if (sum > dep)
					mid--;
				else
					break;
			}

		} else {
			mid = hig;
		}

		bw.write(mid + "");

		bw.flush();
		bw.close();

	}
}