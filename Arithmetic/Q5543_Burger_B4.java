package Arithmetic;

import java.io.*;
import java.math.*;

public class Q5543_Burger_B4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int bmin = 2001;
		int dmin = 2001;

		int smin;

		int burger[] = new int[3];
		int drink[] = new int[2];

		for (int i = 0; i < 3; i++) {
			burger[i] = Integer.parseInt(br.readLine());
			bmin = Math.min(bmin, burger[i]);
		}

		for (int i = 0; i < 2; i++) {
			drink[i] = Integer.parseInt(br.readLine());
			dmin = Math.min(dmin, drink[i]);
		}

		smin = bmin + dmin - 50;

		bw.write(String.valueOf(smin));

		bw.flush();
		bw.close();

	}

}