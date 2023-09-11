package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n;
		long a, b, c, res;

		n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String inp[] = br.readLine().split(" ");
			a = Long.parseLong(inp[0]);
			b = Long.parseLong(inp[1]);
			c = Long.parseLong(inp[2]);
			long big = Math.max(a, Math.max(b, c));
			long sum = a + b + c;
			sum -= big;
			res = (big * big) + (sum * sum);

			bw.write(res + "\n");
		}

		bw.flush();
		bw.close();

	}
}
