package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");

		BigDecimal bd1 = new BigDecimal(inp[0] + ".0");
		BigDecimal bd2 = new BigDecimal(inp[1] + ".0");

		bd1 = bd1.divide(bd2, 1002, BigDecimal.ROUND_DOWN);
		bw.write(bd1.toString());

		bw.flush();
		bw.close();
	}
}
