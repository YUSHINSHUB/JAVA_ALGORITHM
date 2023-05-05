package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.Arrays;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		if (n == 0)
			bw.write("0");
		else if (n == 1)
			bw.write("1");
		else {
			BigInteger arr[] = new BigInteger[n + 1];
			arr[0] = BigInteger.ZERO;
			arr[1] = BigInteger.ONE;
			for (int i = 2; i <= n; i++) {
				arr[i] = arr[i - 1].add(arr[i - 2]);
			}
			bw.write(arr[n].toString());
		}

		bw.flush();
		bw.close();
	}
}
