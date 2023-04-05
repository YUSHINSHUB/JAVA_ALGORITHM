package Bruteforcing;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Q10448_Eureka_Theorem_B1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int max = 0;
		int n = Integer.parseInt(br.readLine());
		int[] inp = new int[n];

		for (int i = 0; i < n; i++) {
			inp[i] = Integer.parseInt(br.readLine());
			if (inp[i] > max) {
				max = inp[i];
			}
		}

		int[] tri = new int[(int) (Math.sqrt(max)) * 2];

		for (int i = 1; i < (int) Math.sqrt(max) * 2; i++) {
			tri[i] = (i * (i + 1)) / 2;
		}

		for (int i = 0; i < n; i++) {
			boolean chk = true;
			int z = 1;
			while (tri[z] < max) {
				z++;
			}
			z--;
			while (z >= 1) {
				for (int x = z; x >= 1; x--) {
					for (int c = x; c >= 1; c--) {
						if (inp[i] == tri[z] + tri[x] + tri[c]) {
							chk = false;
							break;
						}
					}
					if (chk == false) {
						break;
					}
				}
				z--;
				if (chk == false) {
					break;
				}
			}
			if (chk == false) {
				bw.write("1\n");
			} else {
				bw.write("0\n");
			}
		}

		bw.flush();
		bw.close();
	}
}
