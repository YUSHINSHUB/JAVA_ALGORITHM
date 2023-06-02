package Mathematics;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q1312_Decimal_S5 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");

		int a = Integer.parseInt(inp[0]);
		int b = Integer.parseInt(inp[1]);
		int n = Integer.parseInt(inp[2]);

		int mod = a % b;
		int res = 0;
		
		for( int i = 0 ; i < n ; i++ ) {
			mod *= 10;
			res = mod / b;
			mod %= b;
		}
		
		bw.write(res + "");
		
		bw.flush();
		bw.close();
	}
}
