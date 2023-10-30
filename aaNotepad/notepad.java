package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		double bld[] = new double[N + 1];
		double s = 0;
		int cnt = 0;
		int res = 0;

		String inp[] = br.readLine().split(" ");
		for (int i = 1; i <= N; i++)
			bld[i] = Double.parseDouble(inp[i - 1]);

		for (int i = 1; i <= N; i++) {
			cnt = 0;
			s = Integer.MIN_VALUE;

			for (int j = i - 1; j >= 1; j--) {
				if (((bld[j] - bld[i]) / Math.abs(j - i)) > s) {
					cnt++;
					s = ((bld[j] - bld[i]) / Math.abs(j - i));
				}
			}

			s = Integer.MIN_VALUE;

			for (int j = i + 1; j <= N; j++) {
				if (((bld[j] - bld[i]) / Math.abs(j - i)) > s) {
					cnt++;
					s = ((bld[j] - bld[i]) / Math.abs(j - i));
				}
			}

			if (cnt > res)
				res = cnt;

		}

		bw.write(res + "");

		bw.flush();
		bw.close();

	}

}
