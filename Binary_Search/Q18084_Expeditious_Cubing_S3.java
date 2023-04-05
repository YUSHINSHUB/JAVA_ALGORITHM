package Binary_Search;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q18084_Expeditious_Cubing_S3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		double scr[] = new double[4];
		double hig = 0;
		double low = Double.MAX_VALUE;
		int hindex = 0;
		int lindex = 0;

		String inp[] = br.readLine().split(" ");

		for (int i = 0; i < 4; i++) {
			scr[i] = Double.parseDouble(inp[i]);
			if (hig < scr[i]) {
				hig = scr[i];
				hindex = i;
			}
			if (low > scr[i]) {
				low = scr[i];
				lindex = i;
			}
		}

		double win = Double.parseDouble(br.readLine());

		win *= 3;

		double a = win;
		double b = win;
		double c = win;

		for (int i = 0; i < 4; i++) {
			if (i != hindex)
				a = Math.round((a - scr[i]) * 100) / 100.0;
			if (i != lindex)
				b = Math.round((b - scr[i]) * 100) / 100.0;
			if (i != hindex && i != lindex)
				c = Math.round((c - scr[i]) * 100) / 100.0;
		}

		double res = 0;
		boolean chk = false;

		if (a > 0) {
			res = low - 0.01;
		} else if (a == 0)
			res = low;
		if (c > low && c < hig) {
			if (c > res)
				res = c;
		}
		if (b >= 0) {
			// res = hig + 0.01;
			chk = true;
		}

		if (chk)
			bw.write("infinite");
		else if (res != 0)
			bw.write(String.format("%.2f", res));
		else
			bw.write("impossible");
		bw.flush();
		bw.close();

	}
}
