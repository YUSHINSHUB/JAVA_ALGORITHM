package Dynamic_Programming;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Q24416_Fibonacci_1_B1 {

	static int cnt1 = 0;
	static int cnt2 = 0;

	static int fib(int n) {
		if (n == 1 || n == 2) {
			cnt1++;
			return 1; // 코드1
		} else
			return (fib(n - 1) + fib(n - 2));
	}

	static int fibonacci(int n) {
		int f[] = new int[n + 1];
		f[1] = f[2] = 1;
		for (int i = 3; i <= n; i++) {
			cnt2++;
			f[i] = f[i - 1] + f[i - 2]; // 코드2
		}
		return f[n];
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		fib(n);
		fibonacci(n);

		bw.write(String.valueOf(cnt1) + " " + String.valueOf(cnt2));

		bw.flush();
		bw.close();
	}
}
