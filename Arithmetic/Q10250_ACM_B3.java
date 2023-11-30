package Arithmetic;

import java.io.*;

public class Q10250_ACM_B3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		int h[] = new int[t];
		int w[] = new int[t];
		int n[] = new int[t];

		for (int i = 0; i < t; i++) {
			String[] str = br.readLine().split(" ");

			h[i] = Integer.parseInt(str[0]);
			w[i] = Integer.parseInt(str[1]);
			n[i] = Integer.parseInt(str[2]);

		}

		int no = 0;
		int fl = 0;
		for (int i = 0; i < t; i++) {

			no = (n[i] / h[i]) + 1;
			fl = (n[i] % h[i]);
			if (fl == 0) {
				fl = h[i];
				no--;
			}
			bw.write(String.valueOf((fl * 100) + no) + "\n");

		}

		bw.flush();
		bw.close();

	}

}