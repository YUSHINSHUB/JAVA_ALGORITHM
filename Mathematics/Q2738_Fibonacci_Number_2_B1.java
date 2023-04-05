package Mathematics;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Q2738_Fibonacci_Number_2_B1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		BigInteger f = new BigInteger("0");
		BigInteger s = new BigInteger("1");
		BigInteger r = new BigInteger("1");

		for (int i = 3; i <= n; i++) {
			f = s;
			s = r;
			r = f.add(s);
		}

		if (n == 0) {
			bw.write(f.toString());
		} else if (n == 1) {
			bw.write(s.toString());
		} else {
			bw.write(r.toString());
		}

		bw.flush();
		bw.close();

	}
}