package Mathematics;

import java.io.*;
import java.util.*;

public class Q12833_XORXORXOR_B1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int a, b, c;
		String inp[] = br.readLine().split(" ");

		a = Integer.parseInt(inp[0]);
		b = Integer.parseInt(inp[1]);
		c = Integer.parseInt(inp[2]);

		int res = 0;

		if (c % 2 == 1) {

			res = a ^ b;

		} else {
			res = a;
		}

		bw.write(String.valueOf(res));

		bw.flush();
		bw.close();
	}
}