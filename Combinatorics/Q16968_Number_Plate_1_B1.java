package Combinatorics;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Q16968_Number_Plate_1_B1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String in = br.readLine();
		int res = 1;
		char temp = 'f';

		for (int i = 0; i < in.length(); i++) {
			if (in.charAt(i) == 'c') {
				if (temp == 'c') {
					res *= 25;
				} else {
					res *= 26;
				}
				temp = 'c';
			} else {
				if (temp == 'd') {
					res *= 9;
				} else {
					res *= 10;
				}
				temp = 'd';
			}
		}

		bw.write(String.valueOf(res));

		bw.flush();
		bw.close();
	}
}