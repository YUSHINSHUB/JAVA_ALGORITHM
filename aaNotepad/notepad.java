package aaNotepad;

import java.io.*;
import java.math.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n;
		BigInteger bi = new BigInteger("1");
		String fibo[];

		n = Integer.parseInt(br.readLine());
		fibo = new String[10001];
		fibo[1] = "1";
		fibo[2] = "1";

		for (int i = 3; i <= n; i++) {
			bi = bi.add(new BigInteger(fibo[i - 2]));
			fibo[i] = bi.toString();
		}

		bw.write(fibo[n]);
		bw.flush();
		bw.close();

	}

}
