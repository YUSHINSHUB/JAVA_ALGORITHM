package Arithmetic;

import java.io.*;
import java.math.*;

public class Q24723_Green_Tower_B4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = (int) Math.pow(2, Integer.parseInt(br.readLine()));
		bw.write(n + "");

		bw.flush();
		bw.close();

	}
}