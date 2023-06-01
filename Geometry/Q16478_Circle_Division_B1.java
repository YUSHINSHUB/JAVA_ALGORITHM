package Geometry;

import java.io.*;

public class Q16478_Circle_Division_B1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String in[] = br.readLine().split(" ");

		int a, b, c;
		double res;

		a = Integer.parseInt(in[0]);
		b = Integer.parseInt(in[1]);
		c = Integer.parseInt(in[2]);

		res = (double) (a * c) / b;

		bw.write(String.valueOf(res));

		bw.flush();
		bw.close();
	}
}