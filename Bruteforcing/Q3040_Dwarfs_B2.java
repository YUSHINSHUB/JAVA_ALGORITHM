package Bruteforcing;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Q3040_Dwarfs_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] inp = new int[9];
		int sum = 0;
		boolean[] b = new boolean[9];

		for (int i = 0; i < 9; i++) {
			inp[i] = Integer.parseInt(br.readLine());
			sum += inp[i];
		}

		sum -= 100;

		for (int i = 0; i < 9; i++) {
			if (inp[i] < sum) {
				for (int z = i + 1; z < 9; z++) {
					if (inp[i] + inp[z] == sum) {
						b[i] = true;
						b[z] = true;
						break;
					}
				}
				if (b[i] == true) {
					break;
				}
			}
		}

		for (int i = 0; i < 9; i++) {
			if (b[i] == false) {
				bw.write(String.valueOf(inp[i]) + "\n");
			}
		}

		bw.flush();
		bw.close();
	}
}
