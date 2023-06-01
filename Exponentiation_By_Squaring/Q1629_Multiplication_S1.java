package Exponentiation_By_Squaring;

import java.io.*;
import java.util.*;


public class Q1629_Multiplication_S1 {
	
	static long recur(long a, long b, long c) {
		if( b == 0 ) {
			return 1;
		}else if( b % 2 == 0 ) {
			long re = recur(a, b/2, c) % c;
			return (re * re) % c;
		}else {
			long re = recur(a, b/2, c) % c;
			return (re * ( ( (re) * (a % c) ) % c ) ) % c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] inp = br.readLine().split(" ");
		
		long a = Long.parseLong(inp[0]);
		long b = Long.parseLong(inp[1]);
		long c = Long.parseLong(inp[2]);
		
		bw.write(String.valueOf(recur(a, b, c)));
		
		
		bw.flush();
		bw.close();
		
	}
}
