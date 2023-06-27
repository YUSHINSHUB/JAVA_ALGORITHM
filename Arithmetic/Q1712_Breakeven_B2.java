package Arithmetic;

import java.io.*;
import java.util.*;

public class Q1712_Breakeven_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String list = br.readLine();
		StringTokenizer stk = new StringTokenizer(list, " ");

		int a[] = new int[3];

		for (int i = 0; i < 3; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
		}

		int res = 1;

		if (a[1] >= a[2]) {
			res = -1;
		} else {
			res += a[0] / (a[2] - a[1]);
		}

		bw.write(String.valueOf(res));

		bw.flush();
		bw.close();

	}

}