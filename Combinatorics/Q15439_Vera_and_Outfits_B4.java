package Combinatorics;

import java.io.*;
import java.util.*;

public class Q15439_Vera_and_Outfits_B4 {
	
	static long npr(int n, int r) {
		
		int t = n - r+1;
		long res = 1;
		
		for( int i = t ; i <= n ; i++ ) {
			res *= i;
		}
		return res;
		
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		
		bw.write(npr(n, 2) + "");
		
		bw.flush();
		bw.close();
	}
}
