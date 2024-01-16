package Mathematics;

import java.io.*;
import java.util.*;

public class Q2908_Constant_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int a;
		int b;
		String[] s = br.readLine().split(" ");

		a = Integer.parseInt(s[0]);
		b = Integer.parseInt(s[1]);

		a = (a % 10 * 100) + (a % 100 / 10 * 10) + (a / 100);
		b = (b % 10 * 100) + (b % 100 / 10 * 10) + (b / 100);

		bw.write(String.valueOf(Math.max(a, b)));

		bw.flush();
		bw.close();

	}
}
