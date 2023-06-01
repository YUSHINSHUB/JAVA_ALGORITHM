package Bruteforcing;

import java.io.*;
import java.util.*;
import java.text.*;

public class Q13987_Six_Sides_B2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

		int win = 0, pair = 0;
		int f[] = new int[6];
		int s[] = new int[6];

		for (int i = 0; i < 6; i++)
			f[i] = Integer.parseInt(stk.nextToken());

		stk = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 6; i++)
			s[i] = Integer.parseInt(stk.nextToken());

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (f[i] > s[j])
					win++;
				else if (f[i] == s[j])
					pair++;
			}
		}

		double add = (double) pair / 36;
		double base = (double) win / 36;
		double res = base;
		double res2 = base;
		base *= add;
		double temp, temp2;
		int idx = 1;
		DecimalFormat df = new DecimalFormat("0.00000");

		while (true) {
			res2 += base;
			if (res == res2)
				break;
			else {
				res = res2;
				base *= add;
			}
		}

		String out = df.format(res);
		bw.write(out);
		bw.flush();
		bw.close();

	}
}