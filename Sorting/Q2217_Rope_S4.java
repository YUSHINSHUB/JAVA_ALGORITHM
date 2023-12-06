package Sorting;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q2217_Rope_S4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int rnum = n;
		int res = 0;

		int rop[] = new int[n];
		for (int i = 0; i < n; i++) {
			rop[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(rop);

		for (int i = 0; i < n; i++) {
			res = Math.max(res, rop[i] * rnum);
			rnum--;
		}

		bw.write(res + "");

		bw.flush();
		bw.close();

	}
}
