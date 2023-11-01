package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");

		long A = Long.parseLong(inp[0]);
		long B = Long.parseLong(inp[1]);
		int sq = (int) Math.sqrt(B) + 1;
		int era[] = new int[sq];
		int res = 0;

		Arrays.fill(era, 0);
		era[0] = 1;
		era[1] = 1;

		for (int i = 2; i < sq; i++) {
			if (era[i] == 0) {
				for (int j = i * 2; j < sq; j += i) {
					era[j] = 1;
				}
			}
		}

		for (long i = 2; i < sq; i++) {
			if (era[(int) i] == 0) {
				long temp = i * i;
				while (true) {
					if (temp >= A) {
						res++;
					}
					if (temp > B / i)
						break;
					temp *= i;
				}
			}
		}

		bw.write(res + "");
		bw.flush();
		bw.close();

	}

}
