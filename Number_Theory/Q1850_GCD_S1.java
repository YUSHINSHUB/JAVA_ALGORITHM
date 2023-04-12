package Number_Theory;

import java.io.*;
import java.math.BigInteger;
import java.util.*;



public class Q1850_GCD_S1 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String temp[] = br.readLine().split(" ");
		
		long a = Long.parseLong(temp[0]);
		long b = Long.parseLong(temp[1]);
		
		if( a > b ) {
			long t = b;
			b = a;
			a = t;
		}
		
		while( a > 0 ) {
			long t = b;
			b = a;
			a = t % a;
		}
		
		for( int i = 0 ; i < b ; i++ ) bw.write("1");
		
		bw.flush();
		bw.close();
	}
}