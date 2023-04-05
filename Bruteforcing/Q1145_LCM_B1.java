package Bruteforcing;

import java.io.*;
import java.util.*;

public class Q1145_LCM_B1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n[] = new int[5];
		String in[] = br.readLine().split(" ");

		for (int i = 0; i < 5; i++) {
			n[i] = Integer.parseInt(in[i]);
		}

		int high = Math.max(n[0], Math.max(n[1], n[2]));
		int res = high;

		while (true) {
			if (res % n[0] == 0 && res % n[1] == 0 && res % n[2] == 0)
				break;
			else
				res += high;
		}

		for (int i = 0; i < 3; i++) {
			for (int z = i + 1; z < 4; z++) {
				for (int x = z + 1; x < 5; x++) {
					high = Math.max(n[i], Math.max(n[x], n[z]));
					int temp = high;
					while (true) {
						if (temp % n[i] == 0 && temp % n[z] == 0 && temp % n[x] == 0) {
							if (temp < res)
								res = temp;
							break;
						} else
							temp += high;
					}
				}
			}
		}

		bw.write(res + "");

		bw.flush();
		bw.close();

	}
}