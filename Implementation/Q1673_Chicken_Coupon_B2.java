package Implementation;

import java.io.*;
import java.util.*;
import java.text.*;

public class Q1673_Chicken_Coupon_B2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp;

		int n = 0;
		int k = 0;
		int chk = 0;

		while ((inp = br.readLine()) != null) {

			StringTokenizer stk = new StringTokenizer(inp, " ");
			n = Integer.parseInt(stk.nextToken());
			k = Integer.parseInt(stk.nextToken());

			chk = n;
			
			while (n >= k) {
				chk += n / k;
				n = n/k + n%k;
			}

			System.out.println(chk);

		}
	}
}
