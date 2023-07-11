package Bruteforcing;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q1837_Create_PW_B3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		BigInteger n = new BigInteger(inp[0]);
		int k = Integer.parseInt(inp[1]);
		boolean pass = false;

		int chk[] = new int[k];
		Arrays.fill(chk, 0);
		chk[1] = 1;
		for (int i = 4; i < k; i += 2)
			chk[i] = 1;
		for (int i = 3; i < k; i += 2) {
			if (chk[i] == 0) {
				for (int j = i * 2; j < k; j += i)
					chk[j] = 1;
			}
		}
		// 0은 소수, 1은 소수 아님 (에라토스테네스의 체)

		for (int i = 2; i < k; i++) {
			if (chk[i] == 0) {
				if (n.mod(new BigInteger(i + "")).toString().equals("0")) {
					bw.write("BAD " + i);
					pass = true;
					break;
				}
			}
		}

		if (!pass)
			bw.write("GOOD");

		bw.flush();
		bw.close();

	}
}