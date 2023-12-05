package Arithmetic;

import java.io.*;
import java.util.*;

public class Q13458_Test_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int appli[] = new int[n];
		long res = 0;

		String[] temp = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			appli[i] = Integer.parseInt(temp[i]);
		}

		String[] temp2 = br.readLine().split(" ");
		int sup1 = Integer.parseInt(temp2[0]);
		int sup2 = Integer.parseInt(temp2[1]);

		for (int i = 0; i < n; i++) {
			appli[i] -= sup1;
			res++;
			if (appli[i] > 0) {
				res += appli[i] / sup2;
				appli[i] %= sup2;
				if (appli[i] > 0) {
					res++;
				}
			}
		}

		bw.write(String.valueOf(res));

		bw.flush();
		bw.close();

	}

}
