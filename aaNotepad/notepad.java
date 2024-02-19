package aaNotepad;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.math.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int fib[] = new int[1500000];
		int n;
		long inp;

		inp = Long.parseLong(br.readLine());
		n = (int) (inp % 1500000);
		Arrays.fill(fib, 0);
		fib[1] = 1;
		for (int i = 2; i <= n; i++)
			fib[i] = (fib[i - 1] + fib[i - 2])%1000000;

		bw.write(fib[n] + "");
		bw.flush();
		bw.close();
	}
}