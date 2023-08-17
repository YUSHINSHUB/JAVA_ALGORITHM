package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void hanoi(int n, int s, int m, int e) throws IOException {

		if (n == 1) {
			bw.write(s + " " + e + "\n");
			return;
		}

		hanoi(n - 1, s, e, m);
		bw.write(s + " " + e + "\n");

		hanoi(n - 1, m, s, e);

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		bw.write((int) Math.pow(2, n) - 1 + "\n");
		hanoi(n, 1, 2, 3);

		bw.flush();
		bw.close();

	}
}