package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	static int check(long a, long b) {

		int m = (int) (a % b);
		if (m == 0)
			return (int) b;

		return check(b, m);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		int a = Integer.parseInt(inp[0]);
		int b = Integer.parseInt(inp[1]);

		long mul = (long) a * (long) b;

		long res1 = 0, res2 = 0;

		for (int i = a; i <= Math.sqrt(mul); i += a) {
			if (mul % i == 0 && check(i, mul / i) == a) {
				res1 = i;
				res2 = mul / i;
			}
		}

		bw.write(res1 + " " + res2);

		bw.flush();
		bw.close();

	}
}
