package Mathematics;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q23814_Order_Fried_Rice_S3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long d = Long.parseLong(br.readLine());
		long n, m, k;
		String in[] = br.readLine().split(" ");

		n = Long.parseLong(in[0]);
		m = Long.parseLong(in[1]);
		k = Long.parseLong(in[2]);

		long max = (n + m + k) / d;
		long np = d - (n % d);
		long mp = d - (m % d);

		if (k >= np + mp) {
			k -= np + mp;
			long kp = d - (k % d);
			if (d + kp <= np + mp)
				k += np + mp;
			else if (kp <= np || kp <= mp)
				k += Math.max(np, mp);
		} else if (k >= np && k >= mp) {
			long ktempn = k;
			long ktempm = k;
			ktempn -= np;
			long nkp = d - (ktempn % d);
			if (nkp <= np)
				ktempn += np;

			ktempm -= mp;
			long mkp = d - (ktempm % d);
			if (mkp <= mp)
				ktempm += mp;

			k = Math.max(ktempn, ktempm);
		} else if (k >= np) {
			k -= np;
			long kp = d - (k % d);
			if (kp <= np)
				k += np;
		} else if (k >= mp) {
			k -= mp;
			long kp = d - (k % d);
			if (kp <= mp)
				k += mp;
		}

		bw.write(k + "");

		bw.flush();
		bw.close();

	}
}