package aaNotepad;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.math.*;

public class notepad {

	static int init[][] = { { 1, 1 }, { 1, 0 } };
	static long matrix[][] = { { 1, 1 }, { 1, 0 } };

	static void square() {

		long temp[][] = new long[2][2];

		temp[0][0] = ((matrix[0][0] * matrix[0][0]) + (matrix[0][1] * matrix[1][0])) % 1000000007;
		temp[0][1] = ((matrix[0][0] * matrix[0][1]) + (matrix[0][1] * matrix[1][1])) % 1000000007;
		temp[1][0] = ((matrix[1][0] * matrix[0][0]) + (matrix[1][1] * matrix[1][0])) % 1000000007;
		temp[1][1] = ((matrix[1][0] * matrix[0][1]) + (matrix[1][1] * matrix[1][1])) % 1000000007;
		matrix[0][0] = temp[0][0];
		matrix[0][1] = temp[0][1];
		matrix[1][0] = temp[1][0];
		matrix[1][1] = temp[1][1];
	}

	static void mul() {

		long temp[][] = new long[2][2];
		temp[0][0] = ((matrix[0][0] * init[0][0]) + (matrix[0][1] * init[1][0])) % 1000000007;
		temp[0][1] = ((matrix[0][0] * init[0][1]) + (matrix[0][1] * init[1][1])) % 1000000007;
		temp[1][0] = ((matrix[1][0] * init[0][0]) + (matrix[1][1] * init[1][0])) % 1000000007;
		temp[1][1] = ((matrix[1][0] * init[0][1]) + (matrix[1][1] * init[1][1])) % 1000000007;
		matrix[0][0] = temp[0][0];
		matrix[0][1] = temp[0][1];
		matrix[1][0] = temp[1][0];
		matrix[1][1] = temp[1][1];

	}

	static void recur(long cur) {
		if (cur == 1)
			return;
		if (cur % 2 == 0) {
			recur(cur / 2);
			square();
		} else {
			recur(cur/2);
			square();
			mul();
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long n = Long.parseLong(br.readLine());
		recur(n);

		bw.write(matrix[1][0] % 1000000007 + "");

		bw.flush();
		bw.close();
	}
}