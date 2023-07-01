package Geometry;

import java.io.*;

public class Q27323_Rectangle_B5 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int a, b;
		a = Integer.parseInt(br.readLine());
		b = Integer.parseInt(br.readLine());

		bw.write((a * b) + "");

		bw.flush();
		bw.close();
	}
}
