package aaNotepad;

import java.io.*;
import java.util.*;
import java.text.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");

		long a = Long.parseLong(inp[0]);
		long b = Long.parseLong(inp[1]);

		if (a > b) {
			long temp = a;
			a = b;
			b = temp;
		}

		if (b - a < 2)
			bw.write("0\n");
		else {
			bw.write((b - a - 1) + "\n");

			for (long i = a + 1; i <= b - 1; i++) {
				bw.write(i + " ");
			}
		}
		bw.flush();
		bw.close();

	}
}
