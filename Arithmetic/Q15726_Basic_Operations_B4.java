package Arithmetic;

import java.io.*;
import java.math.*;

public class Q15726_Basic_Operations_B4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = br.readLine().split(" ");

		double a = Double.parseDouble(str[0]);
		double b = Double.parseDouble(str[1]);
		double c = Double.parseDouble(str[2]);

		double res1 = a * b / c;
		double res2 = a / b * c;

		bw.write(String.valueOf(Math.max((long) res1, (long) res2)));

		bw.flush();
		bw.close();

	}

}
