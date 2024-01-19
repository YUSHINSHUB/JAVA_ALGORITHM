package aaNotepad;

import java.io.*;
import java.util.*;
import java.math.*;

public class notepad {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N, len;
		int pl = 9;
		int res = 0;

		N = Integer.parseInt(br.readLine());
		len = (int) Math.log10(N);

		for (int i = 1; i <= len; i++) {
			res += pl * i;
			pl *= 10;
		}

		pl /= 10;
		pl += (pl / 9) - 1;

		res += (len + 1) * (N - pl);

		if (N / 10 == 0)
			res = N;

		bw.write(res + "");

		bw.flush();
		bw.close();
	}
}