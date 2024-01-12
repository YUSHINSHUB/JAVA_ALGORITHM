package Mathematics;

import java.io.*;
import java.math.*;

public class Q2903_Middle_B3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int res = 2;
		int add = 1;
		int n;
		n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			res += add;
			add *= 2;
		}

		res = (int) Math.pow(res, 2);

		bw.write(res + "");

		bw.flush();
		bw.close();

	}
}
