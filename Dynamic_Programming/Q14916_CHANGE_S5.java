package Dynamic_Programming;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q14916_CHANGE_S5 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		if (n == 1 || n == 3) {
			bw.write("-1");
		} else {
			int a = n / 5;
			n %= 5;
			int b = n / 2;
			if (n % 2 != 0) {
				a--;
				b += 3;
			}

			bw.write((a + b) + "");
		}
		bw.flush();
		bw.close();

	}
}