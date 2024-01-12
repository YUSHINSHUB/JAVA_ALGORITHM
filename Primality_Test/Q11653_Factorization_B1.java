package Primality_Test;

import java.io.*;

public class Q11653_Factorization_B1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		boolean n[] = new boolean[10000001];
		n[1] = true;
		for (int i = 2; i <= 10000000; i++) {
			if (n[i] != true) {
				n[i] = false;
				for (int z = i * 2; z <= 10000000; z += i) {
					n[z] = true;
				}
			}
		}

		int in = Integer.parseInt(br.readLine());
		int m = 2;

		while (in != 1) {
			if (in % m == 0) {
				in /= m;
				bw.write(String.valueOf(m) + "\n");
			} else {
				m++;
				while (n[m] == true) {
					m++;
				}
			}
		}

		bw.flush();
		bw.close();

	}
}
