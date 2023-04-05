package Geometry;

import java.io.*;

public class Q1297_TV_Size_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str[] = br.readLine().split(" ");
		int inp[] = new int[3];

		for (int i = 0; i < 3; i++) {
			inp[i] = Integer.parseInt(str[i]);
		}

		Double index = Math.sqrt(Math.pow(inp[0], 2) / (Math.pow(inp[1], 2) + Math.pow(inp[2], 2)));

		bw.write(String.valueOf((int) (index * inp[1])) + " " + String.valueOf((int) (index * inp[2])));

		bw.flush();
		bw.close();

	}

}